package com.ersen.entry.finish.service.impl;

import com.ersen.entry.finish.dto.CategoriesDto;
import com.ersen.entry.finish.persistence.entity.Categories;
import com.ersen.entry.finish.persistence.repository.CategoriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesImpl implements CategoriesService {
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

    private List<CategoriesDto> convert(List<Categories> categories) {
        return categories.stream()
                .map(category -> new ModelMapper().map(category, CategoriesDto.class))
                .collect(Collectors.toList());
    }
}
