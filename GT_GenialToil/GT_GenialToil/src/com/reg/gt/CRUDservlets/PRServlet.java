package com.reg.gt.CRUDservlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reg.gt.CRUDOperations.Raw_Material_crud;

/**
 * Servlet implementation class PRServlet
 */
@WebServlet("/PRServlet")
public class PRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String m_name = request.getParameter("material_name");
		request.setAttribute("mate_name", m_name);
		ArrayList<String> type_list =  Raw_Material_crud.retrieveMaterialType(m_name);
		ses.setAttribute("type_List", type_list);
		ArrayList<String> grade_list =  Raw_Material_crud.retrieveMaterialGrade(m_name);
		ses.setAttribute("grade_List", grade_list);
		String m_type = request.getParameter("material_type"); 
		String m_grade = request.getParameter("material_grade");
		String req_qty = request.getParameter("inv_qty");
		String units = request.getParameter("units");
		String est_amt = request.getParameter("inv_amt");
		String req_date = request.getParameter("inv_date");
		if(req_qty=="" || est_amt == ""){
			request.getRequestDispatcher("PR.jsp").forward(request, response);
		}
		else {
			ArrayList<String> order_details = (ArrayList<String>) ses.getAttribute("Order_details");
			Raw_Material_crud.purcase_requisition(order_details.get(3), m_name, m_type, m_grade, Integer.parseInt(req_qty), units, Double.parseDouble(est_amt), req_date);
			request.getRequestDispatcher("ShowPR.jsp").forward(request, response);
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
