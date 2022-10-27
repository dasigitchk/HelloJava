package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;

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
	
	//회원가입.
	public MemberVO insertMember(MemberVO vo);
	
	// 회원목록.
	public List<MemberVO> memberList();
	
	// 로그인.
	public String signIn(String id, String password);

}
