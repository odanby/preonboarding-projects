package com.tabitha.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue
    private int event_id;
    private String event_title;
    private String event_desc;
    private char event_status;
    private Timestamp event_start;
    private Timestamp event_end;
    private char day_status;
    private int task_user_id;

    // an empty constructor
    public Calendar(){};

    // full constructor
    public Calendar(
        int event_id,
        String event_title,
        String event_desc,
        char event_status,
        Timestamp event_start,
        Timestamp event_end,
        char day_status,
        int task_user_id
    ){
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_desc = event_desc;
        this.event_status = event_status;
        this.event_start = event_start;
        this.event_end = event_end;
        this.day_status = day_status;
        this.task_user_id = task_user_id;
    }

    // constructor without id
    public Calendar(
        String event_title,
        String event_desc,
        char event_status,
        Timestamp event_start,
        Timestamp event_end,
        char day_status,
        int task_user_id
    ){
        this.event_title = event_title;
        this.event_desc = event_desc;
        this.event_status = event_status;
        this.event_start = event_start;
        this.event_end = event_end;
        this.day_status = day_status;
        this.task_user_id = task_user_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public char getEvent_status() {
        return event_status;
    }

    public void setEvent_status(char event_status) {
        this.event_status = event_status;
    }

    public Timestamp getEvent_start() {
        return event_start;
    }

    public void setEvent_start(Timestamp event_start) {
        this.event_start = event_start;
    }

    public Timestamp getEvent_end() {
        return event_end;
    }

    public void setEvent_end(Timestamp event_end) {
        this.event_end = event_end;
    }

    public char getDay_status() {
        return day_status;
    }

    public void setDay_status(char day_status) {
        this.day_status = day_status;
    }

    public int getTask_user_id() {
        return task_user_id;
    }

    public void setTask_user_id(int task_user_id) {
        this.task_user_id = task_user_id;
    }

    @Override
    public String toString() {
        return "Calendar [event_id=" + event_id + ", event_title=" + event_title + ", event_desc=" + event_desc
                + ", event_status=" + event_status + ", event_start=" + event_start + ", event_end=" + event_end
                + ", day_status=" + day_status + ", task_user_id=" + task_user_id + "]";
    }
}
