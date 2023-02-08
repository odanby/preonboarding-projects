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

        // // retrieve task by category id
        // List<TaskList> serviceGetAllTasksByTaskId(int task_id);
        public Handler getTaskByCategoryId = ctx -> {
            int category_id = Integer.parseInt(ctx.pathParam("category_id"));
            try {
                List<TaskList> task = this.tasklistService.serviceGetAllTasksByCategoryId(category_id);
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
                // the ctx.body() method creates a java string object from the content of the request body
                String json = ctx.body();
                // we then use Gson to convert the json string into the java class we are working with
                TaskList taskToDelete = this.gson.fromJson(json, TaskList.class);
                // to make sure that I am updating the book that I indicated in the http request I set the path id to the id of the book
                String identifier = ctx.pathParam("task_id");
                int taskId = Integer.parseInt(identifier);
                taskToDelete.setTask_id(taskId);
                // we then pass the java object we created into the appropriate service method for validation
                this.tasklistService.serviceRemoveTask(taskToDelete);
                // because I am not returning any special entity with this method I will use a Map to create my key/value pair message for the json
                Map<String, String> message = new HashMap<>();
                message.put("message", "task was deleted");
                // once the map is made we convert it into a json
                String messageJson = this.gson.toJson(message);
                // then we attach it to the response body and set the status code
                ctx.result(messageJson);
                ctx.status(200); // will need to double check status code at some point
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
