import java.util.Comparator;
import java.util.TreeSet;

public class D06_TreeSet {
/*
 *   # Tree Set
 *   
 *     - �ߺ����� ������ �� ����
 *     - �����͸� ������ �� Comparator�� �̿��� �̸� �����Ѵ�    (�߿�!)
 *     - ��ҷ� null�� ������� �ʴ´�
 *     - ó���� �����ؼ� �ֱ� ������ HashSet�� ���� ���� �ӵ��� ������
 *     - ������ TreeSet���� ����(index)�� �ֱ� ������ ���ϴ� �����͸� ���� �� �ִ�
 *     
 *     �ߺ����� ����鼭 �����ϸ鼭 ������ �ȴ�. 
 *     ������ �������� ������ �־�� �Ѵ�. �� Integer, String �� Ÿ���� �̸� ������ ������ ������ �������� ��� �ȴ�. 
 *     (���� ������ ���س��� �ʾƵ� ��Ȯ�� ������ �ֱ� ������) (Ŭ������ ���� ���� ���� ���� ��� �Ѵ� (Compare)) 
 *     �ش� ��ü�� �� ������ ��ü��� Comparator�� ������� ���� ���� �ִ�. (Comparable �� ��ӹ޾� �� ������ ���� ���´ٸ�)
 *     TreeSet<String> word_tree = new TreeSet<>();
 *     
 *   # TreeSet�� �� ���� ������
 *     
 *     1. ���� ������ ���ϸ鼭 �ν��Ͻ��� ����
 *     2. �÷����� ���� (���� ������ �ش� �÷��� ���׸��� Comparable�� ���)
 */
	public static void main(String[] args) {
		TreeSet<Grape> grape_tree = new TreeSet<>((new �����з���_������ȣ_��������()));
		TreeSet<Grape> grape_tree2 = new TreeSet<>((new �����з���_�����˸���_��������()));
		
		grape_tree.add(new Grape().setGno("1").setFruit(30));
		grape_tree.add(new Grape().setGno("2").setFruit(35));
		grape_tree.add(new Grape().setGno("3").setFruit(40));
		
//		grape_tree2.addAll(grape_tree);
//		System.out.println(grape_tree);
//		System.out.println(grape_tree2);
		
		// �������� : ����Ʈ���� ���� 5�� �߰��� �� mno���� �������� ������ �ǵ��� ����� Ȯ��
		TreeSet<Mango> mango_tree = new TreeSet<>(new MangoCompareByMnoAsc());
		mango_tree.add(new Mango("p001", 2, 5));
		mango_tree.add(new Mango("p006", 6, 1));
		mango_tree.add(new Mango("p004", 9, 2));
		mango_tree.add(new Mango("p0011", 11, 3));
		mango_tree.add(new Mango("p009", 14, 4));
		
//		System.out.println(mango_tree.toString());
		
		// Comparable ����Ͽ� �������� MangoŬ������ �̸� ����� �θ� ������ ���� �ʴ´�
		TreeSet<Mango> mango_tree2 = new TreeSet<>();
		mango_tree2.add(new Mango("001", 2, 5));
		mango_tree2.add(new Mango("006", 6, 1));
		mango_tree2.add(new Mango("004", 9, 2));
		mango_tree2.add(new Mango("011", 11, 3));
		mango_tree2.add(new Mango("009", 14, 4));
		
		System.out.println(mango_tree2);
		
		// # TreeSet Ȱ��
		// decendingSet() : �̸� ���� �س��� ������ �ݴ������ Set�� ��ȯ���ش�
		System.out.println(mango_tree2.descendingSet());
		
		// headSet(toElement) : �� �պ��� ���ϴ� ��ұ����� �ڸ� Set�� ��ȯ
		System.out.println(mango_tree2.headSet(new Mango("004", 2, 5)));
		
		// tailSet(toElement) : ���ϴ� ��Һ��� �� �ڱ��� �ڸ� Set �� ��ȯ
		System.out.println(mango_tree2.tailSet(new Mango().setMno("004")));
		
		// subSet(fromElement, toElement) : ���ϴ� ��Һ��� ���ϴ� ��ұ��� �ڸ� Set ��ȯ
		mango_tree2.subSet(new Mango().setMno("004"), new Mango().setMno("009"));
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(5);
		int_tree.add(15);
		int_tree.add(75);
		int_tree.add(33);
		int_tree.add(21);
		
		System.out.println(int_tree);
		
		// ceiling(element) : ���ϴ� ��Ҹ� ���� ������ �� ��� (�÷��� ���� (20�� ��� 20�̻� ���� ����� ���� ã���ش�) 
		System.out.println(int_tree.ceiling(20));  //21
		System.out.println(int_tree.ceiling(22));  //33
		
		// floor(element) : ���ϴ� ��Ҹ� ���� ������ ���� (������ �� ����)
		System.out.println(int_tree.floor(21));    //21
		System.out.println(int_tree.floor(20));    //15
		
		// higher(element) : ���ϴ� ��Ҹ� ���� �÷��� ���� (������ �� ������)
		// lower(element)  : ���ϴ� ��Ҹ� ���� ������ ���� (������ �� ������)
		
	}
}
//Comparator : ���� �� ����ϴ� �� ���� Ŭ������ ����� �������̽�
//Comparable : �� ��ü�� �� ������ Ŭ�������� ǥ���ϴ� �������̽�
class Mango implements Comparable<Mango>{
	String mno;
	int sweet;
	int size;
	
