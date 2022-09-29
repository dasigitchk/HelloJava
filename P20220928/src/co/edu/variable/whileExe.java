package co.edu.variable;

import java.util.Scanner;

public class whileExe {

	public static void main(String[] args) {
		whileFnc3();
	}

	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료는 -1를 입력.
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println(" 월을 선택하세요. 종료는 -1");
			int input = scn.nextInt();
			if (input == -1) {
				break;
			}
			Methodcalendar.makeCal(input); // 다른 클래스의 메소드 호출가
			System.out.println("");
		}
		System.out.println("end of pgm");
		scn.close();
	}

	public static void whileFnc2() {
		// while구문.
		Scanner scn = new Scanner(System.in); // import : 컨트롤+쉬프트+o
		while (true) {
			System.out.println("값을 입력하세요. 종료하려면 stop입력.");
			String inputVal = scn.nextLine();
			if (inputVal.equals("stop")) {
				break;
			}
			System.out.println("사용자입력값 : " + inputVal);
		}
	}

	public static void whileFnc() {
		// for 반복문: 반복횟수.for(int i=0; i<반복회수 i++)
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			i++;
		}
		System.out.println("end of program");
	}
}
