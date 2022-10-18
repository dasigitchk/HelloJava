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
		System.out.print("이름: ");
		String name = scn.nextLine();
		System.out.print("주민등록번호: ");
		int idNum = Integer.parseInt(scn.nextLine());
		System.out.print("주소: ");
		String addr = scn.nextLine();
		System.out.print("전화번호: ");
		String tel = scn.nextLine();
		System.out.print("신청강의명: ");
		String lect = scn.nextLine();

		Members member = new Members(name, idNum, addr, tel, lect);
		members.add(member);
		dbInput(name, idNum, addr, tel, lect);
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
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("존재하지 않는 회원입니다.");
			}
		}
		}

	// DB저장
	public void dbInput(String name, int idNum, String address, String tel, String lecture) {
		conn = getConnect();
		String sql = "insert into Members (member_num, member_name, id_number, member_address,"
				+ " member_tel, member_lecture, reg_date) "
				+ " values(seq_member.nextval, ?, ?, ?, ?, ?, sysdate )";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, idNum);
			psmt.setString(3, address);
			psmt.setString(4, tel);
			psmt.setString(5, lecture);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//회원전체조회
	public  void searchAll() {
		conn= getConnect();
		String sql = "select * from Members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("회원번호: "+rs.getInt("member_num")+", 이름: "+ rs.getString("member_name")
						+", 전화번호: "+rs.getString("member_tel")+", 수강강의: "+rs.getString("member_lecture")+"\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//회원상세조회
	public  void searchMem() {
		loop: while(true) {
		System.out.print("조회할 회원이름 입력: ");
		String memName = scn.nextLine();
		if(checkmember(memName) ==1) {
		conn= getConnect();
		String sql ="select * from Members where member_name = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println("=========회원상세조회============");
				System.out.println("회원번호: "+rs.getInt("member_num")+", 이름: "
			    + rs.getString("member_name")
				+", 주민번호: "+rs.getString("id_number")+", 주소: "
				+rs.getString("member_address")+", 전화번호: "
				+rs.getString("member_tel")+", 수강강의: "
				+rs.getString("member_lecture")+", 회원가입일시: "
				+rs.getString("reg_date")+"\n");
				break loop;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		}else System.out.println("없는 회원이름입니다.");//end of if
		}//end of while
	}
	
	//로그인
	public int login() {
		int result = 0;
		
		System.out.println("=====로그인 화면=====");
		System.out.print("아이디: ");
		String id = scn.nextLine();
		System.out.print("비밀번호: ");
		String pwd = scn.nextLine();
		
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
	
	//회원정보수정
	public void update() {
		loop :while(true){
		System.out.print("수정할 회원이름 입력: ");
		String name = scn.nextLine();
		while(true) {
		if(checkmember(name) == 1) {
			System.out.println("수정할이름 입력: ");
			String newName = scn.nextLine();
			System.out.println("수정할주민번호 입력: ");
			String newIdNum = scn.nextLine();
			System.out.println("수정할주소 입력: ");
			String newAddr = scn.nextLine();
			System.out.println("수정할전화번호 입력: ");
			String newTel = scn.nextLine();
			System.out.println("수정할강의명 입력: ");
			String newLect = scn.nextLine();
		conn=getConnect();
		String sql = "update Members set member_name = ? "
				+ ", id_number = ?, member_address = ? "
				+ ", member_tel = ?, member_lecture = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, newName);
			psmt.setString(2, newIdNum);
			psmt.setString(3, newAddr);
			psmt.setString(4, newTel);
			psmt.setString(5, newLect);
			psmt.executeUpdate();
			System.out.println("수정완료.");
			break loop;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}else System.out.println("없는 회원이름입니다.");
		break;
	   }
	  }
	}
	//회원이름으로 조회
	private int checkmember(String name) {
		int result =0;
		conn =getConnect();
		String sql ="select * from Members where member_name = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if(rs.next() == true) {
				result=1;
			}
			else {}
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}
		return result;
	}
}// end of class
