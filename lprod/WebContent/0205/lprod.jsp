<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<LprodVO> lprod = (List<LprodVO>) request.getAttribute("123456");
%>

[
<%
	int i = lprod.size();
	for (LprodVO lp : lprod) {
		i--;
%>

{ "id" : "<%=lp.getLprod_id()%>",
"gu" : "<%=lp.getLprod_gu()%>",
"name" : "<%=lp.getLprod_nm()%>" }
<%
	if (i > 0)
			out.print(",");
	}
%>
]
