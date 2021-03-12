package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.MemberVO;

import com.ibatis.sqlmap.client.SqlMapClient;

/*
 * SqlMapClient 객체를 얻어서 mapper 수행 >service로 리턴
 * service에서 사용할 자신의 객체를 생성 - 리턴하는  get
 */
public class DaoImpl implements IDaoSample {

	private SqlMapClient client;
	private static IDaoSample dao;
	
	//생성자
	private DaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static IDaoSample getDao(){
		if(dao==null) dao  = new DaoImpl();
		return dao;
	}
	
	
	@Override
	public List<MemberVO> getMemberAll() {
		List<MemberVO> list = null;
		try {
			//mapper에서 수행된 결과를 받는다.
			list = client.queryForList("member.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; //service로 리턴한다.
	}

}
