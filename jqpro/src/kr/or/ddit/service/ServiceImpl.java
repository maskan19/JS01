package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.DaoImpl;
import kr.or.ddit.dao.IDaoSample;
import kr.or.ddit.member.MemberVO;
/*
 * dao의 객체를 얻어서 dao의 메소드 호출 > servlet으로 리턴
 * 
 * servlet에서 사용할 자신의 객체를 생성하여 리턴 
 * 
 */
public class ServiceImpl implements IServiceSample {
	
	private IDaoSample dao;
	private static IServiceSample service;
	
	private ServiceImpl(){
		dao = DaoImpl.getDao();
	}
	
	public static IServiceSample getService(){
		if(service == null) service = new ServiceImpl();
		return service;
	}

	@Override
	public List<MemberVO> getMemberAll() {
		/*List<MemberVO> list= null;
		list = dao.getMemberAll();//dao메소드를 호출해서 결과를 받는다.
		return list; //servlet으로 리턴*/
		return dao.getMemberAll();
	}

}
