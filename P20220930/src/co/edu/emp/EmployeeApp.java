package co.edu.emp;

import java.util.Scanner;

//메인클래스.
public class EmployeeApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		EmployeeService service = new EmployeeArrayList();

		// 1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
		while (true) {
			System.out.println("1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 5.사원급여 9.종료");
			System.out.print("선택 >> ");
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine()); // "1" -> 1
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
			if (menu == 1) {
				service.init();
			} else if (menu == 2) {
				service.input();
			} else if (menu == 3) {
				System.out.print("검색할 사원번호를 입력 >>>");
				int eId = Integer.parseInt(scn.nextLine()); // "100" enter
				String name = service.search(eId);
				if (name == null) {
					System.out.print("찾는 사원정보가 없습니다.");
				} else {
					System.out.print("사원의 이름은 " + name);
				}
			} else if (menu == 4) {
				service.print();
			} else if (menu == 5) {
				System.out.print("검색할 사원번호를 입력 >>>");
				int eId = Integer.parseInt(scn.nextLine());
				int sal = service.searchSalary(eId);
				if (sal == -1) {
					System.out.print("찾는 사원정보가 없습니다.");
				} else {
					System.out.print("사원의 급여는 " + sal);
				}
			} else if (menu == 9) {
				System.out.print("프로그램을 종료합니다.");
				break;
			}
		}
		System.out.println("프로그램 종료.");
	}
}
// end of class
