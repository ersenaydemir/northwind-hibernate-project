package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CategoriesDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.persistence.entity.Categories;

import java.util.List;

public interface CategoriesService {

    CategoriesDto getCategoryById(Integer categoryId);

    List<CategoriesDto> getCategories();

    ActionResult save(CategoriesDto categoriesDto);
}
