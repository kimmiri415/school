package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminDAOImpl implements AdminDAO {
	private static AdminDAO instance = new AdminDAOImpl();

	private Connection conn;// 오라클 연결객체
	private Statement stmt;// 쿼리 전송객체
	private PreparedStatement pstmt;// 쿼리 전송 객체 2
	private ResultSet rs;// 리턴값 회수 객체

	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	public static AdminDAO getInstance() {
		return instance;
	}

	@Override
	public List<GradeMemberBean> selectAllMember() {
		List<GradeMemberBean> beanList = new ArrayList<GradeMemberBean>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();

				bean.setId(rs.getString("id"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				beanList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectAllMember() 에서 에러 발생");
			e.printStackTrace();
		}
		return beanList;
	}

	@Override
	public int insertScore(GradeBean grade) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) VALUES(score_seq.NEXTVAL,?,?,?,?,?)");

			// Connection은 내부적으로 Factory (ex- create...)////싱글톤은 대부분
			// getInstance로시작
			// pstmt.setInt(1, grade.getHak());
			pstmt.setString(1, grade.getId());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getJsp());
			pstmt.setInt(5, grade.getSpring());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertScore() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("성적입력 성공여부 : " + result);
		return result;
	}

	@Override
	public GradeMemberBean selectMemberById(String id) {
		GradeMemberBean bean = new GradeMemberBean();
		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember where id='" + id + "'");

			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));

			}
		} catch (Exception e) {
			System.out.println("selectMemberById() 에서 에러 발생");
			e.printStackTrace();
		}

		return bean;
	}

	@Override
	public AdminBean selectAdmin(AdminBean admin) {
		AdminBean temp = new AdminBean();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Admin WHERE id ='" + admin.getId() + "' and password='"+admin.getPassword()+"'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setRole(rs.getString("role"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("selectAdmin() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("selectAdmin()의 쿼리 조회 결과 : " + temp.getAddr());
		return temp;
	}

}
