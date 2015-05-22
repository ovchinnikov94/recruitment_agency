package com.ragency.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory session; 
	HibernateUtil(){
		
	}
	static {
		session = new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSession() {
			return session;
	}
	
}
