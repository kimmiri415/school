package com.movie.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;


@WebServlet({"/admin/admin_form.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		MemberBean member = new MemberBean();
		String directory = Seperator.extract(request)[2];
		String action = Seperator.extract(request)[3];

		switch (action) {
		case "admin_form": 
			command = CommandFactory.createCommand(directory, action);
			break;
		case "":
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		DispatcherServlet.go(request, response, command.getView());
	}

}
