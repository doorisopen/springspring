package org.doorisopen.myspring.Board.Persistence;

import java.util.HashMap;
import java.util.Map;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{
	
	private Map<String, BoardVO> storage = new HashMap<String, BoardVO>();
	
	@Override
	public void boardWrite(BoardVO vo) throws Exception {
		storage.put(vo.getBoardTitle(), vo);
	}

	@Override
	public BoardVO boardDetail(String boardTitle) throws Exception {
		// TODO Auto-generated method stub
		return storage.get(boardTitle);
	}


}
