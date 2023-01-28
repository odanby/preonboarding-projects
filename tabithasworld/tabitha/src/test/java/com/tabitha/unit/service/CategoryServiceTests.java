package com.tabitha.unit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tabitha.entities.Category;
import com.tabitha.repository.CategoryDAO;
import com.tabitha.repository.CategoryDAOInterface;
import com.tabitha.service.CategoryService;
import com.tabitha.service.CategoryServiceInterface;
import com.tabitha.utils.CategoryBusinessRules;

public class CategoryServiceTests {

    public static CategoryDAOInterface categoryDao;
    public static CategoryServiceInterface categoryService;
    public static CategoryBusinessRules categoryBusinessRules;

    public static CategoryDAOInterface mockCategoryDao;
    public static CategoryBusinessRules mockCategoryRules;
    public static CategoryServiceInterface categoryServiceWithMocks;

    @BeforeClass
    public static void setup(){

        categoryBusinessRules = new CategoryBusinessRules();
        categoryDao = new CategoryDAO();
        categoryService = new CategoryService(categoryDao, categoryBusinessRules);

        mockCategoryDao = Mockito.mock(CategoryDAO.class);
        mockCategoryRules = Mockito.mock(CategoryBusinessRules.class);
        categoryServiceWithMocks = new CategoryService(mockCategoryDao, mockCategoryRules);
    }
    
    // check category title length
    @Test
    public void invalidCategoryTitle(){
        Category invalidCategory = new Category("TitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitle", 1);
        boolean result = categoryBusinessRules.checkCategoryTitleLength(invalidCategory);
        Assert.assertFalse(result);
    }

    @Test
    public void validCategoryTitle(){
        Category validCategory = new Category("Title", 1);
        boolean result = categoryBusinessRules.checkCategoryTitleLength(validCategory);
        Assert.assertTrue(result);
    }

    // check category match
    @Test
    public void invalidCategoryMatch(){
        Category invalidCategory = new Category("Test", 1);
        boolean result = categoryBusinessRules.checkCategoryMatch(invalidCategory, "Test");
        Assert.assertFalse(result);
    }

    @Test
    public void validCategoryMatch(){
        Category validCategory = new Category("Hi", 1);
        boolean result = categoryBusinessRules.checkCategoryMatch(validCategory, "Test");
        Assert.assertTrue(result);
    }

    // retrieve all categories
    @Test
    public void retrieveAllCategories(){
        List<Category> result = categoryService.serviceGetAllCategories();
        Assert.assertNotNull(result);
    }

    // retrieve category by user id
    @Test
    public void retrieveCategoryByUserId(){
        List<Category> result = categoryService.serviceGetAllCategoriesByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve category by category id
    @Test
    public void retrieveCategoryByCategoryId(){
        List<Category> result = categoryService.serviceGetAllCategoriesByCategoryId(1);
        Assert.assertNotNull(result);
    }

    // create category
    @Test
    public void createCategory(){
        Category goodTask = new Category("Test", 1);

        Mockito.when(mockCategoryRules.checkCategoryTitleLength(goodTask)).thenReturn(true);

        Category greatTask = new Category(-10000, "Test", 1);
        Mockito.when(mockCategoryDao.createCategory(goodTask)).thenReturn(greatTask);

        Category result = categoryServiceWithMocks.serviceCreateCategory(goodTask);
        Assert.assertNotNull(result.getCategory_id());
    }

    // delete category
    @Test
    public void deleteCategory(){
        Category goodTask = new Category("Test", 1);

        Mockito.when(mockCategoryRules.checkCategoryTitleLength(goodTask)).thenReturn(true);

        Category greatTask = new Category(-10000, "Test", 1);
        Mockito.when(mockCategoryDao.createCategory(goodTask)).thenReturn(greatTask);

        categoryServiceWithMocks.serviceCreateCategory(goodTask);
        boolean result = categoryService.serviceRemoveCategory(goodTask);

        Assert.assertTrue(result);
    }

    // update category
    @Test
    public void updateCategory(){
        Category goodTask = new Category("Testing", 1);

        Mockito.when(mockCategoryRules.checkCategoryTitleLength(goodTask)).thenReturn(true);

        Category greatTask = new Category(-10000, "Testing", 1);
        Mockito.when(mockCategoryDao.updateCategory(goodTask)).thenReturn(greatTask);

        Category result = categoryServiceWithMocks.serviceUpdateCategory(goodTask);
        Assert.assertNotNull(result.getCategory_title());
    }
}
