package com.iweb.nct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.iweb.nct.entity.Character;

import com.iweb.nct.entity.User;

public class CharacterDao extends BaseDao{
	private CharacterDao (){}
	private static CharacterDao characterDao = new CharacterDao();
	public static CharacterDao getInstance(){
		return characterDao;
	}
	
	public Character find(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Character character where character.id = ?");
			query.setInteger(0, id);
			List characters = query.list();
			if(characters.size() > 0){
				return (Character)characters.get(0);
			}
		}finally{
			if(session != null){
				session.close();
			}
		}
		return null;
	}
}
