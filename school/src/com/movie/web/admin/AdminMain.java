package com.movie.web.admin;

import java.util.Scanner;

import com.movie.web.admin.AdminService;
import com.movie.web.admin.AdminServiceImpl;
import com.movie.web.grade.GradeBean;

import java.util.ArrayList;
import java.util.Map;

/**
 * @file GradeController.java
 * @author rlaalfl92@gmail.com
 * @date 2016. 3. 14.
 * @story
 *
 */
public class AdminMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AdminService service = new AdminServiceImpl();
		while (true) {
			System.out.println("[메뉴] 1.성적입력 2.성적수정 3.성적조회(id) 4.조회(전체) 0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("[성적입력] id,자바,SQL,JSP,스프링 점수입력 :");
				 System.out.println(service.addScore(new GradeBean(s.next(),s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt())));
				break;
			case 2:
				System.out.println("[성적수정] id,자바,SQL,JSP,스프링 점수입력 :");
				// System.out.println(service.updateScore(new GradeBean(s.next(),s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt())));
				break;
			case 3:
				System.out.println("[id로 성적조회] id 입력 :");
				System.out.println(service.getGradeListById(s.next()));
				
				break;
			case 4:
				System.out.println("[조회(전체)]");
				System.out.println(service.getGradeList());
				break;

			case 0:
				System.out.println("[종료]");

				return;

			default:
				System.out.println("잘못된 값");
				return;
			}
		}
	}
}
