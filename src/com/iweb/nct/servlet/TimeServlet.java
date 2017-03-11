package com.iweb.nct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iweb.nct.dao.UserDao;
import com.iweb.nct.entity.User;

public class TimeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TimeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		User user = UserDao.getInstance().find(id);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(user == null){
			out.println("用户不存在!");
			out.flush();
			out.close();
			return;
		}
		
		StringBuffer sb = new StringBuffer("{");
		sb.append("id:").append(user.getId());
		sb.append(",").append("loginname:'").append(user.getLoginname());
		sb.append("',").append("loginpass:'").append(user.getLoginpass());
		sb.append("',").append("uname:'").append(user.getUname());
		sb.append("'}");
		System.out.println(sb.toString());
		out.println(sb);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
