import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest2 extends JFrame {
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	String[][] data; // 3명의 정보를 담을 2차원 배열을 생성한다.
	String title[] = {"중분류","상품코드","상품명","폐기 수량","폐기일시"};

	public TableTest2() {
		// table = new JTable(3,4); //컬럼을 지정할수 없고, 데이터를 넣을수 없다.
		// 3번방법으로 가보자.

		String data[][] = {
				{"1.도시락","1","알찬도시락","1","06-11 00:00"},
				{"2.햄버거","3","냠냠햄버거","1","06-11 00:00"}
		};

		// title = new String[4]; 다르게 해보자. 선언과 동시에 생성해보자.

		table = new JTable(data, title); // table=new JTable(데이터-2차원배열, 컬럼배열);
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