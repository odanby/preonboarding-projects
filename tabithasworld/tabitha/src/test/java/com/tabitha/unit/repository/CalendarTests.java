package com.tabitha.unit.repository;

import java.sql.Date;

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

    // update calendar event
        // boolean removeCalendarEvent(Calendar calendarEventToBeDeleted);

    // delete calendar event
        // Calendar updateCalendarEvent(Calendar updatedCalendarEvent);
}