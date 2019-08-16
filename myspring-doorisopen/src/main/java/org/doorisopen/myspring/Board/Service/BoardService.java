package org.doorisopen.myspring.Board.Service;

import org.doorisopen.myspring.Board.Domain.BoardVO;

public interface BoardService {
	
	public void BoardWrite(BoardVO vo) throws Exception;
	public BoardVO BoardDetail(String boardTitle) throws Exception;

}
