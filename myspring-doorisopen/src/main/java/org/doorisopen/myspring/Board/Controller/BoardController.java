package org.doorisopen.myspring.Board.Controller;

import org.doorisopen.myspring.Board.Service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/Board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService service;
	
	/* 게시글 작성 화면
	 * 
	 *
	 */
	@RequestMapping(value="/boardCreateView", method = RequestMethod.GET)
	public String BoardCreateView() {
		
		
		return "/Board/BoardCreate";
	}
	
	/* 게시글 작성
	 * 
	 *
	 */
	@RequestMapping(value="/boardCreate", method = RequestMethod.POST)
	public String BoardCreate() {
	
		
		return "/Board/BoardCreate";
	}
	
	/* 게시글 리스트
	 * 
	 *
	 */
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public String BoardRead() {
		
		return "/Board/BoardRead";
	}
	
	
	/* 게시글 상세
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail() {
		
		return "/Board/BoardDetail";
	}
	
	
	/* 게시글 수정 화면
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdateView", method = RequestMethod.GET)
	public String BoardUpdateView() {
		
		return "/Board/BoardUpdate";
	}
	
	/* 게시글 수정
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String BoardModify() {
		
		return "/Board/BoardUpdate";
	}
	
	/* 게시글 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String BoardDelete() {
		
		return "/Board/Board";
	}

}
