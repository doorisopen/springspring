package org.doorisopen.myspring.Goods.Domain;

public class CartVO {
	
/* * * * * * * * * (사용자 추가 -> 수정 예정)
# 장바구니 테이블 생성
CREATE TABLE myspring.cart (
	cartIdx int not null auto_increment primary key,
    writer varchar(255) not null,
    goodsIdx int not null,
    goodsAmount int not null,
    constraint cart_goods_fk
    foreign key (goodsIdx) references myspring.goods (goodsIdx)
);
 * * * * * * * */
	private int cartIdx;
	private String writer;
	private int goodsIdx;
	private int goodsAmount;
	private int isGoodsExist;
	
	public int getIsGoodsExist() {
		return isGoodsExist;
	}
	public void setIsGoodsExist(int isGoodsExist) {
		this.isGoodsExist = isGoodsExist;
	}
	public int getCartIdx() {
		return cartIdx;
	}
	public void setCartIdx(int cartIdx) {
		this.cartIdx = cartIdx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getGoodsIdx() {
		return goodsIdx;
	}
	public void setGoodsIdx(int goodsIdx) {
		this.goodsIdx = goodsIdx;
	}
	public int getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(int goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	
	
}
