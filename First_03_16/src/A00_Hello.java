// public class의 이름은 반드시 파읾ㅇ과 같아야 한다
public class A00_Hello {
// 빨간줄이 생겼을 때에는 그곳에 커서를 두고 F2를 누르면
// 에러에 대한 정보와 해결책을 볼 수 있다.

	/*
	 *   # main() 함수
	 *   	
	 *   	- 프로그램의 시작 지점
	 *   	- 사용자가 프로그램을 시작하면 가장 먼저 main() 함수를 찾아서 실행시킨다.
	 *   	- main() 함수의 범위는 중괄호{}로 결정 된다.
	 *   
	 *   # 함수란?
	 *   	- 어떤 단어 뒤에 ()가 있는 겅슨 모두 함수라고 부른다.
	 *   
	 *   # System.out.println() 함수
	 *   	- () 안에 전달한 데이터를 콘솔에 출력하는 함수
	 *   
	 *   # 콘솔
	 *   	- 글자만 나오는 검은 화면 ( 옛날 컴퓨터 화면 )
	 *   	- Eclipse에서는 테스트용으로 하얀 바탕의 콘솔을 제공한다.
	 *   	- Ctrl + F11을 누르면 우리가 만든 프로그램을
	 *   	    테스트용 콘솔 상에서 실행해 볼 수 있다.
	 *   	- 우리가 만든 소스 코드(.java)의 결과물(.class)은 bin폴더의 저장되어 있다.
	 *    
	 */
		
	
	// Ctrl + F11
	public static void main(String[] args) {
		// 프로그램 시작
		System.out.println("Hello, world 1");
		System.out.println(12345);// 숫자
		System.out.println("12345" + 5 * 7); //문자
		/*
		 * 	# 자바의 데이터들 ( 리터럴 )
		 *  1. ""사이에 적는 것들 : 문자열(String), 문자를 여러개 쓸 수 있는 데이터 타입
		 *  2. ''사이에 적는 것들 : 문자(Character), 문자 단 하나만 쓸 수 있는 데이터 타입
		 *  3. 숫자			: 정수(Integer)
		 *  4. 실수			: (Float, Double)
		 *  5. true, false
		 *  
		 *  # 문자들은 실제로는 숫자값을 가지고 있다.
		 * 	    우리 눈에 보일때만 문자로 보이는 것
		 * 	  문자끼리 계산도 가능, 문자 정수 서로도 계산 가능
		 */
		System.out.println("ABCDEFG 韓國"); 	// String
		System.out.println('한');			// Char
		System.out.println('글');
		System.out.println('자');
		
		System.out.println(1000 + 500);	 	// int
		System.out.println(123.456 + 10.5);	// float
		
		System.out.println(true);
		System.out.println(false);
		
		System.out.println((int)'A');		//문자의 아스키코드값
		System.out.println((int)'가');
		System.out.println((int)'한');
		System.out.println((char)54621);	//아스키코드값을 문자로 변환
		System.out.println('A' + 1);		//66
		System.out.println((char)('A' + 1)); // B
		
		// # 문자열 타입과 다른 타입을 더하면 계산을 하는것이 아니라 이어붙인다.
		System.out.println("'A'의 보여지는 모습 : " + 'A');
		System.out.println("1" + 5); 	//"15" 
		System.out.println('1' + 5);	// 54  (int)'1' = 49  : 문자 1의 코드값 49 + 5   
		System.out.println(1 + 5 ); 	// 6
		System.out.println((int)'1');
		
		// 프로그램 끝
	}
	

}
