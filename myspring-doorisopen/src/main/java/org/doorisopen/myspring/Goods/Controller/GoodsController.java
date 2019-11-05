package org.doorisopen.myspring.Goods.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.doorisopen.myspring.Board.Controller.BoardController;
import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.Goods.Service.GoodsService;
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
@RequestMapping(value="/Goods")
public class GoodsController {
	
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private GoodsService service;
	
	@Autowired
	FileUploadUtils fileuploadutils;

	
	/* 상품 작성 화면
	 * 
	 *
	 */
	@RequestMapping(value="/goodsCreateView", method = RequestMethod.GET)
	public String BoardCreateView() throws Exception {
		
		
		return "/Goods/goodsCreate";
	}
	
	/* 상품 등록
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsCreate", method = RequestMethod.POST)
	public String GoodsCreate(Model model,
			HttpServletRequest request,
			@ModelAttribute GoodsVO vo,
			@ModelAttribute("file") MultipartFile file) throws Exception {
		
		String goodsFilePath = null;
		try {
			
			System.out.println("goodsTitle : "+ request.getParameter("goodsTitle"));
	    	System.out.println("goodsContent : "+ request.getParameter("goodsContent"));
	    	System.out.println("writer : "+ request.getParameter("writer"));
	    	System.out.println("file : "+ request.getParameter("file"));
	    	
	    	if( file.isEmpty() ) {
	    		goodsFilePath = null;
	    	} else {
	    		goodsFilePath = fileuploadutils.restore(file);
	    	}
	    	
	    	vo.setGoodsFilePath(goodsFilePath);
	    	
			service.GoodsCreate(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Goods/goodsRead";
	}
	
	/* 상품 리스트
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsRead", method = RequestMethod.GET)
	public String GoodsRead(Model model,GoodsVO vo
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {

		// 전체 게시글 개수
		int listCnt = service.getGoodsListCnt();
		
		// Pagination 객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", pagination);
		
		List<GoodsVO> goodsRead = service.GoodsRead(pagination);
		model.addAttribute("goodsRead", goodsRead);
		
		
		return "/Goods/goodsRead";
	}
	
	
	/* 상품 상세
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
	public String GoodsDetail(Model model, GoodsVO vo, @ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		
		vo = service.GoodsDetail(goodsIdx);
		model.addAttribute("goodsDetail", vo);
		model.addAttribute("reviewVO", new ReviewVO());
		
		return "/Goods/goodsDetail";
	}
	
	
	/* 상품 수정 화면
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsUpdateView", method = RequestMethod.GET)
	public String GoodsUpdateView(Model model, GoodsVO vo,
			@ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		
		vo = service.GoodsDetail(goodsIdx);
		
		model.addAttribute("goodsUpdate", vo);
		
		return "/Goods/goodsUpdate";
	}
	
	/* 상품 수정
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsUpdate", method = RequestMethod.POST)
	public String GoodsModify(HttpServletRequest request,
			@ModelAttribute GoodsVO vo,
			@ModelAttribute("goodsIdx") int goodsIdx,
			@ModelAttribute("file") MultipartFile file) throws Exception {
		
		String goodsFilePath = null;
		
		if( file.isEmpty() ) {
			goodsFilePath = request.getParameter("goodsFilePath");
    	} else {
    		goodsFilePath = fileuploadutils.restore(file);
    	}
		
    	vo.setGoodsFilePath(goodsFilePath);
    	
		service.GoodsUpdate(vo);
		
		return "redirect:/Goods/goodsDetail";
	}
	
	/* 상품 수정 - 이미지 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/deleteImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteImg(@RequestBody GoodsVO vo) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		String goodsFilePath = null;
		try {
			vo.setGoodsFilePath(goodsFilePath);
	    	
			service.GoodsUpdate(vo);
			
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");

		}
		return result;
	}
	
	/* 상품 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/goodsDelete", method = RequestMethod.GET)
	public String GoodsDelete(@ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		service.GoodsDelete(goodsIdx);
		return "redirect:/Goods/boardRead";
	}
}
