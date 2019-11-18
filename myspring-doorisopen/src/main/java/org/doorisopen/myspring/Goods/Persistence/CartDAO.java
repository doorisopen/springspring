package org.doorisopen.myspring.Goods.Persistence;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.CartVO;
import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.common.Pagination;

public interface CartDAO {
	
	// 장바구니
	public int CartAdd(CartVO vo) throws Exception;
	public List<CartVO> CartRead(Pagination pagination) throws Exception;
	public int getCartListCnt() throws Exception;
	public int CartUpdate(CartVO vo) throws Exception;
	public int CartDelete(int goodsIdx) throws Exception;
	public int isGoodsExist(CartVO vo) throws Exception;
}