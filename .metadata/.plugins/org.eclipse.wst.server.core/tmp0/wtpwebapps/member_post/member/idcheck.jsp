<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//controller에서 request에 저장된 값을 가져온다.
	String aa = (String) request.getAttribute("result");
	if (aa != null) {
		//id가 이미 있을 때
%>
{ "sw" : "이미 사용 중인 아이디" }
<%
	} else {
%>
{ "sw" : "사용 가능한 아이디" }
<%
	}
%>