package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.OrderDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.persistence.entity.Order;
import com.ersen.entry.finish.persistence.repository.OrderRepository;
import com.ersen.entry.finish.service.OrderService;
import com.ersen.entry.finish.util.Generator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderDto getOrderIdById(Integer orderId) {
        Order order = repository.findById(orderId).orElse(new Order());
        return new ModelMapper().map(order, OrderDto.class);
    }

    @Override
    public ResponseDto getOrders(Pageable pageable) {
        Page<Order> orders = repository.findAll(pageable);
        return ResponseDto.builder()
                .totalPage(orders.getTotalPages())
                .totalElement(orders.getTotalElements())
                .data(convert(orders.getContent()))
                .build();
    }

    @Override
    public ActionResult save(OrderDto orderDto) {
        orderDto.getCustomer().setCustomerId(Generator.randomWord(5));
        Order order = new ModelMapper().map(orderDto, Order.class);
        try {
            repository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("saved").data(order).build();
    }

    @Override
    public ActionResult update(OrderDto orderDto) {
        return null;
    }

    private List<OrderDto> convert(List<Order> orders) {
        return orders.stream()
                .map(order -> new ModelMapper().map(order, OrderDto.class))
                .collect(Collectors.toList());
    }
}
