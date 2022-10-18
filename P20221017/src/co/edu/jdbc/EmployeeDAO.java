package co.edu.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO{
	
	
	//삭제
	public void delete(int empId) {
		String sql = "delete from emp1 where employee_id = ?"; 
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제됨.");
	}catch(SQLException e) {
		e.printStackTrace();
		} finally{
			disconnect();
		}
	} 
	
	//수정
	public void update(Employee emp) {
		String sql = "update emp1 "// 
				+ "set email = ?, "// //지금 값을 넣지않고 나중에 값을 넣겠다는 뜻
				+ "    hire_date = ?, "//
				+ "    job_id = ? "//
				+ "where employee_id =?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//등록
	public void insert(Employee emp) {
		String sql = "insert into emp1 (employee_id, last_name, email, hire_date, job_id)"
				 + "values(" +emp.getEmployeeId()//
				 + ", '"+emp.getLastName()//
				 + "', '"+ emp.getEmail()//
				 + "', '"+emp.getHireDate()//
				 + "', '"+emp.getJobId() + "')";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
		System.out.println(r + "건 입력됨.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//조회
	public List<Employee> search() { //컬렉션 타입 List에 Employee 인스턴스의 데이터를 담음
		conn = getConnect(); //DAO를 상속받았기때문에 변수선언없이도 사용가능.(DAO에 private이아닌상태로 선언되어있기때문)
		List<Employee> list = new ArrayList<>(); //반환할 값 
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from emp1");
			while(rs.next()) {
				list.add(new Employee(rs.getInt("employee_id")
						,rs.getString("last_name")
						,rs.getString("email")
						,rs.getString("hire_date")
						,rs.getString("job_id")+"\n"
			    ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//한건만 조회.
	public Employee getEmp(int empId) {
		//한건만 반환.
		String sql = "select * from emp1 where employee_id = ?"; 
		conn = getConnect(); 
		Employee emp = null;;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
				if(rs.next()){
				emp = new Employee(rs.getInt("employee_id")
						,rs.getString("last_name")
						,rs.getString("email")
						,rs.getString("hire_date")
						,rs.getString("job_id")
			    );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
}