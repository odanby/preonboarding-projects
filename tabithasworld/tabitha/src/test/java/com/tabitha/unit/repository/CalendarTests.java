package com.tabitha.unit.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.tabitha.entities.Calendar;
import com.tabitha.repository.CalendarDAO;
import com.tabitha.repository.CalendarDAOInterface;

public class CalendarTests {

    public static CalendarDAOInterface calendarDao = new CalendarDAO();

    // retrieve all calendar events
        // List<Calendar> getAllCalendarEvents();
    @Test
    public void getAllCalendarEvents(){
        List<Calendar> calendarList = calendarDao.getAllCalendarEvents();
        Assert.assertTrue(calendarList.size() >= 1);
    }

    // retrieve calendar events by user id
    // List<Calendar> getAllCalendarEventsByUserId(int task_user_id);
    @Test
    public void getAllCalendarEventsByUserId(){
        List<Calendar> result = calendarDao.getAllCalendarEventsByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by event id
        // List<Calendar> getAllCalendarEventsByEventId(int event_id);
    @Test
    public void getAllCalendarEventsByEventId(){
        List<Calendar> result = calendarDao.getAllCalendarEventsByEventId(1);
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by completion status
        // List<Calendar> getAllCalendarEventsByEventStatus(int event_status);
    @Test
    public void getAllCalendarEventsByEventStatus(){
        List<Calendar> result = calendarDao.getAllCalendarEventsByEventStatus("N");
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by day status
        // List<Calendar> getAllCalendarEventsByDayStatus(int day_status);
    @Test
    public void getAllCalendarEventsByDayStatus(){
        List<Calendar> result = calendarDao.getAllCalendarEventsByDayStatus("N");
        Assert.assertNotNull(result);
    }

    // create calendar event
        // Calendar createCalendarEvent(Calendar newCalendarEvent);
    @Test
    public void createCalendarEvent(){
        String eventStartInput = "2023-01-23 12:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 13:00:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar testEvent = new Calendar(0, "Test event", "Test description", "N", tsStart, tsEnd, "N", 1);
        Calendar result = calendarDao.createCalendarEvent(testEvent);
        Assert.assertNotNull(result.getEvent_id());
    }

    // update calendar event
        // Calendar updateCalendarEvent(Calendar updatedCalendarEvent);
    @Test
    public void updateCalendarEvent(){
        String eventStartInput = "2023-01-23 12:30:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 13:00:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar updatedEvent = new Calendar(2, "Test event", "Test description", "N", tsStart, tsEnd, "N", 1);
        Calendar result = calendarDao.updateCalendarEvent(updatedEvent);
        Assert.assertEquals(tsStart, result.getEvent_start());
    }

    // delete calendar event
        // boolean removeCalendarEvent(Calendar calendarEventToBeDeleted);
    @Test
    public void removeCalendarEvent(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar eventToRemove = new Calendar(0, "Delete me", "Delete me description", "Y", tsStart, tsEnd, "Y", 1);
        calendarDao.createCalendarEvent(eventToRemove);
        boolean result = calendarDao.removeCalendarEvent(eventToRemove);
        Assert.assertTrue(result);
    }
}