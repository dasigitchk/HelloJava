package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

public interface BoardService {
	// κΈ°λ₯λ§? ? ?.
	// ?? ₯.
	public BoardVO insertBoard(BoardVO vo);

	public List<BoardVO> getList(BoardVO vo);

	public BoardVO findBoard(int boardNo);

	public boolean updateBoard(BoardVO vo); // ?€??κ²? ?¨λ³΄κΈ°??΄ boolean? ?¨λ΄?.

	public boolean deleteBoard(int boardNo);
	
	// ΖδΐΜΑφ.
	public List<BoardVO> pageList(int page);

}
