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
	 *   - 동서남북과 가운데로 이루어진 레이아웃
	 *   - 컴포넌트를 추가할 때 위치를 함께 지정해 줄 수 있다.
	 *   
	 */
	public S02_BorderLayout(){

		//이 프레임의 레이아웃 설정 (가장 먼저 해야함)
		setLayout(new BorderLayout());
		
		// 버튼 생성
		JButton quit_btn = new JButton("Quit");
		JButton save_btn = new JButton("Save");
		JButton load_btn = new JButton("로드");
		JButton delete_btn = new JButton("딜리트");
		JButton update_btn = new JButton("업데이트");
		
		quit_btn.setFont(new Font("궁서체",Font.BOLD,35));
		save_btn.setFont(new Font("고딕체",Font.BOLD,10));
		
		// 버튼에 이벤트 추가
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
				// 해당 컴포넌트에 action 발생시 e로 이벤트 당시의 정보가 넘어온다
				System.out.println("눌린것 정보1 : " + e.getActionCommand());
				System.out.println("눌린것 정보2 : " + e.getID());
				System.out.println("눌린것 정보3 : " + e.getModifiers());
				System.out.println("눌린것 정보4 : " + e.getWhen());
				System.out.println("눌린것 정보5 : " + e.getSource());
				
				// e.getSource()에는 액션이 발생한 컴포턴트의 인스턴스가 들어있고
				// 다운캐스팅 하여 사용해야 한다.
				((JButton)e.getSource()).setText("눌렸음!");
			}
		});
		
		// 버튼 추가
		add(save_btn,BorderLayout.CENTER);
		add(load_btn,BorderLayout.EAST);
		add(delete_btn,BorderLayout.WEST);
		add(update_btn,BorderLayout.NORTH);
		add(quit_btn, BorderLayout.SOUTH);
		

		// 위치 설정
		setLocation(1000,50);
		// 프레임 크기 설정
		setSize(600,600);
		// x 버튼을 눌렀을 때의 동작 설정
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 프레임을 보이게 설정(화면이 그린다)
		setVisible(true);
	}
	public static void main(String[] args) {
		new S02_BorderLayout();
	}
}