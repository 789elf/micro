package Swing;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;

public class S05_GridLayout extends MyFrame{

	/*
	 *  Gridlayout(col,row, 가로여백, 세로여백) 아무것도 안줄시 컴포넌트 갯수만큼 row한줄에 생성
	 */
	public S05_GridLayout() {
		ArrayList<JButton> btns = new ArrayList<>();
		for(int i=0; i<10; i++) {
			btns.add(new JButton("Button" + i));
		}
		
		setLayout(new GridLayout(2, 5, 5, 5));
		
		for(JButton btn : btns) {
			add(btn);
		}
		setVisible(true);
	}
	public static void main(String[] args) {
		new S05_GridLayout();
	}
}
