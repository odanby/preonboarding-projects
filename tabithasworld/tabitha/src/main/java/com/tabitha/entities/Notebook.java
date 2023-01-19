package com.tabitha.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook {
    @Id
    @GeneratedValue
    private int notebook_id;
    private String entry_title;
    private String entry_date;
    private String entry_content;
    private int task_user_id;

    // an empty constructor
    public Notebook(){};

    // full constructor
    public Notebook(
        int notebook_id,
        String entry_title,
        String entry_date,
        String entry_content,
        int task_user_id){
            this.notebook_id = notebook_id;
            this.entry_title = entry_title;
            this.entry_date = entry_date;
            this.entry_content = entry_content;
            this.task_user_id = task_user_id;
        }

    // constructor without id
    public Notebook(
        String entry_title,
        String entry_date,
        String entry_content,
        int task_user_id){
            this.entry_title = entry_title;
            this.entry_date = entry_date;
            this.entry_content = entry_content;
            this.task_user_id = task_user_id;
        }

    public int getNotebook_id() {
        return notebook_id;
    }

    public void setNotebook_id(int notebook_id) {
        this.notebook_id = notebook_id;
    }

    public String getEntry_title() {
        return entry_title;
    }

    public void setEntry_title(String entry_title) {
        this.entry_title = entry_title;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getEntry_content() {
        return entry_content;
    }

    public void setEntry_content(String entry_content) {
        this.entry_content = entry_content;
    }

    public int getTask_user_id() {
        return task_user_id;
    }

    public void setTask_user_id(int task_user_id) {
        this.task_user_id = task_user_id;
    }

    @Override
    public String toString() {
        return "Notebook [notebook_id=" + notebook_id + ", entry_title=" + entry_title + ", entry_date=" + entry_date
                + ", entry_content=" + entry_content + ", task_user_id=" + task_user_id + "]";
    }
}

