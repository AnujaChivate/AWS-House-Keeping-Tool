package com.awshousekeeping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awshousekeeping.services.AwsS3ListService;
import com.awshousekeeping.services.impl.AwsS3ListServiceImpl;

/**
 * 
 * @author
 *
 */
@WebServlet(urlPatterns = "/listawss3.do")
public class ListS3Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AwsS3ListService awsS3ListService = new AwsS3ListServiceImpl();

	/**
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("s3Buckets",
					awsS3ListService.listAWSs3Buckets(0));
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());

		}
		request.getRequestDispatcher("/WEB-INF/views/s3-List.jsp").forward(
				request, response);
	}

}
