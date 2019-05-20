<%@page import="com.reg.gt.entity.Purchase_Requisition"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.reg.gt.CRUDOperations.Raw_Material_crud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Material Receipt Note</title>
<link rel="Stylesheet" type="text/css" href="Receipt.css">
</head>
<body>
	<% ArrayList<String> name_list =  Raw_Material_crud.retrieveMaterialName(); %>
	<% ArrayList<String> code_list =  Raw_Material_crud.retrieveVendor(); %>
	<% String[]  unit_list =  Purchase_Requisition.uom_list; %>
	<% HttpSession ses = request.getSession(); %>
	<% ArrayList<String> type_list = (ArrayList<String>)ses.getAttribute("type_List"); %>
	<% ArrayList<String> grade_list = (ArrayList<String>)ses.getAttribute("grade_List"); %>
	<% String s=(String)request.getAttribute("mate_name"); %>
	<div class="imgblock">
		 <div class="block1">
        <div class="block2">
            <div class="block3">
                <div class="block4"><h1>G</h1><h2>T</h2><h4>Genial Toil</h4></div>
            </div>
        </div>
    </div>
	 </div>
	<div class="registrationblock">
		<h1>Material Receipt Note</h1>
				
		<Form action="MRNServlet" method="post">
			<select name="material_name" id="name" onchange="submit()">
			<% if(s==null){
			%> <option>Material Name</option> <%} else  {%>
				<option><%= s %></option><%}
				 for(String name:name_list){%>
					<option><%= name %></option>
				<%}%>
			</select><!-- <a href="AddMaterial.html">Add</a> -->
			<select name="material_type">
				<option>Material Type</option>
				<% if(type_list!=null){
					for(String type:type_list){%>
					<option><%= type %></option>
				<%}}%>
			</select><!-- <a href="AddMaterialtype.html">Add</a> --> 
			
			<select name="material_grade">
				<option>Material Grade</option>
				<% if(grade_list!=null){
					for(String grade:grade_list){%>
					<option><%= grade %></option>
				<%}}%>
			</select><!-- <a href="#">Add</a> -->
			
			<select name="vendor_code" style="width:200px;">
				<option>Vendor Code</option>
				<% if(code_list!=null){
					for(String code:code_list){%>
					<option><%= code %></option>
				<%}}%>
			</select>
			<a href="AddVendor.html">Add</a>
			<input type="date" name="inv_date" placeholder="Invoice Date" title="Invoice Date"/>
			<input type="text" name="inv_no" placeholder="Invoice Number" title="Invoice Number"/>
			<input type="text" name="inv_qty" placeholder="Invoice Quantity" title="Invoice Quantity" style="width:190px"/>
			<select name="units" style="width:65px; height: 40px; margin: -47px 0px 6px 243px; padding-left: 6px;">
				<option>UOM</option>
				<% for(String unit:unit_list){%>
				<option><%= unit %></option>
				<%} %>
			</select>
			<input type="text" name="inv_amt" placeholder="Invoice Amount (0000.00)" title="Invoice Amount"></input>
			
			<button type="submit">Confirm</button>
		</Form>	
	</div>
</body>
