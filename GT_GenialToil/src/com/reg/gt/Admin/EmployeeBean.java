package com.reg.gt.Admin;

public class EmployeeBean {
	String emp_id;
	String emp_name;
	String emp_designation;
	String emp_mail;
	String password;

	public String getempid() {
		return emp_id;
	}

	public void setempid(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getempname() {
		return emp_name;
	}

	public void setempname(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getempdesignation() {
		return emp_designation;
	}

	public void setempdesignation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public String getempMail() {
		return emp_mail;
	}

	public void setempMail(String emp_mail) {
		this.emp_mail = emp_mail;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "EmployeeBean[emp_id" + emp_id + ",emp_name" + emp_name + ",emp_designation" + emp_designation
				+ ",password" + password + ",]";
	}

}
