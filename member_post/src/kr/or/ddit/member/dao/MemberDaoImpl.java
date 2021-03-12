package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

import com.ibatis.sqlmap.client.SqlMapClient;

/*
 * SqlMapClient객체 생성자로 얻어오기
 * - mapper: sql문을 실행하기 위한 객체
 * 자신의 객체를 생성해서 리턴 - getDao() getInstance()
 * - service 에서 사용하게 하기 위해서
 *  
 */
public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient client;
	private static IMemberDao dao;

	private MemberDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}

	public static IMemberDao getDao() {
		if (dao == null)
			dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public String selectById(String id) throws SQLException {
//		String resid = null;
//		// sql문 을 수행한 결과
//		resid = (String) client.queryForObject("member.selectById", id);
		return (String) client.queryForObject("member.selectById", id); // 서비스로 리턴
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
//		String insertId = null;
//		insertId = (String) client.insert("member.insertMember", vo);
//		return insertId;
		return (String) client.insert("member.insertMember", vo);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
//		List<ZipVO> list = null;
//		list = client.queryForList("member.selectByDong", dong);
//		return list;
		return client.queryForList("member.selectByDong", dong);
	}
}
