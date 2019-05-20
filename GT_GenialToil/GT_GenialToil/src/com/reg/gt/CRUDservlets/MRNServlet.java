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
 * Servlet implementation class AddMaterialServlet
 */
@WebServlet("/MRNServlet")
public class MRNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		ArrayList<String> mrn_list = new ArrayList<>();
		String m_name = request.getParameter("material_name");
		request.setAttribute("mate_name", m_name);
		ArrayList<String> type_list =  Raw_Material_crud.retrieveMaterialType(m_name);
		ses.setAttribute("type_List", type_list);
		ArrayList<String> grade_list =  Raw_Material_crud.retrieveMaterialGrade(m_name);
		ses.setAttribute("grade_List", grade_list);
		String m_type = request.getParameter("material_type"); 
		String m_grade = request.getParameter("material_grade");
		String v_code = request.getParameter("vendor_code");
		String v_name = Raw_Material_crud.getVendorName(v_code);
		String invoice_no = request.getParameter("inv_no");
		String units = request.getParameter("units");
		String invoice_qty = request.getParameter("inv_qty");
		String invoice_amt = request.getParameter("inv_amt");
		String invoice_date = request.getParameter("inv_date");
		ArrayList<String> emp_detail = (ArrayList<String>) ses.getAttribute("emp_List");
		String e_name = emp_detail.get(1);
		String e_id = emp_detail.get(0);
		if(invoice_qty=="" || invoice_date == ""){
			request.getRequestDispatcher("Receipt.jsp").forward(request, response);
		}
		else {
			Raw_Material_crud.addMRN(m_name, m_type, m_grade, v_name, v_code, invoice_date, invoice_no, invoice_amt, invoice_qty, units, e_name, e_id);
			int mrn_no = Raw_Material_crud.getMRNId(invoice_no);
			String mrn_number = Integer.toString(mrn_no);
			mrn_list.add(m_name); mrn_list.add(m_type); mrn_list.add(m_grade); mrn_list.add(v_name); mrn_list.add(v_code); mrn_list.add(invoice_date);  
			mrn_list.add(invoice_no);mrn_list.add(invoice_qty); mrn_list.add(invoice_amt); mrn_list.add(e_name); mrn_list.add(e_id);
			mrn_list.add(mrn_number);mrn_list.add(units);
			ses.setAttribute("mrn_list", mrn_list);
			ses.setAttribute("inv_no", invoice_no);
			System.out.println(e_name+"  *-*-*-*-*  "+e_id);
		request.getRequestDispatcher("show_mrn.jsp").forward(request, response);
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
