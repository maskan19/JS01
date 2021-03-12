package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class UpdateHit
 */
@WebServlet("/updateHit.do")
public class UpdateHit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 값 받기 - num값 받기
		request.setCharacterEncoding("utf-8");

		//2. service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//3. service 메소드 호출 - 결과값 받기
		int cnt = service.updateHit(Integer.parseInt(request.getParameter("num")));
		
		//4. 결과값을 request에 저장
		request.setAttribute("result", cnt);
		
		//5. view페이지로 forward-result.jsp
		request.getRequestDispatcher("board/result.jsp").forward(request,
				response);
	}

}
