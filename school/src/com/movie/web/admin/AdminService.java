package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminService {
	public List<GradeMemberBean> getGradeList();
	public int addScore(GradeBean bean);
	public GradeMemberBean getGradeListById(String id);
	public AdminBean getAdmin(AdminBean admin);

	
	
}
