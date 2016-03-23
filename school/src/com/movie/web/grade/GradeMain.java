package com.movie.web.grade;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

/**
 * @file GradeController.java
 * @author rlaalfl92@gmail.com
 * @date 2016. 3. 14.
 * @story
 *
 */
public class GradeMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();
		while (true) {
			System.out.println("[메뉴] 1.등록 2.수정 3.삭제 4.조회(전체) 5.조회(이름) 6.조회(학번) 7.회원수 0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("[등록] 학번,이름,자바,SQL,JSP,스프링 점수입력 :");
				service.input(new GradeBean(s.nextInt(), s.next(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()));
				break;
			case 2:
				System.out.println("수정하려는 성적표의 학번, 자바, SQL, JSP, 스프링 점수입력 :");
				int hak = s.nextInt();
				// String name = service.getGradeByHak(hak).getId();
				// System.out.println(
				// service.update(new GradeBean(hak, name, s.nextInt(),
				// s.nextInt(), s.nextInt(), s.nextInt())));
				break;
			case 3:
				System.out.println("[삭제] 삭제할 학번 입력 : ");
				System.out.println(service.delete(s.nextInt()));
				break;
			case 4:
				System.out.println("[조회(전체)]");
				System.out.println(service.getList());
				break;
			case 5:
				System.out.println("[조회(이름)] 조회할 이름 입력 : ");
				System.out.println(service.getGradesByName(s.next()).toString());
				break;
			case 6:
				System.out.println("[조회(학번)] 조회할 학번 입력 : ");
				System.out.println(service.getGradeByHak(s.nextInt()));
				break;
			case 7:
				System.out.println("[회원수]");
				System.out.println(service.getCount());
				break;
				
			case 0:
				System.out.println("종료");

				return;

			default:
				System.out.println("잘못된 값");
				return;
			}
		}
	}
}
