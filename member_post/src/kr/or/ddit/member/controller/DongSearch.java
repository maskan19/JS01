package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class DongSearch
 */
@WebServlet("/DongSearch.do")
public class DongSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DongSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시 전송되는 데이터를 받는다
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		//2. service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		//3. service메서드 호출해서 결과값 받기
		List<ZipVO> list = service.selectByDong(dong);
		//4. 결과값을 (pagecontext: 현재 페이지에서만 사용 /)request: 일회 요청에 일회 응답(/session: 세션이 종료되기(주로 로그아웃) 전까지/application: 서버가 꺼지기 전까지) 에 저장
		request.setAttribute("123456", list);
		//5. view페이지(jsp)페이지로 forward: 4의 결과값을 공유한다.(/redirect: 클라이언트가 재요청하므로 4의 결과값 유지 불가)
		RequestDispatcher disp = request.getRequestDispatcher("member/zipcode.jsp");
		disp.forward(request, response);
	}

}
