package eduCenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class eduCenterDAO extends DAO {

	ArrayList<Members> members = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	// 1.등록
	public void add() {
		System.out.println("아이디: ");
		String id = scn.nextLine();
		System.out.println("비밀번호: ");
		String pwd = scn.nextLine();
		System.out.println("이름: ");
		String name = scn.nextLine();
		System.out.println("주소: ");
		String addr = scn.nextLine();
		System.out.println("전화번호: ");
		String tel = scn.nextLine();
		System.out.println("신청강의명: ");
		String lect = scn.nextLine();

		Members member = new Members(id, pwd, name, tel, addr, lect);
		members.add(member);
		dbInput(id, pwd, name, addr, tel, lect);
		System.out.println("등록이 완료되었습니다.");
	}

	// 회원삭제
	public void delete() {
		conn = getConnect();
		System.out.println("삭제할 회원의 이름을 입력하세요: ");
		String name = scn.nextLine();
		for (int i = 0; i < members.size(); i++) {
			if (name.equals(members.get(i).getName())) {
				members.remove(i);
			} else {
				System.out.println("존재하지 않는 회원입니다.");
			}
		}
	}

	// DB저장
	public void dbInput(String id, String passwd, String name, String address, String tel, String lecture) {
		conn = getConnect();
		String sql = "insert into Members (member_id, member_passwd, member_name, mamber_address,"
				+ " member_tel, member_lecture)"
				+ "values(?, ?, ?, ?, ?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			psmt.setString(3, name);
			psmt.setString(4, address);
			psmt.setString(5, tel);
			psmt.setString(6, lecture);
			
			psmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//회원전체조회
	public  String searchAll() {
		conn= getConnect();
		String result = null;
		String sql = "select * from Members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
//			while(rs.next()) {
//				System.out.println(rs.getInt("member_id")+rs.getString("member_name")+rs.getString("member_tel")+rs.getString("member_lectrue"));
//				
//
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return result;
	}
	
	//회원상세조회
	public  String searchMem() {
		return  null;
	}
	
	//로그인
	public int login(String id, String pwd) {
		int result = 0;
		conn= getConnect();
		String sql = "select staff_id from staff where staff_id = ? and staff_password = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

		return result;
		
	}
}// end of class
