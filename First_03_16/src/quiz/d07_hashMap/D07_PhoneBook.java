package quiz.d07_hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class GroupInfo implements Comparable<GroupInfo>{
	private String name;
	
	public GroupInfo() {
		
	}
	
	public GroupInfo(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(GroupInfo o) {
		return this.name.compareTo(o.name) *-1;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
public class D07_PhoneBook {

	/*
	 *  # HashMap을 이용해 전화번호부를 구현
	 *  
	 *  1. 그룹 / 전화번호 / 이름을 저장
	 *  2. 그룹 이름을 키값으로 넣으면 해당 그룹의 전화번호 목록이 나온다
	 *  3. 전화번호 목록에 전화번호를 키값으로 넣으면 이름이 나온다
	 *  
	 *  # 메소드
	 *  
	 *  1. 새로운 그룹을 추가하는 메소드
	 *  2. 존재하는 그룹에 새로운 전화번호를 등록하는 메소드 (그룹이 없다면 미분류 그룹에 저장)
	 *  3. 등록된 전화번호를 이름기준 내림차순으로 보여주는 메소드
	 *  4. 이름의 일부를 입력하면 일치하는 모든 정보가 출력되는 검색 메소드
	 *  5. 전화번호의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 검색 메소드
	 *  
	 */
	static Scanner sc = new Scanner(System.in);
	HashMap<String,Object> group_map = new HashMap<>();
	HashMap<String,Object> phone_map = new HashMap<>();
	TreeSet<GroupInfo> name_set = new TreeSet<>();
	HashSet<String> phone_set = new HashSet<>();
	
	// 그룹 검색
	public void groupSearch() {
		System.out.println("검색할 그룹 > ");
		String str = sc.next();
		if(!group_map.containsKey(str)) {
			System.out.println("그룹이 존재하지 않음");
			return;
		}
		System.out.println(group_map.get(str));
	}
	// 전화번호로 이름 검색
	public void phoneSearch() {
		System.out.println("검색할 이름의 전화 번호 > ");
		String phone_number = sc.next();
		
		if(!phone_map.containsKey(phone_number)) {
			System.out.println("전화번호가 존재하지 않음");
			return;
		}
		System.out.println(phone_map.get(phone_number));
	}
	
	// 존재하는 그룹에 새로운 전화번호를 등록하는 메소드
	public void setGroup() {
		System.out.println("번호를 추가할 그룹 > ");
		String group_name = sc.next();
		
		System.out.println("추가할 번호 > ");
		String phone_number = sc.next();
		
		System.out.println("이름 > ");
		String name = sc.next();
		// 그룹 이름이 존재하지 않는다면 메시지 출력
		if(!group_map.containsKey(group_name)) {
			System.out.println("입력한 그룹이 존재하지 않음 (미분류) 그룳에 추가 됨");
		}
		// 미분류 그룹이 아직 없다면 미분류 그룹을 생성하고 번호 추가
		if(!group_map.containsKey("미분류")) {
			group_map.put("미분류", new HashSet<>());
			((HashSet<String>)group_map.get("미분류")).add(phone_number);
		}
		// 미분류 그룹이 있다면 번호 추가
		else {
			((HashSet<String>)group_map.get("미분류")).add(phone_number);
		}

		phone_map.put(phone_number, name);	// 전화번호 map에 번호, 이름 추가
		phone_set.add(phone_number);		// HashSet에 번호 추가
		name_set.add(new GroupInfo(name));	// TreeSet에 이름 추가 
	}
	
	// 새로운 그룹 추가
	public void groupAdd() {
		
		System.out.println("추가할 그룹 이름 > ");
		String group_name = sc.next();
		group_map.put(group_name, new HashSet<>());
		
		System.out.println("입력할 전화번호 갯수 > ");
		int loop = sc.nextInt();
		
		// loop 만큼 반복
		for(int i=0; i<loop; i++) {
			
			System.out.println((i+1) + "번째로 입력할 전화번호 > ");
			String phone_number = sc.next();
			//번호 추가 
			((HashSet<String>)group_map.get(group_name)).add(phone_number);
			
			System.out.println(phone_number + "에 저장할 이름 > ");
			String name = sc.next();
			
			phone_map.put(phone_number, name);
			phone_set.add(phone_number);
			name_set.add(new GroupInfo(name));
		}
	}
	
	// 이름의 일부를 검색하면 모든 정보가 출력
	public void nameSearch() {
		System.out.println("이름 입력 > ");
		String input_name = sc.next();
		
		String name;
		System.out.println("이름\t번호");
		
		for(String key : phone_map.keySet()) {
			name = (String) phone_map.get(key);

			if(name.contains(input_name)){
				System.out.print(name + "\t" + key + "\n");
			}
		}
	}
	// 전화번호 일부 검색
	public void numberSearch() {
		System.out.println("전화번호 입력 > ");
		String input_number = sc.next();

		for(String number : phone_set) {
			
			if(number.contains(input_number)) {
				System.out.println(number);
			}
		}
	}
	
	// 모든 이름 내림차순 출력
	public void printName_desc() {
		
		Iterator<GroupInfo> iter = name_set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	public static void main(String[] args) {

		D07_PhoneBook pb = new D07_PhoneBook();
		
		int select;
		
		while(true) {
			System.out.println("1.그룹 검색  2.이름 검색  3.그룹 추가  4.전화번호 추가  5.이름 검색(일부)  "
					+ "6.전화번호 검색(일부)  7.모든 이름 검색   0. 종료");
			select = sc.nextInt();
			
			if(select == 1) 
				pb.groupSearch();
			if(select == 2) 
				pb.phoneSearch();
			if(select == 3)
				pb.groupAdd();
			if(select == 4)
				pb.setGroup();
			if(select == 5)
				pb.nameSearch();
			if(select == 6)
				pb.numberSearch();
			if(select == 7)
				pb.printName_desc();
			if(select == 0)
				System.exit(0);
			
		}
	}	
}
