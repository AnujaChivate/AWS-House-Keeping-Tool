package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.impl.AccountServiceImpl;

@WebServlet(urlPatterns = "/Account-List.do")

public class AccountListServlet extends HttpServlet {

	private AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    // list of all accounts
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setAttribute("accounts", accountServiceImpl.listAllAccounts());
		request.getRequestDispatcher("/WEB-INF/views/Account-List.jsp").forward(request, response);
	}

}
