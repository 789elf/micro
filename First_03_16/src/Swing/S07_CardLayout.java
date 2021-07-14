package Swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S07_CardLayout extends MyFrame{

	/*
	 * 	# CardLayout
	 * 
	 * 	 - 컴포넌트를 카드 처럼 넘기면서 사용하는 레이아웃
	 */
	/*
	 *  CardLayout에는 여러 메소드가 있고 여러 기능이 있다.
	 *  이 메소드들을 구현하기 위해서는 comp.addActionListener(new ActionListener(){} 를 구현해야 한다.
	 *  
	 *  1. cardLayout.first(parent) : 맨 첫 카드보기
	 *  2. cardLayout.last(parent) : 맨 뒤 카드보기
	 *  3. cardLayout.next(parent) : 다음카드 보기
	 *  4. cardLayout.previous(parent) : 이전 카드 보기
	 *  5. cardLayout.show(parent, card_name) : 원하는 카드 보기
	 */
	
	public S07_CardLayout() {
		Container jframe = getContentPane();
		setLayout(new BorderLayout());
		JPanel center = new JPanel();
		
		// JLabel : 내용을 그냥 출력하는 곳
		JLabel label1 = new JLabel("Hello");
		JLabel label2 = new JLabel("Hi");
		JLabel label3 = new JLabel("Bye");
		
		label1.setIcon(new ImageIcon("./data/kakao1.png"));
		label2.setIcon(new ImageIcon("./data/kakao2.png"));
		label3.setIcon(new ImageIcon("./data/kakao3.png"));
		
		center.setLayout(new CardLayout(5, 5));
		center.add("card1",label1);
		center.add("card2",label2);
		center.add("card3",label3);
		
		JPanel south = new JPanel();
		
		JButton prev = new JButton("prev");
		JButton next = new JButton("next");
		JButton next1 = new JButton("next1");
		
		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)center.getLayout();
				// 이전카드보기
				// 첫번째 라벨이 보이지 않을때만 이전버튼 동작
				 if(!label1.isVisible()) { // label1이 첫번째고 이게 보이지 않을때에만 버튼이 눌린다는 조건문
					 card.previous(center);
				 }
			}
		});
		// 다음 카드
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)center.getLayout();
				
				//next() 메소드 : 다음으로 넘기기
				card.next(center); // 다음 카드로 넘기기 (레이아웃이 설정된 컨테이너의 인스턴스가 필요)
			}
		});
//		south.setLayout(new GridLayout(1,2));
		south.add(prev);
		south.add(next);
		south.add(next1);
		
		add(center,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new S07_CardLayout();
	}
}
