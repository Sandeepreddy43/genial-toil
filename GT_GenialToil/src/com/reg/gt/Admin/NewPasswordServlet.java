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
 * Servlet implementation class NewPasswordServlet
 */
@WebServlet("/NewPasswordServlet")
public class NewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String npwd =Base64.getEncoder().encodeToString(request.getParameter("npw").getBytes()); 
		String confnpw=Base64.getEncoder().encodeToString(request.getParameter("confirmPw").getBytes()); 
		if(npwd.equals(confnpw)){
			try {
				DBCRUDOperations.updatedPassword(npwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("UpdatePasswordSuccess.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("NewPassword.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
