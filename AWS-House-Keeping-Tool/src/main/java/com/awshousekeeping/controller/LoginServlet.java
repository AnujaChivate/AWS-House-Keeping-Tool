package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.impl.LoginServiceImpl;
import com.awshousekeeping.services.impl.TodoServiceImpl;
import com.awshousekeeping.utils.BusinessException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginServiceImpl userValidationService = new LoginServiceImpl();
	private TodoServiceImpl todoService = new TodoServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		int role;
		try {
			role = userValidationService.isUserValid(name, password);
			if (role == 1) {
				request.getSession().setAttribute("name", name);
				response.sendRedirect("list-todos.do");

			} else if (role == 2) {
				request.getSession().setAttribute("name", name);
				response.sendRedirect("landing-admin.do");

			} else {
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp")
						.forward(request, response);
			}
		} catch (BusinessException e) {

			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);

		}

	}

}