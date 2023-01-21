package com.tabitha.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String category_title;
    private int task_user_id;

    // an empty constructor
    public Category(){};

    // full constructor
    public Category(
        int category_id,
        String category_title,
        int task_user_id
    ){
        this.category_id = category_id;
        this.category_title = category_title;
        this.task_user_id = task_user_id;
    }

    // constructor without id
    public Category(
        String category_title,
        int task_user_id
    ){
        this.category_title = category_title;
        this.task_user_id = task_user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public int getTask_user_id() {
        return task_user_id;
    }

    public void setTask_user_id(int task_user_id) {
        this.task_user_id = task_user_id;
    }

    @Override
    public String toString() {
        return "Category [category_id=" + category_id + ", category_title=" + category_title + ", task_user_id="
                + task_user_id + "]";
    }
}
