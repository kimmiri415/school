package com.movie.web.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradeServiceImpl implements GradeService {
	// 멤버필드
	ArrayList<GradeBean> gradeList;
	GradeDAO dao = new GradeDAOImpl();

	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>();
	}

	// 멤버 메소드 에어리어
	public void input(GradeBean grade) {
		// C 성적표 등록
		gradeList.add(new GradeBean(2, "김구", 100, 100, 100, 100));
		gradeList.add(new GradeBean(3, "강감찬", 90, 90, 90, 90));
		gradeList.add(new GradeBean(4, "유관순", 80, 80, 80, 80));
		gradeList.add(new GradeBean(5, "김구", 70, 70, 70, 70));
		gradeList.add(grade);
	}

	public List<GradeMemberBean> getList() {
		// R 성적표 리스트 출력
		return dao.selectAll();
	}

	public GradeMemberBean getGradeByHak(int hak) {

		return dao.selectGradeByHak(hak);
	}

	public GradeMemberBean getGradeById(String id) {

		return dao.selectGradeById(id);
	}

	@Override
	public List<GradeMemberBean> getGradesByName(String name) {
		// R 성적표 조회(이름)
		return dao.selectGradesByName(name);
	}

	public int getCount() {
		// R 카운트 조회
		return dao.count();

	}

	public void getCountByName() {
		// R 이름조회시 카운트조회

	}

	public String update(GradeBean grade) {
		// U 성적표 수정
		String temp = "";

		return temp;
	}

	public String delete(int hak) {
		// D 성적표 삭제

		return dao.delete(hak);
	}

}
