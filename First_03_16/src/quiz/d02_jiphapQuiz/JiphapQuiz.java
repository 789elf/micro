package quiz.d02_jiphapQuiz;
import java.util.*;

public class JiphapQuiz{

	/*
	 *  1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set 타입으로 반환하는 메서드
	 *  
	 *  2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set 타입으로 반환하는 메서드
	 *  
	 *  3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set 타입으로 반환하는 메서드
	 */

	List list = new ArrayList<>();
	Set set = new HashSet<>();
	
	public static void main(String[] args) {
		JiphapQuiz jiphap = new JiphapQuiz();
		
		jiphap.valAdd();
		System.out.println(jiphap.hap(jiphap.list,jiphap.set));
		
	}

	// 1
	public Set<Integer> hap(Collection<Integer> c1, Collection<Integer> c2) {
		Set<Integer> set = new HashSet<>(c1);
		set.addAll(c2);
		
		return set;
	}
	// 2
	public Set<Integer> gyo(Collection<Integer> c1, Collection<Integer> c2) {
		Set<Integer> set = new HashSet<Integer>(c1);
		set.retainAll(c2);
		
		return set;
	}
	// 3
	public Set<Integer> cha(Collection<Integer> c1, Collection<Integer> c2) {
		Set<Integer> set = new HashSet<Integer>(c1);
		set.removeAll(c2);
		return set;
	}
	
	public void valAdd() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);

		set.add(1);
		set.add(3);
		set.add(2);
		set.add(4);
		set.add(5);
		set.add(7);
	}
}

