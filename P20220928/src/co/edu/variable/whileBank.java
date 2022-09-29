package co.edu.variable;

import java.util.Scanner;

public class whileBank {
	public static void main(String[] args) {
		bankApp();
	}

	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		// 메뉴 : 1:예금, 2:출금, 3:잔고, 4:종료
		// 10만원이 넘으면 예금불가.
		int money = 0;
		while (run) {
			System.out.println("메뉴 : 1:예금, 2:출금, 3:잔고, 4:종료");
			int menu = scn.nextInt();

			switch (menu) {
			case 1:
				System.out.println("예금처리 메뉴입니다.");
				System.out.println("예금액을 입력>>> ");
				int input = scn.nextInt();
				if (input > 0 && input <= 100000) {
					money = money + input;
					if(money > 100000) {
						money = money - input;
						System.out.println("10만원이상을 예금하실 수 없습니다. (잔고:10만원)");
						break;
				}  
				}
				else {
					System.out.println("예금은 0원이상, 10만원이하로 가능합니다.");
					money = money - input;
				}
					
					
				break;
			case 2:
				System.out.println("출금처리 메뉴입니다.");
				System.out.println("출금액을 입력>>> ");
				int input2 = scn.nextInt();
				if (input2 > money) {
					System.out.println("잔액이 출금신청액보다 적습니다.");
					break;
				}
				money = money - input2;

				break;
			case 3:
				System.out.println("잔고처리 메뉴입니다.");
				System.out.println("현재잔고는 : " + money);
				break;
			case 4:
				System.out.println("이용해주셔서 감사합니다.");
				run = false;
			}
		} // end of while
		System.out.println("end of pgm");
	}// end of bankApp()
}
