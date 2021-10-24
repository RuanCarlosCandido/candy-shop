package org.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.tables.Client;
import org.tables.Product;
import org.tables.Sale;

public class MyConnection {

	private static Configuration con = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Client.class)
			.addAnnotatedClass(Sale.class)
			.addAnnotatedClass(Product.class);

	private static ServiceRegistry registry = new StandardServiceRegistryBuilder()
			.applySettings(con.getProperties())
			.build();

	private static SessionFactory sessionFactory = con.buildSessionFactory(registry);

	private static Session session = sessionFactory.openSession();

	public static Session getSession() {
		return session;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
