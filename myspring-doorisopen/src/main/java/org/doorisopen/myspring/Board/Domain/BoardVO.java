package org.doorisopen.myspring.Board.Domain;

public class BoardVO {
	
	private int boardIdx;
	private String boardTitle;
	private String boardContent;
	private String writer;
	private String writeDate;
	private int enabled;
	
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
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	// DI XML Test by doorisopen
	public String toString() {
		return "BoardVO [boardIdx="+boardIdx+" boardTitle="+boardTitle+" boardContent="+boardContent+" writer="+writer+"]";
	}
}
