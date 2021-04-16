import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class D05_Comparator{

	/*
	 *   # Comparator
	 *   
	 *     - �����ϸ� �� ��ü�� ũ�⸦ ���� �� ����ϴ� Ŭ������ �Ǵ� �������̽�
	 *     - ��ü���� ũ�⸦ ���� �� ���ȴ�
	 */
	
	public static void main(String[] args) {
		LinkedList<Grape> grapes = new LinkedList<Grape>();

		for(int i=0; i<10; i++){
			grapes.addLast(new Grape()
					.setGno(String.format("PODO%04d", i))
					.setLocation((int)(Math.random() * Grape.LOCATIONS))
					.setFruit((int)(Math.random() * 11 + 30)));
			System.out.println(grapes.getLast());
		}
		
		// Collections.sort�� �̿��� Grape��ü�� ����
		Collections.sort(grapes, new �����з���_�����˸���_��������());
		
		System.out.println("\n ##���� ���� ���� ��## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}
		
		// ����1: �����˸��� ���� ��������
		Collections.sort(grapes, new �����з���_�����˸���_��������());
		System.out.println("\n ##�˸��� �������� ���� ��## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}

		// ����2: ���� gno ���� �������� ����
		Collections.sort(grapes, new �����з���_������ȣ_��������());
		System.out.println("\n ##��ȣ �������� ���� ��## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}
	}
	
}
class �����з���_������ȣ_�������� implements Comparator<Grape>{
	// 1 �� ( �Ϸù�ȣ ����ó�� �Ǿ��ִ� ���ڿ��� ���ڸ� �߶󳻰� ����ȯ �Ŀ� �� �� )
	// ���������� ��ȯ�ϱ⿡�� �������� ������ �� ,, 
	//	@Override
//	public int compare(Grape o1, Grape o2) {
//
//		int gno1 = Integer.parseInt(o1.gno.substring(4));
//		int gno2 = Integer.parseInt(o2.gno.substring(4));
//		
//		if(gno1 > gno2) {
//			return -1;
//		}else if(o1.gno == o2.gno) {
//			return 0;
//		}else {
//			return 1;
//		}
//	}
	// 2��
//	@Override
//	public int compare(Grape o1, Grape o2) {
//		String gno1 = o1.gno;
//		String gno2 = o2.gno;
//		
//		int min_len = Math.min(gno1.length(), gno2.length());
//		for(int i=0; i<min_len; i++) {
//			if(gno1.charAt(i) > gno2.charAt(i)) {
//				return -1;
//			} else if(gno1.charAt(i) < gno2.charAt(i)) {
//				return 1;
//			}
//		}
//		
//		if(gno1.length() == gno2.length()) {
//			return 0;
//		}else if(gno1.length() > gno2.length()) {
//			return -1;
//		}else {
//			return 1;
//		}
//	}

	// 3�� �̹� �����Ǿ� �ִ� String Ŭ������ ���ڿ� ũ�� �� �޼ҵ带 ��� compareTo()
	@Override
	public int compare(Grape o1, Grape o2) {
		return o1.gno.compareTo(o2.gno) * -1;
	}
}
class �����з���_�����˸���_�������� implements Comparator<Grape>{

	// 1�� ( ù��° if���� �� �񱳺����ϴ� ���)
//	@Override
//	public int compare(Grape o1, Grape o2) {
//		if(o1.fruit > o2.fruit) {
//			return -1;
//		}else if(o1.fruit == o2.fruit) {
//			return 0;
//		}else {
//			return 1;
//		}
//	}
	
	// 2�� ( ���ϰ��� -1, 1�� �����ϴ� ���)
	@Override
	public int compare(Grape o1, Grape o2) {
		if(o1.fruit > o2.fruit) {
			return 1;
		}else if(o1.fruit == o2.fruit) {
			return 0;
		}else {
			return -1;
		}
	}
}
class �����з���_�����˸���_�������� implements Comparator<Grape>{

	/*
	 *   - compare �޼ҵ��� ���ϰ��� ����� o1, o2�� ������ �ٲ۴�
	 *   - compare �޼ҵ��� ���ϰ��� 0�̸� ���� ũ��� ����Ѵ�
	 *   - compare �޼ҵ��� ���ϰ��� ������ o1�� o2�� ������ �״�� �����Ѵ�
	 */
	@Override
	public int compare(Grape o1, Grape o2) {
		if(o1.fruit < o2.fruit) {
			return -1;
		}else if(o1.fruit == o2.fruit) {
			return 0;
		}else {
			return 1;
		}
	}
	
}

class Grape{
	private static String[] locationNames = {"�����̽þ�","����", "����", "������", "�ŵ���"};
	public static int LOCATIONS = locationNames.length;
	
	String gno;
	int location;
	int fruit;
	
	
	/*
	 *  # toString()
	 *    
	 *    - ��� ��ü�� ���ԵǾ� �ִ� �޼���(Object �޼ҵ�)
	 *    - �� �ν��Ͻ��� ���ڿ��� ǥ���Ѵٸ� ? �� �����س��� �޼���
	 *    - System.out.println()�� ��� ������ �ν��Ͻ��� toString()
	 *      �޼ҵ��� ����� �ֿܼ� ����ϴ� �޼ҵ��̴�
	 *    - Object Ŭ������ �����Ǿ��ִ� toString() �Ĥ��ҵ��� �⺻ ������
	 *      "Ŭ������@�ּҰ�" �̴�
	 */
	
	/*
	 *  # equals()
	 *    
	 *    - Object �޼ҵ�
	 *    - ���� ��ü���� ���� �� � �������� �����ؾ� �ϴ����� �����س�sms �޼ҵ�
	 */
	
	@Override
	public boolean equals(Object obj) {
		return this.gno == ((Grape)obj).gno;
	}
	@Override
	public String toString() {
		return "Grape [gno=" + gno + ", location=" + location + ", fruit=" + fruit + "]";
	
	}
	
	Grape setGno(String gno) {
		this.gno = gno;
		return this;
	}
	Grape setLocation(int location_id) {
		this.location = location_id;
		return this;
	}
	Grape setFruit(int fruit) {
		this.fruit = fruit;
		return this;
	}
	
	
}
