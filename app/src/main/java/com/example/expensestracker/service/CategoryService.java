package com.example.expensestracker.service;

import androidx.room.Query;

import com.example.expensestracker.model.Category;

import java.util.List;

public interface CategoryService {

    public void addCategory(Category newCategory);

    @Query("SELECT * FROM Category")
    List<Category> getAllCategories();
    public void clearTableCategory();
}
