package org.doorisopen.myspring.Board.Service;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
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
