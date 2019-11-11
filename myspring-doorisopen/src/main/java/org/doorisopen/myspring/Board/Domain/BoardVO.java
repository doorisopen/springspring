package org.doorisopen.myspring.Board.Domain;

public class BoardVO {

/* * * * * * * * *
# 게시글 테이블 생성
CREATE TABLE myspring.board (
	 boardIdx int not null auto_increment,
     boardTitle varchar(255) not null,
     boardContent text not null,
     writer varchar(255) not null,
     writeDate datetime not null default now(),
     modifier varchar(255),
     modifyDate datetime,
     important int not null default 0,
     enabled int not null default 1,
     boardViewCnt int not null default 0,
     boardReplyCnt int not null default 0,
     boardFilePath varchar(255),
     PRIMARY KEY(boardIdx)
);
 * * * * * * * */
	
	private int boardIdx;
	private String boardTitle;
	private String boardContent;
	private String writer;
	private String writeDate;
	private String modifier;
	private String modifyDate;
	private int important;
	private int enabled;
	private int boardViewCnt;
	private int boardReplyCnt;
	private String boardFilePath;
	
	
	
	
	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
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
	public int getBoardViewCnt() {
		return boardViewCnt;
	}

	public void setBoardViewCnt(int boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
	}

	public int getBoardReplyCnt() {
		return boardReplyCnt;
	}

	public void setBoardReplyCnt(int boardReplyCnt) {
		this.boardReplyCnt = boardReplyCnt;
	}
	public String getBoardFilePath() {
		return boardFilePath;
	}

	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}

	// DI XML Test by doorisopen
	public String toString() {
		return "BoardVO [boardIdx="+boardIdx+" boardTitle="+boardTitle+" boardContent="+boardContent+" writer="+writer+"]";
	}

	
}
