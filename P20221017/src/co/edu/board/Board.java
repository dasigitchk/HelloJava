package co.edu.board;

import java.text.SimpleDateFormat;

public class Board {
	private int boardNum;
	private String title;
	private String content;
	private SimpleDateFormat date;
	private String writer;
	private int count;
	
	Board( int boardNum, String title, String content,String writer,SimpleDateFormat date){
		this.boardNum = boardNum;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
