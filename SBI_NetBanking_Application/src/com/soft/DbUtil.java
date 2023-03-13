package com.soft;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sbi", "root", "Sanket@123");
				return con;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
}
