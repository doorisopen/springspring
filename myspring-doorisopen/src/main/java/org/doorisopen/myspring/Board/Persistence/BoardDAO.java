package org.doorisopen.myspring.Board.Persistence;

import org.doorisopen.myspring.Board.Domain.BoardVO;


public interface BoardDAO {
	
	public void boardWrite(BoardVO vo) throws Exception;
	public BoardVO boardDetail(String boardTitle) throws Exception;
}
