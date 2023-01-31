package com.tabitha.controllers;

import com.tabitha.entities.Category;
import com.tabitha.exceptions.*;
import com.tabitha.service.CategoryServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class CategoryController {

    private CategoryServiceInterface categoryService;
    private Gson gson;

    public CategoryController(CategoryServiceInterface categoryService){
        this.categoryService = categoryService;
        this.gson = new Gson();
    };

    // retrieve all categories
    public Handler getAllCategories = ctx -> {
        try {
            List<Category> category = this.categoryService.serviceGetAllCategories();
            if(category == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String categoryJSON = this.gson.toJson(category);
                ctx.result(categoryJSON);
                ctx.status(200);
            }
        } catch (InvalidCategory e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
    // retrieve category by user id
    public Handler getCategoryByUserId = ctx -> {
        int task_user_id = Integer.parseInt(ctx.pathParam("task_user_id"));
        try {
            List<Category> category = this.categoryService.serviceGetAllCategoriesByUserId(task_user_id);
            if(category == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String categoryJSON = gson.toJson(category);
                ctx.result(categoryJSON);
                ctx.status(200);
            }
        } catch (InvalidCategory e){
            HashMap<String, String> message = new HashMap<>(); 
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve category by category id
    public Handler getCategoryByCategoryId = ctx -> {
        int category_id = Integer.parseInt(ctx.pathParam("category_id"));
        try {
            List<Category> category = this.categoryService.serviceGetAllCategoriesByCategoryId(category_id);
            if(category == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String categoryJSON = gson.toJson(category);
                ctx.result(categoryJSON);
                ctx.status(200);
            }
        } catch (InvalidCategory e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // create category
    public Handler createCategory = ctx -> {
        try {
            String json = ctx.body();
            Category newCategory = this.gson.fromJson(json, Category.class);
            Category result = this.categoryService.serviceCreateCategory(newCategory);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        } catch (InvalidCategory e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        }
    };
    
    // delete category
    public Handler removeCategory = ctx -> {
        try {
            String json = ctx.body();
            Category categoryToDelete = this.gson.fromJson(json, Category.class);
            categoryToDelete.setCategory_id(Integer.parseInt(ctx.pathParam("category_id")));
            Boolean result = this.categoryService.serviceRemoveCategory(categoryToDelete);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidCategory e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // update category
    public Handler updateCategory = ctx -> {
        try {
            String json = ctx.body();
            Category updatedCategory = this.gson.fromJson(json, Category.class);
            updatedCategory.setCategory_id(Integer.parseInt(ctx.pathParam("category_id")));
            Category result = this.categoryService.serviceUpdateCategory(updatedCategory);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidCategory e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
}
