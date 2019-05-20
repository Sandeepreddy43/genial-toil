package com.reg.gt.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.reg.gt.jdbc.DBConnection;

public class AdminCRUDOperations {
	public int signup(EmployeeBean employee) {
		int rows_insert = 0;
		PreparedStatement pstmt;
		Connection connection = DBConnection.getDBConnection();
		try {
			String insert = "insert into sra_ltd.employee_tbl values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(insert);
			pstmt.setString(1, employee.getempid());
			pstmt.setString(2, employee.getempname());
			pstmt.setString(3, employee.getempdesignation());
			pstmt.setString(4, employee.getempMail());
			pstmt.setString(5, employee.getpassword());
			rows_insert = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Exception in signup");
			e.printStackTrace();
		}
		return rows_insert;

	}

	public static int updatedPassword(String emp_id, String pw) throws SQLException {
		PreparedStatement pstm;
		int noOfRows = 0;
		Connection conn;
		try {
			conn = DBConnection.getDBConnection();
			String UpdateQuery = "UPDATE sra_ltd.employee_tbl SET password = ? WHERE emp_id = ?";
			pstm = conn.prepareStatement(UpdateQuery);
			pstm.setString(1, pw);
			pstm.setString(2, emp_id);
			noOfRows = pstm.executeUpdate();
			System.out.println("Password Updated");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noOfRows;
	}

	public static boolean checkEmployee(String emp_id, String email) {
		PreparedStatement pstm;
		Connection conn;
		ResultSet rs;
		try {
			conn = DBConnection.getDBConnection();
			String query = "Select * from sra_ltd.employee_tbl WHERE emp_id= ? and emp_mail = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, emp_id);
			pstm.setString(2, email);
			rs = pstm.executeQuery();

			if (rs.next()) {
				System.out.println("Employee Exist");
				return true;
			}

			System.out.println("************************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static ArrayList<String> checkLogin(String id, String pw) {
		Connection con = DBConnection.getDBConnection();
		String query = "select * from sra_ltd.employee_tbl where emp_id= ? && password= ? ";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("If Clause **********");
				ArrayList<String> empDetails = new ArrayList<>();
				String eid = rs.getString("emp_id");
				String name = rs.getString("emp_name");
				String designation = rs.getString("emp_designation");
				String email = rs.getString("emp_mail");
				empDetails.add(eid);
				empDetails.add(name);
				empDetails.add(designation);
				empDetails.add(email);
				System.out.println("Employee Name: " + name);
				return empDetails;
			}
		} catch (SQLException e) {
			System.out.println("Sql Exception --- Login Check");
			e.printStackTrace();
		}

		System.out.println("*************");
		return null;
	}

	public static void main(String[] args) throws SQLException {
		// DBCRUDOperations.checkEmployee("SRA02", "robinmark9533@gmail.com");
		AdminCRUDOperations.checkLogin("SRA07", "def123");
	}
}
