package co.edu.inherit;

public class Parent extends Object{ //모든클래스는 상속이 없더라도 기본적으로 Object를 상속받고있음.
	String field;
	Parent() {
		System.out.println("parent method() call.");
	}
	Parent(String args) { 
		System.out.println("Parent(String args) call.");
	}
	void method() {
		System.out.println("parent method() call.");
	}
	@Override  //toString이 override될수있는 이유는 Object를 상속받고있기때문.
	public String toString() {
		return "Parent [field=" + field + "]";
	}
}
