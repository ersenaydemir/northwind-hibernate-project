package com.ersen.entry.finish.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDto {

    private Integer categoryId;
    private String categoryName;
    private String description;
    private String picture;
}
