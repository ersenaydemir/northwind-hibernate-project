package com.ersen.entry.finish.controller;

import com.ersen.entry.finish.dto.OrderDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDto> order(@PathVariable("orderId") int orderId) {
        OrderDto order = orderService.getOrderIdById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<ResponseDto> orders(@PageableDefault(size = 20) Pageable pageable) {
        ResponseDto orders = orderService.getOrders(pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ActionResult> createCustomer(@RequestBody OrderDto request) {
        return new ResponseEntity<>(orderService.save(request), HttpStatus.OK);
    }
}
