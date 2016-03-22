package com.movie.web.member;

import java.sql.Statement;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn;// 오라클 연결객체
	private Statement stmt;// 쿼리 전송객체
	private PreparedStatement pstmt;// 쿼리 전송 객체 2
	private ResultSet rs;// 리턴값 회수 객체

	public MemberDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.createStatement();
			if (isMember(member.getAddr()) == false) {
				rs = stmt.executeQuery("INSERT INTO Member(id,name,password,addr,birth) VALUES(?,?,?,?,?)");
			} else {
				System.out.println("회원가입 실패 : 아이디 중복");
			}
		} catch (Exception e) {
			System.out.println("insert() 에서 에러 발생");
			e.printStackTrace();
		}

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
	public void update(MemberBean member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM Member WHERE id='" + id + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete() 에서 에러 발생");
			e.printStackTrace();
		}

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
		System.out.println("로그인실패 : id가 존재하지 않습니다");
		return result;
	}

}
