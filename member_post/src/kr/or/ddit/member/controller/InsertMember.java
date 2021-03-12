package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1. 클라이언트 요청시 전송되는 값을 리턴
		// 1-1. 입력한 ID값을 리턴
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String pass = request.getParameter("mem_pass");
		String bir = request.getParameter("mem_bir");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		String hp = request.getParameter("mem_hp");
		String mail = request.getParameter("mem_mail"); 
		
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(id);
		mvo.setMem_add1(add1);
		mvo.setMem_add2(add2);
		mvo.setMem_bir(bir);
		mvo.setMem_hp(hp);
		mvo.setMem_zip(zip);
		mvo.setMem_mail(mail);
		mvo.setMem_name(name);
		mvo.setMem_pass(pass);

		// 2. service 객체를 얻는다
		IMemberService service = MemberServiceImpl.getService();

		// 3. service 메소드 호출> 결과값 받기
		String result = service.insertMember(mvo);

		// 4. 결과값을 request에 저장
		request.setAttribute("result", result);

		// 5. view 페이지로 forward
		RequestDispatcher disp = request
				.getRequestDispatcher("member/insert.jsp");
		disp.forward(request, response);
	}

}
