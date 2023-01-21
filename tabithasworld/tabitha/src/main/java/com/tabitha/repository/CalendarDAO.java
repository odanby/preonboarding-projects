package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Calendar;
import com.tabitha.utils.HibernateUtil;

public class CalendarDAO implements CalendarDAOInterface {

    @Override
    public List<Calendar> getAllCalendarEvents() {
        HibernateUtil.beginTransaction();
        List<Calendar> requestList = HibernateUtil.getSession().createQuery("from Calendar", Calendar.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Calendar> getAllCalendarEventsByUserId(int task_user_id) {
        HibernateUtil.beginTransaction();
        List<Calendar> requestList = HibernateUtil.getSession().createQuery("from Calendar where task_user_id = :TaskUserId", Calendar.class).setParameter("TaskUserId", task_user_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Calendar> getAllCalendarEventsByEventId(int event_id) {
        HibernateUtil.beginTransaction();
        List<Calendar> requestList = HibernateUtil.getSession().createQuery("from Calendar where event_id = :EventId", Calendar.class).setParameter("EventId", event_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Calendar> getAllCalendarEventsByEventStatus(String event_status) {
        HibernateUtil.beginTransaction();
        List<Calendar> requestList = HibernateUtil.getSession().createQuery("from Calendar where event_status = :EventStatus", Calendar.class).setParameter("EventStatus", event_status).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Calendar> getAllCalendarEventsByDayStatus(String day_status) {
        HibernateUtil.beginTransaction();
        List<Calendar> requestList = HibernateUtil.getSession().createQuery("from Calendar where day_status = :DayStatus", Calendar.class).setParameter("DayStatus", day_status).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public Calendar createCalendarEvent(Calendar newCalendarEvent) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newCalendarEvent);
        HibernateUtil.endTransaction();
        return newCalendarEvent;
    }

    @Override
    public boolean removeCalendarEvent(Calendar calendarEventToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(calendarEventToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public Calendar updateCalendarEvent(Calendar updatedCalendarEvent) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedCalendarEvent);
        HibernateUtil.endTransaction();
        return updatedCalendarEvent;
    }
    
}
