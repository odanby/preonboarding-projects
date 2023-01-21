package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Calendar;

public interface CalendarDAOInterface {

    // calendar needs these:
        // get all calendar events
        // get calendar events by user id
        // get calendar events by event id
        // create calendar event
        // update calendar event
        // delete calendar event
        // get calendar events by completion status
        // get calendar events by day status

    // retrieve all calendar events
    List<Calendar> getAllCalendarEvents();

    // retrieve calendar events by user id
    List<Calendar> getAllCalendarEventsByUserId(int task_user_id);

    // retrieve calendar events by event id
    List<Calendar> getAllCalendarEventsByEventId(int event_id);

    // retrieve calendar events by completion status
    List<Calendar> getAllCalendarEventsByEventStatus(String event_status);

    // retrieve calendar events by day status
    List<Calendar> getAllCalendarEventsByDayStatus(String day_status);

    // create calendar event
    Calendar createCalendarEvent(Calendar newCalendarEvent);

    // update calendar event
    boolean removeCalendarEvent(Calendar calendarEventToBeDeleted);

    // delete calendar event
    Calendar updateCalendarEvent(Calendar updatedCalendarEvent);
    
}
