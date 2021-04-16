import java.util.ArrayList;
import java.util.Collections;

public class D01_ArrayList {

	/*
	 *  # Java Collections
	 *  
	 *  - 자바에서 기본적으로 제공하는 자료구조 인터페이스
	 *  - Collection 인터페이스를 상속받은 인터페이스로는 List, Set 등이 있다.
	 *  
	 *  # java.util.ArrayList
	 *  
	 *   - 배열과 다르게 크기가 자동으로 조절되는 자료구조  클래스
	 *   - 배열과 유사한 형태
	 *   - 순차적으로 모든 데이터에 접근해야 할 때 가장 유리하다
	 *   
	 *    ※  참고로 변수를 사용할때 기본형 변수는 매개변수로 전달할 때 값을 전달하고
	 *    참조형(클래스) 변수는 매개변수로 전달할 때 주소를 전달한다.  
	 */
	
	public static void main(String[] args) {
		// #타입을 지정하여 ArrayList 생성
		// - 타입을 지정할 때 사용하는 <>를 제네릭이라고 한다.
		ArrayList<String> fruits = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList();
		
		// add(item): 리스트에 원하는 데이터를 순차적으로 맨 뒤에 추가한다
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("kiwi");
		
		numbers.add(1);
		numbers.add(2);
		
		//add(index, item): 리스트의 원하는 위치에 데이터를 넣는다
		fruits.add(2, "orange");
		fruits.add(2, "peach");
		fruits.add(2, "grape");
		
		System.out.println(fruits);
		
		//get(index): 리스트에서 원하는 인덱스의 데이터를 하나 꺼낸다
		System.out.println(fruits.get(0));
		System.out.println(fruits.get(1));
		System.out.println(fruits.get(2));
		
		//size(): 해당 컬렉션의 크기를 반환 
		System.out.println("fruits의 크기 : " + fruits.size());
		System.out.println("numbers의 크기 : " + numbers.size());
		
		//remove(index): 해당 번째의 데이터를 삭제한다. 방금 지운 데이터를 반환한다.
		String deleted_fruit = fruits.remove(0);
		System.out.println("삭제 후 : " + fruits.size());
		System.out.println("삭제된 것 : " + deleted_fruit);
		
		//remove(item): 해당 데이터를 삭제한다. 삭제 성공 여부를 반환한다. (true or false)
		if(fruits.remove("apple")){
			System.out.println("apple를 삭제");
		}else {
			System.out.println("apple가 없어서 삭제 불가");
		}
		
		// 컬렉션 정렬(오름차순)
		Collections.sort(fruits);
		System.out.println(fruits);
		
		System.out.println(fruits);
	}
}

