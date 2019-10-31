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
@RequestMapping(value="/Reply")
public class ReplyController {
	
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
	
	// 대댓글 리스트 TEST
	@RequestMapping(value = "/replyToReplyRead", method = RequestMethod.POST)
	public List<ReplyVO> replyToReplyRead(@RequestParam("boardIdx") int boardIdx) throws Exception {

		List<ReplyVO> models = service.replyToReplyRead(boardIdx);
		System.out.println("boardIdx : "+ boardIdx);
		
		for(int i = 0; i < models.size(); i++) {
            System.out.print(models.get(i).getReplyContent() + "  ");
            System.out.print(models.get(i).getReplyIdx() + "  ");
            System.out.print(models.get(i).getReplyParent() + "  ");
            System.out.print(models.get(i).getLevel() + "  ");
            System.out.println();
        }
		
		return service.replyToReplyRead(boardIdx);

	}
	// 대댓글 작성
	@RequestMapping(value = "/replyToReplyCreate", method = RequestMethod.POST)
	public Map<String, Object> replyToReplyCreate(@RequestBody ReplyVO replyVO) throws Exception {
		
		Map<String, Object> result = new HashMap<>();

		try {
			service.replyToReplyCreate(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}

	
}
