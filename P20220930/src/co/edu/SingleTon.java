package co.edu;

public class SingleTon {
	// private 정적필드
	private static SingleTon singleton = new SingleTon();
	
	// private 생성자.
	private SingleTon() {
		
	}
	// public 타입의 getInstance(); 를 통해서만 생성자를 만들수 있음.
	public static SingleTon getInstance() {
	return singleton;
}
}
