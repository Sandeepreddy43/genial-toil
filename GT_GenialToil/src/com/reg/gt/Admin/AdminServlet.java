package com.reg.gt.Admin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="AdminPage", urlPatterns=("/AdminServlet"), initParams={@WebInitParam(name="AdminId", value="sraltd"),@WebInitParam(name="password", value="admin123")})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc=getServletConfig();
		String adminId=sc.getInitParameter("AdminId");
		String adminPw=sc.getInitParameter("password");
		
		@SuppressWarnings("unused")
		HttpSession ses = request.getSession();
		String id=request.getParameter("Adm_Id");
		String pw=request.getParameter("Adm_Pw");
		if(adminId.equals(id)&&adminPw.equals(pw)){
			request.getRequestDispatcher("EmployeeSignup.html").forward(request, response);
		}
		else if(id==""||pw==""){
			request.getRequestDispatcher("AdminLogin.html").forward(request, response);
		}
		else request.getRequestDispatcher("ContactDeveloper.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
