package org.struts.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.struts.action.Action;
import org.struts.util.ConfigParser;

import com.iweb.nct.action.UserAction;

public class ActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ActionServlet() {
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
		
		try {
			Class.forName("org.struts.util.ConfigParser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.replace(path, "");
		System.out.println(uri);
		for(Action action : ConfigParser.actions){
			if(uri.equals(action.getUriPattern() + ".action")){
				try {
					Class clazz = Class.forName(action.getClassName());
					System.out.println(clazz);
					Method method = clazz.getMethod(action.getMethodName(), new Class[]{HttpServletRequest.class, HttpServletResponse.class});
					String key = method.invoke(clazz.newInstance(), new Object[]{request, response}).toString();
					if(action.getResults().size() == 0){//ajax
						PrintWriter out = response.getWriter();
						out.print(key);
						return;
					}
					String value = action.getResults().get(key);
					if(value == null){
						throw new Exception("返回的key:" + key + "与配置文件不匹配!");
					}
					request.getRequestDispatcher(value).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}			
		}	    
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
