package org.doorisopen.myspring.Goods.Service;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.common.Pagination;

public interface GoodsService {

	
	// 상품
	public int GoodsCreate(GoodsVO vo) throws Exception;
	public List<GoodsVO> GoodsRead(Pagination pagination) throws Exception;
	public int getGoodsListCnt() throws Exception;
	public GoodsVO GoodsDetail(int goodsIdx) throws Exception;
	public int GoodsUpdate(GoodsVO vo) throws Exception;
	public int GoodsDelete(int goodsIdx) throws Exception;
	
	
	// 상품 리뷰
	public List<ReviewVO> ReviewRead(int goodsIdx) throws Exception;
	public int ReviewCreate(ReviewVO vo) throws Exception;
	public int ReviewUpdate(ReviewVO vo) throws Exception;
	public int ReviewDelete(ReviewVO vo) throws Exception;
	
	// 상품 대댓글
	public List<ReviewVO> reviewToReviewRead(int goodsIdx) throws Exception;
	public int reviewToReviewCreate(ReviewVO vo) throws Exception;
}
