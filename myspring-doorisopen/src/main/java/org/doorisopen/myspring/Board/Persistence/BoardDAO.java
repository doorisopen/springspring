package org.doorisopen.myspring.Board.Persistence;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.common.Pagination;


public interface BoardDAO {
	
	public int BoardCreate(BoardVO vo) throws Exception;
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception;
	public int getBoardListCnt() throws Exception;
	public BoardVO BoardDetail(int boardIdx) throws Exception;
	public int BoardUpdate(BoardVO vo) throws Exception;
	public int BoardDelete(int boardIdx) throws Exception;
	public void BoardViewCntUpdate(int boardIdx) throws Exception;
}
