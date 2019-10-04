package org.doorisopen.myspring.Board.Service;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.common.Pagination;

public interface BoardService {
	
	public int BoardCreate(BoardVO vo) throws Exception;
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception;
	public int getBoardListCnt() throws Exception;
	public BoardVO BoardDetail(int boardIdx) throws Exception;
	public int BoardUpdate(BoardVO vo) throws Exception;
	public int BoardDelete(int boardIdx) throws Exception;
	
	
	// °Ô½Ã±Û ´ñ±Û
	public List<ReplyVO> ReplyRead(int boardIdx) throws Exception;
	public int ReplyCreate(ReplyVO vo) throws Exception;
	public int ReplyUpdate(ReplyVO vo) throws Exception;
	public int ReplyDelete(int replyIdx) throws Exception;
}
