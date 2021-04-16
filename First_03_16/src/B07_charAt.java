
public class B07_charAt {

	public static void main(String[] args) {

		/*
		 * 	# "문자열".charAt(index);
		 * 	- 해당 문자열에서 원하는 번째의 문자를 char타입으로 꺼내는 함수
		 * 	- 첫번째 문자는 0
		 * 
		 * 	# "문자열".length();
		 * 	- 함수를 실행하면 해당 문자열의 길이를 int타입으로 알려준다.
		 * 
		 *  
		 */
		System.out.println("Hello, everyone!!!".charAt(0));
		System.out.println("Hello, everyone!!!".charAt(1));
		System.out.println("Hello, everyone!!!".charAt(10));
		
		String str = "Hello, everyone!!!!";
		
		System.out.println(str.charAt(7));
		System.out.println(str.length());
	}
}
