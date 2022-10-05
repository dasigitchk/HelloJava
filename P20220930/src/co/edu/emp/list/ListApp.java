package co.edu.emp.list;

import java.util.ArrayList;

import co.edu.emp.Employee;

public class ListApp {
	public static void main(String[] args) {
		// 배열 -> 컬렉션(ArrayList, HashSet, HashMap)
		String[] strAry = new String[10];
		// Object <- 모든 클래스는 Object의 하위 클래스이기때문에 Object에 다 담길수 있음.
		ArrayList<String> list = new ArrayList<String>(); // <String> 타입선언. 이게 없으면 모든형태의 데이터 담음.
		//Array리스트는 기본크기 10개, 다차면 다시 10개 생성을 반복.
		list.add("Hello");
		list.add("Employee");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		ArrayList<Integer> intList = new ArrayList<Integer>();// <>안에 데이터 타입 지정해주면 그 타입의 데이터만 받음
		intList.add(100);
//		intList.add("100"); //데이터타입달라서 x

		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(100, "홍길동", 1000));
		empList.add(new Employee(200, "김길수", 2000));
		empList.add(new Employee(300, "박길민", 3000));
		empList.add(new Employee(400, "장길권", 4000));
//		empList.add(100); //x 
		
		String result = null;
		int salary = 0;
		for(int i = 0 ; i < empList.size(); i++) {
			if(empList.get(i).getEmployeeId() == 200) {
				result = empList.get(i).getName();
				salary = empList.get(i).getSalary();
			}
		}
		System.out.println("이름은 " + result + " 이고 급여는 " + salary +" 입니다.");
	}
}
