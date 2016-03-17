/**
 * 
 */
package com.movie.web.member;

import java.util.HashMap;

/**
 * @file MemberServiceImpl.java
 * @author rlaalfl92@gmail.com
 * @date 2016. 3. 15.
 * @story
 *
 */
public class MemberServiceImpl implements MemberService {
	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl();// deep copy

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	public String join(MemberBean member) {
		// 회원가입
		String result = "회원가입 실패";
		if (detail(member.getId()) == null) {
			dao.insert(member);
			result = "회원가입 성공 : " + detail(member.getId());
		}
		return result;
	}

	public String login(String id, String password) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야함

		return ((map.containsKey(id)) ? ((map.get(id).getPassword().equals(password))
				? map.get(id).getName() + "님 로그인하셨습니다." : "비밀번호를 확인해주세요.") : "존재하지않는 id입니다.");

	}

	public MemberBean detail(String id) {
		// 내정보 보기
		return dao.selectMember(id);
	}

	public String update(MemberBean member) {
		// 수정
		String result = "수정하려는 id가 존재하지 않음";
		if (map.containsKey(member.getId())) {
			// 방법1.//map.replace(member.getId(), member);
			// 방법2.
			MemberBean tempBean = map.get(member.getId());
			tempBean.setPassword(member.getPassword());
			tempBean.setAddr(member.getAddr());
			tempBean.setBirth(member.getBirth());
			tempBean.setName(member.getName());

			result = "수정 성공 " + tempBean;
		}

		return result;
	}

	public String remove(String id) {
		// 탈퇴
		String result = "탈퇴하려는 id가 존재하지 않음";
		if (map.containsKey(id)) {
			map.remove(id);
			result = "탈퇴 성공";
		}
		return result;
	}

}
