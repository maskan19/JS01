package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

/*
 * SqlMapClient 객체 얻어오기 (생성자에서)
 * 자신의 객체를 생성하고 리턴하는 메소드 - getDao(), getInstance()
 */
public class BoardDaoImpl implements IBoardDao {

	private SqlMapClient client;
	private static IBoardDao dao;

	private BoardDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}

	public static IBoardDao getInstance() {
		if (dao == null)
			dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return client.queryForList("board.selectAll");
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map)
			throws SQLException {
		return client.queryForList("board.selectByPage", map);
	}

	@Override
	public int postCounter() throws SQLException {
		return (Integer) client.queryForObject("board.postCounter");
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (Integer) client.insert("board.insertBoard", vo);
	}

	@Override
	public int deleteBoard(int num) throws SQLException {
		return (Integer) client.delete("board.deleteBoard", num);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		return (Integer) client.update("board.updateBoard", vo);
	}

	@Override
	public int updateHit(int num) throws SQLException {
		return (Integer) client.update("board.updateHit", num);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (Integer) client.insert("reply.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		return (List<ReplyVO>) client.queryForList("reply.listReply", bonum);
	}

	@Override
	public int deleteReply(int renum) throws SQLException{
		return (Integer) client.delete("reply.deleteReply", renum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		return (Integer) client.update("reply.updateReply", vo);
	}

}
