package com.fresh.coding.springweb.mappers;

import com.fresh.coding.springweb.dtos.CategoryForm;
import com.fresh.coding.springweb.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryForm categoryForm) {
        if (categoryForm == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryForm.id());
        category.setName(categoryForm.name());
        category.setDescription(categoryForm.description());

        return category;
    }
}
