<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//서블릿 컨트롤러에서 저장된 값 가져오기
	List<ZipVO> list = (List<ZipVO>) request.getAttribute("123456");
%>
[
<%
for(int i = 0; i < list.size(); i++) {
	ZipVO vo = list.get(i);
	String bunji = vo.getBunji();
	if(bunji==null) bunji = "";
%>
	

{
"code" :"<%=vo.getZipcode() %>",
"addr" :"<%=vo.getSido() %> <%=vo.getGugun() %> <%=vo.getDong() %>",
"bunji" :"<%=bunji %>"
}
<%
if(i<list.size()-1) out.print(",");
	}
%>

]
