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
	 *  # HashMap�� �̿��� ��ȭ��ȣ�θ� ����
	 *  
	 *  1. �׷� / ��ȭ��ȣ / �̸��� ����
	 *  2. �׷� �̸��� Ű������ ������ �ش� �׷��� ��ȭ��ȣ ����� ���´�
	 *  3. ��ȭ��ȣ ��Ͽ� ��ȭ��ȣ�� Ű������ ������ �̸��� ���´�
	 *  
	 *  # �޼ҵ�
	 *  
	 *  1. ���ο� �׷��� �߰��ϴ� �޼ҵ�
	 *  2. �����ϴ� �׷쿡 ���ο� ��ȭ��ȣ�� ����ϴ� �޼ҵ� (�׷��� ���ٸ� �̺з� �׷쿡 ����)
	 *  3. ��ϵ� ��ȭ��ȣ�� �̸����� ������������ �����ִ� �޼ҵ�
	 *  4. �̸��� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ������ ��µǴ� �˻� �޼ҵ�
	 *  5. ��ȭ��ȣ�� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ��ȭ��ȣ�� ��µǴ� �˻� �޼ҵ�
	 *  
	 */
	static Scanner sc = new Scanner(System.in);
	HashMap<String,Object> group_map = new HashMap<>();
	HashMap<String,Object> phone_map = new HashMap<>();
	TreeSet<GroupInfo> name_set = new TreeSet<>();
	HashSet<String> phone_set = new HashSet<>();
	
	// �׷� �˻�
	public void groupSearch() {
		System.out.println("�˻��� �׷� > ");
		String str = sc.next();
		if(!group_map.containsKey(str)) {
			System.out.println("�׷��� �������� ����");
			return;
		}
		System.out.println(group_map.get(str));
	}
	// ��ȭ��ȣ�� �̸� �˻�
	public void phoneSearch() {
		System.out.println("�˻��� �̸��� ��ȭ ��ȣ > ");
		String phone_number = sc.next();
		
		if(!phone_map.containsKey(phone_number)) {
			System.out.println("��ȭ��ȣ�� �������� ����");
			return;
		}
		System.out.println(phone_map.get(phone_number));
	}
	
	// �����ϴ� �׷쿡 ���ο� ��ȭ��ȣ�� ����ϴ� �޼ҵ�
	public void setGroup() {
		System.out.println("��ȣ�� �߰��� �׷� > ");
		String group_name = sc.next();
		
		System.out.println("�߰��� ��ȣ > ");
		String phone_number = sc.next();
		
		System.out.println("�̸� > ");
		String name = sc.next();
		// �׷� �̸��� �������� �ʴ´ٸ� �޽��� ���
		if(!group_map.containsKey(group_name)) {
			System.out.println("�Է��� �׷��� �������� ���� (�̺з�) �׏��� �߰� ��");
		}
		// �̺з� �׷��� ���� ���ٸ� �̺з� �׷��� �����ϰ� ��ȣ �߰�
		if(!group_map.containsKey("�̺з�")) {
			group_map.put("�̺з�", new HashSet<>());
			((HashSet<String>)group_map.get("�̺з�")).add(phone_number);
		}
		// �̺з� �׷��� �ִٸ� ��ȣ �߰�
		else {
			((HashSet<String>)group_map.get("�̺з�")).add(phone_number);
		}

		phone_map.put(phone_number, name);	// ��ȭ��ȣ map�� ��ȣ, �̸� �߰�
		phone_set.add(phone_number);		// HashSet�� ��ȣ �߰�
		name_set.add(new GroupInfo(name));	// TreeSet�� �̸� �߰� 
	}
	
	// ���ο� �׷� �߰�
	public void groupAdd() {
		
		System.out.println("�߰��� �׷� �̸� > ");
		String group_name = sc.next();
		group_map.put(group_name, new HashSet<>());
		
		System.out.println("�Է��� ��ȭ��ȣ ���� > ");
		int loop = sc.nextInt();
		
		// loop ��ŭ �ݺ�
		for(int i=0; i<loop; i++) {
			
			System.out.println((i+1) + "��°�� �Է��� ��ȭ��ȣ > ");
			String phone_number = sc.next();
			//��ȣ �߰� 
			((HashSet<String>)group_map.get(group_name)).add(phone_number);
			
			System.out.println(phone_number + "�� ������ �̸� > ");
			String name = sc.next();
			
			phone_map.put(phone_number, name);
			phone_set.add(phone_number);
			name_set.add(new GroupInfo(name));
		}
	}
	
	// �̸��� �Ϻθ� �˻��ϸ� ��� ������ ���
	public void nameSearch() {
		System.out.println("�̸� �Է� > ");
		String input_name = sc.next();
		
		String name;
		System.out.println("�̸�\t��ȣ");
		
		for(String key : phone_map.keySet()) {
			name = (String) phone_map.get(key);

			if(name.contains(input_name)){
				System.out.print(name + "\t" + key + "\n");
			}
		}
	}
	// ��ȭ��ȣ �Ϻ� �˻�
	public void numberSearch() {
		System.out.println("��ȭ��ȣ �Է� > ");
		String input_number = sc.next();

		for(String number : phone_set) {
			
			if(number.contains(input_number)) {
				System.out.println(number);
			}
		}
	}
	
	// ��� �̸� �������� ���
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
			System.out.println("1.�׷� �˻�  2.�̸� �˻�  3.�׷� �߰�  4.��ȭ��ȣ �߰�  5.�̸� �˻�(�Ϻ�)  "
					+ "6.��ȭ��ȣ �˻�(�Ϻ�)  7.��� �̸� �˻�   0. ����");
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
