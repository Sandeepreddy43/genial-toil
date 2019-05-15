package com.reg.gt.CRUDOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.reg.gt.entity.Purchase_Requisition;
import com.reg.gt.jdbc.DBConnection;

public class Raw_Material_crud {
	public static void addMaterial(String material_name) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO `sra_ltd`.`raw_material_tbl` (`material_name`) VALUES (?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, material_name);
			psmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception - Add Material");
			e.printStackTrace();
		}

	}

	public static int getMaterialId(String material_name) {
		Connection con = DBConnection.getDBConnection();
		String getidQuery = "select material_id from sra_ltd.raw_material_tbl where raw_material_tbl.material_name = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(getidQuery);
			psmt.setString(1, material_name);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				int m_id = rs.getInt(1);
				System.out.println("Material Id: " + m_id);
				return m_id;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception - get Material Id");
			e.printStackTrace();
		}
		return 0;
	}

	public static void addMaterialType(String material_name, String material_type) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.material_type_tbl VALUES (?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getMaterialId(material_name));
			psmt.setString(2, material_type);
			psmt.executeUpdate();
			con.close();
			System.out.println("Material Type: " + material_type);
		} catch (SQLException e) {
			System.out.println("SQL Exception - Add Material Type");
			e.printStackTrace();
		}
	}

	public static void addMaterialGrade(String material_name, String material_grade) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.material_grade_tbl VALUES (?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getMaterialId(material_name));
			psmt.setString(2, material_grade);
			psmt.executeUpdate();
			con.close();
			System.out.println("Material Grade: " + material_grade);
		} catch (SQLException e) {
			System.out.println("SQL Exception - Add Material Grade");
			e.printStackTrace();
		}
	}

	public static void addMaterialVendor(String material_name, String vendor_name, String vendor_code) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.vendor_tbl (material_id, vendor_name, vendor_code) VALUES (?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getMaterialId(material_name));
			psmt.setString(2, vendor_name);
			psmt.setString(3, vendor_code);
			psmt.executeUpdate();
			con.close();
			System.out.println("Vendor Name: " + vendor_name);
			System.out.println("Vendor Code: " + vendor_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generate_order(String order_date, String order_description, String emp_name, String emp_id,
			String remarks) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.order_tbl (order_date, order_description, order_emp_name, order_emp_id, remarks) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, order_date);
			psmt.setString(2, order_description);
			psmt.setString(3, emp_name);
			psmt.setString(4, emp_id);
			psmt.setString(5, remarks);
			psmt.executeUpdate();
			con.close();
			System.out.println("Order date: " + order_date);
			System.out.println("Order Descri: " + order_description + "\nEmp Name: " + emp_name + "\nEmp ID: " + emp_id
					+ "\nRemarks: " + remarks);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getOrderId(String order_description) {
		Connection con = DBConnection.getDBConnection();
		String getidQuery = "select order_no from sra_ltd.order_tbl where order_tbl.order_description = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(getidQuery);
			psmt.setString(1, order_description);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				int m_id = rs.getInt(1);
				return m_id;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception - get Material Id");
			e.printStackTrace();
		}
		return 0;
	}

	public static void purcase_requisition(String order_description, String material_name, String material_type,
			String material_grade, String req_qty, Double est_cost, String req_date) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.pr_tbl (order_no, material_description, material_type, material_grade, req_qty, estimation_cost, req_date) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getOrderId(order_description));
			psmt.setString(2, material_name);
			psmt.setString(3, material_type);
			psmt.setString(4, material_grade);
			psmt.setString(5, req_qty);
			psmt.setDouble(6, est_cost);
			psmt.setString(7, req_date);
			psmt.executeUpdate();
			con.close();
			System.out.println("Order No: " + getOrderId(order_description));
			System.out.println("material Name: " + material_name + "\nMaterial Type: " + material_type
					+ "\nMaterial Grade: " + material_grade + "\nReq. Qty: " + req_qty);
			System.out.println("Estimation Cost: " + est_cost + "\nreq. Date: " + req_date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Purchase_Requisition> retrievePR(int order_no) {
		Connection con = DBConnection.getDBConnection();
		String query = "SELECT Sno, order_date, order_description, order_emp_name, order_emp_id, material_description, material_grade, material_type, req_qty, estimation_cost, req_date FROM sra_ltd.order_tbl o INNER JOIN  sra_ltd.pr_tbl r ON o.order_no = r.order_no WHERE o.order_no = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, order_no);
			ResultSet rs = psmt.executeQuery();
			ArrayList<Purchase_Requisition> prList = new ArrayList<>();
			while (rs.next()) {
				Purchase_Requisition pr = new Purchase_Requisition();
				pr.setSNo(rs.getInt("Sno"));
				pr.setOrderDate("order_date");
				pr.setOrderDescription("order_description");
				pr.setOrder_by_empName(rs.getString("order_emp_name"));
				pr.setOrder_by_empId(rs.getString("order_emp_id"));
				pr.setMaterialName(rs.getString("material_description"));
				pr.setMaterialType(rs.getString("material_type"));
				pr.setMaterialGrade(rs.getString("material_grade"));
				pr.setRequiredQty(rs.getString("req_qty"));
				pr.setEstimationCost(rs.getDouble("estimation_cost"));
				pr.setRequiredDate(rs.getString("req_date"));
				pr.toString();
				prList.add(pr);
				System.out.println("*-*-*-*-* Success *-*-*-*-*");
			}
			return prList;
		} catch (SQLException e) {
			System.out.println("SQL Exception *-*-*-*-*");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// addMaterial("Bricks");
		// addMaterialType("Steel", "Reinforcing");
		// addMaterialGrade("Sand", "River Sand");
		// addMaterialVendor("Cement", "Birla", "SRABCL01");
		// generate_order("2019-05-16", "Test Order", "Rohit", "SRA02", "Second
		// Order");
		//purcase_requisition("Test Order", "Cement", "PSC", "33 Grade", "150MT", 700000.00, "2019-05-20");
		retrievePR(1001);
	}
}
