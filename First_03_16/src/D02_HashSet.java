import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class D02_HashSet {

	/*
	 *  # Set
	 *  
	 *   - ������ �����س��� Ŭ����
	 *   - ��ҷ� ���� ���� ������ ���� ������� �ʴ´�
	 *  
	 *  # Hash
	 *  
	 *   - � ���� �־��� �� ���� ������ �� ���� ���� �����Ǿ�� �ϴ� �˰���
	 *   - ���� ���� �־��� ���� �׻� ������ ���� ���;� �Ѵ�
	 *   - ������ ���� �־��� �� �����ϱ� ���� ���� �ٸ� ���� ���´�
	 *   - ������ �ؽ������� ���� ���� ã�� ���� �Ұ����ؾ� �Ѵ�
	 *   - �ٽ� ���� ������ ���ư� �� �� ���� �ܹ��⼺ �˰���
	 *   - �ߺ� üũ�ÿ� �پ ������ ���δ� 
	 *   
	 *    �� Hash�� ����ϴ� �˰����� �ε����� �������� �ʴ´� ( ���� ������� ������� �ʴ´�)
	 *    
	 *   * MD5 (����)
	 *     hello  -> 5D41402ABC4B2A76B9719D911017C592
	 *     hello1 -> 203AD5FFA1D7C650AD681FDFF3965CD2
	 *   
	 *   * SHA256(����)
	 *      hello -> 2CF24DBA5FB0A30E26E83B2AC5B9E29E1B161E5C1FA7425E73043362938B9824
	 *      
	 *   (��й�ȣ�� �����Ҷ� ������ hash�� ����Ͽ� �����ڰ� �� ������ ���·� �����ؾ� �Ѵ�)
	 *   
	 *   
	 *    �� ���� ū Ư¡ 
	 *     1. �ߺ��� ���� ���� �� ����.
	 *     2. ������� �־����� �ʴ´�  
	 *   
	 *   
	 */
	
	public static void main(String[] args) {
		HashSet<Integer> numbers = new HashSet<>();

		//100�� ������ �־ �ߺ�üũ�� �ϱ� ������ 100�� �ϳ��ۿ� �� �� ���Ѵ�
		numbers.add(100);
		numbers.add(100);
		numbers.add(100);
		
		System.out.println(numbers);
		
		// ���� �÷��� �������̽��̱� ������ ArrayList�� �ִ� �޼������ ���⿡�� �ִ�
		if(numbers.remove(100)) {
			System.out.println("����� ����");
		}else {
			System.out.println("����� ����");
		}
		
		//������� ������� �ʴ´�. (�ε����� ���ǹ�)
		HashSet<String> english = new HashSet<>();
		
		english.add("airplane");
		english.add("apple");
		english.add("bio");
		english.add("cat");
		
		System.out.println(english);
	
		// Set�� �ε����� ���� ������ for-each�� ����� �� �ִ�
		for(String word : english) {
			System.out.println(word);
		}
		
		// �÷����� ��ӹ��� �ֵ鳢���� ��ȯ�� �����Ӵ�
		// - set�� ������ �����ϰ� �ʹٸ� List�� ��ȯ�Ͽ� �����Ѵ�
		// HashSet - > ArrayList
		ArrayList<String> english_list = new ArrayList<>(english);
		Collections.sort(english_list);
		System.out.println(english_list);
		
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(3);
		numbers2.add(6);
		numbers2.add(13);
		numbers2.add(13);
		
		//ArrayList -> HashSet
		System.out.println(numbers2);
		System.out.println((new HashSet<>(numbers2)));
		
		// �÷��ǵ��� �迭�� ��ȯ�ϱ�
		Object[] arr1 = english.toArray();  //1�� ���, Object[]�� ����
		
		String[] arr2 = new String[english.size()];	//2�� ���, �̸� ������ �迭�� ����
		english.toArray(arr2);
		
		System.out.println("Object �迭�� ��ȯ�� english : " + Arrays.toString(arr1));
		System.out.println("�迭�� ��ȯ�� english : " + Arrays.toString(arr2));
 		
		/*
		 *  ���׸��� �䱸�ϴ� Ŭ������ ���׸��� ������� �ʴ� ��� ��� Ÿ���� ���� �� �ִ�
		 *   - ��� Ÿ���� object Ÿ������ ��ĳ���õǾ� ����ȴ�
		 *   - �ش� ���� �ٽ� ����ϱ� ���ؼ��� �ٿ�ĳ������ �ʿ��ϴ�
		 */
		ArrayList numbers3 = new ArrayList();
		
		numbers3.add("ȫ��");
		numbers3.add('a');
		numbers3.add(1.1);
		
		// contains() : �÷��ǿ� �ش� ��Ұ� ���ԵǾ� �ִ��� ���θ� ��ȯ
		System.out.println(english.contains("apple"));
		System.out.println(english.contains("banana"));
		
		System.out.println(english_list.contains("apple"));
		System.out.println(english_list.contains("banana"));
		
		
		// containsAll (Collection): ������ �÷����� ��� ���ԵǾ� �ִ����� �˻�
		Set<String> subset = new HashSet<>();
		List<String> sublist = new ArrayList<>();
		
		subset.add("zebra");
		subset.add("drama");
		
		sublist.add("apple");
		
		System.out.println("english���� subset�� ��� ������ ����ֳ��� ? : " + english.containsAll(subset));
		System.out.println("english���� sublist�� ��� ������ ����ֳ��� ? : " + english.containsAll(sublist));
		
		// addAll(Collection): ������ �÷����� ������ ��� �߰� (�߰� ���� ���θ� ��ȯ)
		// - ���� �߰��� ���� ������ true
		// - �̹� ��� ���Ե� ��쿡�� false�� ��ȯ�Ѵ� ( HashSet )
		System.out.println(english.addAll(subset));
		
		// # removeAll(Collection): ������ �÷��ǰ� ���� ������ ��� ����
		english_list.removeAll(subset);
		System.out.println(english_list);
		
		// # retainAll(Collection) : ������ �÷��ǰ� ��ġ�ϴ� ���븸 �����
		// - ���Ѱ��� �ִٸ� true ���ٸ� false 
		english.retainAll(subset);
		System.out.println(english);
		
		// # isEmpty() : �ش� �÷����� ��������� true
		System.out.println(!english.isEmpty());
		
		
	}
	
}
