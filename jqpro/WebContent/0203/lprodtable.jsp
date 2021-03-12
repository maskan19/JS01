<%@page import="kr.or.ddit.lprod.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//1. 클라이언트 요청시 전송되는 데이터
	//2. SqlMapClient객체 얻기
	SqlMapClient aa = SqlMapClientFactory.getClient();

	//3. Sql문 실행
	List<LprodVO> list = aa.queryForList("lprod.selectAll");

	//4. table생성
%>
<table border="1">
	<tr class="t1">
		<td>LPROD_ID</td>
		<td>LPROD_GU</td>
		<td>LPROD_NM</td>
	</tr>
<%
	for (int i = 0; i < list.size(); i++) {
		LprodVO vo = list.get(i);
%>
	<tr>
		<td><%= vo.getLprod_id() %></td>
		<td><%= vo.getLprod_gu() %></td>
		<td><%= vo.getLprod_nm() %></td>
	</tr>
<%
}
%>
</table>
