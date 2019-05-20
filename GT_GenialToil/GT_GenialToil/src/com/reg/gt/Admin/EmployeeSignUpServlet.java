package com.reg.gt.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeSignUpServlet
 */
@WebServlet("/EmployeeSignUpServlet")
public class EmployeeSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeSignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Sign up Called");
		String emp_Id = request.getParameter("empId");
		Validator valid = new Validator();

		String emp_name = request.getParameter("empName");
		String emp_designantion = request.getParameter("empDes");
		String emp_mail = request.getParameter("empMail");
		String enPaswd = Base64.getEncoder().encodeToString(request.getParameter("empPass").getBytes());
		String confirmPaswd = Base64.getEncoder().encodeToString(request.getParameter("confirmPass").getBytes());
		EmployeeBean employee = new EmployeeBean();
		employee.setempid(emp_Id);
		employee.setempname(emp_name);
		employee.setempdesignation(emp_designantion);
		employee.setempMail(emp_mail);
		employee.setpassword(enPaswd);
		boolean b = false, c = false;
		try {
			b = valid.validateId(emp_Id);
			c = valid.validateMail(emp_mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b && c && valid.ValidateObj(employee) && enPaswd.equals(confirmPaswd)) {
			AdminCRUDOperations dbop = new AdminCRUDOperations();
			int row_count = dbop.signup(employee);
			System.out.println(row_count + "is inserted");
			if (row_count == 1) {
				SendMail sm = new SendMail();
				sm.setName(emp_name);
				sm.Mailsend(emp_mail);
			}
			request.getRequestDispatcher("EmployeeSignupSuccess.html").forward(request, response);
		} else {
			request.getRequestDispatcher("EmployeeSignup.html").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
