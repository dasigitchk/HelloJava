package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		final String constVar = "Hello"; //final이 있으면 변수에 재할당 불가.
//		constVar = "Wolrd"; // 변수.
		
		FriendExe app = new FriendExe();
		app.exe();
	}
}
