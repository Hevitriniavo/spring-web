package com.fresh.coding.springweb.services;

import com.fresh.coding.springweb.dtos.CategoryForm;
import com.fresh.coding.springweb.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category findCategoryById(Long id);

    Category saveCategories(CategoryForm categories);

    void deleteCategoryById(Long id);
}
