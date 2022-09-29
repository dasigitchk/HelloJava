package complex;

import java.util.Scanner;

public class ObjectExe {
	
	public static void main(String[] args) {
	
	 String s1 = "홍길동";
	 int i1 = 20;
	 double d1 = 162; // 컴파일러가 162.0으로 바꿔줌
	 
	 Person p1 = new Person(); // 인스턴스 생성. js의 생성자함수같은기능.
	 p1.name = "김민기";
	 p1.age = 25;
	 p1.height = 172.3;
	 System.out.println(p1);
	 
	 Person p2 = new Person();
	 p2.name = "김경미";
	 p2.age = 27;
	 p2.height = 163.2;
	 System.out.println(p2);
	 
	 Person p3 = new Person();
	 p3.name = "김민기";
	 p3.age = 25;
	 p3.height = 172.3;
	 System.out.println(p3);
	 
	 System.out.println("이름: " + p1.name);
	 System.out.println("나이: " + p1.age);
	 System.out.println("키: " + p1.height);
	 

	 
	 Person[] persons = {p1, p2, p3};
	System.out.println(persons[1].name);
	System.out.println(persons[1].age);
	System.out.println(persons[1].height);
	
	 persons[2].name = "송지은";
	 p3.name = "송송송";
	
	//p1변수값과 persons[0]값을 비교.
	System.out.println(persons[0] == p1);
	
	// 김경미 이름을 찾아서 나이 23 => 22 변경.
	// 반복for
	
	Scanner scn = new Scanner(System.in);
	System.out.println("변경할 이름 >>> ");
	String name = scn.nextLine();
	System.out.println("변경할 나이 >>> ");
	int age = scn.nextInt();
	for(int i =0; i < persons.length; i++) { 
		if(name.equals(persons[i].name)) {
			persons[i].age = age;
			}
		}
//		persons[i].age = 22;
//		break;
//	for(int i =0; i < persons.length; i++) {
//		if("김경미".equals(persons[i].name)) {
//			persons[i].age = 22;
//			break;
//		}
//	}
	//전체목록을 출력.
	for(int i=0; i < persons.length; i++) {
		System.out.println(i + 1 + "번째 이름 : " + persons[i].name + ", 나이 : " + persons[i].age);
	}
	
	
//	System.out.println(n1 == n2); //false
//	System.out.println(m1 == m2);// true m2가 m1의 주소값을 가져와서 넣어서 true
//		
//	String kim = "김경미"; //문자열 리터럴, 정수면 정수리터럴
//	System.out.println(kim == "김경미");
//	 System.out.println(p1 == p3);//주소값이 달라서 false
 	}
}
