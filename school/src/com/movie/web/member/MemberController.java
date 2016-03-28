package com.movie.web.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do", "/member/update_form.do", "/member/update.do", "/member/delete.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		MemberBean member = new MemberBean();
//		String path = Seperator.extract(request)[0];
//		String temp = Seperator.extract(request)[1];
		String directory = Seperator.extract(request)[2];
		String action = Seperator.extract(request)[3];
		HttpSession session = request.getSession();
		
		switch (action) {
		case "join":

			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			if (service.join(member) == 1) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				command = CommandFactory.createCommand(directory, "join_form");
			}
			break;

		case "login":

			if (service.isMember(request.getParameter("id")) == true) {
				System.out.println("====  아이디가 존재함 ===========");
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if (member == null) {
					command = CommandFactory.createCommand(directory, "login_form");
				} else {
					System.out.println("로그인 성공");
					//request.setAttribute("member", member);//request => dom  
					session.setAttribute("user", member);//session => bom
					command = CommandFactory.createCommand(directory, "detail");
				}

			} else {
				System.out.println("====  로그인 실패 ===========");
				command = CommandFactory.createCommand(directory, "login_form");
			}

			break;
		case "update_form":
			System.out.println("====  수정 폼으로 진입 get===========");
			command = CommandFactory.createCommand(directory, action);

			break;
		case "delete":
			System.out.println("=====  회원탈퇴 진입 ===========");

			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				command = CommandFactory.createCommand(directory, "detail");
			}
			break;

		case "update":
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			if (service.update(member) == 1) {
				session.setAttribute("user", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "detail");
			} else {
				command = CommandFactory.createCommand(directory, "update_form");
			}
			break;
		case "logout":
			session.invalidate();
			command = CommandFactory.createCommand(directory, "login_form");
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		DispatcherServlet.go(request, response, command.getView());
	}

}
