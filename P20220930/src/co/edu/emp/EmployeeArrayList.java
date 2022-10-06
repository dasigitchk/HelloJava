package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션(ArrayList)을 활용해서 데이터 저장.
public class EmployeeArrayList implements EmployeeService {
	// 저장공간 생성.
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {

		int eId = readInt("사번 >> ");

		System.out.println("이름>> ");
		String name = scn.nextLine();
		// 부서입력 & 예외처리

		int deptid = -1;
		while (true) {
			deptid = readInt("부서>> ");
			try {
				validDept(deptid);
				break;
			} catch (InvalidDeptException e1) {
				System.out.println(e1.getMessage());
			}
		}
		System.out.println("급여>> ");
		int sal = 0;
		while (true) {
			try {
				sal = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			}
		}
		System.out.println("이메일>> ");
		String email = scn.nextLine();

		list.add(new Employee(eId, name, deptid, sal, email));
	}

	@Override
<<<<<<< HEAD
	public void print() {
=======
	public String search(int employeeId) {
		String result = null;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				break;
//			}
//		}
		for (Employee emp : list) { // i 로 돌릴필요없이 간단.
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	public void validDept(int dept) throws InvalidDeptException {
		int validDept = dept % 10;
		if (validDept != 0 || dept > 30) {
			throw new InvalidDeptException("잘못된 부서정보입니다.");
		}
>>>>>>> branch 'master' of https://github.com/dasigitchk/HelloJava.git
	}

	@Override
<<<<<<< HEAD
	public String search(int employeeId) {
		return null;
=======
	public void print() {
		System.out.println("사원번호 	    이름      급여   ");
		System.out.println("=========================");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(),
					list.get(i).getSalary());
		}
	}

	@Override
	public int searchSalary(int employeeId) {
		int result = 0;
		for (Employee sal : list) {
			if (sal.getEmployeeId() == employeeId) {
				result = sal.getSalary();
				break;
			}
		}
		return result;
	}

	public int readInt(String msg) {
		int result = -1;
		while (true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		return result;
>>>>>>> branch 'master' of https://github.com/dasigitchk/HelloJava.git
	}
}
