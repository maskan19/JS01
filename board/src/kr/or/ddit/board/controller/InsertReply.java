package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class InsertReply
 */
@WebServlet("/InsertReply.do")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//1. 요청시 전송되는 값 가져오기 - bonum, name, cont 
		//VO에 저장 
		ReplyVO  vo  = new ReplyVO();
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name =   request.getParameter("name");
		String cont =   request.getParameter("cont");
	
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		//2. service객체 얻기
		IBoardService  service = BoardServiceImpl.getService();
		
		//3. service메소드 호출 결과값 받기 
		int renum = service.insertReply(vo);
		
		//4. 결과값을 request에 저장
		request.setAttribute("result", renum);
		
		//5 view페이지로 forward-result.jsp
		request.getRequestDispatcher("board/result.jsp")
		       .forward(request, response);
	}

}
