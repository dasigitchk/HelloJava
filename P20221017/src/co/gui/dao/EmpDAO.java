package co.gui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	// 입력
	public EmployeeVO insertEmp(EmployeeVO vo) {
		getConnect();
		
		String seq = "select employees_seq.nextval from dual";
		
		String sql = "insert into emp1 (employee_id, first_name, last_name, email, hire_date, job_id)"
				+ "values (?,?,?,?,?,?)";

		try {
			// sequence 획득.
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seqInt = rs.getInt(1); //첫번째 컬럼을 가져옴
			}
			// insert 작업.
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			int r = psmt.executeUpdate(); // 실제 처리된 건수 반환. 1건이 반환되었기 때문에 1 반환. 그래서 int변수에도 담김
			System.out.println(r + "건 입력됨.");
			
			// 새로운 사원에게 사원번호 입력..
			vo.setEmployeeId(seqInt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect();
		String sql = "delete from emp1 where employee_id = ?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			int r = psmt.executeUpdate(); //쿼리실행 
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update emp1 set first_name=?, last_name=?, email=?, hire_date=?, job_id=? where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}	
	}
	// 목록
	public List<EmployeeVO> empList(EmployeeVO vo){
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from emp1" // 주석은 정렬시 흐트러지지않게하기위해
				+ " where employee_id = decode(?, 0, employee_id, ?) " //
				+ " and first_name like '%'||?||'%' " // ||은 오라클에서 문장연결의기호
				+ " and last_name like '%'||?||'%' " //
				+ " and email like '%'||?||'%' " //
				+ " and to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' " //
				+ " and job_id = nvl(?, job_id) " //
				+ " order by employee_id";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String email = rs.getString("email");
				String hDate = rs.getString("hire_date");
				String jobId= rs.getString("job_id");
				
				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return empList;	
	}
}
