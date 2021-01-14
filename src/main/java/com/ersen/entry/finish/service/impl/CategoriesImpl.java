package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CategoriesDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.persistence.entity.Categories;
import com.ersen.entry.finish.persistence.repository.CategoriesRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesImpl implements CategoriesService {
    private static Logger logger = LoggerFactory.getLogger(CategoriesImpl.class);
    private CategoriesRepository repository;

    public CategoriesImpl(CategoriesRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoriesDto getCategoryById(Integer categoryId) {
        Categories category = repository.findById(categoryId).orElse(new Categories());
        return new ModelMapper().map(category, CategoriesDto.class);
    }

    @Override
    public List<CategoriesDto> getCategories() {
        List<Categories> categories = repository.findAll();
        return convert(categories);
    }

    @Override
    public ActionResult save(CategoriesDto dto) {
        Categories categories = new Categories();
        categories.setCategoryName(dto.getCategoryName());
        categories.setDescription(dto.getDescription());
        categories.setPicture((dto.getPicture().getBytes(StandardCharsets.UTF_8)));
        try {
            repository.save(categories);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.builder().success(false).message(e.getMessage()).build();
        }
        return ActionResult.builder().success(true).message("success").build();
    }

    private List<CategoriesDto> convert(List<Categories> categories) {
        return categories.stream()
                .map(category -> new ModelMapper().map(category, CategoriesDto.class))
                .collect(Collectors.toList());
    }
}
