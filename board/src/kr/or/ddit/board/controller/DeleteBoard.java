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
 * Servlet implementation class DeleteBoard
 */
@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청시 글번호를 가져온다 
		int num =Integer.parseInt(request.getParameter("num"));
		
		//2. service객체 얻기 
		IBoardService  service = BoardServiceImpl.getService();
		
		//3.service메소드 호출하기- 결과값 받기
		int cnt = service.deleteBoard(num);
		
		//4. 결과값을 request에 저장 
		request.setAttribute("result", cnt);
		
		//5. view페이지로 forward - result.jsp
		request.getRequestDispatcher("board/result.jsp")
	       .forward(request, response);
	}

}
