package com.fethi.cqrsorderprocess.controller;

import com.fethi.cqrsorderprocess.document.Order;
import com.fethi.cqrsorderprocess.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/allWithPagination")
    public ResponseEntity<List<Order>> getAllWithPagination(@RequestParam int pageNo,
                                                            @RequestParam int pageSize) {
        return ResponseEntity.ok(service.getAllWithPagination(pageNo, pageSize));
    }

    @GetMapping("/customer/{identityNo}")
    public ResponseEntity<List<Order>> getAllOrderByCustomer(@RequestParam int pageNo,
                                                            @RequestParam int pageSize, @PathVariable String identityNo) {
        return ResponseEntity.ok(service.getAllOrderByCustomer(identityNo,pageNo, pageSize));
    }
}
