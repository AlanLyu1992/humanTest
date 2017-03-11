package com.iweb.nct.dao;

import org.hibernate.Session;

public class ResultDao extends BaseDao{
	private ResultDao (){}
	private static ResultDao resultDao = new ResultDao();
	public static ResultDao getInstance(){
		return resultDao;
	}
	
	public boolean save(int userId, int[] result){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			System.out.println("ID: "+(Integer)session.save(result));
			return true;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
}
