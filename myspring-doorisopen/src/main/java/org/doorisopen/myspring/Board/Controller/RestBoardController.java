package org.doorisopen.myspring.Board.Controller;

import java.util.List;
import javax.inject.Inject;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/restBoard")
public class RestBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/ReqlyRead", method = RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("boardIdx") int boardIdx) throws Exception {

		return service.ReplyRead(boardIdx);

	}
	
}
