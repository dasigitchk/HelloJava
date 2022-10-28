package co.edu.service;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService{
	
	
	BoardDAO dao = new BoardDAO();

	@Override
	public BoardVO insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return 	dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		return dao.serachBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	public MemberVO insertMember(MemberVO vo) {

		return dao.insertMember(vo);
	}
	@Override
	public List<MemberVO> memberList() {
		return dao.MemberList();
	}
	@Override
	public String signIn(String id, String password) {
		return dao.signIn(id, password);
	}

	@Override
	public String passwdReConfrim(String id) {
	
		return dao.sendMail(id);
	}

	
}
