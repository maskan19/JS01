<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 저장된 값을 가져온다
	
	String aa = (String)request.getAttribute("member");

	if(aa != null) {
	
%>
	{
		"inok" : "가입 성공"
	}
<%		
	}else{
%>
	{
		"inok" : "가입 불가"
	}

<%
	}
%>