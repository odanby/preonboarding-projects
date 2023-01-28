package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Calendar;
import com.tabitha.exceptions.InvalidCalendar;
import com.tabitha.repository.CalendarDAOInterface;
import com.tabitha.utils.CalendarBusinessRules;

public class CalendarService implements CalendarServiceInterface {

    private CalendarDAOInterface calendarDao;
    private CalendarBusinessRules calendarBusinessRules;

    public CalendarService(CalendarDAOInterface calendarDao, CalendarBusinessRules calendarBusinessRules){
        this.calendarDao = calendarDao;
        this.calendarBusinessRules = calendarBusinessRules;
    }

    @Override
    public List<Calendar> serviceGetAllCalendarEvents() {
        return this.calendarDao.getAllCalendarEvents();
    }

    @Override
    public List<Calendar> serviceGetAllCalendarEventsByUserId(int task_user_id) {
        return this.calendarDao.getAllCalendarEventsByUserId(task_user_id);
    }

    @Override
    public List<Calendar> serviceGetAllCalendarEventsByEventId(int event_id) {
        return this.calendarDao.getAllCalendarEventsByEventId(event_id);
    }

    @Override
    public List<Calendar> serviceGetAllCalendarEventsByEventStatus(String event_status) {
        return this.calendarDao.getAllCalendarEventsByEventStatus(event_status);
    }

    @Override
    public List<Calendar> serviceGetAllCalendarEventsByDayStatus(String day_status) {
        return this.calendarDao.getAllCalendarEventsByDayStatus(day_status);
    }

    @Override
    public Calendar serviceCreateCalendarEvent(Calendar newCalendarEvent) {
        boolean valCheck1 = this.calendarBusinessRules.checkDateValidity(newCalendarEvent.getEvent_start(), newCalendarEvent.getEvent_end());
        boolean valCheck2 = this.calendarBusinessRules.checkEventTitleLength(newCalendarEvent);
        boolean valCheck3 = this.calendarBusinessRules.checkEventDescLength(newCalendarEvent);
        boolean valCheck4 = this.calendarBusinessRules.eventStatusContainsYOrN(newCalendarEvent);
        boolean valCheck5 = this.calendarBusinessRules.dayStatusContainsYOrN(newCalendarEvent);

        if(valCheck1 && valCheck2 && valCheck3 && valCheck4 && valCheck5){
            return this.calendarDao.createCalendarEvent(newCalendarEvent);
        } else {
            throw new InvalidCalendar("Could not create new calendar event.");
        }
    }

    @Override
    public boolean serviceRemoveCalendarEvent(Calendar calendarEventToBeDeleted) {
        return this.calendarDao.removeCalendarEvent(calendarEventToBeDeleted);
    }

    @Override
    public Calendar serviceUpdateCalendarEvent(Calendar updatedCalendarEvent) {
        boolean valCheck1 = this.calendarBusinessRules.checkDateValidity(updatedCalendarEvent.getEvent_start(), updatedCalendarEvent.getEvent_end());
        boolean valCheck2 = this.calendarBusinessRules.checkEventTitleLength(updatedCalendarEvent);
        boolean valCheck3 = this.calendarBusinessRules.checkEventDescLength(updatedCalendarEvent);
        boolean valCheck4 = this.calendarBusinessRules.eventStatusContainsYOrN(updatedCalendarEvent);
        boolean valCheck5 = this.calendarBusinessRules.dayStatusContainsYOrN(updatedCalendarEvent);

        if(valCheck1 && valCheck2 && valCheck3 && valCheck4 && valCheck5){
            return this.calendarDao.updateCalendarEvent(updatedCalendarEvent);
        } else {
            throw new InvalidCalendar("Could not update new calendar event.");
        }
    }
    
}
