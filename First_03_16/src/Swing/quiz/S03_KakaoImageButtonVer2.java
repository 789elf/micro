package Swing.quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 *  kakao 한장의 사진을 가지고
 *  4개로 나누어서 버튼을 생성
 *  
 *    	※ 사진을 잘라서 사용하면 안됨.
 *    
 *  (이 클래스 + S03_Button 는 강사님 버전)
 *   
 */

public class S03_KakaoImageButtonVer2 extends JButton{

	public static final int RYON = 0;
	public static final int APEACH = 1;
	public static final int MUJI = 2;
	public static final int TUBE = 3;
	
	private static HashMap<Integer, Image> btn_images = new HashMap<>();
	
	static {
//	      int x[] = {0,170,0,170};
//	      int y[] = {0,0,167,167};
	      
//	      int[] x_ = {100,260,100,260};
//	      int[] y_ = {100,100,260,260};
		try {
			BufferedImage src = ImageIO.read(new File("./data/kakao.png"));
			// BufferedImage의 getSubimage(x,y,w,h);
			int wi = src.getWidth() / 2;
			int he = src.getHeight() / 2;
			btn_images.put(RYON, src.getSubimage(0, 0, wi , he));
			btn_images.put(APEACH, src.getSubimage(wi, 0, wi, he));
			btn_images.put(MUJI, src.getSubimage(0, he, wi, he));
			btn_images.put(TUBE, src.getSubimage(wi, he, wi, he));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public S03_KakaoImageButtonVer2(int picture, int x, int y, int width, int height) {
		// 이미지를 꺼내고 , getScaledInstance로 이미지으 크기조절을 한다 
		setIcon(new ImageIcon(btn_images.get(picture).getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		setBounds(x,y,width,height);
		
	}
	
}
