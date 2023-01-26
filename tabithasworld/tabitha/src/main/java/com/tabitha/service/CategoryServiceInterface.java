package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Category;

public interface CategoryServiceInterface {
    
    // retrieve all categories
    List<Category> serviceGetAllCategories();

    // retrieve category by user id
    List<Category> serviceGetAllCategoriesByUserId(int task_user_id);

    // retrieve category by category id
    List<Category> serviceGetAllCategoriesByCategoryId(int category_id);

    // create category
    Category serviceCreateCategory(Category newCategory);

    // delete category
    boolean serviceRemoveCategory(Category categoryToBeDeleted);

    // update category
    Category serviceUpdateCategory(Category updatedCategory);
}
