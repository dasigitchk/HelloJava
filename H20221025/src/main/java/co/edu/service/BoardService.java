package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

public interface BoardService {
	// 기능만 정의.
	// 입력.
	public BoardVO insertBoard(BoardVO vo);
	//
	public List<BoardVO> getList(BoardVO vo);
	// 한건조회.
	public BoardVO findBoard(int boardNo);
	// 수정.
	public boolean updateBoard(BoardVO vo); // 다양하게 써보기위해 boolean도 써봄.
	// 삭제.
	public boolean deleteBoard(int boardNo);

}
