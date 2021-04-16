import java.util.ArrayList;
import java.util.Collections;

public class D01_ArrayList {

	/*
	 *  # Java Collections
	 *  
	 *  - �ڹٿ��� �⺻������ �����ϴ� �ڷᱸ�� �������̽�
	 *  - Collection �������̽��� ��ӹ��� �������̽��δ� List, Set ���� �ִ�.
	 *  
	 *  # java.util.ArrayList
	 *  
	 *   - �迭�� �ٸ��� ũ�Ⱑ �ڵ����� �����Ǵ� �ڷᱸ��  Ŭ����
	 *   - �迭�� ������ ����
	 *   - ���������� ��� �����Ϳ� �����ؾ� �� �� ���� �����ϴ�
	 *   
	 *    ��  ����� ������ ����Ҷ� �⺻�� ������ �Ű������� ������ �� ���� �����ϰ�
	 *    ������(Ŭ����) ������ �Ű������� ������ �� �ּҸ� �����Ѵ�.  
	 */
	
	public static void main(String[] args) {
		// #Ÿ���� �����Ͽ� ArrayList ����
		// - Ÿ���� ������ �� ����ϴ� <>�� ���׸��̶�� �Ѵ�.
		ArrayList<String> fruits = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList();
		
		// add(item): ����Ʈ�� ���ϴ� �����͸� ���������� �� �ڿ� �߰��Ѵ�
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("kiwi");
		
		numbers.add(1);
		numbers.add(2);
		
		//add(index, item): ����Ʈ�� ���ϴ� ��ġ�� �����͸� �ִ´�
		fruits.add(2, "orange");
		fruits.add(2, "peach");
		fruits.add(2, "grape");
		
		System.out.println(fruits);
		
		//get(index): ����Ʈ���� ���ϴ� �ε����� �����͸� �ϳ� ������
		System.out.println(fruits.get(0));
		System.out.println(fruits.get(1));
		System.out.println(fruits.get(2));
		
		//size(): �ش� �÷����� ũ�⸦ ��ȯ 
		System.out.println("fruits�� ũ�� : " + fruits.size());
		System.out.println("numbers�� ũ�� : " + numbers.size());
		
		//remove(index): �ش� ��°�� �����͸� �����Ѵ�. ��� ���� �����͸� ��ȯ�Ѵ�.
		String deleted_fruit = fruits.remove(0);
		System.out.println("���� �� : " + fruits.size());
		System.out.println("������ �� : " + deleted_fruit);
		
		//remove(item): �ش� �����͸� �����Ѵ�. ���� ���� ���θ� ��ȯ�Ѵ�. (true or false)
		if(fruits.remove("apple")){
			System.out.println("apple�� ����");
		}else {
			System.out.println("apple�� ��� ���� �Ұ�");
		}
		
		// �÷��� ����(��������)
		Collections.sort(fruits);
		System.out.println(fruits);
		
		System.out.println(fruits);
	}
}

