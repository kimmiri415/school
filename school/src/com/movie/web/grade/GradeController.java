package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

@WebServlet("/grade/my_grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();

		String id = "";

		String[] arr = new String[2];
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];
		switch (action) {
		case "my_grade":
			System.out.println("====내 성적가져오기====");
			System.out.println(service.getGradeById(request.getParameter("id")));
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));

			command = CommandFactory.createCommand(directory, "my_grade");
			break;

		default:
			break;
		}

		System.out.println("Directory :" + directory);
		System.out.println("getView() :" + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
