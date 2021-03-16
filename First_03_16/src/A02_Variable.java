
public class A02_Variable {

	public static void main(String[] args) {

		/*
		 *  # 변수 (variable)
		 *  	- 데이터를 담을 수 있는 공간
		 *  	- 자바에서는 변수를 반드시 선언한 뒤에 사용해야 한다.
		 *  	- 변수 선언시에는 그 변수에 저장될 데이터의 타입을 정해줘야 한다.
		 *  	- ""나 ''가 없는 모든 문자열 또는 문자는 변수다.
		 *  	- 같은 이름의 변수는 다시 선언할 수 없다.
		 *  
		 *  # 변수의 선언 ( declare, declaration )
		 *  	타입 변수명; -> int a, char b
		 *  # 변수의 타입
		 *  	- int : 정수만 저장할 수 있는 변수 타입
		 *  
		 *  # = 의미 
		 *  	프로그래밍 언어에서 =의 의미는 왼쪽의 변수에 오른쪽의 값을 넣어라 
		 *  
		 */
		
		int a = 10;
		int apple = a + 50;
		
		System.out.println(a);
		System.out.println(apple);
		
		a = 50;
		System.out.println(a);
		
		// 여러가지 변수 선언 방식
		//선언한 변수에 최초로 값을 대입하는 것을 '초기화(initialize, init)' 라고 한다.
		int b;
		//System.out.println(b); 값이 한번도 대입된적이 없는 변수는 사용할 수 없다. ( 초기화 되지 않은 변수 )
		int c,d;
		int e = 55;
		int f = 99, g = 999;
		System.out.println("f에 들어있는 값: " + f);
		System.out.println("g에 들어있는 값: " + g);
		
	}
}
