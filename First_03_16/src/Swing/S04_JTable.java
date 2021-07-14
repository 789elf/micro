package Swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class S04_JTable extends JFrame{

	public S04_JTable() {
		Container container = getContentPane();
		setLayout(new BorderLayout(10,10)); // 레이아웃에 int를 넘겨준다 -> 컴포넌트끼리의 여백을 생성한다.
		
		String data[][] = {
				{"100","Smith","3500","10"},
				{"101","King","4500","30"},
				{"102","Steve","50000","10"},
				{"103","Ryo","30","10"},
		};
		
		String[] column = {"ID","NAME","SALARY","DEPTNO"};
		
		JTable table = new JTable(data,column);
		
//		add(table,BorderLayout.CENTER); 
//		add(new Button("Heelo,Swing"),BorderLayout.SOUTH);
		
		// adapter를 이용해서 구현하는 이유는 listener를 이용해서 
		// 구현하면 많은 메소드를 의무적으로 구현해야 하지만 어댑터를 이용하면 의무적으로 구현할 필요가 없다.
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component com = e.getComponent();
				System.out.println("-----------------");
				System.out.println("location - (" + com.getX() + "," + com.getY() + ")");
				System.out.println("size - (" + com.getWidth() + "," + com.getHeight() + ")");
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				container.isMinimumSizeSet();
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				container.setBackground(Color.red);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000,50,800,800);
		setVisible(true);
	}
	public static void main(String[] args) {
		new S04_JTable();
	}
}
