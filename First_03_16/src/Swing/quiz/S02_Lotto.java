package Swing.quiz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_Lotto extends javax.swing.JFrame{

	/*
	 * 	뽑기 버튼을 누를 때마다 6개의 중복없는 랜덤 숫자를 가진 버튼을
	 *  프레임에 띄우는 프로그램을 만들기
	 */
	public S02_Lotto(){

		//이 프레임의 레이아웃 설정 (가장 먼저 해야함)
		setLayout(new BorderLayout());
		
		// 버튼 생성
		JButton get_number_btn = new JButton("뽑기");
		get_number_btn.setFont(new Font("돋움체",Font.BOLD,15));
		
		// 버튼 추가
		add(get_number_btn,BorderLayout.NORTH);
		
		get_number_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<JButton> lotto_list = new ArrayList<>();
				HashSet<Integer> lotto_set = new HashSet<>();
				
				int cnt = 0;
				
				while (cnt < 6) {
					int temp = (int)(Math.random() * 45 + 1);
					if (lotto_set.add(temp)){
						lotto_list.add(new JButton(Integer.toString(temp)));
						lotto_list.get(cnt).setBounds(30+(50*cnt),30,50,50);
						add(lotto_list.get(cnt));
						cnt++;
					}
				}
			}
		});
		
		setLocation(1000,50);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new S02_Lotto();
	}
}
