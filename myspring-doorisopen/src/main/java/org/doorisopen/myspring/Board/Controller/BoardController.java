package org.doorisopen.myspring.Board.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Domain.ReplyVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.doorisopen.myspring.common.FileUploadUtils;
import org.doorisopen.myspring.common.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/Board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@Autowired
	FileUploadUtils fileuploadutils;
	
	/* 게시글 작성 화면
	 * 
	 *
	 */
	@RequestMapping(value="/boardCreateView", method = RequestMethod.GET)
	public String BoardCreateView() throws Exception {
		
		
		return "/Board/boardCreate";
	}
	
	/* 게시글 작성
	 * 
	 *
	 */
	@RequestMapping(value = "/boardCreate", method = RequestMethod.POST)
	public String BoardCreate(Model model,
			HttpServletRequest request,
			@ModelAttribute BoardVO vo,
			@ModelAttribute("file") MultipartFile file) throws Exception {
		
		String boardFilePath = null;
		try {
			
			System.out.println("boardTitle : "+ request.getParameter("boardTitle"));
	    	System.out.println("boardContent : "+ request.getParameter("boardContent"));
	    	System.out.println("writer : "+ request.getParameter("writer"));
	    	System.out.println("file : "+ request.getParameter("file"));
	    	
	    	if( file.isEmpty() ) {
	    		boardFilePath = null;
	    	} else {
	    		boardFilePath = fileuploadutils.restore(file);
	    	}
	    	
	    	vo.setBoardFilePath(boardFilePath);
	    	
			service.BoardCreate(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Board/boardRead";
	}
	
	/* 게시글 리스트
	 * 
	 *
	 */
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public String BoardRead(Model model,BoardVO vo
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {

		// 전체 게시글 개수
		int listCnt = service.getBoardListCnt();
		
		// Pagination 객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", pagination);
		
		List<BoardVO> boardRead = service.BoardRead(pagination);
		model.addAttribute("boardRead", boardRead);
		
		
		return "/Board/boardRead";
	}
	
	
	/* 게시글 상세
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail(Model model, BoardVO vo, @ModelAttribute("boardIdx") int boardIdx) throws Exception {
		
		vo = service.BoardDetail(boardIdx);
		model.addAttribute("boardDetail", vo);
		model.addAttribute("replyVO", new ReplyVO());
		
		return "/Board/boardDetail";
	}
	
	
	/* 게시글 수정 화면
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdateView", method = RequestMethod.GET)
	public String BoardUpdateView(Model model, BoardVO vo,
			@ModelAttribute("boardIdx") int boardIdx) throws Exception {
		
		vo = service.BoardDetail(boardIdx);
		
		model.addAttribute("boardUpdate", vo);
		
		return "/Board/boardUpdate";
	}
	
	/* 게시글 수정
	 * 
	 *
	 */
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String BoardModify(HttpServletRequest request,
			@ModelAttribute BoardVO vo,
			@ModelAttribute("boardIdx") int boardIdx,
			@ModelAttribute("file") MultipartFile file) throws Exception {
		
		String boardFilePath = null;
		
		if( file.isEmpty() ) {
    		boardFilePath = request.getParameter("boardFilePath");
    	} else {
    		boardFilePath = fileuploadutils.restore(file);
    	}
		
    	vo.setBoardFilePath(boardFilePath);
    	
		service.BoardUpdate(vo);
		
		return "redirect:/Board/boardDetail";
	}
	
	/* 게시글 수정 - 이미지 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/deleteImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteImg(@RequestBody BoardVO vo) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		String boardFilePath = null;
		try {
			vo.setBoardFilePath(boardFilePath);
	    	
			service.BoardUpdate(vo);
			
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}
	
	/* 게시글 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String BoardDelete(@ModelAttribute("boardIdx") int boardIdx) throws Exception {
		service.BoardDelete(boardIdx);
		return "redirect:/Board/boardRead";
	}

}
