package com.movie.web.member;

import java.sql.Statement;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();

	private Connection conn;// 오라클 연결객체
	private Statement stmt;// 쿼리 전송객체
	private PreparedStatement pstmt;// 쿼리 전송 객체 2
	private ResultSet rs;// 리턴값 회수 객체

	public MemberDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	@Override
	public int insert(MemberBean member) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Member(id,name,password,addr,birth) VALUES(?,?,?,?,?)");

			// Connection은 내부적으로 Factory (ex- create...)////싱글톤은 대부분
			// getInstance로시작
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insert() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("회원가입 성공여부 : " + result);
		return result;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='" + id + "' and password = '" + password + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}

		} catch (Exception e) {
			System.out.println("selectById() 에서 에러 발생함 !!");
			e.printStackTrace();
		}
		if (temp.getAddr() != null) {
			System.out.println("selectById() 쿼리 조회 결과 :" + temp.getAddr());
			return temp;
		} else {
			System.out.println("selectById() 쿼리 조회 결과 : null ");
			return null;
		}

	}

	@Override
	public MemberBean selectMember(String id) {
		// TODO Auto-generated method stub
		MemberBean temp = new MemberBean();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='" + id + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("selectMember() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("selectMember()의 쿼리 조회 결과 : " + temp.getAddr());
		return temp;
	}

	@Override
	public int update(MemberBean member) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("UPDATE Member SET password=? ,addr=? WHERE id=?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getAddr());
			pstmt.setString(3, member.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("update() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("update()의 쿼리 조회 결과 : " + result);
		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("DELETE FROM Member WHERE id=?");
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
		
			System.out.println("delete() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("delete()의 쿼리 조회 결과 : " + result);
		return result;
	}

	@Override
	public boolean isMember(String id) {
		boolean result = false;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='" + id + "'");

			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			System.out.println("isMember() 에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("isMember()의 쿼리 조회 결과 : " + result);
		return result;
	}

}
