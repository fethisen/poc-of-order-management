package com.fethi.productsalesteamA.Controller;

import com.fethi.productsalesteamA.Service.OrderService;
import com.fethi.productsalesteamA.Service.dto.OrderItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders/{customerIdentiyNo}")
    public ResponseEntity<Long> createOrder(@RequestBody List<OrderItemDTO> orderItemDTOS, @PathVariable String customerIdentiyNo) throws Exception {

        Long orderId = orderService.save(orderItemDTOS, customerIdentiyNo);
        return ResponseEntity
                .created(new URI("/api/orders/" + orderId))
                .body(orderId);
    }
}
