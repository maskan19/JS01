<%@page import="kr.or.ddit.prod.ProdVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   // 1. SqlMapClient 객체를 얻어오기
   String prod_id = request.getParameter("id");

   // 2. sql문을 실행
   SqlMapClient smc = SqlMapClientFactory.getClient();
   
   //3. sql문 실행
   ProdVO prod = (ProdVO)smc.queryForObject("prod.selectBydetails", prod_id);
   
%>

{
	"id" : "<%= prod.getProd_id() %>",
	"name" : "<%= prod.getProd_name() %>",
	"lgu" : "<%= prod.getProd_lgu() %>",
	"buyer" : "<%= prod.getProd_buyer() %>",
	"cost" : "<%= prod.getProd_cost() %>",
	"price" : "<%= prod.getProd_price() %>",
	"sale" : "<%= prod.getProd_sale() %>",
	"outline" : "<%= prod.getProd_outline() %>",
	"detail" : "<%= prod.getProd_detail() %>"
}