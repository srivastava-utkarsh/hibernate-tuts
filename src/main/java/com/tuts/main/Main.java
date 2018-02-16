package com.tuts.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
            
            
            UserDetails userDetails = new UserDetails("utkarsh", "utkarsh@gmail.com");
            Vehicle vehicle1 = new Vehicle("twister");
            Vehicle vehicle2 = new Vehicle("gixer");
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle1);
            vehicles.add(vehicle2);
            
            
            userDetails.setVehicle(vehicles);
            session.beginTransaction();
            session.save(vehicle1);
            session.save(vehicle2);
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
//        main.read();
        main.exit();
    }
}
