import java.util.Comparator;
import java.util.TreeSet;

public class D06_TreeSet {
/*
 *   # Tree Set
 *   
 *     - 중복값을 저장할 수 없다
 *     - 데이터를 저장할 때 Comparator를 이용해 미리 정렬한다    (중요!)
 *     - 요소로 null을 허용하지 않는다
 *     - 처음에 정렬해서 넣기 때문에 HashSet에 비해 저장 속도가 느리다
 *     - 하지만 TreeSet에는 순서(index)가 있기 때문에 원하는 데이터만 꺼낼 수 있다
 *     
 *     중복값을 지우면서 정렬하면서 저장이 된다. 
 *     정렬할 기준점이 무조건 있어야 한다. 단 Integer, String 등 타입을 미리 지정해 놓으면 정렬할 기준점이 없어도 된다. 
 *     (비교의 기준을 정해놓지 않아도 명확한 기준이 있기 때문에) (클래스와 같은 것은 비교할 것을 줘야 한다 (Compare)) 
 *     해당 객체가 비교 가능한 객체라면 Comparator를 사용하지 않을 수도 있다. (Comparable 을 상속받아 비교 기준을 정해 놓는다면)
 *     TreeSet<String> word_tree = new TreeSet<>();
 *     
 *   # TreeSet의 두 가지 생성자
 *     
 *     1. 정렬 기준을 정하면서 인스턴스를 생성
 *     2. 컬렉션을 전달 (정렬 기준은 해당 컬렉션 제네릭의 Comparable을 사용)
 */
	public static void main(String[] args) {
		TreeSet<Grape> grape_tree = new TreeSet<>((new 포도분류기_포도번호_내림차순()));
		TreeSet<Grape> grape_tree2 = new TreeSet<>((new 포도분류기_포도알맹이_오름차순()));
		
		grape_tree.add(new Grape().setGno("1").setFruit(30));
		grape_tree.add(new Grape().setGno("2").setFruit(35));
		grape_tree.add(new Grape().setGno("3").setFruit(40));
		
//		grape_tree2.addAll(grape_tree);
//		System.out.println(grape_tree);
//		System.out.println(grape_tree2);
		
		// 연습문제 : 망고트리에 망고를 5개 추가할 때 mno기준 오름차순 정렬이 되도록 만들고 확인
		TreeSet<Mango> mango_tree = new TreeSet<>(new MangoCompareByMnoAsc());
		mango_tree.add(new Mango("p001", 2, 5));
		mango_tree.add(new Mango("p006", 6, 1));
		mango_tree.add(new Mango("p004", 9, 2));
		mango_tree.add(new Mango("p0011", 11, 3));
		mango_tree.add(new Mango("p009", 14, 4));
		
//		System.out.println(mango_tree.toString());
		
		// Comparable 사용하여 기준점을 Mango클래스에 미리 만들어 두면 에러가 나지 않는다
		TreeSet<Mango> mango_tree2 = new TreeSet<>();
		mango_tree2.add(new Mango("001", 2, 5));
		mango_tree2.add(new Mango("006", 6, 1));
		mango_tree2.add(new Mango("004", 9, 2));
		mango_tree2.add(new Mango("011", 11, 3));
		mango_tree2.add(new Mango("009", 14, 4));
		
		System.out.println(mango_tree2);
		
		// # TreeSet 활용
		// decendingSet() : 미리 정렬 해놓은 방향의 반대방향의 Set을 반환해준다
		System.out.println(mango_tree2.descendingSet());
		
		// headSet(toElement) : 맨 앞부터 원하는 요소까지의 자른 Set을 반환
		System.out.println(mango_tree2.headSet(new Mango("004", 2, 5)));
		
		// tailSet(toElement) : 원하는 요소부터 맨 뒤까지 자른 Set 을 반환
		System.out.println(mango_tree2.tailSet(new Mango().setMno("004")));
		
		// subSet(fromElement, toElement) : 원하는 요소부터 원하는 요소까지 자른 Set 반환
		mango_tree2.subSet(new Mango().setMno("004"), new Mango().setMno("009"));
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(5);
		int_tree.add(15);
		int_tree.add(75);
		int_tree.add(33);
		int_tree.add(21);
		
		System.out.println(int_tree);
		
		// ceiling(element) : 원하는 요소를 대충 선택할 때 사용 (올려서 선택 (20이 없어도 20이상 가장 가까운 수를 찾아준다) 
		System.out.println(int_tree.ceiling(20));  //21
		System.out.println(int_tree.ceiling(22));  //33
		
		// floor(element) : 원하는 요소를 대충 내려서 선택 (전달한 값 포함)
		System.out.println(int_tree.floor(21));    //21
		System.out.println(int_tree.floor(20));    //15
		
		// higher(element) : 원하는 요소를 대충 올려서 선택 (전달한 값 미포함)
		// lower(element)  : 원하는 요소를 대충 내려서 선택 (전달한 값 미포함)
		
	}
}
//Comparator : 비교할 때 사용하는 비교 도구 클래스로 만드는 인터페이스
//Comparable : 이 객체가 비교 가능한 클래스임은 표현하는 인터페이스
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
	// this vs 매개변수로 compare 메소드를 구현하면 된다.
	@Override
	public int compareTo(Mango o) {
		return this.mno.compareTo(o.mno);
	}
	
	
}
class MangoCompareByMnoAsc implements Comparator<Mango>{

	/*
	 *   - compare 메소드의 리턴값이 1이면 o1, o2의 순서를 바꾼다
	 *   - compare 메소드의 리턴값이 0이면 같은 크기로 취급한다
	 *   - compare 메소드의 리턴값이 -1 이면 o1과 o2의 순서를 그대로 유지한다
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
	 *   - compare 메소드의 리턴값이 1이면 o1, o2의 순서를 바꾼다
	 *   - compare 메소드의 리턴값이 0이면 같은 크기로 취급한다
	 *   - compare 메소드의 리턴값이 -1 이면 o1과 o2의 순서를 그대로 유지한다
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
