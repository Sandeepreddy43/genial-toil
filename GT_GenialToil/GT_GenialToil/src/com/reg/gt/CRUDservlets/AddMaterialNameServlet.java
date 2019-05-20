package com.reg.gt.CRUDservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reg.gt.CRUDOperations.Raw_Material_crud;

/**
 * Servlet implementation class AddMaterialNameServlet
 */
@WebServlet("/AddMaterialNameServlet")
public class AddMaterialNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaterialNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String material_name = request.getParameter("mtrl_name");
		ses.setAttribute("materl_name", material_name);
		Raw_Material_crud.addMaterial(material_name);
		String material_type = request.getParameter("mtrl_type");
		Raw_Material_crud.addMaterialType(material_name, material_type);
		String material_grade = request.getParameter("mtrl_grade");
		Raw_Material_crud.addMaterialGrade(material_name, material_grade);
		request.getRequestDispatcher("ContactDeveloper.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
