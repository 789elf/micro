import java.util.ArrayList;
import java.util.LinkedList;

public class D04_LinkedList {

	/*
	 *   # 연결 리스트
	 *   
	 *     - ArrayList보다 삽입/삭제에 유리한 리스트
	 *     
	 *     - 데이터 중간에 삽입이 발생했을 때 ArrayList는 모든 데이터를 뒤로 밀어야 하지만
	 *       연결 리스트는 연결된 노드만 변경하기 때문에 훨씬 빠르다
	 *       
	 *     - ArrayList는 데이터 보관 및 읽기에 유리하고
	 *       LinkedList는 데이터 추가 수정 및 삭제에 유리하다
	 */
	
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<String>();
		
		animals.add("tiger");
		animals.add("lion");
		animals.add("horse");
		
		System.out.println(animals);
		
		animals.addFirst("turtle");
		animals.addFirst("monkey");
		
		System.out.println(animals);
		
		//LinkedList get
		System.out.println(animals.get(3));
		System.out.println(animals.getFirst());
		System.out.println(animals.getLast());
		
		//pop() : 리스트의 맨 앞 데이터를 읽고 버린다
		while(animals.size() != 0) {
			System.out.println("pop! " + animals.pop());
		}
		System.out.println("after pop: " + animals);
		
		//pollLast() : 리스트의 맨 뒤 데이터를 읽고 버린다
		ArrayList<String> cage = new ArrayList<String>();
		cage.add("rabbit");
		cage.add("hamster");
		cage.add("bird");
		cage.add("fish");
		
		animals.addAll(cage);
		
		while(animals.size() != 0) {
			System.out.println("뒤에서부터 꺼내기 : " + animals.pollLast());
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>(10000);
		LinkedList<Integer> linked = new LinkedList<Integer>();
		
		System.out.println("1. ArrayList Insertion Test");
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<5000; i++) {
			arr.add(50, 10);
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
		
		
		System.out.println("2. LinkedList Insertion Test");
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<5000; i++) {
			linked.add(50, 10);
		}
		endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
		
	}
}
