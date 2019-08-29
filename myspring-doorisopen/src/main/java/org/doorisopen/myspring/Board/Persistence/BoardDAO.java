package org.doorisopen.myspring.Board.Persistence;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;


public interface BoardDAO {
	
	public int BoardCreate(BoardVO vo) throws Exception;
	public List<BoardVO> BoardRead(BoardVO vo) throws Exception;
	public BoardVO BoardDetail(int boardIdx) throws Exception;
	public int BoardUpdate(BoardVO vo) throws Exception;
	public int BoardDelete(int boardIdx) throws Exception;
}
