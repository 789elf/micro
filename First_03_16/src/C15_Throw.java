import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C15_Throw {

	/*
	 *  # throw
	 *  
	 *  - 원하는 예외를 발생시킨다
	 *  
	 *  # throws
	 *  
	 *  - 해당 메서드에서 이러한 예외들을 발생시킨다는 것을 알린다
	 *  - 해당 메서드를 호출하는 곳에 경고를 해줄 수 있다.
	 *  
	 *  # Exception 클래스를 상속받은 예외는 " 반드시 처리해야 하는 예외 "
	 *    - Exception은 예외처리를 하지 않으면 컴파일 에러를 발생시킨다
	 *    
	 *  
	 *  # RuntimeException 클래스를 상속받은 예외는 "꼭 처리하지 않아도 되는 예외" 가 된다.
	 *    (InputMismachException, ArrayIndexOutOfBoundException등 컴파일 에러는 발생하지 않는다)  
	 */

	
	public static void main(String[] args) {
		C15_Throw instance = new C15_Throw();
	
		try {
			instance.dangerous_method();
			instance.dangerous_method2();
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 터짐" + e.getMessage());
		}
		
		try {
			instance.checkEven(20);
			instance.checkOdd(20);
		} catch (NotEvenException e) {
			System.out.println("짝수 아님");
		} catch(NotOddException e) {
			System.out.println("홀수 아님");
		}
	}
	
	//이 메소드에서 예외처리를 미룬다.
	public void dangerous_method() throws FileNotFoundException {
		// 파일의 내용을 읽어오는 준비 과정
		File f = new File("E:\\kg-ac\\temp\\nameless.txt");
		FileReader reader = new FileReader(f);
	}
	
	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("그냥 만듬");
	}
	
	public void checkEven(int num) throws NotEvenException{
		if(num % 2 == 0) {
			System.out.println("짝수 입니다");
		}else {
			throw new NotEvenException();
		}
		System.out.println("checkEven 메서드가 정상 종료");
	}
	
	public void checkOdd(int num){
		if(num % 2 == 1) {
			System.out.println("홀수 입니다");
		}else {
			throw new NotOddException();
		}
		System.out.println("checkOdd 메서드가 정상 종료");
	}
}

// 짝수가 아닐때 발생 시킬 예외 (예외처리 하지 않으면 컴파일 불가)
class NotEvenException extends Exception{ 
	public NotEvenException() {
		super("짝수가 아니어서 발생하는 예외");
	}
}

// 홀수가 아닐 때 발생시킬 예외 ( 예외처리 하지 않아도 빨간줄이 안뜨는 예외)
class NotOddException extends RuntimeException{
	public NotOddException() {
		super("홀수가 아니어서 발생하는 예외");
	}
}