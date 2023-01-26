package com.tabitha.utils;

import com.tabitha.entities.Category;

public class CategoryBusinessRules {

    // category title can only be 50 characters
    public boolean checkCategoryTitleLength(Category titleToCheck){
        if(titleToCheck.getCategory_title().length() > 50){
            return false;
        } else {
            return true;
        }
    }

    // cannot make a new category if one already exists with the same name
    public boolean checkCategoryMatch(Category categoryToCheck, String actualCategory){
        if(categoryToCheck.getCategory_title().equals(actualCategory)){
            return false;
        } else {
            return true;
        }
    }    
}
