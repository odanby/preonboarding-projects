package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.User;
import com.tabitha.utils.HibernateUtil;

public class UserDAO implements UserDAOInterface {

    @Override
    public User createUser(User newUser) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newUser);
        HibernateUtil.endTransaction();
        return newUser;
    }

    @Override
    public List<User> getAllUsers() {
        HibernateUtil.beginTransaction();
        List<User> requestList = HibernateUtil.getSession().createQuery("from User", User.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<User> getUserById(int id) {
        HibernateUtil.beginTransaction();
        List<User> requestList = HibernateUtil.getSession().createQuery("from User where id = :Id", User.class).setParameter("Id", id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public User updateLocation(User updatedZipCode) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedZipCode);
        HibernateUtil.endTransaction();
        return updatedZipCode;
    }

    @Override
    public List<User> getUserByUsername(String username) {
        HibernateUtil.beginTransaction();
        List<User> requestList = HibernateUtil.getSession().createQuery("from User where username = :Username", User.class).setParameter("Username", username).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
