<%@page import="com.reg.gt.CRUDOperations.Raw_Material_crud"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.reg.gt.entity.Purchase_Requisition"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show PR</title>
<link rel='stylesheet' type='text/css' media='screen' href='ShowPR.css'>
</head>
<body>
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
    <%HttpSession ses = request.getSession();
    	ArrayList<String> order_details = (ArrayList)ses.getAttribute("Order_details");
    %>
            <h1>S R A</h1>
            <h3>SRA Limited</h3>
            <h2>Purchase Requisition</h2>
            <div class="showDataName">Site Name</div><div class="showDataValue"><%= order_details.get(0) %></div>
            <div class="showDataName"style="clear:both">PR No</div><div class="showDataValue"><%= order_details.get(1)%></div>
            <div class="showDataName"style="clear:both">PR Date</div><div class="showDataValue"><%= order_details.get(2) %></div>
            <div class="showDataName"style="clear:both">PR Description</div><div class="showDataValue"><%= order_details.get(3) %></div>
            <div class="showDataName"style="clear:both">Remarks (If any)</div><div class="showDataValue"><%= order_details.get(4) %></div>
     <%ArrayList<Purchase_Requisition> pr_list = Raw_Material_crud.retrievePR(Integer.parseInt(order_details.get(1))); 
     %>       
            <div class="tableBlock">
            <table>
		        <thead>
			        <th id="sNo">S.No</th>
			        <th id="mName">Material Name</th>
			        <th class="ab">Material Type</th>
			        <th class="ab">Material Grade</th>
			        <th class="abc">Required Qty</th>
			        <th class="abc">UOM</th>
			        <th class="abc">Estimation Cost</th>
			        <th class="abc">Required Date</th>
                 </thead>
                 <% for(int i = 0; i<pr_list.size(); i++){ %>
                 <tr>	
                 	<td><%= i+1%></td>
					<td><%= pr_list.get(i).mName%></td>
					<td><%= pr_list.get(i).mType%></td>
					<td><%= pr_list.get(i).mGrade%></td>
					<td><%= pr_list.get(i).reqQty%></td>
					<td><%= pr_list.get(i).uom%></td>
					<td><%= pr_list.get(i).estAmount%></td>
					<td><%= pr_list.get(i).reqDate%></td>
				</tr><%} %>
            </table>
        </div> 
        <div class="showDataName" style="margin-top: 10px; ">Employee Name</div>
        <div class="showDataValue" style="margin-top: 10px; width: 400px;"><%= order_details.get(5) %></div> 
        <div class="showDataName" style="margin-top: 10px; margin-left: 300px;"><a href="PR.jsp"><button>Next Material</button></a></div> 
        <div class="showDataName" style="margin-top: 2px; clear:both; width:200px;">Employee Id</div>
        <div class="showDataValue" style="margin-top: 2px;  width: 400px;"><%= order_details.get(6) %></div>
        <div class="showDataName" style="margin-top: 10px; margin-left: 300px;"><a href="MaterialManagement.html"><button>Save PR & Create PDF</button></a></div>  
    </div>
</body>
</html>