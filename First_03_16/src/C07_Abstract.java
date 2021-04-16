
public class C07_Abstract {

	/*
	 *  # 추상 클래스
	 *  
	 *    - 완성을 자식 클래스에게 미루는 클래스
	 *    - 추상메소드를 하나라도 갖고 있다면 추상 클래스
	 *    
	 *  # 추상 메소드
	 *    - 함수의 형태(리턴 타입, 접근 제어자, 매개변수)만 정해놓고 자세한 구현은
	 *      자식 클래스에서 오버라이드를 통해 구현하는 메소드
	 *      
	 *    - 자식 클래스에서 오버라이드 하지 않으면 컴파일 에러가 발생한다 (필수)
	 */
	public static void main(String[] args) {
		Vehicle v1 = new Bus();
		
		//익명 클래스
		Vehicle v2 = new Vehicle() {
			
			@Override
			void ride() {
				System.out.println("즉석에서 구현한 탈 것");
			}
		};
		
		v1.ride();
		v2.ride();
	}
}

abstract class Vehicle{
	
	abstract void ride();
}

class Bus extends Vehicle{
	
	@Override
	void ride() {
		System.out.println("요금을 내고 타야함");
	}
}
class Bike extends Vehicle{

	// 오버라이드 조건 (같은 함수명, 같은 리턴 타입, 같은 매개 변수)
	@Override 
	void ride() {
		
	}
}