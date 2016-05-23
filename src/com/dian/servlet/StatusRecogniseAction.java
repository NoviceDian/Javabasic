package com.dian.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dian.dao.EmpDao;
import com.dian.dao.imp.EmpDaoImp;
import com.dian.entity.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/StatusRecogniseAction")
public class StatusRecogniseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StatusRecogniseAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if (id == null || "".equals(id)) {
			request.setAttribute("error", "������Ա�����");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		} else if (pwd == null || "".equals(pwd)) {
			request.setAttribute("error", "������ϵͳ����");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		} else {
			EmpDao dao = new EmpDaoImp();
			Employee emp = dao.findById(Integer.parseInt(id));
			if (emp == null) {
				request.setAttribute("error", "Ա����Ŵ���");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			} else {
				if (pwd.equals(emp.getPwd())) {
					request.setAttribute("emp", emp);
					response.sendRedirect("index.jsp");
					return;
				} else {
					request.setAttribute("error", "ϵͳ�������");
					dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
				}
			}

		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
