package com.ersen.entry.finish.controller;

import com.ersen.entry.finish.dto.CustomerDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDto> customer(@PathVariable("customerId") String customerId) {
        CustomerDto customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<ResponseDto> customers(@PageableDefault(size = 20) Pageable pageable) {
        ResponseDto customers = customerService.getCustomers(pageable);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ActionResult> createCustomer(@RequestBody CustomerDto request) {
        return new ResponseEntity<>(customerService.save(request), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<ActionResult> updateCategory(@RequestBody CustomerDto request,
                                                       @RequestParam("customerId") String customerId) {
        request.setCustomerId(customerId);
        return new ResponseEntity<>(customerService.update(request), HttpStatus.OK);
    }
}
