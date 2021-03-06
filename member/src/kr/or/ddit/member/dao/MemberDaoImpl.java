package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
 *  SqlMapClient객체 얻어오기 - 생성자
 *  -mapper-sql문을 실행하기 위한 객체
 *  
 *  자신의 객체를 생성해서 리턴 - getDao() getInstance()
 *  -service에서 사용하게 하기 위해서
 * */

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient client;
	private static IMemberDao dao;
	
	private MemberDaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static IMemberDao getDao(){
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public String selectById(String id) throws SQLException {
		return (String) client.queryForObject("member.selectById", id);
		
		/*String resid = null;
		
		//sql문을 수행 결과를 리턴 받음
		resid = (String) client.queryForObject("member.selectById", id);
		
		return resid;*/ //서비스로 리턴
	}

	@Override
	public String insertMember(MemberVO mvo) throws SQLException {
		return (String) client.insert("member.insertMember", mvo);
		
		/*String insertId = null;
		
		//sql문을 수행 결과를 리턴 받음
		insertId = (String) client.insert("member.insertMember", mvo);
		return insertId;//서비스로 리턴
*/	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
		return  client.queryForList("member.selectByDong", dong);//서비스로 리턴
	}

}
