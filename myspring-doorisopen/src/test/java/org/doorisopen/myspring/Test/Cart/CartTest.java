package org.doorisopen.myspring.Test.Cart;

import org.doorisopen.myspring.urlControllerTest;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class CartTest {
	
	private static final Logger logger = LoggerFactory.getLogger(urlControllerTest.class);
	
	
	@Autowired
	private CartService service;
	
	@Test
	public void cartAddTest() {
		System.out.println("This is cartAddTest Test...");
		CartVO vo = new CartVO();
		vo.setGoodsIdx(10);
		vo.setWriter("as");
		try {
			int isGoodsExist = service.isGoodsExist(vo);
			System.out.println("isGoodsExist: "+isGoodsExist);
			if(isGoodsExist == 0) {
				System.out.print("상품이  존재 하지 않습니다.");
			} else {
				System.out.print("상품이 이미 존재 합니다.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
