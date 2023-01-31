package com.tabitha.controllers;

import com.tabitha.entities.Calendar;
import com.tabitha.exceptions.*;
import com.tabitha.service.CalendarServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class CalendarController {
    
    private CalendarServiceInterface calendarService;
    private Gson gson;

    public CalendarController(CalendarServiceInterface calendarService){
        this.calendarService = calendarService;
        this.gson = new Gson();
    };

    // retrieve all calendar events
    public Handler getAllEvents = ctx -> {
        try {
            List<Calendar> event = this.calendarService.serviceGetAllCalendarEvents();
            if(event == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String calendarJSON = this.gson.toJson(event);
                ctx.result(calendarJSON);
                ctx.status(200);
            }
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve calendar events by user id
    // List<Calendar> serviceGetAllCalendarEventsByUserId(int task_user_id);
    public Handler getEventByUserId = ctx -> {
        int task_user_id = Integer.parseInt(ctx.pathParam("task_user_id"));
        try {
            List<Calendar> event = this.calendarService.serviceGetAllCalendarEventsByUserId(task_user_id);
            if(event == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String calendarJSON = gson.toJson(event);
                ctx.result(calendarJSON);
                ctx.status(200);
            }
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve calendar events by event id
    // List<Calendar> serviceGetAllCalendarEventsByEventId(int event_id);
    public Handler getEventByEventId = ctx -> {
        int event_id = Integer.parseInt(ctx.pathParam("event_id"));
        try {
            List<Calendar> event = this.calendarService.serviceGetAllCalendarEventsByEventId(event_id);
            if(event == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String calendarJSON = gson.toJson(event);
                ctx.result(calendarJSON);
                ctx.status(200);
            }
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve calendar events by completion status
    // List<Calendar> serviceGetAllCalendarEventsByEventStatus(String event_status);
    public Handler getEventByEventStatus = ctx -> {
        String event_status = ctx.pathParam("event_status");
        try {
            List<Calendar> event = this.calendarService.serviceGetAllCalendarEventsByEventStatus(event_status);
            if(event == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String calendarJSON = gson.toJson(event);
                ctx.result(calendarJSON);
                ctx.status(200);
            }
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // retrieve calendar events by day status
    // List<Calendar> serviceGetAllCalendarEventsByDayStatus(String day_status);
    public Handler getEventByDayStatus = ctx -> {
        String day_status = ctx.pathParam("day_status");
        try {
            List<Calendar> event = this.calendarService.serviceGetAllCalendarEventsByDayStatus(day_status);
            if(event == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String calendarJSON = gson.toJson(event);
                ctx.result(calendarJSON);
                ctx.status(200);
            }
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // create calendar event
    // Calendar serviceCreateCalendarEvent(Calendar newCalendarEvent);
    public Handler createEvent = ctx -> {
        try {
            String json = ctx.body();
            Calendar newEvent = this.gson.fromJson(json, Calendar.class);
            Calendar result = this.calendarService.serviceCreateCalendarEvent(newEvent);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        } catch (InvalidCalendar e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        }
    };

    // delete calendar event
    // boolean serviceRemoveCalendarEvent(Calendar calendarEventToBeDeleted);
    public Handler removeEvent = ctx -> {
        try {
            String json = ctx.body();
            Calendar eventToDelete = this.gson.fromJson(json, Calendar.class);
            eventToDelete.setEvent_id(Integer.parseInt(ctx.pathParam("event_id")));
            Boolean result = this.calendarService.serviceRemoveCalendarEvent(eventToDelete);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // update calendar event
    // Calendar serviceUpdateCalendarEvent(Calendar updatedCalendarEvent);
    public Handler updateEvent = ctx -> {
        try {
            String json = ctx.body();
            Calendar updatedEvent = this.gson.fromJson(json, Calendar.class);
            updatedEvent.setEvent_id(Integer.parseInt(ctx.pathParam("event_id")));
            Calendar result = this.calendarService.serviceUpdateCalendarEvent(updatedEvent);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidCalendar e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
}
