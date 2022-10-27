package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// ?��?��,조회,?��?��,?��?��...
	public BoardVO insertBoard(BoardVO vo) {
		// ?��?��처리중에 ?��?���? 발생?���? null
		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer, image) "
				+ "values(?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			while(rs.next()) {
				nextSeq = rs.getInt(1);
			}
			
			// insert
			psmt= conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());
			int r = psmt.executeUpdate();
			if(r > 0) {
			vo.setBoardNo(nextSeq);
			return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; //  ?��?��?�� 경우?��?�� null?�� 반환.
	}

	public BoardVO serachBoard(int boardNo) {
		getConnect();
		String sql = "select * from tbl_board where board_no = ? ";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("Board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;

	}

	public List<BoardVO> boardList(BoardVO vo) {
		
		List<BoardVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from tbl_board " //
				+ " where 1 = 1" //
				+ " and title like '%'||?||'%'" //
				+ " and content like '%'||?||'%' " //
				+ " and writer like  '%'||?||'%' ";

		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriteDate());
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("Board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				
				list.add(board);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public boolean updateBoard(BoardVO vo) {
		getConnect();
		String sql = "update tbl_board set title = ?"
				+ ", content = ?, writer = ?, where board_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getBoardNo());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBoard(int boardNo) {
		getConnect();
		String sql = "delete  from tbl_board where board_no = ?";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
		// 처리건수�? 0?���? false
	}
	
	//������. ��ü�Ǽ�/ 10����, �˻���� ��ü�Ǽ�/10����,
	public int totalCnt() {
		getConnect();
		String sql = "select count(1) from tbl_board";
		
		try {
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return 0;
	}
	public List<BoardVO> pageList(int page){
		getConnect();
		List<BoardVO> list = new ArrayList<>();
		String sql = "select b.* "
				+ "from (select rownum rn, a.* "
				+ "      from (select *  "
				+ "            from tbl_board "
				+ "            order by board_no desc) a "
				+ "    where rownum <= ?) b "
				+ "where b.rn >= ? ";
		
		int from = (page -1) * 10 +1; // 1
		int to = (page * 10); // 10, 20
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to);
			psmt.setInt(2, from);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		} 
	
	public MemberVO insertMember(MemberVO vo) {
		// 
		getConnect();
		String sql = "insert into members (id, passwd, name, email, resposibility) "
				+ "values(?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5,"user");
			int r= psmt.executeUpdate();
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public List<MemberVO> MemberList(){
		List<MemberVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from members";
		

		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				
				list.add(vo);
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
		
	}
	
	public String signIn(String id, String passwd) {
		getConnect();
		String sql = "select id from members where id = ? and passwd = ?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
		
	}
	}
