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
		 *  # Button �޼ҵ�
		 *  
		 *   1. setBounds(x,y,w,h) - ��ư�� ��ġ ũ�� ������ �ѹ���
		 *   2. setText("Text") - �ش� ������Ʈ�� �ؽ�Ʈ�� ����
		 *   3. setEnabled(boolean) - �ش� ������Ʈ�� Ȱ/��Ȱ��ȭ �Ѵ�
		 *   4. setBackground(new Color(r,g,b) - �ش� ������Ʈ�� ������ ����
		 *   5. setIcon(new ImageIcon("���ϰ��") - �ش� ������Ʈ�� ������ ���� 
		 */
		setLayout(null);
		
		JButton btn1 = new JButton("����");
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
