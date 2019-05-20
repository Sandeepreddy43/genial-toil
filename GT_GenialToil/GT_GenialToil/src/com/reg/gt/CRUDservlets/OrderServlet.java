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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String site_name = request.getParameter("site_name");
		String pr_description = request.getParameter("pr_des");
		String pr_date = request.getParameter("pr_date");
		String remarks = request.getParameter("remarks");
		HttpSession ses = request.getSession();
		ArrayList<String> emp_detail = (ArrayList<String>) ses.getAttribute("emp_List");
		String e_name = emp_detail.get(1);
		String e_id = emp_detail.get(0);
		Raw_Material_crud.generate_order(pr_date, pr_description, e_name, e_id, remarks);
		String order_no = Integer.toString(Raw_Material_crud.getOrderId(pr_description));
		ArrayList<String> order_Details = new ArrayList<>();
		order_Details.add(site_name);order_Details.add(order_no); order_Details.add(pr_date);order_Details.add(pr_description); order_Details.add(remarks);
		order_Details.add(e_name); order_Details.add(e_id);
		ses.setAttribute("Order_details", order_Details);
		request.getRequestDispatcher("PR.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
