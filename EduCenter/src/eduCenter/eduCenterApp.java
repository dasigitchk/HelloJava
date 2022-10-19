package eduCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class eduCenterApp {
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		eduCenterDAO app = new eduCenterDAO();

		loop: while (true) {
			System.out.println("1.교직원 로그인 2.회원 로그인");
			System.out.print("메뉴 선택: ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				if (app.login(menu) == 1) {
					System.out.println("로그인 성공");
					while (true) {
						System.out.println("1.회원등록 2.회원삭제 3.회원조회 4.상세조회 5.회원정보수정 9.종료");
						int menu2 = Integer.parseInt(scn.nextLine());
						if (menu2 == 1) {
							app.add();
						} else if (menu2 == 2) {
							app.delete();
						} else if (menu2 == 3) {
							app.searchAll();
						} else if (menu2 == 4) {
							app.searchMem();
						} else if (menu2 == 5) {
							app.update();
						} else if (menu2 == 9) {
							System.out.println("프로그램을 종료합니다.");
							break loop;
						}
					} // end of inner while
				}// end of menu == 1 if
			} else if (menu == 2) {
				if (app.login(menu) == 2) {
					System.out.println("로그인 성공");
					while (true) {
						System.out.println("1.강의전체조회 2.수강취소 3.강의변경신청 4.상담신청 5.회원정보수정 9.종료");
						int menu3 = Integer.parseInt(scn.nextLine());
						if (menu3 == 1) {
							app.searchAllLect();
						} else if (menu3 == 2) {
							app.cancelLect();
						} else if (menu3 == 3) {
	
						} else if (menu3 == 4) {
		
						} else if (menu3 == 5) {

						} else if (menu3 == 9) {
							System.out.println("프로그램을 종료합니다.");
							break loop;
						}
					} // end of second inner while
				}// end of menu == 2 if
			} else
				System.out.println("올바른 메뉴번호를 입력하세요");
			System.out.println("end of program.");
		} // end of outer while
	}// end of main
}// end of class
