package Swing.quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 *  kakao 한장의 사진을 가지고
 *  4개로 나누어서 버튼을 생성
 *  
 *    	※ 사진을 잘라서 사용하면 안됨.
 *    
 *  (이 클래스는 내가  처음에 코드를 이용해서 사진을 나눠서 저장후 다시 불러온 방식)
 *   
 */
public class S03_KakaoImageButton extends JFrame{
   public S03_KakaoImageButton() {
      setLayout(null);
      
      Image src;
//      int x,y,w,h;
      int w,h;
      int x[] = {0,170,0,170};
      int y[] = {0,0,167,167};
      
      try {
         
         src = ImageIO.read(new File("./data/kakao.png"));
         
         for(int i=0; i<4; i++) {
            w = 150; h = 150;
            BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            dst.getGraphics().drawImage(src, 0, 0, w, h, x[i], y[i], x[i] + w, y[i] + h, null);
            ImageIO.write(dst, "png", new File("./data/kakao"+(i+1)+".png"));
            
         }
//         
//         x = 0; y = 0; w = 150; h = 150;
//         BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//         dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
//         ImageIO.write(dst, "png", new File("./data/kakao1.png"));
//         
//         x = 170; y = 0; w = 150; h = 150;
//         dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//         dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
//         ImageIO.write(dst, "png", new File("./data/kakao2.png"));
//         
//         x = 0; y = 167; w = 150; h = 150;
//         dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//         dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
//         ImageIO.write(dst, "png", new File("./data/kakao3.png"));
//         
//         x = 170; y = 167; w = 150; h = 150;
//         dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//         dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
//         ImageIO.write(dst, "png", new File("./data/kakao4.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      ArrayList<JButton> btns = new ArrayList<>();
      
      for(int i=0; i<4; i++) {
         btns.add(new JButton());
      }
      
      int[] x_ = {100,260,100,260};
      int[] y_ = {100,100,260,260};
      
      for(int i=0; i<4; i++) {
         btns.get(i).setBounds(x_[i],y_[i],150,150);
         btns.get(i).setIcon(new ImageIcon("./data/kakao"+(i+1)+".png"));
         add(btns.get(i));
      }
//      btns.get(0).setBounds(100,100,150,150);
//      btns.get(0).setIcon(new ImageIcon("./data/kakao1.png"));
//
//      btns.get(1).setBounds(260,100,150,150);
//      btns.get(1).setIcon(new ImageIcon("./data/kakao2.png"));
//
//      btns.get(2).setBounds(100,260,150,150);
//      btns.get(2).setIcon(new ImageIcon("./data/kakao3.png"));
//
//      btns.get(3).setBounds(260,260,150,150);
//      btns.get(3).setIcon(new ImageIcon("./data/kakao4.png"));

//      for(int i=0; i<4; i++) {
//         add(btns.get(i));
//      }
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(800,800);
      setLocation(1000,50);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new S03_KakaoImageButton();
   }
}