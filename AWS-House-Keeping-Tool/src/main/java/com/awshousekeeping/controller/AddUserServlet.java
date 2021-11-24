package com.awshousekeeping.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.model.User;
import com.awshousekeeping.services.UserService;
import com.awshousekeeping.services.impl.UserServiceImpl;
import com.awshousekeeping.utils.BusinessException;

@WebServlet(urlPatterns = "/add-user.do")
public class AddUserServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			User user = new User();
			// String newTodo = request.getParameter("todo");
			
			user.setCreatedBy(request.getSession().getAttribute("name").toString());
			user.setUpdatedBy(request.getSession().getAttribute("name").toString());
			user.setCreateOn(new Date());
			user.setUpdatedOn(new Date());
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setIsActive(1);
			user.setUserName(request.getParameter("userName"));
			
			user.setRole(1);
			
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));

			boolean success = userService.addUser(user);

			if (success) {
				response.sendRedirect("User-List.do");
			} else {
				request.setAttribute("errorMessage", "Error while Adding user");
				request.getRequestDispatcher("/WEB-INF/views/add-user.jsp")
						.forward(request, response);
			}
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/add-user.jsp")
					.forward(request, response);

		}

	}

}