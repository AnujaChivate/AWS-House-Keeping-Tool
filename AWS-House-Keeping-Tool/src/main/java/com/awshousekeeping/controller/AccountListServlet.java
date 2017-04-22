package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.AccountService;
import com.awshousekeeping.services.impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Account-List.do")
/**
 * 
 * @author pavan_pawar
 * 
 * This Servlet for account management 
 *
 */
public class AccountListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountService accountServiceImpl = new AccountServiceImpl();
		request.setAttribute("accounts", accountServiceImpl.listAllAccounts());
		request.getRequestDispatcher("/WEB-INF/views/Account-List.jsp").forward(request, response);
	}

}