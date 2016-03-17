package com.movie.web.grade;

import java.util.ArrayList;

public class GradeServiceImpl implements GradeService {
	// 멤버필드
	ArrayList<GradeBean> gradeList;

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

	public ArrayList<GradeBean> getList() {
		// R 성적표 리스트 출력
		return gradeList;
	}

	public GradeBean getGradeByHak(int hak) {
		// R 성적표 조회(학번)
		GradeBean tempGrade = new GradeBean();
		for (int i = 0; i < gradeList.size(); i++) {

			if (hak == gradeList.get(i).getHak()) {
				tempGrade = gradeList.get(i);
				break;
			}
		}
		return tempGrade;
	}

	@Override
	public ArrayList<GradeBean> getGradesByName(String name) {
		// R 성적표 조회(이름)
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getName())) {
				tempList.add(gradeList.get(i));

			}
		}
		return tempList;
	}

	public int getCount() {
		// R 카운트 조회
		return gradeList.size();

	}

	public void getCountByName() {
		// R 이름조회시 카운트조회

	}

	public String update(GradeBean grade) {
		// U 성적표 수정
		String result = "수정하려는 학번이 존재하지 않음";
		if (gradeList.contains(getGradeByHak(grade.getHak()))) {
			GradeBean searchedGrade = getGradeByHak(grade.getHak());
			searchedGrade.setJava(grade.getJava());
			searchedGrade.setSql(grade.getSql());
			searchedGrade.setJsp(grade.getJsp());
			searchedGrade.setSpring(grade.getSpring());

			result = "수정 성공 " + searchedGrade;
			// delete(grade.getHak());
			// input(grade);
		}

		return result;
	}

	public String delete(int hak) {
		// D 성적표 삭제

		return ((gradeList.remove(getGradeByHak(hak))) ? "삭제성공" : "삭제실패");
	}

}
