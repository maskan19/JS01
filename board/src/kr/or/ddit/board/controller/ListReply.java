package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ListReply
 */
@WebServlet("/ListReply.do")
public class ListReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 요청시 bonum 받기
		//1
		int bonum = Integer.parseInt(request.getParameter("bonum"));
				
		//2
		IBoardService  service = BoardServiceImpl.getService();
		
		//3
		List<ReplyVO>  list = service.listReply(bonum);
		
		//4
		request.setAttribute("list", list);
		
		//5 view페이지로 forward - replyList.jsp
		request.getRequestDispatcher("board/replyList.jsp")
		        .forward(request, response);
		
		
	}

}











