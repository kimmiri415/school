/**
 * 
 */
package com.movie.web.member;

import java.util.Scanner;

/**
 * @file MemberController.java
 * @author rlaalfl92@gmail.com
 * @date 2016. 3. 15.
 * @story
 *
 */
public class MemberController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MemberService service = new MemberServiceImpl();

		while (true) {
			System.out.println("[메뉴] 1.회원가입 2.로그인 3.내정보보기 4.내정보수정 5.탈퇴 0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("[회원가입] id, password, 이름, 주소, 생년월일 입력 :");
				MemberBean member = new MemberBean(s.next(), s.next(), s.next(), s.next(), s.nextInt());
				System.out.println(service.join(member));
				break;
			case 2:
				System.out.println("[로그인] id, password 입력 : ");
				System.out.println(service.login(s.next(), s.next()));
				break;
			case 3:
				System.out.println("[내정보보기] id 입력 : ");
				System.out.println(service.detail(s.next()).toString());
				break;
			case 4:
				System.out.println("[내정보수정] id와 수정할정보(password, 이름, 주소, 생년월일)입력 :");
				System.out.println(service.update(new MemberBean(s.next(), s.next(), s.next(), s.next(), s.nextInt())));
				break;
			case 5:
				System.out.println("[탈퇴] id 입력 : ");
				System.out.println(service.remove(s.next()));
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
