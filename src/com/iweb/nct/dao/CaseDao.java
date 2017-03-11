package com.iweb.nct.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.iweb.nct.entity.Case;

public class CaseDao extends BaseDao{
	
	private static List<Case> cases 
		= new ArrayList<Case>();
	
	private void init(){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Case");
			cases = query.list();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	static{//初始集合
		new CaseDao().init();
	}
	
	public static List<Case> getCases(){
		return cases;
	}
	
}
