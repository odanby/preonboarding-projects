package com.tabitha.controllers;

import com.tabitha.entities.TaskList;
import com.tabitha.exceptions.*;
import com.tabitha.service.TaskListServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class TaskListController {

    private TaskListServiceInterface tasklistService;
    private Gson gson;

    public TaskListController(TaskListServiceInterface tasklistService){
        this.tasklistService = tasklistService;
        this.gson = new Gson();
    };
    
        // retrieve all tasks
        public Handler getAllTasks = ctx -> {
            try {
                List<TaskList> task = this.tasklistService.serviceGetAllTasks();
                if(task == null){
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                } else {
                    String tasklistJSON = this.gson.toJson(task);
                    ctx.result(tasklistJSON);
                    ctx.status(200);
                }
            } catch (InvalidTask e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
    
        // // retrieve task by user id
        // List<TaskList> serviceGetAllTasksByUserId(int task_user_id);
        public Handler getTaskByUserId = ctx -> {
            int task_user_id = Integer.parseInt(ctx.pathParam("task_user_id"));
            try {
                List<TaskList> task = this.tasklistService.serviceGetAllTasksByUserId(task_user_id);
                if(task == null){
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                } else {
                    String tasklistJSON = gson.toJson(task);
                    ctx.result(tasklistJSON);
                    ctx.status(200);
                }
            } catch (InvalidTask e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
    
        // // retrieve task by task id
        // List<TaskList> serviceGetAllTasksByTaskId(int task_id);
        public Handler getTaskByTaskId = ctx -> {
            int task_id = Integer.parseInt(ctx.pathParam("task_id"));
            try {
                List<TaskList> task = this.tasklistService.serviceGetAllTasksByTaskId(task_id);
                if(task == null){
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                } else {
                    String tasklistJSON = gson.toJson(task);
                    ctx.result(tasklistJSON);
                    ctx.status(200);
                }
            } catch (InvalidTask e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
        
        // // create a task
        // TaskList serviceCreateTask(TaskList newTask);
        public Handler createTask = ctx -> {
            try {
                String json = ctx.body();
                TaskList newTask = this.gson.fromJson(json, TaskList.class);
                TaskList result = this.tasklistService.serviceCreateTask(newTask);
                String resultJson = this.gson.toJson(result);
                ctx.result(resultJson);
                ctx.status(201);
            } catch (InvalidTask e){
                Map<String, String> message = new HashMap<>();
                message.put("message", e.getMessage());
                String messageJson = this.gson.toJson(message);
                ctx.result(messageJson);
                ctx.status(400);
            }
        };
    
        // // delete a task
        // boolean serviceRemoveTask(TaskList taskToBeDeleted);
        public Handler removeTask = ctx -> {
            try {
                String json = ctx.body();
                TaskList taskToDelete = this.gson.fromJson(json, TaskList.class);
                taskToDelete.setTask_id(Integer.parseInt(ctx.pathParam("task_id")));
                Boolean result = this.tasklistService.serviceRemoveTask(taskToDelete);
                String resultJson = gson.toJson(result);
                ctx.result(resultJson);
                ctx.status(200);
            } catch (InvalidTask e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
    
        // // update a task
        // TaskList serviceUpdateTaskList(TaskList updatedTaskList);
        public Handler updateTask = ctx -> {
            try {
                String json = ctx.body();
                TaskList updatedTask = this.gson.fromJson(json, TaskList.class);
                updatedTask.setTask_id(Integer.parseInt(ctx.pathParam("task_id")));
                TaskList result = this.tasklistService.serviceUpdateTaskList(updatedTask);
                String resultJson = gson.toJson(result);
                ctx.result(resultJson);
                ctx.status(200);
            } catch (InvalidTask e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
}
