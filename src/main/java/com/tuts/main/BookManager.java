package com.tuts.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
    protected SessionFactory sessionFactory;
    
    protected void setup(){
        final StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    
    protected void exit(){
        sessionFactory.close();
    }
    
    protected void create(){
        Book book = new Book();
        book.setTitle("effective java");
        book.setAuthor("joshua bloch");
        book.setPrice(55.5f);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(book);
        
        session.getTransaction().commit();
        session.close();
    }
    
    protected void read(){
        Session session = sessionFactory.openSession();
        
        long id = 1;
        Book book = session.get(Book.class, id);
        if (book != null) {
            System.out.printf("%n%n%s%n%n","====reading===");
            System.out.printf("%n%n%s%n%n",book);
            System.out.printf("%n%n%s%n%n","============");
                
        }
        session.close();
    }
    
    protected void update(){
            Session session = sessionFactory.openSession();
        try {
            long id = 1;
            session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                book.setTitle("more and more effective java");
                session.update(book);
                session.getTransaction().commit();
                System.out.printf("%n%n%s%n%n","===after updating====");
                System.out.printf("%n%n%s%n%n",book);
                System.out.printf("%n%n%s%n%n","============");
            }
        } finally {
            session.close();
        }
    }
    
    protected void delete(){
            Session session = sessionFactory.openSession();
        try {
            long id = 1;
            session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }
    
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.setup();
        manager.delete();
        manager.exit();
    }
}
