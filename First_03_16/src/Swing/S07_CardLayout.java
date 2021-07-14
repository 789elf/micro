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
	 * 	 - ������Ʈ�� ī�� ó�� �ѱ�鼭 ����ϴ� ���̾ƿ�
	 */
	/*
	 *  CardLayout���� ���� �޼ҵ尡 �ְ� ���� ����� �ִ�.
	 *  �� �޼ҵ���� �����ϱ� ���ؼ��� comp.addActionListener(new ActionListener(){} �� �����ؾ� �Ѵ�.
	 *  
	 *  1. cardLayout.first(parent) : �� ù ī�庸��
	 *  2. cardLayout.last(parent) : �� �� ī�庸��
	 *  3. cardLayout.next(parent) : ����ī�� ����
	 *  4. cardLayout.previous(parent) : ���� ī�� ����
	 *  5. cardLayout.show(parent, card_name) : ���ϴ� ī�� ����
	 */
	
	public S07_CardLayout() {
		Container jframe = getContentPane();
		setLayout(new BorderLayout());
		JPanel center = new JPanel();
		
		// JLabel : ������ �׳� ����ϴ� ��
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
				// ����ī�庸��
				// ù��° ���� ������ �������� ������ư ����
				 if(!label1.isVisible()) { // label1�� ù��°�� �̰� ������ ���������� ��ư�� �����ٴ� ���ǹ�
					 card.previous(center);
				 }
			}
		});
		// ���� ī��
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)center.getLayout();
				
				//next() �޼ҵ� : �������� �ѱ��
				card.next(center); // ���� ī��� �ѱ�� (���̾ƿ��� ������ �����̳��� �ν��Ͻ��� �ʿ�)
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
