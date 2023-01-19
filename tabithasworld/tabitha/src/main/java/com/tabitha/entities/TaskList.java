package com.tabitha.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue
    private int task_id;
    private String task_desc;
    private int task_frequency;
    private char task_status;
    private int task_user_id;
    private int category_id;

    // empty constructor
    public TaskList(){};

    // full constructor
    public TaskList(
        int task_id,
        String task_desc,
        int task_frequency,
        char task_status,
        int task_user_id,
        int category_id
    ){
        this.task_id = task_id;
        this.task_desc = task_desc;
        this.task_frequency = task_frequency;
        this.task_status = task_status;
        this.task_user_id = task_user_id;
        this.category_id = category_id;
    };

    // constructor without id
    public TaskList(
        String task_desc,
        int task_frequency,
        char task_status,
        int task_user_id,
        int category_id
    ){
        this.task_desc = task_desc;
        this.task_frequency = task_frequency;
        this.task_status = task_status;
        this.task_user_id = task_user_id;
        this.category_id = category_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public int getTask_frequency() {
        return task_frequency;
    }

    public void setTask_frequency(int task_frequency) {
        this.task_frequency = task_frequency;
    }

    public char getTask_status() {
        return task_status;
    }

    public void setTask_status(char task_status) {
        this.task_status = task_status;
    }

    public int getTask_user_id() {
        return task_user_id;
    }

    public void setTask_user_id(int task_user_id) {
        this.task_user_id = task_user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "TaskList [task_id=" + task_id + ", task_desc=" + task_desc + ", task_frequency=" + task_frequency
                + ", task_status=" + task_status + ", task_user_id=" + task_user_id + ", category_id=" + category_id
                + "]";
    };
    
}

