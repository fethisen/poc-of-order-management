package com.fethi.cqrsorderprocess.controller;

import com.fethi.cqrsorderprocess.document.OrderItem;
import com.fethi.cqrsorderprocess.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderNo}")
    public ResponseEntity<List<OrderItem>> getAllWithPagination(@RequestParam int pageNo,
                                                               @RequestParam int pageSize, @PathVariable("orderNo") String orderNo ) {
        return ResponseEntity.ok(orderItemService.getAllWithPagination(pageNo, pageSize,orderNo));
    }
}
