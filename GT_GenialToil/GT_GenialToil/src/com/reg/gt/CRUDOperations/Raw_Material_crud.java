package com.reg.gt.CRUDOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	public static ArrayList<String> retrieveMaterialName() {
		Connection con = DBConnection.getDBConnection();
		String query = "select material_name from sra_ltd.raw_material_tbl";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			ArrayList<String> materialList = new ArrayList<>();
			while (rs.next()) {
				materialList.add(rs.getString("material_name"));
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public static ArrayList<String> retrieveMaterialType(String material_name) {
		Connection con = DBConnection.getDBConnection();
		String query = "select material_type from sra_ltd.material_type_tbl where material_id = ?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getMaterialId(material_name));
			ResultSet rs = psmt.executeQuery();
			ArrayList<String> materialList = new ArrayList<>();
			while (rs.next()) {
				materialList.add(rs.getString("material_type"));
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public static ArrayList<String> retrieveMaterialGrade(String material_name) {
		Connection con = DBConnection.getDBConnection();
		String query = "select material_grade from sra_ltd.material_grade_tbl where material_id = ?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getMaterialId(material_name));
			ResultSet rs = psmt.executeQuery();
			ArrayList<String> materialList = new ArrayList<>();
			while (rs.next()) {
				materialList.add(rs.getString("material_grade"));
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void addVendor(String vendor_name, String vendor_code) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.vendor_tbl (vendor_name, vendor_code) VALUES (?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, vendor_name);
			psmt.setString(2, vendor_code);
			psmt.executeUpdate();
			con.close();
			System.out.println("Vendor Name: " + vendor_name);
			System.out.println("Vendor Code: " + vendor_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String> retrieveVendor() {
		Connection con = DBConnection.getDBConnection();
		String query = "select vendor_code from sra_ltd.vendor_tbl";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			ArrayList<String> materialList = new ArrayList<>();
			while (rs.next()) {
				materialList.add(rs.getString("vendor_code"));
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			System.out.println("Order Description: "+order_description);
			if (rs.next()) {
				int m_id = rs.getInt(1);
				System.out.println("*******"+m_id);
				return m_id;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception - get Material Id");
			e.printStackTrace();
		}
		return 0;
	}

	public static String getVendorName(String vendor_code) {
		Connection con = DBConnection.getDBConnection();
		String query = "select vendor_name from sra_ltd.vendor_tbl where vendor_code = ?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, vendor_code);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				String ven_name = rs.getString("vendor_name");
				System.out.println("Vendor Name: "+ven_name);
				return ven_name;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void purcase_requisition(String order_description, String material_name, String material_type,
			String material_grade, int req_qty, String uom, Double est_cost, String req_date) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.pr_tbl (order_no, material_description, material_type, material_grade, req_qty, uom, estimation_cost, req_date) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, getOrderId(order_description));
			psmt.setString(2, material_name);
			psmt.setString(3, material_type);
			psmt.setString(4, material_grade);
			psmt.setInt(5, req_qty);
			psmt.setString(6, uom);
			psmt.setDouble(7, est_cost);
			psmt.setString(8, req_date);
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
		String query = "SELECT Sno, order_date, order_description, order_emp_name, order_emp_id, material_description, material_grade, material_type, req_qty, uom, estimation_cost, req_date FROM sra_ltd.order_tbl o INNER JOIN  sra_ltd.pr_tbl r ON o.order_no = r.order_no WHERE o.order_no = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, order_no);
			ResultSet rs = psmt.executeQuery();
			ArrayList<Purchase_Requisition> prList = new ArrayList<>();
			while (rs.next()) {
				Purchase_Requisition pr = new Purchase_Requisition();
				pr.sNo = (rs.getInt("Sno"));
				pr.prDate = ("order_date");
				pr.prDescription = ("order_description");
				pr.eName = (rs.getString("order_emp_name"));
				pr.eId = (rs.getString("order_emp_id"));
				pr.mName = (rs.getString("material_description"));
				pr.mType = (rs.getString("material_type"));
				pr.mGrade = (rs.getString("material_grade"));
				pr.reqQty = (rs.getInt("req_qty"));
				pr.uom = (rs.getString("uom"));
				pr.estAmount = (rs.getDouble("estimation_cost"));
				pr.reqDate = (rs.getString("req_date"));
				prList.add(pr);
				System.out.println(pr);
			}
			return prList;
		} catch (SQLException e) {
			System.out.println("SQL Exception *-*-*-*-*");
			e.printStackTrace();
		}
		return null;
	}

	public static void addMRN(String m_name, String m_type, String m_grade, String v_name, String v_code,
			String inv_date, String inv_no, String inv_amount, String inv_qty, String uom, String emp_name, String emp_id) {
		Connection con = DBConnection.getDBConnection();
		String query = "INSERT INTO sra_ltd.mrn_tbl (material_name, material_type, material_grade, vendor_name, vendor_code, invoice_qty, uom, invoice_date, invoice_no, invoice_amount, emp_name, emp_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, m_name);
			psmt.setString(2, m_type);
			psmt.setString(3, m_grade);
			psmt.setString(4, v_name);
			psmt.setString(5, v_code);
			psmt.setInt(6, Integer.parseInt(inv_qty));
			psmt.setString(7, uom);
			psmt.setString(8, inv_date);
			psmt.setString(9, inv_no);
			psmt.setDouble(10, Double.parseDouble(inv_amount));
			psmt.setString(11, emp_name);
			psmt.setString(12, emp_id);
			psmt.executeUpdate();
			con.close();
			System.out.println("Invoice No: " + inv_no);
			System.out.println("material Name: " + m_name + "\nMaterial Type: " + m_type + "\nMaterial Grade: "
					+ m_grade + "\nInv. Qty: " + inv_qty);
			System.out.println("Invoice Amount: " + inv_amount + "\nInv. Date: " + inv_date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteMRN(String invoice_no){
		Connection con = DBConnection.getDBConnection();
		String query = "delete from sra_ltd.mrn_tbl where mrn_tbl.invoice_no = ?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, invoice_no);
			psmt.executeUpdate();
			System.out.println("*-*-*-*");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getMRNId(String invoice_no) {
		Connection con = DBConnection.getDBConnection();
		String getidQuery = "select mrn_id from sra_ltd.mrn_tbl where mrn_tbl.invoice_no = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(getidQuery);
			psmt.setString(1, invoice_no);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				int mrn_id = rs.getInt(1);
				System.out.println("Material Id: " + mrn_id);
				return mrn_id;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception - get Material Id");
			e.printStackTrace();
		}
		return 0;
	}
	
	

	public static void main(String[] args) {
		// addMaterial("Wood");
		// addMaterialType("Steel", "Reinforcing");
		// addMaterialGrade("Sand", "River Sand");
		// addMaterialVendor("Cement", "Birla", "SRABCL01");
		// generate_order("2019-05-16", "Test Order", "Rohit", "SRA02", "Second
		// Order");
		// purcase_requisition("Test Order", "Cement", "PSC", "33 Grade",
		// "150MT", 700000.00, "2019-05-20");
		// retrievePR(1001);
		// ArrayList<String> mList = retrieveMaterialName();
		// for (String s : mList) {
		// System.out.println(s);
		// }
		// ArrayList<String> List = retrieveMaterialType("Cement");
		// for (String s : List) {
		// System.out.println(s);
		// }
		// ArrayList<String> VList = retrieveVendor();
		// for (String s : VList) {
		// System.out.println(s);
		// }
		//getVendorName("SRAACC01");
		//deleteMRN("VSLSRA160519-02");
		Date today = new Date();
		System.out.println("*--*-*-*-*-*-");
		System.out.println("Today is: "+today);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yyyy format : " + date);
	}
}
