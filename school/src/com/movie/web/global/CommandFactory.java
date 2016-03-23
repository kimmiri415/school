package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Facotry 패턴 : 생성자 객체를 만드는 공장
public class CommandFactory {
	public static Command getCommand(HttpServletRequest request, HttpServletResponse response) {
		String[] arr = new String[2];
		String path = request.getServletPath();
		//String queryString = ""; // 쿼리스트링있을때랑 없을때 if else
		arr[0] = path.split("/")[1];
		arr[1] = path.split("/")[2].split("\\.")[0];

		// arr[1] = path.split("/")[2].substring(0,
		// path.split("/")[2].indexOf("."));

		return new Command(arr[0], arr[1]);
	}

	public static Command createCommand(String directory, String action) {

		return new Command(directory, action);

	}
}
