package co.edu.jdbc;

import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		Scanner scn = new Scanner(System.in);
		
		//메뉴 => 1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 9.종료
		while(true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				System.out.println("사원번호: ");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("이름: ");
				String lastName = scn.nextLine();
				System.out.println("이메일: ");
				String email = scn.nextLine();
				System.out.println("입사일: ");
				String hireDate = scn.nextLine();
				System.out.println("직무: ");
				String jobId = scn.nextLine();
				Employee emp1 = new Employee(empId, lastName, email,
						hireDate, jobId);
				dao.insert(emp1);
			}else if(menu == 2) {
				System.out.println("검색할 사원번호 입력: ");
				int empid = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getEmp(empid)); 
			}else if(menu == 3) {
				System.out.println("수정할 사원의 사원번호: ");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("이메일: ");
				String email = scn.nextLine();
				System.out.println("입사일: ");
				String hireDate = scn.nextLine();
				System.out.println("직무: ");
				String jobId = scn.nextLine();
				Employee emp1 = new Employee(empId, email,
						hireDate, jobId);
				dao.update(emp1);
			}else if(menu == 4) {
				System.out.println("삭제할 사원의 사원번호 입력: ");
				int num = Integer.parseInt(scn.nextLine());
				dao.delete(num);
			}else if(menu == 5) {
				System.out.print(dao.search());  
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("올바른 메뉴를 입력해주세요.");
			}	
		}// end of while
		System.out.println("end of program");
	}
}
