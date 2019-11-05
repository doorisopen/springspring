package org.doorisopen.myspring.Goods.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Goods.Domain.GoodsVO;
import org.doorisopen.myspring.Goods.Domain.ReviewVO;
import org.doorisopen.myspring.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsDAOImpl implements GoodsDAO{

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace ="org.doorisopen.myspring.Goods.GoodsMapper";
	private static final String review_namespace ="org.doorisopen.myspring.Goods.ReviewMapper";
	
	
	/* 상품 작성
	 * 
	 * 
	 */
	@Override
	public int GoodsCreate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".GoodsCreate", vo);
	}
	
	/* 상품 리스트
	 * 
	 * 
	 */
	@Override
	public List<GoodsVO> GoodsRead(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		List<GoodsVO> GoodsRead = new ArrayList<GoodsVO>();
		GoodsRead = sqlSession.selectList(namespace + ".GoodsRead", pagination);
		return GoodsRead;
	}
	
	/* 전체 상품 개수 확인
	 * 
	 * 
	 */
	@Override
	public int getGoodsListCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getGoodsListCnt");
	}
	
	/* 상품 상세
	 * 
	 * 
	 */
	@Override
	public GoodsVO GoodsDetail(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		GoodsVO vo = sqlSession.selectOne(namespace + ".GoodsDetail", goodsIdx);
		
		return vo;
	}
	
	/* 상품 수정
	 * 
	 * 
	 */
	@Override
	public int GoodsUpdate(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".GoodsUpdate", vo);
	}
	
	/* 상품 삭제
	 * 
	 * 
	 */
	@Override
	public int GoodsDelete(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + ".GoodsDelete", goodsIdx);
	}
	
	/* 상품 조회수 증가
	 * 
	 * 
	 */
	@Override
	public void GoodsViewCntUpdate(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".GoodsViewCntUpdate", goodsIdx);
	}
	
	/* 상품 댓글 수 증감
	 * 
	 * 
	 */
	@Override
	public void GoodsReplyCntUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".GoodsReplyCntUpdate", vo);
	}
	
	/* *****************************
	 *           REVIEW
	 *          
	 *******************************/
	@Override
	public List<ReviewVO> ReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int ReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ReviewDelete(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ReviewVO> reviewToReviewRead(int goodsIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int reviewToReviewCreate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
