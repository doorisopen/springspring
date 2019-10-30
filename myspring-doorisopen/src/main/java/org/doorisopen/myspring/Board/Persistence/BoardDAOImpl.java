package org.doorisopen.myspring.Board.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Board.BoardMapper";
	private static final String reply_namespace ="org.doorisopen.myspring.Board.ReplyMapper";
	
	/* 게시글 작성
	 * 
	 * 
	 */
	@Override
	public int BoardCreate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".BoardCreate", vo);
	}

	/* 게시글 리스트
	 * 
	 * 
	 */
	@Override
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<BoardVO> BoardRead = new ArrayList<BoardVO>();
		BoardRead = sqlSession.selectList(namespace + ".BoardRead", pagination);
		return BoardRead;
	}
	
	/* 전체 게시글 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getBoardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBoardListCnt");
	}
	
	/* 게시글 상세
	 * 
	 * 
	 */
	@Override
	public BoardVO BoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		BoardVO vo = sqlSession.selectOne(namespace + ".BoardDetail", boardIdx);
		
		return vo;
	}

	/* 게시글 수정
	 * 
	 * 
	 */
	@Override
	public int BoardUpdate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".BoardUpdate", vo);
	}

	/* 게시글 삭제
	 * 
	 * 
	 */
	@Override
	public int BoardDelete(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".BoardDelete", boardIdx);
	}

	/* 게시글 조회수 증가
	 * 
	 * 
	 */
	@Override
	public void BoardViewCntUpdate(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".BoardViewCntUpdate", boardIdx);
	}
	
	/* 게시글 댓글 수 증감
	 * 
	 * 
	 */
	@Override
	public void BoardReplyCntUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".BoardReplyCntUpdate", vo);
	}

	
	/* *****************************
	 *           REPLY
	 *          
	 *******************************/
	
	/* 댓글 리스트
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> ReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(reply_namespace + ".ReplyRead", boardIdx);
	}
	
	/* 댓글 등록
	 * 
	 * 
	 */
	@Override
	public int ReplyCreate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(reply_namespace + ".ReplyCreate", vo);
	}
	
	/* 댓글 수정
	 * 
	 * 
	 */
	@Override
	public int ReplyUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(reply_namespace + ".ReplyUpdate", vo);
	}
	
	/* 댓글 삭제
	 * 
	 * 
	 */
	@Override
	public int ReplyDelete(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(reply_namespace + ".ReplyDelete", vo);
	}

	
	/* *****************************
	 *        REPLY TO REPLY
	 *          
	 *******************************/
	
	/* 대댓글 리스트
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> replyToReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(reply_namespace + ".replyToReplyRead", boardIdx);
	}
	
	
	/* 대댓글 등록
	 * 
	 * 
	 */
	@Override
	public int replyToReplyCreate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(reply_namespace + ".replyToReplyCreate", vo);
	}
	
	
	/* 대댓글 수정
	 * 
	 * 
	 */
	@Override
	public int replyToReplyUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(reply_namespace + ".replyToReplyUpdate", vo);
	}
	

	/* 대댓글 삭제
	 * 
	 * 
	 */
	@Override
	public int replyToReplyDelete(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(reply_namespace + ".replyToReplyDelete", vo);
	}
}
