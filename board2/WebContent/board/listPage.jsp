<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("pageList");
	int totalPage = (Integer) request.getAttribute("totalPage");
	int startPage = (Integer) request.getAttribute("startPage");
	int endPage = (Integer) request.getAttribute("endPage");
%>


{
	"totalPage" : <%= totalPage %>,
	"startPage" : <%= startPage %>,
	"endPage" : <%= endPage %>,
	"datas" : [
	<%
	int i = list.size();
	for(BoardVO vo : list){
		i--;
		%>
	{
	"num" : "<%=vo.getNum() %>",
	"subject" :"<%=vo.getSubject()%>",
	"writer":"<%=vo.getWriter()%>",
	"mail":"<%=vo.getMail()%>",
	"password":"<%=vo.getPassword()%>",
	"content":"<%=vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>")%>",
	"hit":"<%=vo.getHit() %>",
	"wip":"<%=vo.getWip()%>",
	"wdate":"<%=vo.getWdate()%>"
	}


<%
if (i > 0)
	out.print(",");
}
	
	
	
%>


] 
}
