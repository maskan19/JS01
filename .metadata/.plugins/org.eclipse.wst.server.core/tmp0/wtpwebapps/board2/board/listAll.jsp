<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

[
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("123123");
for(int i = 0; i<list.size(); i++){
	BoardVO vo = list.get(i);
%>
{
"num" : "<%=vo.getNum() %>",
"subject" :"<%=vo.getSubject()%>",
"writer":"<%=vo.getWriter()%>",
"mail":"<%=vo.getMail()%>",
"password":"<%=vo.getPassword()%>",
"content":"<%=vo.getContent()%>",
"hit":"<%=vo.getHit() %>",
"wip":"<%=vo.getWip()%>",
"wdate":"<%=vo.getWdate()%>"
}
<%

if(i!=list.size()-1) out.print(',');
}
%>
]