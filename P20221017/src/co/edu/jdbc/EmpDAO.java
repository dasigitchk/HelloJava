package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	public static void main(String[] args) {
		search();
	}// end of main
	
	public static void update() {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // url/ 계정/ pw
			
			stmt =  conn.createStatement();
//			stmt.executeQuery(); //데이터조회시 excuteQurery
			int r = stmt.executeUpdate("update emp1  set first_name = 'steven' where employee_id=550"); // 입력,삭제,업데이트등.
			System.out.println(r + "건 수정됨."); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외발생하더라도 실행되는영역.
			try {
//				rs.close(); // 항상 전부 다 close해줘야함.
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // url/ 계정/ pw
			
			stmt =  conn.createStatement();
//			stmt.executeQuery(); //데이터조회시 excuteQurery
			int r = stmt.executeUpdate("delete from emp1 where employee_id=206"); // 입력,삭제,업데이트등.
			System.out.println(r + "건 삭제됨."); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외발생하더라도 실행되는영역.
			try {
//				rs.close(); // 항상 전부 다 close해줘야함.
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//조회
	public static void search() {
		// jdbc driver로드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // url/ 계정/ pw

			stmt = conn.createStatement(); // 실행할 쿼리문을 전송, 결과 받아옴.
			rs = stmt.executeQuery("select * from emp1 order by employee_id"); // 실행된결과를 employees에서 가져옴. 받아온 결과를 resultSet이라는 set컬렉션에 넣음.
			
			// Set컬렉션
			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id"));
				System.out.println("이름: " + rs.getString("first_name"));
				System.out.println("급여: " + rs.getInt("salary"));
				System.out.println("======================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외발생하더라도 실행되는영역.
			try {
				rs.close(); // 항상 close해줘야함.
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료.");
	}
}// end of class