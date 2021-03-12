<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 저장된 값을 가져온다
	
	String aa = (String)request.getAttribute("mama");

	if(aa != null) {
	//id가 이미 있다 a001
%>
	{
		"sw" : "사용 불가능한 아이디"
	}
<%		
	}else{
		//id가 없다 - 사용 가능
%>
	{
		"sw" : "사용 가능한 아이디"
	}

<%
	}
%>