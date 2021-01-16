package com.ersen.entry.finish.service;

import com.ersen.entry.finish.dto.CustomerDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerDto getCustomerById(String customerId);

    ResponseDto getCustomers(Pageable pageable);

    ActionResult save(CustomerDto customerDto);

    ActionResult update(CustomerDto customerDto);
}
