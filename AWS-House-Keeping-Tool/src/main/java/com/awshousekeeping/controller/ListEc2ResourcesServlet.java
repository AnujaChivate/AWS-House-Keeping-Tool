package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.AWSListEc2ResourcesService;
import com.awshousekeeping.services.impl.AWSListEc2ResourcesServiceImpl;

/**
 * 
 * 
 *
 */
@WebServlet(urlPatterns = "/listawsec2.do")
public class ListEc2ResourcesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AWSListEc2ResourcesService ec2service = new AWSListEc2ResourcesServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("ec2instances", ec2service.getAllRegionsEc2Resources(0));
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());

		}
		request.getRequestDispatcher("/WEB-INF/views/Ec2-List.jsp").forward(request, response);
	}
}
