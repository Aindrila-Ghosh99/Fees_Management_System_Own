package com.fee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "iem123", "iem123");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
	}
}
