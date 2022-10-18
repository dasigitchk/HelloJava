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
			//아이디,비밀번호 DB비교
			if(app.login() == 1) {
				System.out.println("로그인 성공");
			
			while (true) {
				System.out.println("1.회원등록 2.회원삭제 3.회원조회 4.상세조회 5.회원정보수정 9.종료");
				int menu = Integer.parseInt(scn.nextLine());
				if (menu == 1) {
					app.add();
				} else if (menu == 2) {
					app.delete();
				} else if (menu == 3) {
					app.searchAll();
				} else if (menu == 4) {
					app.searchMem();
				}else if (menu == 5) {
					app.update();
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break loop;
				}
			} // end of inner while
			}// end of login if
			else System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		} // end of outer while
	  System.out.println("end of program.");
	} // end of main
}//end of class
