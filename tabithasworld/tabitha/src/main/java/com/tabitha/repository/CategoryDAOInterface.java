package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Category;

public interface CategoryDAOInterface {
    
    // for category we need:
        // pull category by category id
        // pull category by user id
        // pull all categories
        // create a category
        // delete a category
        // update a category

    // retrieve all categories
    List<Category> getAllCategories();

    // retrieve category by user id
    List<Category> getAllCategoriesByUserId(int task_user_id);

    // retrieve category by category id
    List<Category> getAllCategoriesByCategoryId(int category_id);

    // create category
    Category createCategory(Category newCategory);

    // delete category
    boolean removeCategory(Category categoryToBeDeleted);

    // update category
    Category updateCategory(Category updatedCategory);
}
