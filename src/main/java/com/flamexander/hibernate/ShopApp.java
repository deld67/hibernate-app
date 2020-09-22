package com.flamexander.hibernate;

import com.flamexander.hibernate.lib.Buyer;
import com.flamexander.hibernate.lib.PrepareDataApp;
import com.flamexander.hibernate.lib.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        Long maxId = null;

        SessionFactory factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            System.out.println("============\n== CREATE ==\n============");

            session = factory.getCurrentSession();
            session.beginTransaction();

            Buyer newBuer = new Buyer();
            newBuer.setName( "Sergey" );
            newBuer.setId(3L);
            List<Product> allProducts = session.createQuery("SELECT b FROM products b").getResultList();
            for (Product p: allProducts) {
                if (p.getCost() < 50L){
                    newBuer.getProducts().add( p );
                }
            }
            session.saveOrUpdate(newBuer);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
