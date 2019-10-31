package org.doorisopen.myspring.Board.Service;

import java.util.List;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
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
		
		return dao.BoardDelete(boardIdx);
	}
	
	
	/* *****************************
	 *           REPLY
	 *          
	 *******************************/
	
	/* 댓글 리스트
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> ReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.ReplyRead(boardIdx);
	}
	
	/* 댓글 등록
	 * 
	 * 
	 */
	@Override
	public int ReplyCreate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		vo.setReplyCnt(1);
		dao.BoardReplyCntUpdate(vo);
		return dao.ReplyCreate(vo);
	}
	
	/* 댓글 수정
	 * 
	 * 
	 */
	@Override
	public int ReplyUpdate(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.ReplyUpdate(vo);
	}
	
	/* 댓글 삭제
	 * 
	 * 
	 */
	@Override
	public int ReplyDelete(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		vo.setReplyCnt(-1);
		dao.BoardReplyCntUpdate(vo);
		return dao.ReplyDelete(vo);
	}

	
	
	
	/* 댓글 리스트 TEST
	 * 
	 * 
	 */
	@Override
	public List<ReplyVO> replyToReplyRead(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyToReplyRead(boardIdx);
	}
	
	/* 대댓글 등록
	 * 
	 * 
	 */
	@Override
	public int replyToReplyCreate(ReplyVO vo) throws Exception {
		vo.setReplyCnt(1);
		dao.BoardReplyCntUpdate(vo);
		return dao.replyToReplyCreate(vo);
	}
	
	
	
}
