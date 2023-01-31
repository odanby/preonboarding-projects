package com.tabitha.controllers;

import com.tabitha.entities.Notebook;
import com.tabitha.exceptions.*;
import com.tabitha.service.NotebookServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class NotebookController {

    private NotebookServiceInterface notebookService;
    private Gson gson;

    public NotebookController(NotebookServiceInterface notebookService){
        this.notebookService = notebookService;
        this.gson = new Gson();
    };

    // retrieve all notebook entries
    public Handler getAllNotebookEntries = ctx -> {
        try {
            List<Notebook> notebook = this.notebookService.serviceGetAllNotebookEntries();
            if(notebook == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String notebookJSON = this.gson.toJson(notebook);
                ctx.result(notebookJSON);
                ctx.status(200);
            }
        } catch (InvalidNotebook e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
    // retrieve notebook entry by user id
    public Handler getNotebookByUserId = ctx -> {
        int task_user_id = Integer.parseInt(ctx.pathParam("task_user_id"));
        try {
            List<Notebook> notebook = this.notebookService.serviceGetAllNotebookEntriesByUserId(task_user_id);
            if(notebook == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String notebookJSON = gson.toJson(notebook);
                ctx.result(notebookJSON);
                ctx.status(200);
            }
        } catch (InvalidNotebook e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve notebook entry by notebook id
    public Handler getNotebookByNotebookId = ctx -> {
        int notebook_id = Integer.parseInt(ctx.pathParam("notebook_id"));
        try {
            List<Notebook> notebook = this.notebookService.serviceGetAllNotebookEntriesByNotebookId(notebook_id);
            if(notebook == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String notebookJSON = gson.toJson(notebook);
                ctx.result(notebookJSON);
                ctx.status(200);
            }
        } catch (InvalidNotebook e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // create notebook entry
    public Handler createNotebookEntry = ctx -> {
        try {
            String json = ctx.body();
            Notebook newEntry = this.gson.fromJson(json, Notebook.class);
            Notebook result = this.notebookService.serviceCreateNotebookEntry(newEntry);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        } catch (InvalidNotebook e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        }
    };
    
    // delete notebook entry
    public Handler removeNotebookEntry = ctx -> {
        try {
            String json = ctx.body();
            Notebook entryToDelete = this.gson.fromJson(json, Notebook.class);
            entryToDelete.setNotebook_id(Integer.parseInt(ctx.pathParam("notebook_id")));
            Boolean result = this.notebookService.serviceRemoveNotebookEntry(entryToDelete);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidNotebook e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // update notebook entry
    public Handler updateNotebookEntry = ctx -> {
        try {
            String json = ctx.body();
            Notebook updatedEntry = this.gson.fromJson(json, Notebook.class);
            updatedEntry.setNotebook_id(Integer.parseInt(ctx.pathParam("notebook_id")));
            Notebook result = this.notebookService.serviceUpdateNotebookEntry(updatedEntry);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidNotebook e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
     
}