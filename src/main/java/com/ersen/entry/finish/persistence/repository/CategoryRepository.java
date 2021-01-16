package com.ersen.entry.finish.persistence.repository;

import com.ersen.entry.finish.persistence.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}
