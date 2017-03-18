package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.impl.AccountServiceImpl;
import com.awshousekeeping.utils.BusinessException;

@WebServlet(urlPatterns = "/Account-List.do")

public class AccountListServlet extends HttpServlet {

	private AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setAttribute("account", accountServiceImpl.listAllAccounts());
		request.getRequestDispatcher("/WEB-INF/views/Account-List.jsp").forward(request, response);
	}

}
