<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%
List<ReplyVO> list = (List<ReplyVO>) request.getAttribute("list");
for(int i = 0; i<list.size(); i++){
	ReplyVO vo = list.get(i);
%>
{
"bonum" : "<%=vo.getBonum() %>",
"cont" :"<%=vo.getCont().replaceAll("\r", "").replaceAll("\n", "<br>")%>",
"name":"<%=vo.getName()%>",
"redate":"<%=vo.getRedate()%>",
"renum":"<%=vo.getRenum()%>"
}
<%

if(i!=list.size()-1) out.print(',');
}
%>
]