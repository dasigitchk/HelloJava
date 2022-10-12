package co.edu.board;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CRUD
public class BoardDAO extends DAO{
	List<Board> board = new ArrayList<>();
	
	//1.글등록
	public void insert(Board text) {
		conn = getConnect();
		String sql = "insert into board(board_num, board_title,"
				+ " board_content, board_writer)"
				+ "values("+text.getBoardNum()+", '"+text.getTitle()+"',"
				+"'"+text.getContent()+"', '"+text.getWriter()+"')";
		try {
			stmt=conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r+"건 등록됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//2.글수정
	public void Update(int num, String content) {
		conn = getConnect();
		String sql = "update board set board_content = ?, creattion_date = sysdate "
				+ "where board_num = ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, content); //첫번째 물음표자리의 값
			psmt.setInt(2, num);// 두번째물음표자리의 값
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//3.글삭제
	public void Delete(int num) {
		conn = getConnect();
		String sql = "delete from board "
				+ "where board_num = ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, num);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//4.글목록
	public List<Board> search() {
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery("select * from board");
		while(rs.next()) {
			System.out.println(rs.getInt(0));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}