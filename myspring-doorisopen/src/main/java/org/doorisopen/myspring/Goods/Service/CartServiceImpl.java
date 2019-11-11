package org.doorisopen.myspring.Goods.Service;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Persistence.CartDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO dao;

	
	/* 장바구니 추가
	 * 
	 * 
	 */
	@Override
	public int CartAdd(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartAdd(vo);
	}

	/* 장바구니 리스트
	 * 
	 * 
	 */
	@Override
	public List<CartVO> CartRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartRead(pagination);
	}

	/* 전체 장바구니 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getCartListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getCartListCnt();
	}
	
	/* 장바구니 수정
	 * 
	 * 
	 */
	@Override
	public int CartUpdate(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartUpdate(vo);
	}
	
	/* 장바구니 삭제
	 * 
	 * 
	 */
	@Override
	public int CartDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.CartDelete(goodsIdx);
	}

	
}
