import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;

public class D08_String {

	public static void main(String[] args) {
		
		String fruits = "apple/banana/orange/kiwi/pineapple";
		
		// split(delimiter) : ���ڿ��� ���ϴ� �������� �ڸ� �� ���ڿ� �迭�� ��ȯ
		
		String[] splitted_fruits = fruits.split("/");
		
		System.out.println(Arrays.toString(splitted_fruits));
		
		for (String fruit : splitted_fruits) {
			System.out.println(fruit);
		}
		
		// join(delim, �̾������ ���� ��) : �ڿ� ������ ���ڿ����� ��� delim���� �̾� ������. (for each ������ value �ϳ��� �̾Ƽ� ������ ���� )
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
		
		
		// substring(start) : start���� ������ ���� ���ڿ��� �߶� ��ȯ
		// substring(start, end) : start���� end�̸� ���� ���ڿ��� �߶� ��ȯ   ( �̻� , �̸�)
		System.out.println("Hello, everyone".substring(3));
		System.out.println("Hello, everyone".substring(0, 5));
		
		
		// replace() : ���ڿ� ġȯ
		String emails = "abc123@naver.com, abc1234@naver.com";
		String replaced = emails.replace("naver.com", "gmail.com");
		System.out.println(replaced);
		
		// format(format, value) : ������ �̿��� ���ϴ� ���ڿ� ����
		String text = String.format("������ %c���� �Դϴ�.", '��');
		System.out.println(text);
		
		// contains(seq) : ���ڿ��� �ش� ���ڿ��� ���ԵǾ� �ִ��� �˻� 
		System.out.println("pineapple".contains("apple"));
		
		// startsWith(seq) : ���ڿ��� �ش� ���ڿ��� �����ϴ��� �˻�
		System.out.println("pineapple".startsWith("pine"));
		
		// endsWith(seq) : ���ڿ��� �ش� ���ڿ��� �������� �˻�
		System.out.println("resource/image/���.jpeg".startsWith("resource/image/"));
		System.out.println("resource/image/���.jpeg".endsWith(".jpeg"));
		
		// getBytes() : ���ڿ��� byte[] �� ��ȯ�Ѵ� (������ ���� �غ�)
		String data = "�ȳ��ϼ���";
		
		byte[] byte_arr = null; 
		try{
			byte_arr = data.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		// �����ڸ� �̿��� byte[] �� �ٽ� ���ڿ��� ��ĥ �� �ִ� (���� ���� �����͸� ��ȯ)
		try {
			System.out.println(new String(byte_arr,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		// trim() : ���ڿ� �ٱ����� ������ ������ �ش�
		String str1 = "  abc123 "; 		// => "abc123"
		String str2 = "abc123   ";		// => "abc123"
		String str3 = " Hello Java  ";	// => "Hello Java";
		
		str1 = str1.trim();
		str2 = str2.trim();
		
		System.out.println(str1.equals(str2));
		
		// toUpperCase(), toLowerCase() : ���ڿ��� ��� ��/ �ҹ��ڷ� ��ȯ�� ���ο� �ν��Ͻ� ��ȯ
		System.out.println(str3.toUpperCase().trim()); // �빮�ڷ� ��ȯ �� ��,�� ���� ����
		
		// ���ڿ� �� ���� �빮�� �ҹ��ڷ� ���� �� ���ϱ�
		str1 = "jaVa";
		str2 = "jAvA";
		
		System.out.println(str1.equals(str2));	// false
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		System.out.println(str1.equals(str2)); 	// true
		
		// equalsIgnoreCase() : ��ҹ��� ��� ���� equals
		System.out.println("equals: " + str1.equals(str2.toLowerCase()));	 // false
		System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase(str2.toLowerCase()));  // true
		
		// getChars(start, end, ������, ������ ��������) : char[]�� ���ڿ��� ���ϴ� �κ��� ���� �� �ִ�.
		// ������ �������� : 1�̸� �迭�� �� ���� �������� ä��� (�ε��� ���� ���� ) 
		char[] buffer = new char[10];
		
		"Hello, world!!".getChars(7, 12, buffer, 0);
		
		System.out.println(buffer);
		
		// Arrays.fill(char[], ä�� ����) : �迭�� ����� ä�� ���ڸ� ä���ش�
		char[] fill_arr = new char[10];
		Arrays.fill(fill_arr, '#');
		
		System.out.println(fill_arr);
		"Hello, world!!".getChars(7, 12, fill_arr, 3); //���ڿ��� 7��°���� �����ؼ� 12��° �� ���� fill_arr�� 3��° �ε������� ��´�  
		
		System.out.println(fill_arr);
		
		
	}
	
}
