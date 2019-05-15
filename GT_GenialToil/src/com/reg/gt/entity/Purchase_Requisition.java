package com.reg.gt.entity;

public class Purchase_Requisition {
	public int sno;
	int order_no;
	String order_date;
	String order_descri;
	String orderby_emp_name;
	String orderby_emp_id;
	String material_name;
	String material_type;
	String material_grade;
	String req_qty;
	Double est_cost;
	String req_date;
	
	public void setSNo(int sno){
		this.sno=sno;
	}
	
	public int getSNo(){
		return sno;
	}
	
	public void setOrderNo(int order_no){
		this.order_no=order_no;
	}
	
	public int getOrderNo(){
		return order_no;
	}
	
	public void setOrderDate(String order_date){
		this.order_date=order_date;
	}
	
	public String getOrderDate(){
		return order_date;
	}
	
	public void setOrderDescription(String order_descri){
		this.order_descri=order_descri;
	}
	
	public String getOrderDescriptione(){
		return order_descri;
	}
	
	public void setOrder_by_empName(String orderby_emp_name){
		this.orderby_emp_name=orderby_emp_name;
	}
	
	public String getOrder_by_empName(){
		return orderby_emp_name;
	}
	
	public void setOrder_by_empId(String orderby_emp_id){
		this.orderby_emp_id=orderby_emp_id;
	}
	
	public String getOrder_by_empId(){
		return orderby_emp_id;
	}
	
	public void setMaterialName(String material_name){
		this.material_name = material_name;
	}
	
	public String getMaterialName(){
		return material_name;
	}
	
	public void setMaterialType(String material_type){
		this.material_type = material_type;
	}
	
	public String getMaterialType(){
		return material_type;
	}
	
	public void setMaterialGrade(String material_grade){
		this.material_grade = material_grade;
	}
	
	public String getMaterialGrade(){
		return material_grade;
	}
	
	public void setRequiredQty(String req_qty){
		this.req_qty = req_qty;
	}
	
	public String getRequiredQty(){
		return req_qty;
	}
	
	public void setEstimationCost(Double est_cost){
		this.est_cost = est_cost;
	}
	
	public Double getEstimationCost(){
		return est_cost;
	}
	
	public void setRequiredDate(String req_date){
		this.req_date = req_date;
	}
	
	public String getRequiredDate(){
		return req_date;
	}
	
	@Override
	public String toString() {
			return "S.No: "+sno+"\nMaterial Name: "+material_name+"\nMaterial Type: "+material_type+"\nMaterial Grade: "+material_grade+"\nReq. Qty: "+req_qty+"Estimation Cost: "+est_cost+"\nreq. date: "+req_date;
	}
}
