package com.reg.gt.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.reg.gt.jdbc.DBConnection;

public class Validator {
	public boolean validateId(String id) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		Statement stmt = con.createStatement();
		String query="select emp_id from sra_ltd.employee_tbl where emp_id='"+id+"'";
		ResultSet rs= stmt.executeQuery(query);
		if(rs.next()) {
			System.out.println(rs.getString("emp_id"));
			return false;
		}
		System.out.println("user not exist");
		return true;
	}
	public boolean ValidateObj(EmployeeBean employee){
		if(employee.emp_id==""||employee.emp_name==""||employee.emp_designation==""||employee.emp_mail==""||employee.password==""){
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws SQLException {
		Validator  v = new Validator();
		v.validateId("SRA01");
	}
}
