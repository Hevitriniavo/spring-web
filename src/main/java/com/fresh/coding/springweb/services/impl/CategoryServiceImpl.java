package com.fresh.coding.springweb.services.impl;

import com.fresh.coding.springweb.dtos.CategoryForm;
import com.fresh.coding.springweb.entities.Category;
import com.fresh.coding.springweb.exceptions.HttpNotFoundException;
import com.fresh.coding.springweb.mappers.CategoryMapper;
import com.fresh.coding.springweb.repositories.CategoryRepository;
import com.fresh.coding.springweb.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        var category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new HttpNotFoundException("Category not found"));
    }

    @Override
    public Category saveCategories(CategoryForm categoryForm) {
        var category = categoryMapper.toEntity(categoryForm);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
    }
}
