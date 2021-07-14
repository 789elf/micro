import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class E05_Stream_EX {

	public static void main(String[] args) {

		LinkedList<UserRecord> ranking = new LinkedList<>();

		File save = new File("./data/base.game");

		if (save.exists()) {
			try {
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream(save));
				// 파일에 저장된 객체를 다시 불러와서 저장할 수 있다. 
				ranking = (LinkedList)oin.readObject();
				oin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("######### 현재 랭킹 #########");
			printRanking(ranking);
		}

		int answer = 1234;

		InputStreamReader input = new InputStreamReader(System.in);
		// DataInputStream sc = new DataInputStream(System.in);
		Scanner sc = new Scanner(input);

		System.out.println("게임 시작! 빠르게 1234를 입력하는 게임!");

		long start = System.currentTimeMillis();

		System.out.print("입력해보세요 >> ");

		int record = -1;
		if (sc.nextInt() == 1234) {
			System.out.println("성공!");
			record = (int) (System.currentTimeMillis() - start);

			sc.nextLine();
			System.out.print("당신의 이름을 입력하세요 > ");
			ranking.add(new UserRecord(sc.next(), record));
			Collections.sort(ranking);

			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(save));
				// writeObject = 파일에 객체의 정보를 저장해놓고 나중에 다시 불러올 수 있다.
				// 여러 객체의 정보를 담을 수 있지만 각 객체마다 Serializable가 필요하며 넣은 순서대로 꺼내야 한다.
				out.writeObject(ranking);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("실패!");
		}
		System.out.println(ranking);
		printRanking(ranking);
	}

	private static void printRanking(List<UserRecord> ranking) {
		int i = 1;
		for (UserRecord record : ranking) {
			System.out.println(i++ + "위 - " + record);
		}
	}
}
/*
 * # Serializable interface
 * 
 * - 해당 클래스로 생성된 인스턴스를 직렬화 할 수 있다고 표시하는 인터페이스 - serialVersionUID에 원하는 값을 넣으면 된다
 * - ObjectOutputStream으로 자바 객체를 파일에 저장할 때 해당 객체를 직렬화(코드화) 할 수 있어야 한다
 */
class UserRecord implements Comparable<UserRecord>, Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	int user_try;
	int record;

	public UserRecord(String name, int record) {
		this.name = name;
		this.record = record;
		this.user_try = (int) (Math.random() * 8 + 1);
	}

	@Override
	public String toString() {
		return String.format("%s [try %d time(s) / %d millisec]", name, user_try, record);
	}

	@Override
	public int compareTo(UserRecord o) {
		return this.user_try - o.user_try != 0 ? this.user_try - o.user_try : this.record - o.record;
	}
}
