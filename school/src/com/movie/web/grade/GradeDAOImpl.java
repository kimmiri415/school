/**
 * 
 */
package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.member.MemberBean;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class GradeDAOImpl implements GradeDAO {
	private static GradeDAO instance = new GradeDAOImpl();
	
	private Connection conn;// 오라클 연결객체
	private Statement stmt;// 쿼리 전송객체
	private PreparedStatement pstmt;// 쿼리 전송 객체 2
	private ResultSet rs;// 리턴값 회수 객체

	public GradeDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	public static GradeDAO getInstance() {
		return instance;
	}

	@Override
	public void insert(GradeBean grade) {
		// TODO Auto-generated method stub
		GradeMemberBean bean = new GradeMemberBean();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("INSERT INTO Grade(hak,id,java,sql,jsp,spring) VALUES(hak.NEXTVAL,?,?,?,?,?)");
			while (rs.next()) {

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<GradeMemberBean> selectAll() {
		List<GradeMemberBean> beanList = new ArrayList<GradeMemberBean>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setId(rs.getString("id"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				beanList.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("selectAll()에서 에러 발생");
			e.printStackTrace();
		}

		return beanList;
	}

	public GradeMemberBean selectGradeByHak(int hak) {
		// R 성적표 조회(학번)

		GradeMemberBean bean = new GradeMemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak = '" + hak + "'");
			while (rs.next()) {

				// 방법1 Map이용

				// 방법2 bean객체 생성
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setId(rs.getString("id"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectGradeByHak()에서 에러 발생");
			e.printStackTrace();
		}

		return bean;
	}

	public GradeMemberBean selectGradeById(String id) {
		// R 성적표 조회(id)

		GradeMemberBean bean = new GradeMemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE id = '" + id + "'");
			while (rs.next()) {

				// 방법1 Map이용

				// 방법2 bean객체 생성
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setId(rs.getString("id"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectGradeById()에서 에러 발생");
			e.printStackTrace();
		}

		return bean;
	}

	@Override
	public List<GradeMemberBean> selectGradesByName(String name) {
		// TODO Auto-generated method stub
		List<GradeMemberBean> beanList = new ArrayList<GradeMemberBean>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name = '" + name + "'");

			while (rs.next()) {
				// 방법2 bean객체 생성
				GradeMemberBean bean = new GradeMemberBean();

				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setId(rs.getString("id"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				beanList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectGradeByName()에서 에러 발생");
			e.printStackTrace();
		}

		return beanList;
	}

	@Override
	public int count() {
		int count = 0;
		try {

			stmt = conn.createStatement();
			// 방법1.
			rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM GradeMember");
			while (rs.next()) {
				count = rs.getInt(1);
			}
			// 방법1 end

			// //방법2.
			// stmt.executeQuery("SELECT COUNT(*) AS count FROM
			// GradeMember").last();
			// count = rs.getRow();

		} catch (Exception e) {
			System.out.println("count()에서 에러 발생");
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public String update(GradeBean grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int hak) {
		// TODO Auto-generated method stub
		String result = "회원 탈퇴 실패";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM GradeMember WHERE hak=" + hak);
			while (rs.next()) {
				result = "회원 탈퇴 성공";
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete()에서 에러 발생");
			e.printStackTrace();
		}

		return result;
	}

}
