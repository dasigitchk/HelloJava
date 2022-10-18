package co.gui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.*;

public class BatchFrame2 extends JFrame{
	public BatchFrame2() {
		setTitle("BorderLayout 관리자");
		setSize(300, 250);
		
		setLayout(BorderLayout(10, 10)); //
		
		setLayout(new BorderLayout()); // setLayout에는 원하는 배치관리자를 넣을수있음.
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton	center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top); //add는 위치를 지정가능
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		setVisible(true); // 이 메소드 이전에 컴포넌트를 배치해야 화면에 보임
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //화면의 중앙.
	}
	
	private LayoutManager BorderLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		new BatchFrame2();
	}
}
