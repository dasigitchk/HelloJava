package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//javax.swing전체를 import
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame { //프레임을 상속받았기때문에 window같은 역할가능
	
	public MyFrame() {
		
		setTitle("윈도우 UI");
		setSize(300, 250); //윈도우 크기 가로, 세로
		
		
		setLayout(new FlowLayout()); // 배치관리자.
		
		JButton btn = new JButton("확인"); // 버튼
		JButton btn2 = new JButton("취소");
		btn.addActionListener(e -> System.out.println("확인버튼 클릭.")); // 람다표현식

		btn2.addActionListener((e) ->{  // 람다표현식
				System.out.println("취소버튼 클릭.");
				System.exit(0); //0을 넣으면 종료.
		});//이벤트발생시 인터페이스(동작)구현.
		add(btn); // 컨트롤등록.
		add(btn2);
		
		setVisible(true); // 화면출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 누르면 종료.
		
	}
	//main 
	public static void main(String[] args) {
		new MyFrame(); //호출해서 화면시작.
	
	}
		
}
