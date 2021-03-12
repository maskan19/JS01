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
       
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //1. 요청시 글번호를 가져온다.
      int num = Integer.parseInt(request.getParameter("num"));
      
      //2. 서비스 객체얻어오기
      IBoardService service = BoardServiceImpl.getInstance();
      //3. 서비스 메소드 호출하기 - 결과값 받기
      int cnt = service.deleteBoard(num);
      
      //4. 결과값을 request에 저장하기
      request.setAttribute("result", cnt);
      //5. view페이지로 forward
      request.getRequestDispatcher("board/result.jsp").forward(request, response);
   }

}