package com.awshousekeeping.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.model.Account;
import com.awshousekeeping.services.AccountService;
import com.awshousekeeping.services.impl.AccountServiceImpl;

@WebServlet(urlPatterns = "/add-account.do")
public class AddAccountServlet extends HttpServlet {

	private AccountService accountService = new AccountServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-account.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Account account = new Account();

			// account.setAccountId(Integer.parseInt(request.getParameter("accountId")));
			account.setProjectId(request.getParameter("projectId"));
			account.setProjectName(request.getParameter("projectName"));
			account.setAwsAccountAlias(request.getParameter("awsAccountAlias"));
			account.setAwsAccountOwnerName(request
					.getParameter("awsAccountOwnerName"));
			account.setEmailIdOfOwner(request.getParameter("emailIdOfOwner"));
			account.setAccountType(request.getParameter("accountType"));
			account.setCreatedOn(new Date());
			account.setCreatedBy(request.getSession().getAttribute("name")
					.toString());
			account.setUpdatedOn(new Date());
			account.setUpdatedBy(request.getSession().getAttribute("name")
					.toString());
			account.setHspsId(request.getParameter("hspsId"));
			account.setHspsExpireDate(new Date());
			account.setProjectExpireDate(new Date());
			account.setFreeTrialExpireDate(new Date());
			account.setHspsDescription(request.getParameter("hspsDescription"));
			account.setBusinessUnit(request.getParameter("businessUnit"));
			account.setAwsAccountNumber(request
					.getParameter("awsAccountNumber"));
			account.setAwsAccessKey(request.getParameter("awsAccessKey"));
			account.setAwsSecretKey(request.getParameter("awsSecretKey"));
			account.setAwsAccessKeyXXXX(request
					.getParameter("awsAccessKeyXXXX"));
			account.setAwsSecretKeyXXXX(request
					.getParameter("awsSecretKeyXXXX"));

			// TODO continue Complte all
			// fields................................................

			boolean success = accountService.addAccount(account);

			if (success) {
				response.sendRedirect("Account-List.do");
			} else {
				request.setAttribute("errorMessage",
						"Error while Adding account");
				request.getRequestDispatcher("/WEB-INF/views/add-account.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getCause());
			request.getRequestDispatcher("/WEB-INF/views/add-account.jsp")
					.forward(request, response);

		}

	}

}
