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

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		MemberService service = new MemberServiceImpl();
		String id = "", password = "";

		String[] arr = new String[2];
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];
		switch (action) {
		case "join":
			System.out.println("====회원가입====");

			MemberBean member = new MemberBean();
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setName(request.getParameter("name"));
			// member.setBirth(parseInt(request.getParameter("birth")));
			// service.join(member);
			System.out.println(request.getParameter("birth") + "생일은 뭘까?");
			// System.out.println("id :" + id);
			command = CommandFactory.createCommand(directory, "login_form");
			break;
		case "login":
			
			if (service.isMember(request.getParameter("id")) == true) {
				System.out.println("====  아이디가 존재함 ===========");
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if (member.getId().equals(null)) {
					System.out.println("비밀번호오류");
					command = CommandFactory.createCommand(directory,"login_form");
				}else{
					System.out.println("로그인 성공");
					request.setAttribute("member", member);
					command = CommandFactory.createCommand(directory,"detail");
				}
			} else {
				System.out.println("====  로그인 실패 ===========");
				command = CommandFactory.createCommand(directory,"login_form");
			}
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
