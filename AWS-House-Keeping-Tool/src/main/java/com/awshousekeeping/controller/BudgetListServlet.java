package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.impl.BudgetServiceImpl;

@WebServlet(urlPatterns = "/Budget-List.do")

public class BudgetListServlet extends HttpServlet {

	private BudgetServiceImpl budgetServiceImpl = new BudgetServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("budgets", budgetServiceImpl.listAllBudgets());
		request.getRequestDispatcher("/WEB-INF/views/Budget-List.jsp").forward(request, response);
	}

}
