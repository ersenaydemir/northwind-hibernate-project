package com.ersen.entry.finish.persistence.repository;

import com.ersen.entry.finish.persistence.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
