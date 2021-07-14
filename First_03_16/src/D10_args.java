
public class D10_args {

	/*
	 *  main 메소드 첫 번째 매개변수(args)의 역할
	 *  
	 *   - 프로그램 실행시 사용자가 지정한 옵션을 main의 첫 번째 매개변수에 받는다 (콘솔로 java 실행시)
	 *   - 사용자가 지정한 옵션에 따라 다르게  동작하는 프로그램을 만들 수 있다.
	 *  
	 *  프로그램 아규먼트 (String[] args)

		- 프로그램을 실행할 때 넘겨주는 값

		- 예) 클래스 파일 뒤에 "aaa bbb ccc 111 222"와 같은 값을 넘겨줘 보자.
  			> 워크스페이스경로\프로젝트폴더\bin\java -cp bin step08.Test01_1 aaa bbb ccc 111 222

		- 이처럼 클래스 이름 뒤에 값을 주게 되면 공백을 기준으로 문자열을 잘라서 배열에
  		     담아 main() 메서드의 파라미터 값으로 넘어온다. 
	 */
	public static void main(String[] args) {

		System.out.println("args.length : " + args.length);
	}

}
