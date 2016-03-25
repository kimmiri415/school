package com.movie.web.jquery;

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

@WebServlet({ "/jquery/attr.do", "/jquery/core.do", "/jquery/dom.do",  
	"/jquery/event.do", "/jquery/selector.do", "/jquery/traversing.do",})
public class JqeuryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		command = CommandFactory.createCommand(Seperator.extract(request)[2], Seperator.extract(request)[3]);

		DispatcherServlet.go(request, response, command.getView());
	}

}
