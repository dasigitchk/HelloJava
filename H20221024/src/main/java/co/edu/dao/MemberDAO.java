package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	DAO dao = new DAO();
	// 생성, 수정, 삭제, 한건조회, 목록조회
	public void memberInsert(MemberVO vo) {
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
	
	// 단건조회.
	public MemberVO memberSearch(String id) {
		getConnect();
		MemberVO member = new MemberVO();
		String sql = "select * from members where id = ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId("id");
				vo.setName("name");
				vo.setEmail("email");
				vo.setPasswd("passwd");
				vo.setResposibility("resposibility");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return member;
}

	// 수정.
	public void memberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members set passwd= ?, name= ?, email= ? where id= ? ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}	
	}
	
	//삭제
	public void memberDelete(String id) {
		getConnect();
		String sql = "delete from members where id = ? ";
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
	
	//전체목록조회
	public List<MemberVO> memberList() {
		List<MemberVO> list =  new ArrayList<MemberVO>();
		MemberVO member = new MemberVO();
		getConnect();
		String sql = "select * from members";
		try {
			psmt=conn.prepareStatement(sql);
		 rs= psmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO(rs.getString("id")
						,rs.getString("passwd"),rs.getString("name")
						,rs.getString("email"),rs.getString("resposibility"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	//로그인
	// String id, String passwd => MemberVO
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id=? and passwd=? ";
				try {
					psmt=conn.prepareStatement(sql);
					psmt.setString(1, id);
					psmt.setString(2, passwd);
					rs = psmt.executeQuery();
					while(rs.next()) {
						MemberVO vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setName(rs.getString("name"));
						vo.setEmail(rs.getString("email"));
						vo.setPasswd(rs.getString("passwd"));
						vo.setResposibility(rs.getString("resposibility"));
						return vo;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
				return null;
	}
}
