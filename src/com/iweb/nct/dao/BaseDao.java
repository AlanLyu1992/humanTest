package com.iweb.nct.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	static SessionFactory sessionFactory = null;
	static {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
	}
	
	
}
