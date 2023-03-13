package com.soft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SBI implements RBI {

	private static final int Account_No = 0;
	Scanner sc = new Scanner(System.in);

	@Override
	public void createAccount() throws SQLException {

		System.out.println("Enter Account Number ");
		int Account_No = sc.nextInt();
		System.out.println("Enter Name ");
		String Name = sc.next();
		System.out.println("Enter Pan Card Number");
		String Pan_Number = sc.next();
		System.out.println("Enter Balance");
		double Balance = sc.nextDouble();
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into bank_sbi.new_table values(?,?,?,?)");
		ps.setInt(1, Account_No);
		ps.setString(2, Name);
		ps.setString(3, Pan_Number);
		ps.setDouble(4, Balance);
		ps.execute();
		System.out.println("Account Created Succesufull !!");
	}

	@Override
	public void checkBalance() throws Exception {

		System.out.println("Enter Your Account Number");
		int Account_No = sc.nextInt();
		String str = "select * from bank_sbi.new_table where Account_No = ?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, Account_No);
		ResultSet rs = ps.executeQuery();
		rs.next();
		System.out.println("  " + "Account_No" + "    " + "Name" + "      " + "Pan_Number" + "      " + "Balance");
		System.out.println("    " + rs.getInt(1) + "        " + rs.getString(2) + "       " + rs.getString(3) + "      "
				+ rs.getDouble(4));
		System.out.println("===========================================");
		System.out.println("Account Details Selected !!");
		System.out.println("===========================================");

	}

	@Override
	public void DeleteCustomer() throws Exception {

		System.out.println("Enter Account_No to Delete Record");
		int Account_No = sc.nextInt();

		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("Delete from bank_sbi.new_table where Account_No = ? ");

		ps.setInt(1, Account_No);

		int k = ps.executeUpdate();
		if (k > 0) {
			System.out.println("Account Delete SucessFully Done...!");
			System.out.println("===========================================");
		} else {
			System.out.println("Account Not Deleted plz check Again...!");
			System.out.println("===========================================");
		}

	}

	@Override
	public void UpdateCustomer() throws Exception {

		System.out.println("Enter Account_No");
		int Account_No = sc.nextInt();
		System.out.println("Enter Balance to updateBalance Record");
		double Balance = sc.nextDouble();

		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("update new_table SET Balance=? where Account_No=?");
		ps.setInt(2, Account_No);
		ps.setDouble(1, Balance);
		int k = ps.executeUpdate();
		if (k > 0) {
			System.out.println("Account Balance Update SucessFully Done...!");
			System.out.println("===========================================");
		} else {
			System.out.println("Account Not Update plz check Again...!");
			System.out.println("===========================================");
		}

	}

	@Override
	public void ReadAll_Record() throws SQLException {

		Connection con = DbUtil.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from bank_sbi.new_table");
		System.out.println("===========================================");
		System.out.println("View All Account Details....!!");
		System.out.println("===========================================");
		while (rs.next()) {
			System.out.println("  " + "Account_No" + "    " + "Name" + "      " + "Pan_Number" + "      " + "Balance");
			System.out.println("    " + rs.getInt(1) + "        " + rs.getString(2) + "       " + rs.getString(3)
					+ "      " + rs.getDouble(4));
		}
	}

}
