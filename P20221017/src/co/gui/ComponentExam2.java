package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class ComponentExam2 extends JFrame{

	public ComponentExam2() {
		//입력가능한 텍스트필드.
		setTitle("입력필드 UI");
		setSize(350, 150);
		Dimension lblDim = new Dimension(60, 16);

		setLayout(new BorderLayout());
		
		//패널
		JPanel center = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel();
		
		//라벨
		JLabel idLbl = new JLabel("id");
		idLbl.setPreferredSize(lblDim);
		JLabel pwLbl = new JLabel("password");
		pwLbl.setPreferredSize(lblDim);
		JTextField idTxt = new JTextField(23); //매개값으로 크기
		JPasswordField pwTxt = new JPasswordField(23); // 패스워드필드는 입력시 값이 안보임
	
		//각 패널에 라벨 추가.
		center.add(idLbl);
		center.add(idTxt);
		center.add(pwLbl);
		center.add(pwTxt);
		
		JButton btn = new JButton("확인");
		bottom.add(btn);
		
		//패널에 위치 지정.
		add("Center", center);
		add("South", bottom);
		
		//화면출력.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new ComponentExam2();
	}
}
