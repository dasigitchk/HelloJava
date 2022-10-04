package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3]; //크기가 정해지면 변경불가.
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화꽃";
//		flowers[3] = "목련"; //선언된 크기보다 더 넣을수 없음.
		
		String[] flowers2 = new String[6];
		
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		// 배열의 크기 고정 => 컬렉션(ArrayList);
		// Object 모든 클래스의 최상위 클래스.
		ArrayList flowers3 = new ArrayList(); //기본 10개 공간생성.  10개 다차면 다시 10개 더 생성
		flowers3.add("장미"); // 첫번쨰 위치 장미저장.
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
//		flowers3.add(123);
//		for(Object str : flowers3) {
//			String result = (String) str;
//			System.out.println(result);
//		}
		// 컬렉션의크기보는법 : size() 
		for(int i=0; i<flowers3.size(); i++) {
			String result = (String)flowers3.get(i); //get(): 몇번쨰 위치의 값
			System.out.println(result);
			
		}
	}
}
