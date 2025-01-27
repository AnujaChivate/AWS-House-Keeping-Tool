package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.model.Todo;
import com.awshousekeeping.services.impl.TodoServiceImpl;

@WebServlet(urlPatterns = "/delete-user.do")
public class DeleteTodoServlet extends HttpServlet {

	private TodoServiceImpl todoService = new TodoServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		todoService.deleteTodo(new Todo(request.getParameter("todo"), request
				.getParameter("category")));
		response.sendRedirect("delete-user.do");
	}
}