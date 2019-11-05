package org.doorisopen.myspring.Goods.Service;

import java.util.List;

import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.Goods.Persistence.GoodsDAO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO dao;

	
	/* 상품 등록
	 * 
	 * 
	 */
	@Override
	public int GoodsCreate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsCreate(vo);
	}

	/* 상품 리스트
	 * 
	 * 
	 */
	@Override
	public List<GoodsVO> GoodsRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsRead(pagination);
	}

	/* 전체 상품 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getGoodsListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.getGoodsListCnt();
	}

	/* 상품 상세
	 * 
	 * 
	 */
	@Override
	public GoodsVO GoodsDetail(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		// 상품 조회수 업데이트
		dao.GoodsViewCntUpdate(goodsIdx);
		
		return dao.GoodsDetail(goodsIdx);
	}
	
	/* 상품 수정
	 * 
	 * 
	 */
	@Override
	public int GoodsUpdate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsUpdate(vo);
	}
	
	/* 상품 삭제
	 * 
	 * 
	 */
	@Override
	public int GoodsDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return dao.GoodsDelete(goodsIdx);
	}

	
	/* *****************************
	 *           REVIEW
	 *          
	 *******************************/
	/* 상품 리뷰 리스트
	 * 
	 * 
	 */
	@Override
	public List<ReviewVO> ReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* 상품 리뷰 작성
	 * 
	 * 
	 */
	@Override
	public int ReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 상품 리뷰 수정
	 * 
	 * 
	 */
	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 상품 리뷰 삭제
	 * 
	 * 
	 */
	@Override
	public int ReviewDelete(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 상품 리뷰 리뷰 TEST
	 * 
	 * 
	 */
	@Override
	public List<ReviewVO> reviewToReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* 상품 리뷰 리뷰 등록
	 * 
	 * 
	 */
	@Override
	public int reviewToReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
