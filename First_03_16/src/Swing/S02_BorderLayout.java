package Swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_BorderLayout extends javax.swing.JFrame {

	/*
	 *  # BorderLayout
	 *  
	 *   - �������ϰ� ����� �̷���� ���̾ƿ�
	 *   - ������Ʈ�� �߰��� �� ��ġ�� �Բ� ������ �� �� �ִ�.
	 *   
	 */
	public S02_BorderLayout(){

		//�� �������� ���̾ƿ� ���� (���� ���� �ؾ���)
		setLayout(new BorderLayout());
		
		// ��ư ����
		JButton quit_btn = new JButton("Quit");
		JButton save_btn = new JButton("Save");
		JButton load_btn = new JButton("�ε�");
		JButton delete_btn = new JButton("����Ʈ");
		JButton update_btn = new JButton("������Ʈ");
		
		quit_btn.setFont(new Font("�ü�ü",Font.BOLD,35));
		save_btn.setFont(new Font("���ü",Font.BOLD,10));
		
		// ��ư�� �̺�Ʈ �߰�
		save_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("save_btn");
			}
		});
		load_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		delete_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete employees");
			}
		});
		update_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("update employees set salary = salary * 100");
			}
		});
		
		quit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ش� ������Ʈ�� action �߻��� e�� �̺�Ʈ ����� ������ �Ѿ�´�
				System.out.println("������ ����1 : " + e.getActionCommand());
				System.out.println("������ ����2 : " + e.getID());
				System.out.println("������ ����3 : " + e.getModifiers());
				System.out.println("������ ����4 : " + e.getWhen());
				System.out.println("������ ����5 : " + e.getSource());
				
				// e.getSource()���� �׼��� �߻��� ������Ʈ�� �ν��Ͻ��� ����ְ�
				// �ٿ�ĳ���� �Ͽ� ����ؾ� �Ѵ�.
				((JButton)e.getSource()).setText("������!");
			}
		});
		
		// ��ư �߰�
		add(save_btn,BorderLayout.CENTER);
		add(load_btn,BorderLayout.EAST);
		add(delete_btn,BorderLayout.WEST);
		add(update_btn,BorderLayout.NORTH);
		add(quit_btn, BorderLayout.SOUTH);
		

		// ��ġ ����
		setLocation(1000,50);
		// ������ ũ�� ����
		setSize(600,600);
		// x ��ư�� ������ ���� ���� ����
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �������� ���̰� ����(ȭ���� �׸���)
		setVisible(true);
	}
	public static void main(String[] args) {
		new S02_BorderLayout();
	}
}