import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class D07_HashMap {

	/*
	 *  # Map
	 *  
	 *   - Key와 Value가 한 쌍을 이루는 자료구조
	 *   - Key값을 통해 Value에 접근할 수 잇다
	 *   - Key는 중복을 허용하지 않는다
	 */
	
	public static void main(String[] args) {
		HashMap<String, Integer> record = new HashMap<>();
		// put(key, value)
		record.put("홍길동", 50000);
		record.put("고길동", 35000);
		record.put("박길동", 90000);
		
		System.out.println(record);
		// map에 저장되어있는 value값을 증가시키기
		record.put("홍길동", record.get("홍길동")+3000);
		System.out.println("홍길동 : " + record.get("홍길동"));
		
		
		// get(key) : key를 이용해 value를 꺼냄
		System.out.println(record.get("박길동"));
		
		HashMap<String, Object> person = new HashMap<>();
		
		person.put("이름", "홍길동");
		person.put("나이", 35);
		person.put("좋아하는 것", new String[] {"놀기", "잠자기", "먹기"});


		// "싫어하는 것" 에 데이터를 추가해보라.
		person.put("싫어하는 것 리스트", new ArrayList<>());
		person.put("싫어하는 것 세트", new HashSet<>());

		// Map에 hashSet을 이용해 데이터 추가
		((HashSet<String>)person.get("싫어하는 것 세트")).add("공부");
		HashSet<String> dislike = ((HashSet)person.get("싫어하는 것 세트"));
		
		dislike.add("공부");
		dislike.add("코딩");
		
		// Map에 ArrayList를 이용해 데이터 추가
		ArrayList<Object> dislike_list = ((ArrayList)person.get("싫어하는 것 리스트"));
		dislike_list.add("자바");
		dislike_list.add("코딩");
		
		System.out.println(person.get("나이"));
		System.out.println(((String[]) person.get("좋아하는 것"))[0]);

		System.out.println(((HashSet)person.get("싫어하는 것 세트")));
		System.out.println(((ArrayList)person.get("싫어하는 것 리스트")).get(1));
		
		// # 반복문으로 Map 활용
		// keySet() : key들로만 이루어진 Set을 반환
		// values() : value 로만 이루어진 Set 반환
		// entrySet() : Entry<key, value>로 이루어진 Set을 반환한다.
		
		//keySet
		for(String key : person.keySet()) {
			Object value = person.get(key);
			
			// A instanceof B : A가 B의 인스턴스인지를 판별한다. 업캐스팅 상태에서도 판별 된다.
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
		// 해당 key, value가 포함되어 있느지 검사한다
		HashMap<Integer, String> map = new HashMap<>();
		map.put(15, "hi");
		System.out.println("키 중에 15가 있나요 ? " + map.containsKey(15));
		
		System.out.println("값 중에 hi가 있나요 ? " + map.containsValue("hi"));
		
		
		
	}
}
