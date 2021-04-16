import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import quiz.d02_jiphapQuiz.JiphapQuiz;

// ���׸��� �����ص�(DynamicType) Ŭ������ �ν��Ͻ� ������ ���ϴ� Ÿ���� �� �� �ְ� �ȴ�
// ���� ������ Object�� �����ȴ�
// DynamicType�� T �� �ٿ��� ����� �� �ְ� Collection<? extends T> �ε� ����� �� �ִ�
public class D02_Generic<DynamicType> {

	static List list = new ArrayList<>();
	static Set set = new HashSet<>();
	
	public static void main(String[] args) {
		JiphapQuiz jiphap = new JiphapQuiz();
		
		jiphap.valAdd();
		System.out.println(jiphap.hap(list,set));
		
	}

	// 1
	public Set<DynamicType> hap(Collection<DynamicType> c1, Collection<DynamicType> c2) {
		Set<DynamicType> set = new HashSet<>(c1);
		set.addAll(c2);
		
		return set;
	}
	// 2
	public Set<DynamicType> gyo(Collection<DynamicType> c1, Collection<DynamicType> c2) {
		Set<DynamicType> set = new HashSet<>(c1);
		set.retainAll(c2);
		
		return set;
	}
	// 3
	public Set<DynamicType> cha(Collection<DynamicType> c1, Collection<DynamicType> c2) {
		Set<DynamicType> set = new HashSet<>(c1);
		set.removeAll(c2);
		return set;
	}
	
	public void valAdd() {
		list.add(1);
		list.add(3);
		list.add(3);

		set.add(1);
		set.add(3);
		set.add(7);
		
		D02_Generic<String> jiphap_tools = new D02_Generic<String>();
		D02_Generic<Integer> jiphap_tools2 = new D02_Generic<Integer>();
	}
}
