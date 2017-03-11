package com.iweb.nct.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iweb.nct.entity.Pagenation;
import com.iweb.nct.entity.User;

public class UserDao extends BaseDao{
	private UserDao (){}
	public static UserDao userDao = new UserDao();
	public static UserDao getInstance(){
		return userDao;
	}
	
	public User find(String loginname, String loginpass){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			//session.createSQLQuery("")
			Query query = session.createQuery("from User user where user.loginname = ? and user.loginpass = ?");
			query.setString(0, loginname);
			query.setString(1, loginpass);
			List users = query.list();
			if(users.size() > 0){
				return (User)users.get(0);
			}
		}finally{
			if(session != null){
				session.close();
			}
		}
		return null;
	}
	
	public boolean find(String loginname){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from User user where user.loginname = ?");
			query.setString(0, loginname);
			User user = (User)query.iterate().next();			
			user.setUname("娃哈哈");
			if(user != null){
				return true;
			}
		}finally{
			if(session != null){
				session.close();
			}
		}
		return false;
	}
	
	public int getTotalSize(){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("select count(*) from User");
			return Integer.parseInt(query.uniqueResult().toString());
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public List getPageData(Pagenation pn){
		int beginRecord = (pn.getCurrentPage() -1)* pn.getPageSize() + 1;
		int endRecord = pn.getCurrentPage() * pn.getPageSize();
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from User");
			query.setFirstResult(beginRecord);
			query.setMaxResults(5);
			return query.list();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public User find(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from User user where user.id = ?");
			query.setInteger(0, id);
			List users = query.list();
			if(users.size() > 0){
				return (User)users.get(0);
			}
		}finally{
			if(session != null){
				session.close();
			}
		}
		return null;
	}
	
	public boolean add(User user){
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("ID: "+(Integer)session.save(user));
			tx.commit();
			return true;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

}
