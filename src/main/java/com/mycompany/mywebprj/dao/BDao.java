package com.mycompany.mywebprj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mycompany.mywebprj.util.Constant;


public class BDao {
	
	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
	}
	
	
	public void signup(final String id, final String pw) {
		System.out.println("ddc11112c");
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				System.out.println("dd2222222222cc");
				String query = "insert into mywebprj(id, pw) values (?, ?)";
				System.out.println("ddc33333333c");
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				System.out.println("dd4444444c");
				return pstmt;
			}
		});
	}
}
