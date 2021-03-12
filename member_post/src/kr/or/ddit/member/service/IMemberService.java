package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {

	public String selectById(String id);
	
	public String insertMember(MemberVO vo);
	
	public List<ZipVO> selectByDong(String dong);
	
}
