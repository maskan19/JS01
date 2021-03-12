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
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      // 1. 클라이언트 요청시 전송데이터 받기
      
      ReplyVO rvo = new ReplyVO();
      
      int bonum = Integer.parseInt(request.getParameter("bonum"));
      String name = request.getParameter("name");
      String cont = request.getParameter("cont");
      
      rvo.setBonum(bonum);
      rvo.setName(name);
      rvo.setCont(cont);
      
      // 2. service객체 얻기
      IBoardService service = BoardServiceImpl.getInstance();
            
      //3. service메소드 호출 - 결과값
      int re = service.insertReply(rvo);
            
      //4. 결고값을 request에 저장
      request.setAttribute("result", re);
      //5. view페이지로 forward
      request.getRequestDispatcher("board/result.jsp").forward(request, response);
   }

}