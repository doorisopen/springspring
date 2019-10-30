package org.doorisopen.myspring.Board.Service;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.common.Pagination;

public interface BoardService {
	
	// 게시글
	public int BoardCreate(BoardVO vo) throws Exception;
	public List<BoardVO> BoardRead(Pagination pagination) throws Exception;
	public int getBoardListCnt() throws Exception;
	public BoardVO BoardDetail(int boardIdx) throws Exception;
	public int BoardUpdate(BoardVO vo) throws Exception;
	public int BoardDelete(int boardIdx) throws Exception;
	
	
	// 게시글 댓글
	public List<ReplyVO> ReplyRead(int boardIdx) throws Exception;
	public int ReplyCreate(ReplyVO vo) throws Exception;
	public int ReplyUpdate(ReplyVO vo) throws Exception;
	public int ReplyDelete(ReplyVO vo) throws Exception;
	
	// 게시글 대댓글
	public List<ReplyVO> replyToReplyRead(int boardIdx) throws Exception;
	public int replyToReplyCreate(ReplyVO vo) throws Exception;
	public int replyToReplyUpdate(ReplyVO vo) throws Exception;
	public int replyToReplyDelete(ReplyVO vo) throws Exception;
}
