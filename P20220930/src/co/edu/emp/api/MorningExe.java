package co.edu.emp.api;

public class MorningExe {
	public static void main(String[] args) {
		int count = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", count);
				count++;
			}
			System.out.println(" ");
		}
		
		int count2 = 1;
		int count3 = 3;
		int count4 = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < count3; j++) {
				System.out.print("   ");
			}	
			for(int n=0; n<count2; n++) {
				System.out.printf("%3d", count4);
				count4++;
			}	
				System.out.println(" ");
				count2++;
				count3--;
		}
	}
}
