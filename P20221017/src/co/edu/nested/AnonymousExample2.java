package co.edu.nested;

interface Run{
	void run();
}

class Runner implements Run{
	@Override
	public void run() {
		System.out.println("run.");
	}
}
public class AnonymousExample2 {
	public static void main(String[] args) {
		
		//익명구현객체: 상황에 따라 기능이 다를 경우.
		Run runner = new Run() { //run을 구현하는 익명객체생성.
			String kind;
			void runKind() {
				System.out.println("육상");
			}
			@Override
			public void run() {
				System.out.println("구현 run.");
				runKind();
			}
		};
		runner.run();
		
		Run runner2 = new Run() {
			@Override
			public void run() {
				System.out.println("구기종목");
			}
		}; //구현하는 메소드이기때문에 세미콜론이 와야한다(?)
		runner2.run();
	}

}
