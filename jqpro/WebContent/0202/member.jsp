<%@page import="kr.or.ddit.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClientBuilder"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="com.ibatis.common.resources.Resources"%>
<%@page import="java.io.Reader"%>
<%@page import="java.nio.charset.Charset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 1. sqlMapClient 객체 생성 = SqlMapClientFactory.getClient()
	// 2. sql문을 실행 = mapper파일의 namespace.id이름 
	//		select> aa.queryForList() 또는 aa.queryForObject()
%>

<%
	//SqlMapClient객체 얻어오기
	SqlMapClient aa = SqlMapClientFactory.getClient();

	//sql문 실행
	List<MemberVO> list = aa.queryForList("member.selectAll");
%>
[
<%
	//실행 결과로 json데이터 생성
	for (int i = 0; i < list.size(); i++) {
		MemberVO vo = list.get(i);
		if(i>0)out.print(",");
%>

{ "id" : "<%=vo.getMem_id()%>", "name" : "<%=vo.getMem_name()%>", "hp" :
"<%=vo.getMem_hp()%>", "mail" : "<%=vo.getMem_mail()%>" }
<%
	}
%>

]
