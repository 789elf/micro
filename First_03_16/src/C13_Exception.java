import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_Exception {

	/*
	 *  # 예외 (Exception)
	 *  
	 *    - 우리가 에러라고 알고 있던 빨간 글씨들을 사실 예외라고 부른다
	 *    - 프로그래머가 발생 가능한 예외를 미리 예상하고 대비해두는 것을 예외처리라고 한다.
	 *    - 자바의 문법을 틀리는 것은 예외가 아니라 컴파일 에러라고 부른다(오타 등)  
	 *    - 프로그래머가 예외에 대하여 적절한 조치를 취해준다면
	 *      프로그램을 강제 종료하지 않고 계속해서 진행할 수 있다
	 *    - 메서드에 마우스를 올려보면 어떤 예외가 발생할 지에 대한 정보를 알 수 있다
	 *    
	 *   # 예외처리
	 *     
	 *     - 예외가 발생할 가능성이 있는 코드를 try문 내부에 포함시킨다
	 *     - try문 내부에 있는 코드는 예외가 발생하지 않으면 모두 정상 실행된다
	 *     - try문 내부에서 예외가 발생하는 경우 실행이 즉시 중단되고
	 *       해당 예외를 담당하는 catch문으로 이동하게 된다.
	 *     - catch문에는 발생한 예외에 대한  정보를 담고 있는 인스턴스가 도착하게 된다
	 *     - catch문은 여러개 중첩해서 사용할 수 있다.
	 *     
	 *    # finally
	 *     - 예외가 발생하든 안하든 실행하고 싶은 코드는 finally에 작성한다. ( return을 만나면 catch가 끝나는데 그 와중에도 finally에 있는건 실행이 된다)
	 */
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println(" 숫자만 입력하세요. ");
		
		try{
			a = sc.nextInt();
		} catch(InputMismatchException e) {
//			e.printStackTrace();
			System.out.println(e);
			a = -1;
		} catch(IllegalStateException e) {
			System.out.println("스캐너가 닫혀있는데");
			a = -1;
		} catch(NoSuchElementException e) {
			System.out.println("스캐너에 읽을 내용이 없는데");
			a = -1;
		} finally {
			System.out.println(" /)/)");
			System.out.println("(  ..)");
			System.out.println("(  >$");
		}
		
		System.out.println("입력하신 숫자: " + a);
		System.out.println("프로그램 종료");
		}
}
	
