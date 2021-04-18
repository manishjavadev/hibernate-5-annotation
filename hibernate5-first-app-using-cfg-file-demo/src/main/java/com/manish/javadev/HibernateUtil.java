package com.manish.javadev;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

				MetadataSources metadataSources = new MetadataSources(serviceRegistry);
				metadataSources.addAnnotatedClass(Student.class);
				// Create Metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
