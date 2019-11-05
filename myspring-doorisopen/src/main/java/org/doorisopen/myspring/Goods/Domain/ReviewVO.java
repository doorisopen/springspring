package org.doorisopen.myspring.Goods.Domain;

public class ReviewVO {
	
	private int reviewIdx;
	private int goodsIdx;
	private int reviewParent;
	private String reviewContent;
	private String reviewWriter;
	private String reviewWriteDate;
	private String reviewModifier;
	private String reviewModifyDate;
	private int enabled;
	private int reviewCnt; // +1, -1
	private int level;
	
	
	private String reviewToReviewContent;
	private String reviewToReviewWriter;
	
	public int getReviewIdx() {
		return reviewIdx;
	}
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}
	public int getGoodsIdx() {
		return goodsIdx;
	}
	public void setGoodsIdx(int goodsIdx) {
		this.goodsIdx = goodsIdx;
	}
	public int getReviewParent() {
		return reviewParent;
	}
	public void setReviewParent(int reviewParent) {
		this.reviewParent = reviewParent;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewWriteDate() {
		return reviewWriteDate;
	}
	public void setReviewWriteDate(String reviewWriteDate) {
		this.reviewWriteDate = reviewWriteDate;
	}
	public String getReviewModifier() {
		return reviewModifier;
	}
	public void setReviewModifier(String reviewModifier) {
		this.reviewModifier = reviewModifier;
	}
	public String getReviewModifyDate() {
		return reviewModifyDate;
	}
	public void setReviewModifyDate(String reviewModifyDate) {
		this.reviewModifyDate = reviewModifyDate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getReviewCnt() {
		return reviewCnt;
	}
	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getReviewToReviewContent() {
		return reviewToReviewContent;
	}
	public void setReviewToReviewContent(String reviewToReviewContent) {
		this.reviewToReviewContent = reviewToReviewContent;
	}
	public String getReviewToReviewWriter() {
		return reviewToReviewWriter;
	}
	public void setReviewToReviewWriter(String reviewToReviewWriter) {
		this.reviewToReviewWriter = reviewToReviewWriter;
	}
	

}
