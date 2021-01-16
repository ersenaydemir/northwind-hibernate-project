package com.ersen.entry.finish.persistence.repository;

import com.ersen.entry.finish.persistence.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

}
