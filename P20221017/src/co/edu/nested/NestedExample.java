package co.edu.nested;

class Person {
	//필드,생성자,메소드등은 클래스의 멤버
	//필드.
	String name;
	int age;
	
	// 생성자.
	Person(){}
	
	//메소드.
	void showInfo() {
		//메소드 안의 클래스 = 로컬클래스.
		class Local{
			
			void show() {
				System.out.println("show");
			}
		}
		Local local = new Local();
		local.show();
	}
	
	//클래스가 클래스의 멤버로 들어오면 멤버클래스/중첩클래스(Inner Class)(?)
	// inner 클래스(인스턴스)
	class Car{
		String carName;
		
		void run() {
			System.out.println("run");
		}
	}
	
	// inner 클래스(정적)
	static class Calculator{
		void add() {
			System.out.println("add");
		}
	}
	class Run implements Runnable{
		@Override
		public void run() {
			System.out.println("run 구현.");
		}
	}
	// Inner 인터페이스.
	interface Runnable{
		void run();
	}
}// end of Person class

public class NestedExample {
	public static void main(String[] args) {
		
		//이너 인스턴스 클래스 객체생성
		Person p = new Person();
		Person.Car car = p.new Car();
		car.run();
		
		//정적 멤버 클래스.
		Person.Calculator cal = new Person.Calculator();
		cal.add();
		
		p.showInfo(); //로컬 클래스.
	}//end of main 
}// end of NedstedExample 클래스
