package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Category;
import com.tabitha.exceptions.InvalidCategory;
import com.tabitha.repository.CategoryDAOInterface;
import com.tabitha.utils.CategoryBusinessRules;

public class CategoryService implements CategoryServiceInterface {

    private CategoryDAOInterface categoryDao;
    private CategoryBusinessRules categoryBusinessRules;

    public CategoryService(CategoryDAOInterface categoryDao, CategoryBusinessRules categoryBusinessRules){
        this.categoryDao = categoryDao;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public List<Category> serviceGetAllCategories() {
        return this.categoryDao.getAllCategories();
    }

    @Override
    public List<Category> serviceGetAllCategoriesByUserId(int task_user_id) {
        return this.categoryDao.getAllCategoriesByUserId(task_user_id);
    }

    @Override
    public List<Category> serviceGetAllCategoriesByCategoryId(int category_id) {
        return this.categoryDao.getAllCategoriesByCategoryId(category_id);
    }

    @Override
    public Category serviceCreateCategory(Category newCategory) {
        boolean valCheck1 = this.categoryBusinessRules.checkCategoryTitleLength(newCategory);

        if(valCheck1){
            List<Category> categoryArray = this.categoryDao.getAllCategories();
            for(int x = 0; x < categoryArray.size(); x++){
                Category pulledCategory = categoryArray.get(x);
                if(!this.categoryBusinessRules.checkCategoryMatch(pulledCategory, newCategory.getCategory_title())){
                    throw new InvalidCategory("Category title already in use.");
                }
            }
            return this.categoryDao.createCategory(newCategory);
        } else {
            throw new InvalidCategory("Could not create category.");
        }
    }

    @Override
    public boolean serviceRemoveCategory(Category categoryToBeDeleted) {
        return this.categoryDao.removeCategory(categoryToBeDeleted);
    }

    @Override
    public Category serviceUpdateCategory(Category updatedCategory) {
        boolean valCheck1 = this.categoryBusinessRules.checkCategoryTitleLength(updatedCategory);

        if(valCheck1){
            List<Category> categoryArray = this.categoryDao.getAllCategories();
            for(int x = 0; x < categoryArray.size(); x++){
                Category pulledCategory = categoryArray.get(x);
                if(!this.categoryBusinessRules.checkCategoryMatch(pulledCategory, updatedCategory.getCategory_title())){
                    throw new InvalidCategory("Category title already in use.");
                }
            }
            return this.categoryDao.updateCategory(updatedCategory);
        } else {
            throw new InvalidCategory("Could not create category.");
        }
    }
    
}
