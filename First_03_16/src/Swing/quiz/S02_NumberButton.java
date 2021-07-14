package Swing.quiz;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;

public class S02_NumberButton extends JButton{

	public S02_NumberButton(int x, int y) {
		super();
		
		setFont(new Font("Consolas",Font.BOLD,10));
		setSize(50,50);
		setLocation(new Point(x,y));
	}
}
