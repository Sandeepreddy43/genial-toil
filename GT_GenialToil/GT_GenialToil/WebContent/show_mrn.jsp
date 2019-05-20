<%@page import="java.util.ArrayList"%>
<%@page import="com.reg.gt.CRUDOperations.Raw_Material_crud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Material Receipt Note</title>
<link rel="Stylesheet" type="text/css" href="showmrn.css">
</head>
<body>
	<% HttpSession ses = request.getSession(); %>
	<% ArrayList<String> mrn_list = (ArrayList<String>)ses.getAttribute("mrn_list"); %>
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
				<% String s = "ABCDEF"; %>
			<div class="showDataName">MRN Number</div><div class="showDataValue"><%= mrn_list.get(11) %></div>
			<div class="showDataName">Material Name</div><div class="showDataValue"><%= mrn_list.get(0) %></div>
			<div class="showDataName">Material Type</div><div class="showDataValue"><%= mrn_list.get(1) %></div>
			<div class="showDataName">Material Grade</div><div class="showDataValue"><%= mrn_list.get(2) %></div>
			<div class="showDataName">Vendor Name</div><div class="showDataValue"><%= mrn_list.get(3) %></div>
			<div class="showDataName">Vendor Code</div><div class="showDataValue"><%= mrn_list.get(4) %></div>
			<div class="showDataName">Invoice Date</div><div class="showDataValue"><%= mrn_list.get(5) %></div>
			<div class="showDataName">Invoice Number</div><div class="showDataValue"><%= mrn_list.get(6) %></div>
			<div class="showDataName">Invoice Quantity</div><div class="showDataValue"><%= mrn_list.get(7) %><%= mrn_list.get(12) %></div>
			<div class="showDataName">Invoice Amount</div><div class="showDataValue"><%= mrn_list.get(8) %></div>
			<div class="showDataName">Employee Name</div><div class="showDataValue"><%= mrn_list.get(9) %></div>
			<div class="showDataName">Employee Id</div><div class="showDataValue"><%= mrn_list.get(10) %></div>
			<!-- <div class="showDataName" style="width: 222px; height: 90px; margin-top: -30px;">If You have any Corrections, go to 'Reset'</div>
			<div class="showDataValue" style="width: 250px; height: 90px; margin-top: -100px;"></div> -->
			
			<a href="EditMRN_Servlet">Reset</a>
			<Form action="ContactDeveloper.html" method="post">
			<button type="submit">Save</button>
		</Form>	
	</div>
</body>
