package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {

	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();

	// 친구등록 - 학교/회사/친구...
	public void exe() {

		while (true) {
			System.out.println("1.등록 2.조회 3.종료");
			System.out.println("선택 >>");

			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();
				scn.nextLine();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				}
			} else if (menu == 2) {
				searchFriend();
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("프로그램 종료.");
	} // end of exe()

	// 추가메소드.

	// 회사친구 추가.
	public void addComFriend() {
		System.out.println("이름을 입력하세요 : ");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		String phone = scn.nextLine();
		System.out.println("회사이름을 입력하세요 : ");
		String company = scn.nextLine();
		System.out.println(" 부서이름을 입력하세요 : ");
		String dept = scn.nextLine();
		ComFrined Cfrnd = new ComFrined(name, phone, company, dept);
		
		friends.add(Cfrnd);
	}

	// 학교친구 추가.
	public void addUnivFriend() {
		System.out.println("이름을 입력하세요 : ");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		String phone = scn.nextLine();
		System.out.println("학교이름을 입력하세요 : ");
		String univ = scn.nextLine();
		System.out.println("전공을 입력하세요 : ");
		String major = scn.nextLine();
		UnivFriend Ufrnd = new UnivFriend(name, phone, univ, major);

		friends.add(Ufrnd);
		}
	
	// 친구 추가.
	public void addFriend() {
		System.out.println("이름을 입력하세요 : ");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		String phone = scn.nextLine();
		Friend friend = new Friend(name, phone);
		
		friends.add(friend); //비워져있는 위치에 한건 등록.
		}

	// 친구조회.
	public void searchFriend() {
		System.out.println("찾을 친구이름 입력 >>>");
		String SearchKey = scn.nextLine();
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] != null && friends[i].getName().contains(SearchKey))
//		System.out.println(friends[i].showInfo());
		for (int i = 0; i < friends.size(); i++) {
			// Friend 클래스의 상속. Friend, ComFriend, UnivFriend
			Object frnd = friends.get(i); // get(): 몇번쨰 위치의 값
			if(frnd instanceof Friend) { // frnd 변수의 타입이 어떤 유형의 클래스인지..
			Friend friend = (Friend) frnd;
			System.out.println(friend.showInfo());
			}else if(frnd instanceof ComFrined) {
				ComFrined friend = (ComFrined) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
			
			

		}
	}
}
