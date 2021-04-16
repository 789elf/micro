package quiz.d07_hashMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneBookVer2 {

	public static class PhoneInfo{
	
		String name;
		String phone_number;
		String address;
		String profile_image_path;
	}
	
	HashMap<String,HashMap<String,String>> phonebook;

	public PhoneBookVer2() {
		phonebook = new HashMap<>();
		
		phonebook.put("미분류", new HashMap<>());
		phonebook.put("가족", new HashMap<>());
		phonebook.put("직장", new HashMap<>());
		phonebook.put("친구", new HashMap<>());
		
		phonebook.get("가족").put("010-1234-1234","엄마");
	}
	
	public boolean addGroup(String groupName) {
		if(phonebook.containsKey(groupName)) {
			System.out.println("이미 존재하는 그룹 : " + groupName);
			return false;
		}else {
			System.out.println("성공적으로 추가 : " + groupName);
			phonebook.put(groupName, new HashMap<>());
			return true;
		}
	}
	
	// 그룹 리스트
	public void printGroupList() {
		for(String groupName : phonebook.keySet()) {
			System.out.printf("#### %s ####\n", groupName);
		}
	}

	// 번호 추가
	public boolean addNumber(String groupName, String phoneNumber, String name) {
		for(HashMap<String, String> group : phonebook.values()) {
			if(group.containsKey(phoneNumber)) {
				System.out.println("이미 등록된 번호입니다.");
				return false;
			}
		}
		if(phonebook.containsKey(groupName)) {
			phonebook.get(groupName).put(phoneNumber,name);
		}else {
			phonebook.get("미분류").put(phoneNumber, name);
		}
		
		return true;
	}
		
	public void printPhoneBook() {
	
		for(String groupName : new TreeSet<>(phonebook.keySet())){
			System.out.printf("--- %s --- \n", groupName);
			
			HashMap<String, String> group = phonebook.get(groupName);
			
			TreeSet<Entry<String,String>> sortedEntrySet =
					new TreeSet<>(new Comparator<Entry<String, String>>() {
				@Override
				public int compare(Entry<String, String> o1, Entry<String, String> o2) {
					
					// 이름으로 1차 정렬 후 , 전화번호 기준으로 2차 정렬 
					int value_diff = o1.getValue().compareTo(o2.getValue());
					
					if(value_diff == 0) {
						return o1.getValue().compareTo(o2.getKey());
					}else {
						return value_diff;
					}
				}
			});
			
			sortedEntrySet.addAll(group.entrySet());
			
			for (Entry<String,String> entry : sortedEntrySet) {
				System.out.printf("%s : %s\n", entry.getValue(), entry.getKey());
			}
		}
	}
	
	// 이름 검색
	public void searchByName(String keyword) {
		int count = 0;
		
		System.out.println("검색 결과");
		for(HashMap<String, String> group : phonebook.values()) {
			
			for(Entry<String, String> entry : group.entrySet()) {
				
				if(entry.getValue().contains(keyword)) {
					
					System.out.printf("%s : %s\n",entry.getValue(),entry.getKey());
					count++;
				}
			}
		}
		System.out.printf("검색 결과 %d건 \n", count);
	}
	
	// 번호 검색
	public void searchByPhoneNumber(String number_fragment) {
		int count = 0;
		for(HashMap<String, String> group : phonebook.values()) {
			
			for(String phoneNumber : group.keySet()) {
				if(phoneNumber.contains(number_fragment)) {
					System.out.printf("%s : %s\n",group.get(phoneNumber), phoneNumber);
					count++;
				}
			}
		}
	}
	public static void main(String[] args) {
		PhoneBookVer2 book = new PhoneBookVer2();
		Scanner sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.println("그룹 이름을 입력 >> ");
//			book.addGroup(sc.nextLine());
//			
//			book.printGroupList();
//		}
		
		book.addGroup("가족");
		book.addGroup("동호회");
		book.addGroup("초등학교 동창");
		book.addGroup("중학교 동창");
		book.addGroup("고등학교 동창");
		book.addGroup("취업반");
		
		book.addNumber(null, "123-1234-1234", "김동현");
		book.addNumber(null, "010-1234-12341", "추성훈");
		
		book.printGroupList();
		book.printPhoneBook();
		
		book.searchByName("훈");
		
	}
}

