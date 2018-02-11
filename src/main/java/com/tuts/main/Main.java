package com.tuts.main;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    protected SessionFactory sessionFactory;
    
    protected void setup(){
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
        }
    }
    
    protected void exit(){
        sessionFactory.close();
    }
    
    
    private void create(){
        Session session = sessionFactory.openSession();
        try {
            Set<Address> listofAddresses = new HashSet<>();
            listofAddresses.add(new Address("noida", "UP"));
            listofAddresses.add(new Address("buxar", "BIHAR"));
            
            UserDetails userDetails = new UserDetails("utkarsh", "utkarsh@gmail.com", listofAddresses);
            
            session.beginTransaction();
            session.save(userDetails);
            session.getTransaction().commit();
            
        } finally {
            session.close();
        }
    }
    
    protected void read(){
        Session session = sessionFactory.openSession();
        
        long id = 1;
        UserDetails userDetails = session.get(UserDetails.class, id);
        if (userDetails != null) {
            System.out.printf("%n%n%s%n%n","====reading===");
            System.out.printf("%n%n%s%n%n",userDetails);
            System.out.printf("%n%n%s%n%n","============");
        }else{
            System.err.println("No details found");
        }
        session.close();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.setup();
        main.create();
        main.read();
        main.exit();
    }
}
