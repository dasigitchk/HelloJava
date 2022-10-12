package co.edu.board;

import java.util.Scanner;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("글번호: ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println("글제목: ");
				String title = scn.nextLine();
				System.out.println("글내용: ");
				String content = scn.nextLine();
				System.out.println("작성자: ");
				String writer = scn.nextLine();
				Board b = new Board(num, title, content, writer);
				dao.insert(b);
			} else if (menu == 2) {
				System.out.print("수정할 글의 글번호 입력: ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("글내용 입력: ");
				String content = scn.nextLine();
				dao.Update(num,content);
			} else if (menu == 3) {
				System.out.println("삭제할 사원번호 입력: ");
				int num = Integer.parseInt(scn.nextLine());
				dao.Delete(num);
				
			} else if (menu == 4) {

			} else if (menu == 5) {

			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 메뉴번호를입력하세요.");
			}
		} // end of while
		System.out.println("end of program");
	}
}
