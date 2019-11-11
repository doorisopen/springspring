package org.doorisopen.myspring.Goods.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.doorisopen.myspring.Board.Controller.BoardController;
import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Service.CartService;
import org.doorisopen.myspring.common.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/Cart")
public class CartController {
	
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private CartService service;

	
	
	/* 장바구니 추가
	 * 
	 *
	 */
	@RequestMapping(value = "/cartAdd", method = RequestMethod.POST)
	public String GoodsCreate(Model model,
			HttpServletRequest request,
			@ModelAttribute CartVO vo) throws Exception {
	
		try {
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Cart/cartRead";
	}
	
	/* 장바구니 리스트
	 * 
	 *
	 */
	@RequestMapping(value = "/cartRead", method = RequestMethod.GET)
	public String CartRead(Model model,CartVO vo
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) throws Exception {

		// 전체 게시글 개수
		int listCnt = service.getCartListCnt();
		
		// Pagination 객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", pagination);
		
		List<CartVO> cartRead = service.CartRead(pagination);
		model.addAttribute("cartRead", cartRead);
		
		
		return "/Cart/cartRead";
	}
	
	/* 장바구니 수정
	 * 
	 *
	 */
	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String GoodsModify(HttpServletRequest request,
			@ModelAttribute CartVO vo,
			@ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		
    	
		service.CartUpdate(vo);
		
		return "redirect:/Cart/cartRead";
	}
	
	/* 장바구니 삭제
	 * 
	 *
	 */
	@RequestMapping(value = "/cartDelete", method = RequestMethod.GET)
	public String GoodsDelete(@ModelAttribute("goodsIdx") int goodsIdx) throws Exception {
		service.CartDelete(goodsIdx);
		return "redirect:/Cart/boardRead";
	}
}
