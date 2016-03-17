package com.movie.web.member;

import java.sql.Statement;

import com.movie.web.global.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn;// 오라클 연결객체
	private Statement stmt;// 쿼리 전송객체
	private PreparedStatement pstmt;// 쿼리 전송 객체 2
	private ResultSet rs;// 리턴값 회수 객체

	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("INSERT INTO Member(id,name,password,addr,birth) VALUES('" + member.getId() + "','"
					+ member.getName() + "','" + member.getPassword() + "','" + member.getAddr() + "',"
					+ member.getBirth() + ")");

		} catch (Exception e) {
			System.out.println("insert() 에서 에러 발생");
			e.printStackTrace();
		}

	}

	@Override
	public void selectById(String id, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberBean selectMember(String id) {
		// TODO Auto-generated method stub
		MemberBean temp = new MemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
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
		System.out.println("쿼리 조회 결과 : " + temp.getAddr());
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
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM Member WHERE id='" + id + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete() 에서 에러 발생");
			e.printStackTrace();
		}

	}

}
