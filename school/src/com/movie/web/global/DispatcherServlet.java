package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void go(HttpServletRequest request, HttpServletResponse response,String view) {
		try {
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
