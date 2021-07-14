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
	 * 	�̱� ��ư�� ���� ������ 6���� �ߺ����� ���� ���ڸ� ���� ��ư��
	 *  �����ӿ� ���� ���α׷��� �����
	 */
	public S02_Lotto(){

		//�� �������� ���̾ƿ� ���� (���� ���� �ؾ���)
		setLayout(new BorderLayout());
		
		// ��ư ����
		JButton get_number_btn = new JButton("�̱�");
		get_number_btn.setFont(new Font("����ü",Font.BOLD,15));
		
		// ��ư �߰�
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
