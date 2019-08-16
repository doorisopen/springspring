package org.doorisopen.myspring.Board.Service;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Persistence.BoardDAO;
import org.springframework.stereotype.Service;

public class BoardServiceImpl implements BoardService{

	
	// Method 1 (Constructor Injection)
	// (root-context.xml) <construtor-arg> 태그 사용
	private BoardDAO dao;
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	// Method 2 (Setter Injection)
	// (root-context.xml) <property> 태그 사용
	/*
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	*/
	
	@Override
	public void BoardWrite(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.boardWrite(vo);
		
	}
	@Override
	public BoardVO BoardDetail(String boardTitle) throws Exception {
		// TODO Auto-generated method stub
		return dao.boardDetail(boardTitle);
	}
}
