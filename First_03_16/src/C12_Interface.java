
public class C12_Interface {

	/*
	 *	# 인터페이스
	 *
	 *	- abstract class는 상속을 여러개 받을 수 없다는 단점을 보완한 것
	 *	- 인터페이스 내부의 메소드는 자동으로 abstract public이 된다 (강제로 메소드를 구현해야 한다)
	 *  - 인터페이스 내부의 변수는 자동으로 final static이 된다
	 *  - 인터페이스 내부의 메서드를 정의할 때 default 를 붙히면 기본 동작을 설정할 수 있다
	 */
	
	public static void main(String[] args) {
		new OrangeTree().click();
	}
}

interface CanClick{
	int a = 10;			 	  // 자동으로 final static
	default void click() {	      // abstract public이 자동으로 붙어있다
		System.out.println("클릭 인터페이스가 달려있는 클래스의 기본 동작. (오버라이드 해서 사용하세요)");
	}
}
interface CanPunch{
	abstract void punch();
}

class OrangeTree implements CanClick, CanPunch{
	@Override
	public void click() {
	}
	@Override
	public void punch() {
		
	}
}
