package org.doorisopen.myspring.Board.Service;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Persistence.BoardDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;

	
	/* 게시글 작성
	 * 
	 * 
	 */
	@Override
	public int BoardCreate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardCreate(vo);
	}

	/* 게시글 리스트
	 * 
	 * 
	 */
	@Override
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardRead(pagination);
	}
	
	/* 전체 게시글 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getBoardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getBoardListCnt();
	}
	
	/* 게시글 상세
	 * 
	 * 
	 */
	@Override
	public BoardVO BoardDetail(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		
		// 게시글 조회수 업데이트
		dao.BoardViewCntUpdate(boardIdx);
		
		return dao.BoardDetail(boardIdx);
	}

	/* 게시글 수정
	 * 
	 * 
	 */
	@Override
	public int BoardUpdate(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardUpdate(vo);
	}

	/* 게시글 삭제
	 * 
	 * 
	 */
	@Override
	public int BoardDelete(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardDelete(boardIdx);
	}

	
}
