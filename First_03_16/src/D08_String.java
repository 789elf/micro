import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;

public class D08_String {

	public static void main(String[] args) {
		
		String fruits = "apple/banana/orange/kiwi/pineapple";
		
		// split(delimiter) : 문자열을 원하는 기준으로 자른 후 문자열 배열로 반환
		
		String[] splitted_fruits = fruits.split("/");
		
		System.out.println(Arrays.toString(splitted_fruits));
		
		for (String fruit : splitted_fruits) {
			System.out.println(fruit);
		}
		
		// join(delim, 이어붙히고 싶은 것) : 뒤에 나오는 문자열들을 모두 delim으로 이어 붙힌다. (for each 문으로 value 하나씩 뽑아서 붙히는 느낌 )
		String join_result1 = String.join(" ", splitted_fruits);
		String join_result2 = String.join("-", "Java", "is", "cook");
				
		System.out.println(join_result1);
		System.out.println(join_result2);
		
		HashSet<StringBuilder> set = new HashSet<>();
		
		set.add(new StringBuilder("Hello"));
		set.add(new StringBuilder("my name is"));
		set.add(new StringBuilder("John Doe"));
		
		String join_result3 = String.join("--", set);
		
		System.out.println(join_result3);
		
		
		// substring(start) : start부터 마지막 까지 문자열을 잘라서 반환
		// substring(start, end) : start부터 end미만 까지 문자열을 잘라서 반환   ( 이상 , 미만)
		System.out.println("Hello, everyone".substring(3));
		System.out.println("Hello, everyone".substring(0, 5));
		
		
		// replace() : 문자열 치환
		String emails = "abc123@naver.com, abc1234@naver.com";
		String replaced = emails.replace("naver.com", "gmail.com");
		System.out.println(replaced);
		
		// format(format, value) : 서식을 이용해 원하는 문자열 생성
		String text = String.format("오늘은 %c요일 입니다.", '수');
		System.out.println(text);
		
		// contains(seq) : 문자열에 해당 문자열이 포함되어 있는지 검사 
		System.out.println("pineapple".contains("apple"));
		
		// startsWith(seq) : 문자열이 해당 문자열로 시작하는지 검사
		System.out.println("pineapple".startsWith("pine"));
		
		// endsWith(seq) : 문자열이 해당 문자열로 끝나는지 검사
		System.out.println("resource/image/펭귄.jpeg".startsWith("resource/image/"));
		System.out.println("resource/image/펭귄.jpeg".endsWith(".jpeg"));
		
		// getBytes() : 문자열을 byte[] 로 변환한다 (데이터 전송 준비)
		String data = "안녕하세요";
		
		byte[] byte_arr = null; 
		try{
			byte_arr = data.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// 생성자를 이용해 byte[] 를 다시 문자열로 합칠 수 있다 (전달 받은 데이터를 변환)
		try {
			System.out.println(new String(byte_arr,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		// trim() : 문자열 바깥쪽의 공백을 제거해 준다
		String str1 = "  abc123 "; 		// => "abc123"
		String str2 = "abc123   ";		// => "abc123"
		String str3 = " Hello Java  ";	// => "Hello Java";
		
		str1 = str1.trim();
		str2 = str2.trim();
		
		System.out.println(str1.equals(str2));
		
		// toUpperCase(), toLowerCase() : 문자열을 모두 대/ 소문자로 변환한 새로운 인스턴스 반환
		System.out.println(str3.toUpperCase().trim()); // 대문자로 변환 후 앞,뒤 공백 제거
		
		// 문자열 비교 전에 대문자 소문자로 통일 후 비교하기
		str1 = "jaVa";
		str2 = "jAvA";
		
		System.out.println(str1.equals(str2));	// false
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		System.out.println(str1.equals(str2)); 	// true
		
		// equalsIgnoreCase() : 대소문자 상관 없는 equals
		System.out.println("equals: " + str1.equals(str2.toLowerCase()));	 // false
		System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase(str2.toLowerCase()));  // true
		
		// getChars(start, end, 담을곳, 담을곳 시작지점) : char[]에 문자열의 원하는 부분을 담을 수 있다.
		// 담을곳 시작지점 : 1이면 배열의 맨 앞을 공백으로 채운다 (인덱스 에러 조심 ) 
		char[] buffer = new char[10];
		
		"Hello, world!!".getChars(7, 12, buffer, 0);
		
		System.out.println(buffer);
		
		// Arrays.fill(char[], 채울 문자) : 배열의 빈곳에 채울 문자를 채워준다
		char[] fill_arr = new char[10];
		Arrays.fill(fill_arr, '#');
		
		System.out.println(fill_arr);
		"Hello, world!!".getChars(7, 12, fill_arr, 3); //문자열의 7번째부터 시작해서 12번째 전 까지 fill_arr에 3번째 인덱스부터 담는다  
		
		System.out.println(fill_arr);
		
		
	}
	
}
