package co.edu.nested;

// 익명 구현 객체.
// 추상메소드 하나만 존재하는 인터페이스 => Functional 인터페이스.
interface MyInterface {
	void run();
}

interface MyInterface2{
	void run(String kind);
}

interface MyInterface3 {
	int sum(int num1, int num2);
}


public class AnonymousExample3 {
public static void main(String[] args) {
	// 람다표현식. 코드를 간단하게만들기위한 목적. 많이쓰여짐. 
	//구현해야할 메소드가 2개이상이라면 쓸수없음. 누구를 써야하는지 알수없기때문에.
	MyInterface intf = () -> System.out.println("MyInterface Run.");//run 메소드 하나밖에 없기때문에 다 생략하고 구현코드만 써줘도됨.
	intf.run();
	
	//매개변수가있을땐 매개변수를 써줌.
	MyInterface2 intf2 = kind -> System.out.println(kind + "Run.");
	intf2.run("농구종목");
	
	
	MyInterface3 intf3 = (num1, num2) -> num1 * 2 + num2;
	int result = intf3.sum(10, 20);
	
	//또다른기능을 가진 익명객체로 생성가능.
	intf3 = (num1, num2) -> num1*2 + num2*3;
	result = intf3.sum(11, 22);
	}
}
