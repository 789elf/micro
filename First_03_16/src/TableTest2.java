import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest2 extends JFrame {
	JTable table;
	JScrollPane scroll; // ���̺� ���� �� ���� �־�����~ scroll
	String[][] data; // 3���� ������ ���� 2���� �迭�� �����Ѵ�.
	String title[] = {"�ߺз�","��ǰ�ڵ�","��ǰ��","��� ����","����Ͻ�"};

	public TableTest2() {
		// table = new JTable(3,4); //�÷��� �����Ҽ� ����, �����͸� ������ ����.
		// 3��������� ������.

		String data[][] = {
				{"1.���ö�","1","�������ö�","1","06-11 00:00"},
				{"2.�ܹ���","3","�ȳ��ܹ���","1","06-11 00:00"}
		};

		// title = new String[4]; �ٸ��� �غ���. ����� ���ÿ� �����غ���.

		table = new JTable(data, title); // table=new JTable(������-2�����迭, �÷��迭);
		scroll = new JScrollPane(table);
		add(scroll);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		// setSize(400,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TableTest2();

	}

}