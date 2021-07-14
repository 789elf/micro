package Swing.quiz;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_LottoVer2 extends JFrame{

	public S02_LottoVer2() {
		setLayout(null);
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			btns.add(new S02_NumberButton(100+(90*i),100));
		}
		JButton nextBtn = new S02_NextButton(100, 200, btns);
		
		for(JButton btn : btns) {
			add(btn);
		}
		add(nextBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1000,50);
		setSize(1000,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new S02_LottoVer2();
	}
}
