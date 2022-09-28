package co.edu.variable;

// 자바는 class 시작.
//class의 main메소드로 시작.

public class App {
	public static void main(String[] args) {
		System.out.println("매개값을 출력."); // (매개값을 출력)
		
		//변수의 타입 지정. => 정수(int, long), 실수(double, float)
		//참/거짓(boolean), 문자열: (String)
		
		int  myAge = 25; // 왼쪽 = 오른쪽 타입 항상 동일해야함.
//		int myAge = "스물다섯"; //컴파일 에러.
		String 내나이 = "스물다섯";
		내나이 = "28"; //문자열 28.
		
		int result = myAge + 30;
		System.out.println(myAge + "와 30을 더하면 " + result + "입니다.");
		
		//배열.
		//let numSAry = [] ; //jsp 방식
		int[] numAry = {20, 29, 13, 44, 88, 33}; //배열 선언.
		int sum = 0;
		
//		1) 배열의 합계.
		for (int i = 0 ; i < 6 ; i++) {
			if(numAry[i] % 2 != 0) {
				sum += numAry[i];
			}
		} 
		System.out.println("합계=> " + sum);
		
//		2)배열 조건.
		sum = 0; // 변수 값 초기화. sum의 값이 100을 넘어서는 시점 break;
		for(int i = 0; i < 6 ; i++) {
			sum += numAry[i];
			if(sum > 100) {
				break;
			}
		} System.out.println(sum);
	}
}