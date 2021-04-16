import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class D05_Comparator{

	/*
	 *   # Comparator
	 *   
	 *     - 구현하면 두 객체의 크기를 비교할 때 사용하는 클래스가 되는 인터페이스
	 *     - 객체간의 크기를 정할 때 사용된다
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
		
		// Collections.sort를 이용한 Grape객체의 정렬
		Collections.sort(grapes, new 포도분류기_포도알맹이_오름차순());
		
		System.out.println("\n ##과일 기준 정렬 후## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}
		
		// 연습1: 포도알맹이 기준 내림차순
		Collections.sort(grapes, new 포도분류기_포도알맹이_내림차순());
		System.out.println("\n ##알맹이 내림차순 정렬 후## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}

		// 연습2: 포도 gno 기준 내림차순 정렬
		Collections.sort(grapes, new 포도분류기_포도번호_내림차순());
		System.out.println("\n ##번호 내림차순 정렬 후## ");
		for(Grape grape : grapes) {
			System.out.println(grape);
		}
	}
	
}
class 포도분류기_포도번호_내림차순 implements Comparator<Grape>{
	// 1 번 ( 일련번호 형식처럼 되어있는 문자열을 문자만 잘라내고 형변환 후에 값 비교 )
	// 사전순으로 변환하기에는 적합하진 않지만 뭐 ,, 
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
	// 2번
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

	// 3번 이미 구현되어 있는 String 클래스의 문자열 크기 비교 메소드를 사용 compareTo()
	@Override
	public int compare(Grape o1, Grape o2) {
		return o1.gno.compareTo(o2.gno) * -1;
	}
}
class 포도분류기_포도알맹이_내림차순 implements Comparator<Grape>{

	// 1번 ( 첫번째 if문의 값 비교변경하는 방식)
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
	
	// 2번 ( 리턴값을 -1, 1을 변경하는 방식)
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
class 포도분류기_포도알맹이_오름차순 implements Comparator<Grape>{

	/*
	 *   - compare 메소드의 리턴값이 양수면 o1, o2의 순서를 바꾼다
	 *   - compare 메소드의 리턴값이 0이면 같은 크기로 취급한다
	 *   - compare 메소드의 리턴값이 음수면 o1과 o2의 순서를 그대로 유지한다
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
	private static String[] locationNames = {"말레이시아","종로", "강남", "영등포", "신도림"};
	public static int LOCATIONS = locationNames.length;
	
	String gno;
	int location;
	int fruit;
	
	
	/*
	 *  # toString()
	 *    
	 *    - 모든 객체에 포함되어 있는 메서드(Object 메소드)
	 *    - 이 인스턴스를 문자열로 표현한다면 ? 을 구현해놓는 메서드
	 *    - System.out.println()은 사실 전달한 인스턴스의 toString()
	 *      메소드의 결과를 콘솔에 출력하는 메소드이다
	 *    - Object 클래스에 구현되어있는 toString() ㅔㅁ소드의 기본 동작은
	 *      "클래스명@주소값" 이다
	 */
	
	/*
	 *  # equals()
	 *    
	 *    - Object 메소드
	 *    - 같은 객체인지 비교할 때 어떤 동작으로 구분해야 하는지를 구현해놓sms 메소드
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
