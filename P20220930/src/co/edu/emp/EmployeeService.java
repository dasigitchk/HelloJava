package co.edu.emp;

// CRUD 처리
public interface EmployeeService {
	// 초기화(init)
	public void init();
	// 추가
	public void input();
	public String search(int employeeId); // 사원아이디에 이름 반환.
	public void print(); // 전체사원정보 출력.
	public int searchSalary(int employeeId); //사원번호에 맞는 급여 반환.
}
