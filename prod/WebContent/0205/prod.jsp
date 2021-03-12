<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ProdVO> prod = (List<ProdVO>) request.getAttribute("123456");
%>

[
<%
	int i = prod.size();
	for (ProdVO pr : prod) {
		i--;
%>

{ 
"id" : "<%= pr.getProd_id() %>",
"name" : "<%= pr.getProd_name() %>",
"lgu" : "<%= pr.getProd_lgu() %>",
"buyer" : "<%= pr.getProd_buyer() %>",
"cost" : "<%= pr.getProd_cost() %>",
"price" : "<%= pr.getProd_price() %>",
"sale" : "<%= pr.getProd_sale() %>",
"outline" : "<%= pr.getProd_outline() %>",
"detail" : "<%= pr.getProd_detail() %>",
"img" : "<%= pr.getProd_img() %>",
"totalstock" : "<%= pr.getProd_totalstock() %>",
"insdate" : "<%= pr.getProd_insdate() %>",
"properstock" : "<%= pr.getProd_properstock() %>",
"size" : "<%= pr.getProd_size() %>",
"color" : "<%= pr.getProd_color() %>",
"delivery" : "<%= pr.getProd_delivery() %>",
"unit" : "<%= pr.getProd_unit() %>",
"qtyin" : "<%= pr.getProd_qtyin() %>",
"qtysale" : "<%= pr.getProd_qtysale() %>"
 <%-- ,"mileage" : "    <%= pr.getProd_mileage() %>" --%>
     
     }
<%
	if (i > 0)
			out.print(",");
	}
%>

]
