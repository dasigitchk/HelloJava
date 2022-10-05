package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {
		// null pointer 참조.
		String str = "Hello World!!";
		// 예외처리. RuntimeException 상속받아서 처리하는 예외클래스.
		try {
			String result = str.substring(0, 10); // 0번쨰자리부터10번째자리까지의 값
			char chr = result.charAt(20); // char 는 문자열같지만 정수타입.
			System.out.println(chr);
//		} catch (NullPointerException e) {
//			System.out.println("참조하는 값이 없습니다.");
//		} catch (StringIndexOutOfBoundsException e1) {
//			System.out.println("인덱스 범위를 벗어난 값입니다.");
//		} catch (RuntimeException e2) {
//			System.out.println("실행예외가 발생했습니다.");
		} catch (Exception e3) { // 모든예외를 처리할수있음.
			System.out.println("알수 없는 예외가 발생했습니다.");
		}

		Scanner scn = new Scanner(System.in);
		System.out.println("숫자 입력 >>> ");
		while (true) {
			try {
				int menu = scn.nextInt(); // InputMismatchException
				System.out.println("입력값은 :" + menu);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력하세요!");
				scn.nextLine(); // abc (Enter)
			} finally {
				System.out.println("반드시 실행할 코드.");
				// db connection 사용하고 resource 반환.
			}
		}
		
		try {
			exceptMethod();   //여기로 떠넘김 
		} catch (ClassNotFoundException e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료.");
	} // end of main()

	public static void exceptMethod() throws ClassNotFoundException { //예외가 발생하면 이 메소드를 호출한 곳으로 떠넘긴다.
		// 일반예외 : Exception 상속받아서 처리하는 예외클래스.
//		try {
			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
