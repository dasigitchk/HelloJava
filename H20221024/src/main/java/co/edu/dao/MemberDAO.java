package co.edu.dao;

import java.sql.SQLException;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	DAO dao = new DAO();
	// 생성, 수정, 삭제, 한건조회, 목록조회
	public void memeberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members(id, passwd, name, email) values(?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2,  vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}	
	}
	
	public MemberVO memberSearch(String id) {
		getConnect();
		String sql = "select * from members where id= ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id")
						+rs.getString("passwd")
						+rs.getString("name")
						+rs.getString("email"));
				MemberVO member = new MemberVO(rs.getString("id")
						,rs.getString("passwd"),rs.getString("name")
						,rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return null;
	}
	
	public void memeberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members set id = ? "
				+ ", passwd= ? "
				+ ", name = ? "
				+ ", email = ? "
				+ " where id = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2,  vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}	
	}
	
	public void memberdelete(String id) {
		getConnect();
		String sql = "delete from members where id= ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
	}
	
	public List<MemberVO> memberList() {
		
		return null;
	}
}
