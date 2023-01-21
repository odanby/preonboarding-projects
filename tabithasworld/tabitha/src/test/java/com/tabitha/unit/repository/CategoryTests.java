package com.tabitha.unit.repository;

import org.junit.Test;

import com.tabitha.entities.Category;
import com.tabitha.repository.CategoryDAO;
import com.tabitha.repository.CategoryDAOInterface;

import java.util.List;
import org.junit.Assert;

public class CategoryTests {

    public static CategoryDAOInterface categoryDao = new CategoryDAO();

    // retrieve all categories
        // List<Category> getAllCategories();
    @Test
    public void getAllCategories(){
        List<Category> categoryList = categoryDao.getAllCategories();
        Assert.assertTrue(categoryList.size() >= 1);
    }

    // retrieve category by user id
        // List<Category> getAllCategoriesByUserId(int task_user_id);
    @Test
    public void getAllCategoriesByUserId(){
        List<Category> result = categoryDao.getAllCategoriesByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve category by category id
        // List<Category> getAllCategoriesByCategoryId(int category_id);
    @Test
    public void getAllCategoriesByCategoryId(){
        List<Category> result = categoryDao.getAllCategoriesByCategoryId(1);
        Assert.assertNotNull(result);
    }

    // create category
        // Category createCategory(Category newCategory);
    @Test
    public void createCategory(){
        Category testCategory = new Category(0, "Test", 1);
        Category result = categoryDao.createCategory(testCategory);
        Assert.assertNotNull(result.getCategory_id());
    }

    // delete category
        // boolean removeCategory(Category categoryToBeDeleted);
    @Test
    public void removeCategory(){
        Category categoryToBeRemoved = new Category(-1, "Delete me", 1);
        categoryDao.createCategory(categoryToBeRemoved);
        boolean result = categoryDao.removeCategory(categoryToBeRemoved);
        Assert.assertTrue(result);
    }

    // update category
        // Category updateCategory(Category updatedCategory);
    @Test
    public void updateCategory(){
        Category categoryToBeUpdated = new Category(2, "Test", 2);
        Category result = categoryDao.updateCategory(categoryToBeUpdated);
        Assert.assertEquals(2, result.getTask_user_id());
    }

}