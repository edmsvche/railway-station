package com.example.railwaystation.service;

import com.example.railwaystation.model.Category;

import java.util.List;

public interface CategoryService {

    void create(Category category);

    List<Category> readAll();

    Category read(long id);

    boolean update(Category category, long id);

    boolean delete(long id);
}
