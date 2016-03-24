package com.movie.web.js;

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

@WebServlet({ "/js/hello.do", "/js/var.do", "/js/operator.do", "/js/function.do", "/js/object.do", "/js/bom.do",
		"/js/dom.do", "/js/form.do", "/js/closure.do", "/js/pattern.do" })
public class JsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();

		// String directory = Seperator.extract(request)[2];
		// String action = Seperator.extract(request)[3];

		command = CommandFactory.createCommand(Seperator.extract(request)[2], Seperator.extract(request)[3]);

		DispatcherServlet.go(request, response, command.getView());
	}

}
