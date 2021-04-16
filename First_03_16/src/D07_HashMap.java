import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class D07_HashMap {

	/*
	 *  # Map
	 *  
	 *   - Key�� Value�� �� ���� �̷�� �ڷᱸ��
	 *   - Key���� ���� Value�� ������ �� �մ�
	 *   - Key�� �ߺ��� ������� �ʴ´�
	 */
	
	public static void main(String[] args) {
		HashMap<String, Integer> record = new HashMap<>();
		// put(key, value)
		record.put("ȫ�浿", 50000);
		record.put("��浿", 35000);
		record.put("�ڱ浿", 90000);
		
		System.out.println(record);
		// map�� ����Ǿ��ִ� value���� ������Ű��
		record.put("ȫ�浿", record.get("ȫ�浿")+3000);
		System.out.println("ȫ�浿 : " + record.get("ȫ�浿"));
		
		
		// get(key) : key�� �̿��� value�� ����
		System.out.println(record.get("�ڱ浿"));
		
		HashMap<String, Object> person = new HashMap<>();
		
		person.put("�̸�", "ȫ�浿");
		person.put("����", 35);
		person.put("�����ϴ� ��", new String[] {"���", "���ڱ�", "�Ա�"});


		// "�Ⱦ��ϴ� ��" �� �����͸� �߰��غ���.
		person.put("�Ⱦ��ϴ� �� ����Ʈ", new ArrayList<>());
		person.put("�Ⱦ��ϴ� �� ��Ʈ", new HashSet<>());

		// Map�� hashSet�� �̿��� ������ �߰�
		((HashSet<String>)person.get("�Ⱦ��ϴ� �� ��Ʈ")).add("����");
		HashSet<String> dislike = ((HashSet)person.get("�Ⱦ��ϴ� �� ��Ʈ"));
		
		dislike.add("����");
		dislike.add("�ڵ�");
		
		// Map�� ArrayList�� �̿��� ������ �߰�
		ArrayList<Object> dislike_list = ((ArrayList)person.get("�Ⱦ��ϴ� �� ����Ʈ"));
		dislike_list.add("�ڹ�");
		dislike_list.add("�ڵ�");
		
		System.out.println(person.get("����"));
		System.out.println(((String[]) person.get("�����ϴ� ��"))[0]);

		System.out.println(((HashSet)person.get("�Ⱦ��ϴ� �� ��Ʈ")));
		System.out.println(((ArrayList)person.get("�Ⱦ��ϴ� �� ����Ʈ")).get(1));
		
		// # �ݺ������� Map Ȱ��
		// keySet() : key��θ� �̷���� Set�� ��ȯ
		// values() : value �θ� �̷���� Set ��ȯ
		// entrySet() : Entry<key, value>�� �̷���� Set�� ��ȯ�Ѵ�.
		
		//keySet
		for(String key : person.keySet()) {
			Object value = person.get(key);
			
			// A instanceof B : A�� B�� �ν��Ͻ������� �Ǻ��Ѵ�. ��ĳ���� ���¿����� �Ǻ� �ȴ�.
			if(value instanceof String[]) {
				String[] arr = (String[]) value;
				
				System.out.print("[");
				
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i] + ", ");
				}
				System.out.println("]");
			}else {
				System.out.println(key + ": " + value);
			}
		}

		// values()
		System.out.println("values : " + person.values());
		
		// entrySet()
		for(Entry<String,Object> entry : person.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			System.out.println(key + "=" + value);
		}
		
		// containsKey(key), containsValue(value)
		// �ش� key, value�� ���ԵǾ� �ִ��� �˻��Ѵ�
		HashMap<Integer, String> map = new HashMap<>();
		map.put(15, "hi");
		System.out.println("Ű �߿� 15�� �ֳ��� ? " + map.containsKey(15));
		
		System.out.println("�� �߿� hi�� �ֳ��� ? " + map.containsValue("hi"));
		
		
		
	}
}
