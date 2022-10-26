package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

public interface BoardService {
	// ê¸°ëŠ¥ë§? ? •?˜.
	// ?…? ¥.
	public BoardVO insertBoard(BoardVO vo);

	public List<BoardVO> getList(BoardVO vo);

	public BoardVO findBoard(int boardNo);

	public boolean updateBoard(BoardVO vo); // ?‹¤?–‘?•˜ê²? ?¨ë³´ê¸°?œ„?•´ boolean?„ ?¨ë´?.

	public boolean deleteBoard(int boardNo);
	
	// ÆäÀÌÁö.
	public List<BoardVO> pageList(int page);

}
