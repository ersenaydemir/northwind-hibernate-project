package com.ersen.entry.finish.service;

import com.ersen.entry.finish.dto.CategoryDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategoryById(Integer categoryId);

    ResponseDto getCategories(Pageable pageable);

    ActionResult save(CategoryDto categoryDto);

    ActionResult update(CategoryDto categoryDto);
}
