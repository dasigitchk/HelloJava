package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MailScreen extends JFrame{
	
	Dimension lbl1 = new Dimension(65, 15); //너비,높이
	Dimension lbl2 = new Dimension(45, 15);
	
	JPanel center, bottom; //컴포넌트를 모아두기 위한 컨테이너.
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블.
	JTextField fromTxt, toTxt, subjectTxt; //텍스트 필드. 
	JTextArea contentTxt;
	JButton send, cancel;
	
	MailApp app = new MailApp();
	
	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());
		// panel
		center = new JPanel();
		bottom = new JPanel();
		
		// label
		toLbl = new JLabel("받는 사람");
		fromLbl = new JLabel("보내는 사람");
		subjectLbl = new JLabel("제목: ");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		//textfield
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);
		
		// button.
		send = new JButton("보내기");
		cancel = new JButton("취소");
		
		// 컨테이너에 컴포넌트 배치.
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		// 컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);
		
		// 윈도우에 컨테이너 배치
		add("Center", center);
		add("South", bottom);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	// 화면시작.
	public static void main(String[] args) {
		new MailScreen();
	}
}
