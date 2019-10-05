package org.doorisopen.myspring.Board.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/replyRead", method = RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("boardIdx") int boardIdx) throws Exception {

		return service.ReplyRead(boardIdx);

	}
	
	@RequestMapping(value = "/replyCreate", method = RequestMethod.POST)
	public Map<String, Object> ReqlyCreate(@RequestBody ReplyVO replyVO) throws Exception {
		
		Map<String, Object> result = new HashMap<>();

		try {
			service.ReplyCreate(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}
	
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public Map<String, Object> ReplyUpdate(@RequestBody ReplyVO replyVO) throws Exception {
		
		Map<String, Object> result = new HashMap<>();

		try {
			service.ReplyUpdate(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}
	
	@RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
	public Map<String, Object> ReplyDelete(@RequestBody ReplyVO replyVO) throws Exception {
		
		Map<String, Object> result = new HashMap<>();

		try {
			service.ReplyDelete(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}


	
}
