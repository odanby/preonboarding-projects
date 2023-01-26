package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Calendar;

public interface CalendarServiceInterface {

    // retrieve all calendar events
    List<Calendar> serviceGetAllCalendarEvents();

    // retrieve calendar events by user id
    List<Calendar> serviceGetAllCalendarEventsByUserId(int task_user_id);

    // retrieve calendar events by event id
    List<Calendar> serviceGetAllCalendarEventsByEventId(int event_id);

    // retrieve calendar events by completion status
    List<Calendar> serviceGetAllCalendarEventsByEventStatus(String event_status);

    // retrieve calendar events by day status
    List<Calendar> serviceGetAllCalendarEventsByDayStatus(String day_status);

    // create calendar event
    Calendar serviceCreateCalendarEvent(Calendar newCalendarEvent);

    // delete calendar event
    boolean serviceRemoveCalendarEvent(Calendar calendarEventToBeDeleted);

    // update calendar event
    Calendar serviceUpdateCalendarEvent(Calendar updatedCalendarEvent);
    
}
