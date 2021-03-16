
public class A03_VarTypes {

	public static void main(String[] args) {
		/*
		 * 	# 정수 타입  ( 1byte -> 8bit ) (1비트 = 1전구)
		 * 
		 * 		0000 0000 (0) ~ 1111 1111 (255)
		 * 		
		 * 		*첫 번째 bit는 부호 비트로 사용된다. (0은 양수 1은 음수)
		 * 		byte타입의 양수 범위  0000 0000 (0) ~ 0111 1111 (127)
		 * 		byte타입의 음수 범위  1000 0000 (-128) ~ 1111 1111 (-1) 양수 음수 반대로 계산해서 1000 0000 이 -128
		 * 
		 * 		1bit : 2 ^ 1 - 2가지
		 * 		2bit : 2 ^ 2 - 4가지
		 * 		3bit : 2 ^ 3 - 8가지
		 * 		4bit : 2 ^ 4 - 16가지
		 * 		5bit : 2 ^ 5 - 32가지
		 * 		6bit : 2 ^ 6 - 64가지
		 *		7bit : 2 ^ 7 - 128가지
		 *		8bit : 2 ^ 8 - 256가지
		 *   
		 * 		- byte (1byte) (2 ^ 8 : 256가지, 양/음수범위 0 ~ 255 / -256 ~ -1)
		 * 		- short(2byte) (2 ^ 16: 65536가지, 양/음수범위 : 0 ~ 32767 / -32768 ~ -1)
		 * 		- char (2byte) (2 ^ 16: 65536가지, 양수만 나타냄, 부호가 없기(unsigned) 때문에 0 ~ 65535의 양수만 저장할 수 있는 타입 주로 문자 코드를 저장하는데에 사용한다(문자타입))  
		 * 		- int  (4byte) (2 ^ 32: 43억가지)
		 * 		- long (8byte) (2 ^ 64)
		 * 
		 * */
		
		byte min_Byte = -128;
		byte max_Byte = 127;
		System.out.println(
				"byte타입에 저장할 수 있는 가장 큰 값은"+max_Byte+"이고,"
						+ "가장 작은 값은"+min_Byte+"입니다.");
		
		short min_Short = -32768;
		short max_Short = 32767;
		System.out.println(
				"short타입에 저장할 수 있는 가장 큰 값은"+max_Short+"이고,"
						+ "가장 작은 값은"+min_Short+"입니다.");
		
		char max_Char = 65535;
		char min_Char = 0;
		
		char ch = 65;
		System.out.println("char타입에 저장된 값은 기본적으로 문자로 출력된다."+ch);
		System.out.println("char타입에 저장된 코드값을 확인하고 싶으면 앞에(int)를 붙힌다.");
		
		System.out.println(
				"char타입에 저장할 수 있는 가장 큰 값은"+(int)max_Char+"이고,"
						+ "가장 작은 값은"+(int)min_Char+"입니다.");

		int max_Int = 2_147_483_647;
		int min_Int = -2_147_483_648;
		System.out.println(
				"int타입에 저장할 수 있는 가장 큰 값은"+max_Int+"이고,"
						+ "가장 작은 값은"+min_Int+"입니다.");
		
		long _long = 2_147_483_648L; //int의 범위를 넘어가는 숫자를 사용할 때는 뒤에 L을 붙혀야한다.
		
		/*
		 *	# 실수 타입
		 *
		 *		- flaot (4byte)
		 *		- double(8byte)
		 *
		 *		실수는 주로 그래픽 계산에 사용된다.
		 *		부동소수점 방식을 사용한다.
		 */
		
		// 그냥 소수만 적는것은 기본적으로 double타입이다.
		// float타입의 소수는 뒤에 F를 붙혀야 한다.
		float weight = 65.66F;  //뒤에 F
		double height = 177.77;
		
		/*
		 *	# boolean 타입
		 *
		 *		참과 거짓을 표현하는데에 사용되는 타입
		 *		값은 true/false밖에 없다
		 */
		//boolean
		boolean has_Food = true;
		boolean is_Child = true;
		
		/*
		 *	# 참조형 타입 ( 클래스 타입 )
		 *		참조형 타입은 기본형 타입들과는 다르게 대문자로 시작한다.
		 *			- String : 문자열 ( 참조형중에서 참조 안하고 사용하는 것 )
		 *			- 그 외 모든 클래스들  
		 */
		//참조형 타입
		String hello_Message = "Hello, My name is John Doe.";
		String bye_Message = "Good bye. ";
		System.out.println(hello_Message);
		System.out.println("hello_Message");
		
		System.out.println(bye_Message + bye_Message + bye_Message);
		


	}
}
