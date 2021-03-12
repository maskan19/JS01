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
 * Servlet implementation class DeleteReply
 */
@WebServlet("/DeleteReply.do")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 renum가져오기 
		int num =Integer.parseInt(request.getParameter("renum"));
		System.out.println("num=" + num);
		
		//2. service객체 얻기 
		IBoardService  service = BoardServiceImpl.getService();
		
		//3.service메소드 호출하기- 결과값 받기
		int cnt = service.deleteReply(num);
		
		//4. 결과값을 request에 저장 
		request.setAttribute("result", cnt);
		
		//5. view페이지로 forward - result.jsp
		request.getRequestDispatcher("board/result.jsp")
	              .forward(request, response);
		
	}

}
