package co.edu.variable;

public class MethodExample {
	// 가로, 세로  =>
	public static int getArea(int width, int height) {
		int sum = width * height;
		return sum;
	}
	
	//배열요소의 각 값의 합.
	public static int sumAry(int[] ary) {
		int result = 0;
		for(int i = 0; i<ary.length; i ++) {
			result =  result + ary[i];
		}
			return result;
	}
	
	// 두수의 나눈 결과를 반환.
	public static double divide(double n1, double n2) {
		double result = n1 / n2;
		return result;
	}
	
	// 두수를 나누는 작업. 매개변수를 int로 지정.
	public static double divide2(int n1, long n2) {
		//1 bit * 8 = 1byte.
		// 유형 : byte(1byte), short(2byte), int(4byte), long(8byte) 
		if(n2 ==0) {
			return 0;
		}
		double result = (double)n1 / n2; // 3 /2 => 1.5 //(long) 형변환. 캐스팅이라고함.
		return result;
	}
	
	//main 
	public static void main(String[] args) {
		int result = getArea(20, 15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry);
		System.out.println("전체 배열요소의 합계는 " + result);
		
		// 실수. float, double 더블이 담을수 있는 값이 더 큼.
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2;
		
		d3 = divide(d1, d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 = divide2(3,0);
		System.out.println("나눈 결과는 " + d3);
	}
}