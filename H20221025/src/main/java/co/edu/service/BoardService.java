package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

public interface BoardService {
	// 기능�? ?��?��.
	// ?��?��.
	public BoardVO insertBoard(BoardVO vo);

	public List<BoardVO> getList(BoardVO vo);

	public BoardVO findBoard(int boardNo);

	public boolean updateBoard(BoardVO vo); // ?��?��?���? ?��보기?��?�� boolean?�� ?���?.

	public boolean deleteBoard(int boardNo);
	
	// ������.
	public List<BoardVO> pageList(int page);

}
