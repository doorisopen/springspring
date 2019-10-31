package org.doorisopen.myspring.Board.Domain;

public class ReplyVO {
	
	private int replyIdx;
	private int boardIdx;
	private int replyParent;
	private String replyContent;
	private String replyWriter;
	private String replyWriteDate;
	private String replyModifier;
	private String replyModifyDate;
	private int enabled;
	private int replyCnt; // +1, -1
	private int level;
	
	
	private String replyToReplyContent;
	private String replyToReplyWriter;
	

	public int getReplyIdx() {
		return replyIdx;
	}
	public void setReplyIdx(int replyIdx) {
		this.replyIdx = replyIdx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public int getReplyParent() {
		return replyParent;
	}
	public void setReplyParent(int replyParent) {
		this.replyParent = replyParent;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getReplyWriteDate() {
		return replyWriteDate;
	}
	public void setReplyWriteDate(String replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}
	public String getReplyModifier() {
		return replyModifier;
	}
	public void setReplyModifier(String replyModifier) {
		this.replyModifier = replyModifier;
	}
	public String getReplyModifyDate() {
		return replyModifyDate;
	}
	public void setReplyModifyDate(String replyModifyDate) {
		this.replyModifyDate = replyModifyDate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getReplyToReplyContent() {
		return replyToReplyContent;
	}
	public void setReplyToReplyContent(String replyToReplyContent) {
		this.replyToReplyContent = replyToReplyContent;
	}
	public String getReplyToReplyWriter() {
		return replyToReplyWriter;
	}
	public void setReplyToReplyWriter(String replyToReplyWriter) {
		this.replyToReplyWriter = replyToReplyWriter;
	}
}
