/**
 * 
 */
package com.movie.web.member;

public interface MemberService {
	// 인터페이스는 추상메소드만 와야한다는 문법이 있어서
	// abstract를 생략가능하다.
	// 그러나 추상클래스는 구상 메소드가 존재 가능하므로
	// 둘을 구분하기 위해서는 반드시 abstract를 붙여야한다.
	public abstract void join(MemberBean member);

	public MemberBean login(String id, String password);

	public String update(MemberBean member);

	public MemberBean detail(String id);

	public String remove(String id);
	
	public boolean isMember(String id);
}
