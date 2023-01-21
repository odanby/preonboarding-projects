package com.tabitha.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    public static Session session;
    public static Transaction transaction;
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            // first, we create a configuration based on hibernate.cfg.xml:
            Configuration cfg = new Configuration();

            // connect configuration to the file:
            cfg.configure("com/tabitha/resources/hibernate.cfg.xml");

            // a factory that creates sessions (this line creates the table in the database)
            sessionFactory = cfg.buildSessionFactory();
        }

        // return the factory to be used in other methods
        return sessionFactory;
    }
    
    // this beginTransaction method can be used in any DAOs I create now
    public static void beginTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public static void endTransaction() {
        transaction.commit();
        session.close();
    }

    public static Session getSession() {
        return session;
    }
}
