package org.doorisopen.myspring.Goods.Domain;

public class GoodsVO {
	
/* * * * * * * * *
# 상품 테이블 생성
CREATE TABLE myspring.goods (
	 goodsIdx int not null auto_increment,
     goodsTitle varchar(255) not null,
     goodsContent text not null,
     writer varchar(255) not null,
     writeDate datetime not null default now(),
     modifier varchar(255),
     modifyDate datetime,
     important int not null default 0,
     enabled int not null default 1,
     goodsViewCnt int not null default 0,
     goodsReviewCnt int not null default 0,
     goodsFilePath varchar(255),
     PRIMARY KEY(goodsIdx)
);
 * * * * * * * */
	
	private int goodsIdx;
	private String goodsTitle;
	private String goodsContent;
	private String writer;
	private String writeDate;
	private String modifier;
	private String modifyDate;
	private int important;
	private int enabled;
	private int goodsViewCnt;
	private int goodsReplyCnt;
	private String goodsFilePath;
	
	public int getGoodsIdx() {
		return goodsIdx;
	}
	public void setGoodsIdx(int goodsIdx) {
		this.goodsIdx = goodsIdx;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getImportant() {
		return important;
	}
	public void setImportant(int important) {
		this.important = important;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getGoodsViewCnt() {
		return goodsViewCnt;
	}
	public void setGoodsViewCnt(int goodsViewCnt) {
		this.goodsViewCnt = goodsViewCnt;
	}
	public int getGoodsReplyCnt() {
		return goodsReplyCnt;
	}
	public void setGoodsReplyCnt(int goodsReplyCnt) {
		this.goodsReplyCnt = goodsReplyCnt;
	}
	public String getGoodsFilePath() {
		return goodsFilePath;
	}
	public void setGoodsFilePath(String goodsFilePath) {
		this.goodsFilePath = goodsFilePath;
	}
	
	
	
}
