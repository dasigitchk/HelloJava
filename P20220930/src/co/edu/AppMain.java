package co.edu;

// 하나의 실행클래스와 여러개의 라이브러리클래스 필요.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스 생성.

		// Person Class
//		kim.name = "김민기";
//		kim.age = 20;
//		kim.sleep();
//		kim.eat("메론");
//		kim.run();

//		System.out.println(kim);

//		Person lee = new Person();
//		lee.name = "이순신";
//		lee.age = 25;
//		lee.sleep();
//		lee.eat("샤인머스켓");
//		lee.run();

		// Student Class
		Student stud1 = new Student();

		Student stud2 = new Student();

		Student stud3 = new Student();

		stud1.setName("김충현");
		stud1.setStudId("123-123");
		stud1.setMajor("CS");

		stud2.setName("손흥민");
		stud2.setStudId("234-234");
		stud2.setMajor("Soccer");

//		stud1.name = "김충현";
//		stud1.StuId = "123";
//		stud1.playGame();
//		stud1.sleep();
//		stud1.study();
//		
//		stud2.name = "손흥민";
//		stud2.StuId = "456";
//		stud2.playGame();
//		stud2.sleep();
//		stud2.study();

//		Student[] students;
//		students = new Student[] {stud1, stud2, stud3};
//		for(Student stud : students) {
//			System.out.println("학번: " + stud.StuId + "" + ",학생이름: " +stud.name+ "");
//		}
//	}
		// 상속
		WorkMan wman = new WorkMan();
		wman.name = "월급쟁이";
		wman.age = 30;

		StuMan sman = new StuMan();
		sman.school = "자사고";
		sman.height = 202.2;
	}
}
