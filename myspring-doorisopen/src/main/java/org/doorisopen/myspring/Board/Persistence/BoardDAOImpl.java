package org.doorisopen.myspring.Board.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Board.BoardMapper";
	
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


}
