package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		String[] arr = new String[2];
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];
		switch (action) {
		case "join":
			String id = request.getParameter("id");
			System.out.println("id :" + id);
			break;
		case "login":
			System.out.println("====로그인====");
			command = CommandFactory.createCommand(directory, "detail");
			break;

		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}

		System.out.println("Directory :" + directory);
		System.out.println("getView() :" + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		// request.getRequestDispatcher(new Command(doProc(request,
		// response)[0], doProc(request, response)[1]).getView());

		// request.getRequestDispatcher(fac.getCommand(doProc(request,
		// response)[0], doProc(request, response)[1]).getView());

		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
