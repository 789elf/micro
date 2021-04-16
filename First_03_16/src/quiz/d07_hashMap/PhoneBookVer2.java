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
		
		phonebook.put("�̺з�", new HashMap<>());
		phonebook.put("����", new HashMap<>());
		phonebook.put("����", new HashMap<>());
		phonebook.put("ģ��", new HashMap<>());
		
		phonebook.get("����").put("010-1234-1234","����");
	}
	
	public boolean addGroup(String groupName) {
		if(phonebook.containsKey(groupName)) {
			System.out.println("�̹� �����ϴ� �׷� : " + groupName);
			return false;
		}else {
			System.out.println("���������� �߰� : " + groupName);
			phonebook.put(groupName, new HashMap<>());
			return true;
		}
	}
	
	// �׷� ����Ʈ
	public void printGroupList() {
		for(String groupName : phonebook.keySet()) {
			System.out.printf("#### %s ####\n", groupName);
		}
	}

	// ��ȣ �߰�
	public boolean addNumber(String groupName, String phoneNumber, String name) {
		for(HashMap<String, String> group : phonebook.values()) {
			if(group.containsKey(phoneNumber)) {
				System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�.");
				return false;
			}
		}
		if(phonebook.containsKey(groupName)) {
			phonebook.get(groupName).put(phoneNumber,name);
		}else {
			phonebook.get("�̺з�").put(phoneNumber, name);
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
					
					// �̸����� 1�� ���� �� , ��ȭ��ȣ �������� 2�� ���� 
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
	
	// �̸� �˻�
	public void searchByName(String keyword) {
		int count = 0;
		
		System.out.println("�˻� ���");
		for(HashMap<String, String> group : phonebook.values()) {
			
			for(Entry<String, String> entry : group.entrySet()) {
				
				if(entry.getValue().contains(keyword)) {
					
					System.out.printf("%s : %s\n",entry.getValue(),entry.getKey());
					count++;
				}
			}
		}
		System.out.printf("�˻� ��� %d�� \n", count);
	}
	
	// ��ȣ �˻�
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
//			System.out.println("�׷� �̸��� �Է� >> ");
//			book.addGroup(sc.nextLine());
//			
//			book.printGroupList();
//		}
		
		book.addGroup("����");
		book.addGroup("��ȣȸ");
		book.addGroup("�ʵ��б� ��â");
		book.addGroup("���б� ��â");
		book.addGroup("����б� ��â");
		book.addGroup("�����");
		
		book.addNumber(null, "123-1234-1234", "�赿��");
		book.addNumber(null, "010-1234-12341", "�߼���");
		
		book.printGroupList();
		book.printPhoneBook();
		
		book.searchByName("��");
		
	}
}

