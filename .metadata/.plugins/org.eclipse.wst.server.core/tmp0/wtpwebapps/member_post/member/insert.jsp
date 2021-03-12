<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 request에 저장된 값을 가져온다.
	String aa = (String) request.getAttribute("result");
	if (aa != null) {
		//id가 이미 있을 때
%>
{ "sw" : "성공" }
<%
	} else {
%>
{ "sw" : "실패" }
<%
	}
%>