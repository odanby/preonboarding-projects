package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Calendar;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean serviceRemoveCalendarEvent(Calendar calendarEventToBeDeleted) {
        return this.calendarDao.removeCalendarEvent(calendarEventToBeDeleted);
    }

    @Override
    public Calendar serviceUpdateCalendarEvent(Calendar updatedCalendarEvent) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
