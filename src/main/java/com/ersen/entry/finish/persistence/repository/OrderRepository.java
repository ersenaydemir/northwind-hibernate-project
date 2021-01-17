package com.ersen.entry.finish.persistence.repository;

import com.ersen.entry.finish.persistence.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}
