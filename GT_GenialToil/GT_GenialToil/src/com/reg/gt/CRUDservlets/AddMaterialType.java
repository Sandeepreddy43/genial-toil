package com.reg.gt.CRUDservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.reg.gt.CRUDOperations.Raw_Material_crud;

/**
 * Servlet implementation class AddMaterialType
 */
@WebServlet("/AddMaterialType")
public class AddMaterialType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaterialType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String material_name = request.getParameter("mtrl_name");
		String material_type = request.getParameter("mtrl_type");
		Raw_Material_crud.addMaterialType(material_name, material_type);
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
