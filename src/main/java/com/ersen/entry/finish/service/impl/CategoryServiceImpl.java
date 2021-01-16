package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CategoryDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.persistence.entity.Category;
import com.ersen.entry.finish.persistence.repository.CategoryRepository;
import com.ersen.entry.finish.service.CategoryService;
import com.ersen.entry.finish.util.LoggerSupport;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService, LoggerSupport {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = repository.findById(categoryId).orElse(new Category());
        return new ModelMapper().map(category, CategoryDto.class);
    }

    @Override
    public ResponseDto getCategories(Pageable pageable) {
        Page<Category> categories = repository.findAll(pageable);
        return ResponseDto.builder()
                .totalPage(categories.getTotalPages())
                .totalElement(categories.getTotalElements())
                .data(convert(categories.getContent()))
                .build();
    }

    @Override
    public ActionResult save(CategoryDto categoryDto) {
        Category category = mapCategory(categoryDto);
        try {
            repository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("saved").data(category).build();
    }

    @Override
    public ActionResult update(CategoryDto categoryDto) {
        Category entity = mapCategory(categoryDto);
        try {
            repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("updated").data(entity).build();
    }

    private List<CategoryDto> convert(List<Category> categories) {
        return categories.stream()
                .map(category -> new ModelMapper().map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    private Category mapCategory(CategoryDto dto) {
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
        category.setPicture((dto.getPicture().getBytes(StandardCharsets.UTF_8)));
        return category;
    }
}
