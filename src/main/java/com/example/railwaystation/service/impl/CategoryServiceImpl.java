package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Category;
import com.example.railwaystation.repository.CategoryRepository;
import com.example.railwaystation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> readAll()  {
        return categoryRepository.findAll();
    }

    @Override
    public Category read(long id) {
        if (categoryRepository.existsById(id))
            return categoryRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Category categoryOrig, long id) {
        if (categoryRepository.existsById(id)) {
            Optional<Category> found = categoryRepository.findById(id);
            if (found.isPresent()) {
                Category category = found.get();
                category.setId(id);
                if (categoryOrig.getName() == null) {
                    category.setName(categoryOrig.getName());
                }
                if (categoryOrig.getFunction() == null) {
                    category.setFunction(categoryOrig.getFunction());
                }
                categoryRepository.save(category);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.findById(id);
            return true;
        }
        return false;
    }
}
