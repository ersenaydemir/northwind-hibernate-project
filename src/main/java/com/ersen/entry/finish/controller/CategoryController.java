package com.ersen.entry.finish.controller;

import com.ersen.entry.finish.dto.CategoryDto;
import com.ersen.entry.finish.dto.ResponseDto;
import com.ersen.entry.finish.model.ActionResult;
import com.ersen.entry.finish.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<CategoryDto> category(@PathVariable("categoryId") Integer categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<ResponseDto> categories(@PageableDefault(size = 20) Pageable pageable) {
        ResponseDto categories = categoryService.getCategories(pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ActionResult> createCategory(@RequestBody CategoryDto request) {
        return new ResponseEntity<>(categoryService.save(request), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<ActionResult> updateCategory(@RequestBody CategoryDto request,
                                                       @RequestParam("categoryId") Integer categoryId) {
        request.setCategoryId(categoryId);
        return new ResponseEntity<>(categoryService.update(request), HttpStatus.OK);
    }
}
