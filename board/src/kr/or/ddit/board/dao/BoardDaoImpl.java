package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

/*
 * SqlMapClient 객체 얻어오기 - 생성자 
 * 자신의 객체를 생성하고 리턴 하는 메소드 - getDao()  getInstance()
 * 
 */
public class BoardDaoImpl implements IBoardDao {
  
	private SqlMapClient  client;
	private static IBoardDao  dao ;
	
	//생성자
	private BoardDaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static IBoardDao getDao(){
		if(dao == null)  dao = new BoardDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.selectAll");
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map)
			throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.selectByPage", map);
	}

	@Override
	public int listCount() throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)client.queryForObject("board.listCount");
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 0;
		Object obj = client.insert("board.insertBoard", vo);
		if(obj==null) cnt = 1;
		return cnt;
	}

	@Override
	public int deleteBoard(int num) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("board.deleteBoard", num);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("board.updateBoard", vo);
	}

	@Override
	public int updateHit(int num) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("board.updateHit", num);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)client.insert("reply.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("reply.listReply", bonum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)client.update("reply.updateReply", vo);
	}

	
	@Override
	public int deleteReply(int renum) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("reply.deleteReply", renum);
	}

}



