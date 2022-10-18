package co.edu.board;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// CRUD
public class BoardDAO extends DAO{
	List<Board> board = new ArrayList<>();
	 
	Date now = new Date();
	public void insert(Board text) {
		conn = getConnect();
//		String sql = "insert into board(board_num, board_title,"
//				+ "board_content, board_writer, creation_date, cnt)"
//				+ "values("+get.
					
		board.add(new Board(text.getBoardNum(), text.getTitle(),
				  text.getContent(), text.getWriter(), text.getDate()));
	}
	
	public void Update(int num) {
		
	}
}