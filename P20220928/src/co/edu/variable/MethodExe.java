package co.edu.variable;

public class MethodExe {
	public static void main(String[] args) { //모든것은 main에서 실행됨. main에서 호출해서 써야함.
//		printStar();
//		printStar(3);
//		printCircle("@ ");
//		printCircle("◈", 5);
		int result = sum(sum(2, 3), sum(3,4));
		System.out.println("최종값은 " + result);
	}
	
	public static void printStar() { //반환값: 없음. 매개변수 : 없음
		System.out.println("★");
	}
	public static void printStar(int num) {// 반환값 없음 , 매개변수 있음(괄호안의 num이 매개변수)
		for(int i=0; i<num; i++) {
			System.out.print("★" );
		}
	}
	
	public static void printCircle(String circle) {
		System.out.println(circle);
	}
	//string으로 입력받은것을, 몇번출력할것인지
	public static void printCircle(String circle, int times) {
		for (int i = 0 ; i < times; i++) {
			System.out.println(circle);
		}
	}
	
	// 반환값을 가지는 메소드.
	public static int sum(int n1,int n2) {
		int result = n1 *2  + n2 *3;
		System.out.println("결과값은 " + result);
		return result;
	}
  }


