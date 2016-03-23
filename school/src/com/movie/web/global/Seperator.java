package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;


public class Seperator {
	public static String[] extract(HttpServletRequest request) {

		String[] seperators = new String[4];
		String path = request.getServletPath();
		String temp = path.split("/")[2];
		String directory = path.split("/")[1];
		String action = temp.substring(0, temp.indexOf("."));
		seperators[0] = path;
		seperators[1] = temp;
		seperators[2] = directory;
		seperators[3] = action;
		// arr[1] = temp3.split("\\.")[0]; 이 방법도 가능
		return seperators;

	}
}
