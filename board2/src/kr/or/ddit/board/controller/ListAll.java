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

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class ListAll
 */
@WebServlet("/List.do")
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 페이지별 포스트 리스트 가져오기

		// 클라이언트 요청시 전송 데이터 받기
		// 서비스 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		// 서비스 메소드 호출 - 결과값은 list로 받기
		List<BoardVO> list = service.selectAll();
		// 결과값을 request에 저장
		request.setAttribute("123123", list);
		// view페이지로 forward
		request.getRequestDispatcher("board/listAll.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 페이지별 포스트 리스트 가져오기

		// 클라이언트 요청시 전송 데이터 받기
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		// 서비스 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();

		// 전체 글 갯수 가져오기
		int totalPost = service.postCounter();
		// 한 페이지에 출력할 포스트 수 - 4
		int postInPage = 2;
		// 한 화면에 출력할 페이지 인덱스 수 - 3
		int pageIndex = 3;
		// 전체 페이지 수 구하기
		int totalPage = (int) Math.ceil(totalPost / (double) postInPage);
		// start와 end 값 구하기
		int start = (cpage - 1) * postInPage + 1;
		int end = start + postInPage - 1;
		if (end > totalPost)
			end = totalPost;

		// startpage endpage 값 구하기
		int startPage = ((cpage - 1) / pageIndex * pageIndex) + 1;
		int endPage = startPage + pageIndex - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		// 서비스 메소드 호출 - 결과값은 list로 받기
		List<BoardVO> list = service.selectByPage(map);
		// 결과값을 request에 저장
		request.setAttribute("pageList", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		// view페이지로 forward
		request.getRequestDispatcher("board/listPage.jsp").forward(request,
				response);

	}

}
