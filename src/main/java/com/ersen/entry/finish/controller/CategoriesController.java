package com.ersen.entry.finish.controller;

import com.ersen.entry.finish.dto.CategoriesDto;
import com.ersen.entry.finish.service.impl.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {
    private CategoriesService service;

    public CategoriesController(CategoriesService service) {
        this.service = service;
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<CategoriesDto> category(@PathVariable("categoryId") Integer categoryId) {
        CategoriesDto category = service.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CategoriesDto>> categories() {
        List<CategoriesDto> categories = service.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
