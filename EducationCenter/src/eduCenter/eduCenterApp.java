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
		while (true) {
			System.out.println("=====로그인 화면=====");
			System.out.print("아이디: ");
			String id = scn.nextLine();
			System.out.print("비밀번호: ");
			String pwd = scn.nextLine();
			
			//아이디,비밀번호 DB비교
			if(app.login(id, pwd) == 1) {
				System.out.println("로그인 성공");
			
			while (true) {
				System.out.println("1.회원등록 2.회원삭제 3.회원조회 4.상세조회 9.종료");
				int menu = Integer.parseInt(scn.nextLine());
				if (menu == 1) {
					app.add();
				} else if (menu == 2) {
					app.delete();
				} else if (menu == 3) {
					app.searchAll();
				} else if (menu == 4) {
					app.searchMem();
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			} // end of inner while
			}// end of login if
			else System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		} // end of outer while
	} // end of main
}//end of class
