package com.ersen.entry.finish.service;

import com.ersen.entry.finish.dto.OrderDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderDto getOrderIdById(Integer orderId);

    ResponseDto getOrders(Pageable pageable);

    ActionResult save(OrderDto orderDto);

    ActionResult update(OrderDto orderDto);
}
