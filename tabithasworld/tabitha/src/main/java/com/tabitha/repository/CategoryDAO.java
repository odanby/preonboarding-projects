package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Category;
import com.tabitha.utils.HibernateUtil;

public class CategoryDAO implements CategoryDAOInterface {

    @Override
    public List<Category> getAllCategoriesByUserId(int task_user_id) {
        HibernateUtil.beginTransaction();
        List<Category> requestList = HibernateUtil.getSession().createQuery("from Category where task_user_id = :TaskUserId", Category.class).setParameter("TaskUserId", task_user_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Category> getAllCategoriesByCategoryId(int category_id) {
        HibernateUtil.beginTransaction();
        List<Category> requestList = HibernateUtil.getSession().createQuery("from Category where category_id = :CategoryId", Category.class).setParameter("CategoryId", category_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public Category createCategory(Category newCategory) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newCategory);
        HibernateUtil.endTransaction();
        return newCategory;
    }

    @Override
    public boolean removeCategory(Category categoryToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(categoryToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public Category updateCategory(Category updatedCategory) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedCategory);
        HibernateUtil.endTransaction();
        return updatedCategory;
    }

    @Override
    public List<Category> getAllCategories() {
        HibernateUtil.beginTransaction();
        List<Category> requestList = HibernateUtil.getSession().createQuery("from Category", Category.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
