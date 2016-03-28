package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService{
	private static AdminService instance = new AdminServiceImpl();
	AdminDAO dao = AdminDAOImpl.getInstance();
	
	public static AdminService getInstance() {
		return instance;
	}
	@Override
	public List<GradeMemberBean>  getGradeList() {
		// TODO Auto-generated method stub
		return dao.selectAllMember();
	}

	@Override
	public int addScore(GradeBean bean) {
		// TODO Auto-generated method stub
		return dao.insertScore(bean);
	}
	@Override
	public GradeMemberBean getGradeListById(String id) {
		
		return dao.selectMemberById(id);
	}
	@Override
	public AdminBean getAdmin(AdminBean admin) {
		return dao.selectAdmin(admin);
	}

}
