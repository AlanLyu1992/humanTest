package com.iweb.nct.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iweb.nct.dao.CaseDao;
import com.iweb.nct.dao.UserDao;
import com.iweb.nct.entity.Pagenation;
import com.iweb.nct.entity.User;

public class UserAction {
	//注册
	public String add(HttpServletRequest request, HttpServletResponse response){
		String loginname = request.getParameter("loginname");
		String loginpass = request.getParameter("loginpass");
		String uname = request.getParameter("uname");
		User user = new User(loginname, loginpass, uname);
		if(UserDao.getInstance().add(user)){//成功
			return "success";
		}else{//失败
			return "failure";
		}
	}
	
	//登录
	public String find(HttpServletRequest request, HttpServletResponse response){
		String loginname = request.getParameter("loginname");
		String loginpass = request.getParameter("loginpass");
		User user = UserDao.getInstance().find(loginname, loginpass);
		if(user != null){//成功
			int[] result = new int[CaseDao.getCases().size()];
			request.getSession().setAttribute("result", result);
			request.getSession().setAttribute("user", user);
			return "success";
		}else{//失败
			return "failure";
		}
	}
	
	//验证
	public String validate(HttpServletRequest request, HttpServletResponse response){
		String loginname = request.getParameter("loginname");		
		if(UserDao.getInstance().find(loginname)){
			return "false";
		}else{//用户名可用
			return "true";
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response){
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentPageStr != null){
			currentPage = Integer.parseInt(currentPageStr);			
		}
		Pagenation pn = new Pagenation(UserDao.getInstance().getTotalSize(), 5, currentPage);
		pn.setPageDate(UserDao.getInstance().getPageData(pn));
		request.getSession().setAttribute("pn", pn);
		return "success";
	}
}
