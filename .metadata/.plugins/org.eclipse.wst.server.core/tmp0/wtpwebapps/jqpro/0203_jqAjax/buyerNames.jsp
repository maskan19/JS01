<%@page import="kr.or.ddit.buyer.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 1. SqlMapClient 객체를 얻어오기
   
   SqlMapClient aa = SqlMapClientFactory.getClient();

   // 2. sql문을 실행
   List<BuyerVO> list =  aa.queryForList("buyer.selectAll");
%>
[

<%
   for(int i =0; i<list.size(); i++){
      BuyerVO vo = list.get(i);
      if(i >0) out.print(",");
%>      
   {
      "id" : "<%= vo.getBuyer_id() %>",
      "name" : "<%= vo.getBuyer_name() %>"
   }
   
<%    
   }
%>


]