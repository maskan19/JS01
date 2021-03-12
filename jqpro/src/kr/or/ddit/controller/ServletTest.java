package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.MemberVO;
import kr.or.ddit.service.IServiceSample;
import kr.or.ddit.service.ServiceImpl;
/*
 * Servlet > Service> Dao > Service > Servlet
 */



/**
 * Servlet implementation class ServletTest
 * 
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 전송되는 데이터 받기
		String aa = request.getParameter("id");
		
		//2. crud준비
		//2.service 객체 얻어오기
		IServiceSample service = ServiceImpl.getService();
		
		//3.service메소드 호출 - 결과값 리턴 받아 가져온다.
		List<MemberVO> list = service.getMemberAll();
		
		//list결과값을 request객체에 저장
		request.setAttribute("listvalue", list);
		
		
		
		//4. 수행 결과값을 view페이지로 보낸다 - forward방식
		RequestDispatcher disp = request.getRequestDispatcher("0205/view.jsp");
		disp.forward(request, response);
		
	}

}
