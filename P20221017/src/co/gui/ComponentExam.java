package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ComponentExam extends JFrame{

	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300, 250));
		
		JPanel panel = new JPanel();  //괄호안에 배치관리자 지정가능. 기본값은 보더레이아웃
		JLabel label1 = new JLabel("Color Label");
		
		label1.setFont(new Font("Arial", Font.ITALIC, 30));
		label1.setForeground(Color.yellow);
		label1.setText("Yellow Font"); //라벨 값 변경가능한 메소드.
		
		JLabel label2 = new JLabel("Font Label");
		label2.setFont(new Font("Arial", Font.BOLD, 25)); //폰트종류, 스타일, 크기
		label2.setForeground(Color.GREEN);
		
		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("c:/Temp/dragons-3272041.jpg"); //이미지 불러오기
		Image img = icon.getImage();
		Image changeImgSize = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label3.setIcon(icon);
		label3.setSize(200, 180); //이미지 크기지정.
		
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //가운데 배치.
	}
	
	public static void main(String[] args) {
		new ComponentExam();
	}
}
