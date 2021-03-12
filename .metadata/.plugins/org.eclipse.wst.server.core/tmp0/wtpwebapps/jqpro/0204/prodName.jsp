<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.ProdVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 1. SqlMapClient 객체를 얻어오기
   String lgu = request.getParameter("gu");

   // 2. sql문을 실행
   SqlMapClient smc = SqlMapClientFactory.getClient();
   
   //3. sql문 실행
   List<ProdVO> list = smc.queryForList("prod.selectByName", lgu);
   if(list !=null &&list.size()>0){
%>
[
<%
for(int i = 0; i<list.size(); i++){
	ProdVO vo = list.get(i);
	if(i>0) out.print(",");
%>
{
"id" : "<%=vo.getProd_id() %>",
"name" : "<%= vo.getProd_name()%>"

}
<%
}
%>

]

<%
}else{
}
%>