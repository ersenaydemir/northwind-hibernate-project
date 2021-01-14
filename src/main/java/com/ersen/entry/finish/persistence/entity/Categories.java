package com.ersen.entry.finish.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table
@Entity(name = "Categories")
public class Categories implements Serializable {
    private static final long serialVersionUID = 3532606259725028014L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Categoryid")
    private Integer categoryId;

    @Column(name = "Categoryname")
    private String categoryName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Picture")
    private byte[] picture;
}
