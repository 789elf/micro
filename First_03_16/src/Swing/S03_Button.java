package Swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Swing.quiz.S03_KakaoImageButton;
import Swing.quiz.S03_KakaoImageButtonVer2;

public class S03_Button extends JFrame{

	private static final long serialVersionUID = 1L;
	public S03_Button() {
		/*
		 *  # Button 메소드
		 *  
		 *   1. setBounds(x,y,w,h) - 버튼의 위치 크기 설정을 한번에
		 *   2. setText("Text") - 해당 컴포넌트의 텍스트를 변경
		 *   3. setEnabled(boolean) - 해당 컴포넌트를 활/비활성화 한다
		 *   4. setBackground(new Color(r,g,b) - 해당 컴포넌트의 배경색을 변경
		 *   5. setIcon(new ImageIcon("파일경로") - 해당 컴포넌트의 아이콘 설정 
		 */
		setLayout(null);
		
		JButton btn1 = new JButton("눌러");
		// setBounds
		btn1.setBounds(100,100,200,200);
		// setText() 
		btn1.setText("Push this button");
		// setEnabled()
//		btn1.setEnabled(true);
		// setBackground
//		btn1.setBackground(new Color(255,255,0));
		// setIcon
		
		btn1.setIcon(new ImageIcon("./data/kakao.png"));
		add(btn1);
		
		add(new S03_KakaoImageButtonVer2(S03_KakaoImageButtonVer2.RYON, 100, 300, 100, 100));
		add(new S03_KakaoImageButtonVer2(S03_KakaoImageButtonVer2.APEACH, 100, 400, 100, 100));
		add(new S03_KakaoImageButtonVer2(S03_KakaoImageButtonVer2.MUJI, 100, 500, 100, 100));
		add(new S03_KakaoImageButtonVer2(S03_KakaoImageButtonVer2.TUBE, 100, 600, 100, 100));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setLocation(1000,50);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_Button();
	}
}
