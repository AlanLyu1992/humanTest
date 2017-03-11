package com.iweb.nct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iweb.nct.dao.CaseDao;
import com.iweb.nct.dao.CharacterDao;
import com.iweb.nct.dao.ResultDao;
import com.iweb.nct.entity.Case;
import com.iweb.nct.entity.User;

public class GameServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GameServlet() {
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

		List<Case> cases = CaseDao.getCases();
		request.getSession().setAttribute("case_size", cases.size());		
		String idxStr = request.getParameter("idx");
		int idx = 0;
		if(idxStr != null){
			idx = Integer.parseInt(idxStr);
			//	给出结果
			if(idx == cases.size()){
				int[] result = (int[])request.getSession().getAttribute("result");
				//保存
				User user = (User)request.getSession().getAttribute("user");
				ResultDao.getInstance().save(user.getId(), result);
				int[] grade = new int[9];
				for(int i = 0;i < result.length; i++){
					if(result[i] == 1){
						grade[cases.get(i).getChval() - 1]++;
					}				
				}			
				//计算性格值
				int max = grade[0];
				int index = 0;
				for(int i = 1; i < grade.length; i++){
					if(max < grade[i]){
						max = grade[i];
						index = i;
					}
				}
				String characterDetail = CharacterDao.getInstance().find(index + 1).getDetail();
				request.setAttribute("cd", characterDetail);
				request.getRequestDispatcher("/result.jsp").forward(request, response);
				return;
			}
		}
		
		request.setAttribute("case", cases.get(idx));
		request.setAttribute("idx", idx);
		request.getRequestDispatcher("/game.jsp").forward(request, response);
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
