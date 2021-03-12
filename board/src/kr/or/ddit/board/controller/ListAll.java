package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class ListAll
 */
@WebServlet("/List.do")
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//젠체목록 가져오기 
		
		//1. 클라이언트 요청시 전송 데이타 받기
		
		//2. service객체 얻기 
		IBoardService  service =BoardServiceImpl.getService();
	
		//3. service메소드 호출 - 결과값 받기 
		List<BoardVO>  list = service.selectAll();
		
		//4. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//5. view페이지로 forward
		request.getRequestDispatcher("board/listAll.jsp")
		        .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지별 리스트  가져오기 
		
		
		//1. 클라이언트 요청시 전송 데이타 받기- 페이지번호
		int cpage =Integer.parseInt(request.getParameter("cpage"));
		
		//2. service객체 얻기 
		IBoardService  service =BoardServiceImpl.getService();
	
		
		//전체 글 갯수 가져오기 
		int totalCount = service.listCount();
		
		//한페이지에 출력할 글갯수 - 3
		int perList = 3;
		
		//한화면에 출력할 페이지수 -2
		int perPage = 2;
		
		//전체페이지수 구하기 - 7
		int totalPage = (int)(Math.ceil( totalCount /(double)perList));
				
		//start와 end값구하기 1- > 1,2,3  2-> 4,5,6 3-> 7,8,9 
		//7-> 19, 20, 21
		int start = (cpage-1) * perList + 1;
		int end = start + perList - 1;
		if(end > totalCount) end = totalCount;
		
		//startpage와 endpage구하기
        int startPage = ((cpage-1) / perPage * perPage) +1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		Map<String, Integer>  map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//3. service메소드 호출 - 결과값 받기 
		List<BoardVO>  list = service.selectByPage(map);
		
		//4. 결과값을 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("totalp", totalPage);
		request.setAttribute("startp", startPage);
		request.setAttribute("endp", endPage);
		
		
		//5. view페이지로 forward
		request.getRequestDispatcher("board/listPage.jsp")
		        .forward(request, response);
		
				
	}

}
