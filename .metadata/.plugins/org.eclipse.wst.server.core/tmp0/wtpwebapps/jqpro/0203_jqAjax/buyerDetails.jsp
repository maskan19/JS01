<%@page import="kr.or.ddit.buyer.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 1. SqlMapClient 객체를 얻어오기
   String buyer_id = request.getParameter("id");

   // 2. sql문을 실행
   SqlMapClient smc = SqlMapClientFactory.getClient();
   
   //3. sql문 실행
   BuyerVO buyer = (BuyerVO)smc.queryForObject("buyer.selectByDetails", buyer_id);
   
%>

{
	"id" : "<%= buyer.getBuyer_id() %>",
	"name" : "<%= buyer.getBuyer_name() %>",
	"lgu" : "<%= buyer.getBuyer_lgu() %>",
	"bank" : "<%= buyer.getBuyer_bank() %>",
	"bankno" : "<%= buyer.getBuyer_bankno() %>",
	"bankname" : "<%= buyer.getBuyer_bankname() %>",
	"zip" : "<%= buyer.getBuyer_zip() %>",
	"add1" : "<%= buyer.getBuyer_add1() %>",
	"add2" : "<%= buyer.getBuyer_add2() %>",
	"comtel" : "<%= buyer.getBuyer_comtel() %>",
	"fax" : "<%= buyer.getBuyer_fax() %>",
	"mail" : "<%= buyer.getBuyer_mail() %>",
	"charger" : "<%= buyer.getBuyer_charger() %>"
}