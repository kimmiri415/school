/**
 * 
 */
package com.movie.web.member;

import java.util.HashMap;

import oracle.net.aso.g;

/**
 * @file MemberServiceImpl.java
 * @author rlaalfl92@gmail.com
 * @date 2016. 3. 15.
 * @story
 *
 */
public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance();// deep copy

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	public static MemberService getInstance() {
		return instance;
	}

	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member);
	}

	@Override
	public MemberBean login(String id, String password) {
		MemberBean member = new MemberBean();
		member = dao.selectById(id, password);
		if (member != null) {
			System.out.println("서비스 : 멤버가 널이 아님");
			return member;
		} else {
			System.out.println("서비스 : 멤버가 널임");
			return null;
		}
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야 함
	}

	public MemberBean detail(String id) {
		// 내정보 보기
		return dao.selectMember(id);
	}

	public int update(MemberBean member) {
		// 수정
	
		return dao.update(member);
	}

	public int remove(String id) {
		// 탈퇴
		return dao.delete(id);
	}

	@Override
	public boolean isMember(String id) {

		return dao.isMember(id);
	}

}
