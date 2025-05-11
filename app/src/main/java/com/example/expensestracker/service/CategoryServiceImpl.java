package com.example.expensestracker.service;

import android.content.Context;
import android.os.Looper;

import com.example.expensestracker.AppDatabase;
import com.example.expensestracker.DAO.CategoryDao;
import com.example.expensestracker.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class CategoryServiceImpl implements CategoryService {

    private Context context;


    public CategoryServiceImpl(Context context){
        this.context=context;
    }
    @Override
    public void addCategory(Category newCategory) {
        AppDatabase databaseInstance = AppDatabase.getInstance(context);
        CategoryDao categoryDao = databaseInstance.categoryDao();

            categoryDao.insert(newCategory);


    }

    @Override
    public List<Category> getAllCategories() {
        AppDatabase db = AppDatabase.getInstance(context);
        CategoryDao categoryDao = db.categoryDao();

        return categoryDao.getAllCategories();
    }


    @Override
    public void clearTableCategory() {
        AppDatabase databaseInstance = AppDatabase.getInstance(context);
        CategoryDao categoryDao = databaseInstance.categoryDao();
        Executors.newSingleThreadExecutor().execute(() -> {
            categoryDao.clearWalletTable();
        });
    }
}
