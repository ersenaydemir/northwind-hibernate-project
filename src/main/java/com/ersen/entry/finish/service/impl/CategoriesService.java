package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CategoriesDto;
import java.util.List;

public interface CategoriesService {

    CategoriesDto getCategoryById(Integer categoryId);

    List<CategoriesDto> getCategories();
}
