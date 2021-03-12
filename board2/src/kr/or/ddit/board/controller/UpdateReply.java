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
 * Servlet implementation class UpdateReply
 */
@WebServlet("/UpdateReply.do")
public class UpdateReply extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      int renum = Integer.parseInt(request.getParameter("renum"));
      String cont = request.getParameter("cont");
      
      ReplyVO rvo = new ReplyVO();
      
      rvo.setRenum(renum);
      rvo.setCont(cont);
      
      // 2. service객체 얻기
      IBoardService service = BoardServiceImpl.getInstance();
      
      //3. service메소드 호출 - 결과값
      int cnt = service.updateReply(rvo);
      
      //4. 결고값을 request에 저장
      request.setAttribute("insert", cnt);
      //5. view페이지로 forward
      request.getRequestDispatcher("board/result.jsp").forward(request, response);
   }

}