	@Override
	public String toString() {
		return "Mango [mno=" + mno + ", sweet=" + sweet + ", size=" + size + "]";
	}

	public Mango() {
	}

	public Mango setMno(String mno) {
		this.mno = mno;
		return this;
	}
	public Mango(String mno, int sweet, int size) {
		this.mno = mno;
		this.sweet = sweet;
		this.size = size;
	}
	// this vs �Ű������� compare �޼ҵ带 �����ϸ� �ȴ�.
	@Override
	public int compareTo(Mango o) {
		return this.mno.compareTo(o.mno);
	}
	
	
}
class MangoCompareByMnoAsc implements Comparator<Mango>{

	/*
	 *   - compare �޼ҵ��� ���ϰ��� 1�̸� o1, o2�� ������ �ٲ۴�
	 *   - compare �޼ҵ��� ���ϰ��� 0�̸� ���� ũ��� ����Ѵ�
	 *   - compare �޼ҵ��� ���ϰ��� -1 �̸� o1�� o2�� ������ �״�� �����Ѵ�
	 */
//	@Override
//	public int compare(Mango o1, Mango o2) {
//		return o1.mno.compareTo(o2.mno);
//	}
	@Override
	public int compare(Mango o1, Mango o2) {
		String mno1 = o1.mno;
		String mno2 = o2.mno;
		
		int min_len = Math.min(mno1.length(), mno2.length());
		for(int i=0; i<min_len; i++) {
			if(mno1.charAt(i) > mno2.charAt(i)) {
				return 1;
			} else if(mno1.charAt(i) < mno2.charAt(i)) {
				return -1;
			}
		}
		
		if(mno1.length() == mno2.length()) {
			return 0;
		}else if(mno1.length() > mno2.length()) {
			return 1;
		}else {
			return -1;
		}
	}
	
}


class MangoCompareBySweetAsc implements Comparator<Mango>{

	/*
	 *   - compare �޼ҵ��� ���ϰ��� 1�̸� o1, o2�� ������ �ٲ۴�
	 *   - compare �޼ҵ��� ���ϰ��� 0�̸� ���� ũ��� ����Ѵ�
	 *   - compare �޼ҵ��� ���ϰ��� -1 �̸� o1�� o2�� ������ �״�� �����Ѵ�
	 */
	@Override
	public int compare(Mango o1, Mango o2) {
		if(o1.sweet > o2.sweet) {
			return 1;
		}else if(o1.sweet < o2.sweet) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
