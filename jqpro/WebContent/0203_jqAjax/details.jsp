<%@page import="kr.or.ddit.buyer.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 1. SqlMapClient 객체를 얻어오기
   String buyer_id = request.getParameter("id");

   // 2. sql문을 실행
   SqlMapClient smc = SqlMapClientFactory.getClient();
   
   //3. sql문 실행
   BuyerVO buyer = (BuyerVO)smc.queryForObject("buyer.selectByDetails", buyer_id);
   
%>

<table border="1" id="detable"><tr class="tab">
<tr><td>BUYER_ID</td><td><%=buyer.getBuyer_id()%></td></tr>
<tr class=detail><td>BUYER_NAME</td><td><%=buyer.getBuyer_name()%></td></tr>
<tr class=detail><td>BUYER_LGU</td><td><%=buyer.getBuyer_lgu()%></td></tr>
<tr class=detail><td>BUYER_COMTEL</td><td><%=buyer.getBuyer_comtel()%></td></tr>
<tr class=detail><td>BUYER_BANK</td><td><%=buyer.getBuyer_bank()%></td></tr>
<tr class=detail><td>BUYER_BANKNO</td><td><%=buyer.getBuyer_bankno()%></td></tr>
<tr class=detail><td>BUYER_BANKNAME</td><td><%=buyer.getBuyer_bankname()%></td></tr>
<tr class=detail><td>BUYER_MAIL</td><td><%=buyer.getBuyer_mail()%></td></tr>
<tr class=detail><td>BUYER_ZIP</td><td><%=buyer.getBuyer_zip()%></td></tr>
<tr class=detail><td>BUYER_ADD1</td><td><%=buyer.getBuyer_add1()%> <%=buyer.getBuyer_add2()%></td></tr>
</table>

