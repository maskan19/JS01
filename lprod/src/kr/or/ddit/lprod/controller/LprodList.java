package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LprodList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1. 클라이언트 요청시 전송되는 데이타 받기

		// 2. servlet객체 얻어오기
		ILprodService service = LprodServiceImpl.getService();

		// 3. service메소드 호출해서 결과값 받기
		List<LprodVO> list = service.selectLprod();

		// 4. 결과값을 request에 저장하기
		request.setAttribute("123456", list);

		// 5. jsp view 페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher("0205/lprod.jsp");

		disp.forward(request, response);

	}

}
