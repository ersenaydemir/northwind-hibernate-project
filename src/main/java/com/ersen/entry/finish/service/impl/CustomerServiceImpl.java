package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CustomerDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.persistence.entity.Category;
import com.ersen.entry.finish.persistence.entity.Customer;
import com.ersen.entry.finish.persistence.repository.CustomerRepository;
import com.ersen.entry.finish.service.CustomerService;
import com.ersen.entry.finish.util.Generator;
import com.ersen.entry.finish.util.LoggerSupport;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService, LoggerSupport {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDto getCustomerById(String customerId) {
        Customer customer = repository.findById(customerId).orElse(new Customer());
        return new ModelMapper().map(customer, CustomerDto.class);
    }

    @Override
    public ResponseDto getCustomers(Pageable pageable) {
        Page<Customer> customers = repository.findAll(pageable);
        return ResponseDto.builder()
                .totalPage(customers.getTotalPages())
                .totalElement(customers.getTotalElements())
                .data(convert(customers.getContent()))
                .build();
    }

    @Override
    public ActionResult save(CustomerDto customerDto) {
        Customer customer = new ModelMapper().map(customerDto, Customer.class);
        String newCustomerId = Generator.randomWord(5);
        boolean checkCustomer = repository.existsById(newCustomerId);
        while (checkCustomer) {
            newCustomerId = Generator.randomWord(5);
            checkCustomer = repository.existsById(newCustomerId);
        }
        customer.setCustomerId(newCustomerId);
        try {
            repository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("saved").data(customer).build();
    }

    private Customer mapCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public ActionResult update(CustomerDto customerDto) {
        Customer entity = new ModelMapper().map(customerDto, Customer.class);
        try {
            repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("updated").data(entity).build();
    }

    private List<CustomerDto> convert(List<Customer> customers) {
        return customers.stream()
                .map(customer -> new ModelMapper().map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }
}
