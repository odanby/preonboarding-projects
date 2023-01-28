package com.tabitha.unit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tabitha.entities.Calendar;
import com.tabitha.repository.CalendarDAO;
import com.tabitha.repository.CalendarDAOInterface;
import com.tabitha.service.CalendarService;
import com.tabitha.service.CalendarServiceInterface;
import com.tabitha.utils.CalendarBusinessRules;

import io.cucumber.java.bm.Tetapi;

public class CalendarServiceTests {

    public static CalendarDAOInterface calendarDao;
    public static CalendarServiceInterface calendarService;
    public static CalendarBusinessRules calendarBusinessRules;

    public static CalendarDAOInterface mockCalendarDao;
    public static CalendarBusinessRules mockCalendarRules;
    public static CalendarServiceInterface calendarServiceWithMocks;

    @BeforeClass
    public static void setup(){

        calendarBusinessRules = new CalendarBusinessRules();
        calendarDao = new CalendarDAO();
        calendarService = new CalendarService(calendarDao, calendarBusinessRules);

        mockCalendarDao = Mockito.mock(CalendarDAO.class);
        mockCalendarRules = Mockito.mock(CalendarBusinessRules.class);
        calendarServiceWithMocks = new CalendarService(mockCalendarDao, mockCalendarRules);
    }
    
    // check date validity
    @Test
    public void validDate(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);

        boolean result = calendarBusinessRules.checkDateValidity(tsStart, tsEnd);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidDate(){
        String eventStartInput = "2021-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2024-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);

        boolean result = calendarBusinessRules.checkDateValidity(tsStart, tsEnd);
        Assert.assertFalse(result);
    }

    // check event title
    @Test
    public void validTitle(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar validCalendar = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.checkEventTitleLength(validCalendar);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidTitle(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar invalidCalendar = new Calendar("titletitletitletitletitletitletitletitletitletitletitletitletitletitletitletitle", "desc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.checkEventTitleLength(invalidCalendar);
        Assert.assertFalse(result);
    }

    // check event desc
    @Test
    public void validDesc(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar validCalendar = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.checkEventDescLength(validCalendar);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidDesc(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar invalidCalendar = new Calendar("title", "descdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdescdesc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.checkEventDescLength(invalidCalendar);
        Assert.assertFalse(result);
    }

    // check event status
    @Test
    public void validEventStatus(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar validCalendar = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.eventStatusContainsYOrN(validCalendar);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidEventStatus(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar invalidCalendar = new Calendar("title", "desc", "Q", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.eventStatusContainsYOrN(invalidCalendar);
        Assert.assertFalse(result);
    }

    // check day status
    @Test
    public void validDayStatus(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar validCalendar = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        boolean result = calendarBusinessRules.dayStatusContainsYOrN(validCalendar);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidDayStatus(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar invalidCalendar = new Calendar("title", "desc", "N", tsStart, tsEnd, "Q", 1);

        boolean result = calendarBusinessRules.dayStatusContainsYOrN(invalidCalendar);
        Assert.assertFalse(result);
    }

    // create calendar event
    @Test
    public void createCalendarEvent(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar goodEvent = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        Mockito.when(mockCalendarRules.checkDateValidity(tsStart, tsEnd)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventDescLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventTitleLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.dayStatusContainsYOrN(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.eventStatusContainsYOrN(goodEvent)).thenReturn(true);

        Calendar greatEvent = new Calendar(-100, "title", "desc", "N", tsStart, tsEnd, "N", 1);
        Mockito.when(mockCalendarDao.createCalendarEvent(goodEvent)).thenReturn(greatEvent);

        Calendar result = calendarServiceWithMocks.serviceCreateCalendarEvent(goodEvent);
        Assert.assertNotNull(result.getEvent_id());
    }

    // delete calendar event
    @Test
    public void deleteCalendarEvent(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar goodEvent = new Calendar("title", "desc", "N", tsStart, tsEnd, "N", 1);

        Mockito.when(mockCalendarRules.checkDateValidity(tsStart, tsEnd)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventDescLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventTitleLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.dayStatusContainsYOrN(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.eventStatusContainsYOrN(goodEvent)).thenReturn(true);

        Calendar greatEvent = new Calendar(-100, "title", "desc", "N", tsStart, tsEnd, "N", 1);
        Mockito.when(mockCalendarDao.createCalendarEvent(goodEvent)).thenReturn(greatEvent);

        calendarServiceWithMocks.serviceCreateCalendarEvent(goodEvent);
        boolean result = calendarService.serviceRemoveCalendarEvent(goodEvent);

        Assert.assertTrue(result);
    }

    // update calendar event
    @Test
    public void updateCalendarEvent(){
        String eventStartInput = "2023-01-23 08:00:00";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(eventStartInput);
        String eventEndInput = "2023-01-23 08:30:00";
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(eventEndInput);
        Calendar goodEvent = new Calendar("title", "desc", "N", tsStart, tsEnd, "Y", 1);

        Mockito.when(mockCalendarRules.checkDateValidity(tsStart, tsEnd)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventDescLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.checkEventTitleLength(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.dayStatusContainsYOrN(goodEvent)).thenReturn(true);
        Mockito.when(mockCalendarRules.eventStatusContainsYOrN(goodEvent)).thenReturn(true);

        Calendar greatEvent = new Calendar(-100, "title", "desc", "N", tsStart, tsEnd, "Y", 1);
        Mockito.when(mockCalendarDao.updateCalendarEvent(goodEvent)).thenReturn(greatEvent);

        Calendar result = calendarServiceWithMocks.serviceUpdateCalendarEvent(goodEvent);
        Assert.assertNotNull(result.getDay_status());
    }

    // retrieve all calendar events
    @Test
    public void retrieveAllCalendarEvents(){
        List<Calendar> result = calendarService.serviceGetAllCalendarEvents();
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by user id
    @Test
    public void retrieveCalendarEventsByUserId(){
        List<Calendar> result = calendarService.serviceGetAllCalendarEventsByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by event id
    @Test
    public void retrieveCalendarEventsByEventId(){
        List<Calendar> result = calendarService.serviceGetAllCalendarEventsByEventId(1);
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by completion status
    @Test
    public void retrieveCalendarEventsByCompletionStatus(){
        List<Calendar> result = calendarService.serviceGetAllCalendarEventsByEventStatus("Y");
        Assert.assertNotNull(result);
    }

    // retrieve calendar events by day status
    @Test
    public void retrieveCalendarEventsByDayStatus(){
        List<Calendar> result = calendarService.serviceGetAllCalendarEventsByDayStatus("N");
        Assert.assertNotNull(result);
    }
}
