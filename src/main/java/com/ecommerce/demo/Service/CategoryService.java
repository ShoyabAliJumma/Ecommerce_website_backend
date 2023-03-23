package com.ecommerce.demo.Service;

import com.ecommerce.demo.Repo.CategoryRepo;
import com.ecommerce.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category)
    {
        categoryRepo.save(category);
    }

    public List<Category> categoryList()
    {
        return categoryRepo.findAll();
    }
    public void editCategory(int categoryId, Category updateCategory)
    {
    Category category=categoryRepo.getById(categoryId);
    category.setCategoryName(updateCategory.getCategoryName());
    category.setDescription(updateCategory.getDescription());
    category.setImageUrl(updateCategory.getImageUrl());
    categoryRepo.save(category);
    }

    public boolean getById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
