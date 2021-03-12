<%@page import="kr.or.ddit.lprod.LprodVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. 클라이언트 요청시 전송되는 데이터
//2. SqlMapClient객체 얻기
SqlMapClient aa = SqlMapClientFactory.getClient();

//3. Sql문 실행
List<LprodVO> list = aa.queryForList("lprod.selectAll");

//4. json생성
%>

[
<%
	//실행 결과로 json데이터 생성
	for (int i = 0; i < list.size(); i++) {
		LprodVO vo = list.get(i);
		if(i>0)out.print(",");
%>

{ "gu" : "<%=vo.getLprod_gu()%>", "id" : "<%=vo.getLprod_id()%>", "nm" :
"<%=vo.getLprod_nm()%>" }
<%
	}
%>
]


