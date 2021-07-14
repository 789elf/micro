package Swing.quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 *  kakao ������ ������ ������
 *  4���� ����� ��ư�� ����
 *  
 *    	�� ������ �߶� ����ϸ� �ȵ�.
 *    
 *  (�� Ŭ������ ������ ���� �������� �ʰ� ������ ������ ������ �߶� ���ο� �̹����� 4���� �ν��Ͻ��� ������ ��� )
 *   
 */
public class S03_Kakao extends JFrame {


	private static HashMap<Integer, Image> btn_images = new HashMap<>();

	public S03_Kakao() {
		setLayout(null);
		try {
			BufferedImage src = ImageIO.read(new File("./data/kakao.png"));
			// BufferedImage�� getSubimage(x,y,w,h);
			ArrayList<JButton> btns = new ArrayList<JButton>();
			for (int i = 0; i < 4; i++) {
				btns.add(new JButton());
			}
			Image[] images = new Image[4];
			int x[] = { 0, 170, 0, 170 };
			int y[] = { 0, 0, 167, 167 };

		    for(int i=0; i<4; i++) {
		    	images[i] = src.getSubimage(x[i], y[i], 150, 150);
		    	btns.get(i).setIcon(new ImageIcon(images[i].getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		    	btns.get(i).setBounds(x[i], y[i], 150, 150);
		    	add(btns.get(i));
		    }

		    System.out.println(EXIT_ON_CLOSE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(1000,50,800,800);
			setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new S03_Kakao();
	}
}