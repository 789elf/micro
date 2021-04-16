import java.util.Random;

public class B16_Random {

	public static void main(String[] args) {

		/*
		 * 	# JAVA에서 무작위 숫자 생성
		 * 	
		 * 	1. Math.random()
		 * 
		 * 	 - double 타입의 랜덤 소수를 생성한다
		 * 	 - 0 <= x < 1
		 * 
		 *  # 원하는 범위의 숫자를 만드는 순서 (ex: 30 ~ 60)
		 *  
		 *	 (1) 생성된 랜덤 소수에 원하는 숫자의 갯수를 곱한다 (31개)
		 *		(0 * 31 <= x < 1 * 31)
		 *	 
		 *	 (2) 원하는 숫자 중 가장 작은 숫자를 더한다
		 *		(0 * 31 + 30 <= x < 1 * 31 + 30) -->  30 <=x <61
		 *	 
		 *	 (3) 소숫점 아래를 삭제한다
		 *		Math.floor()   or   (int)
		 */
		
		for(int i=0; i<10;i++) {
//			System.out.println((int)(Math.random() * 31 + 30));
		}
		
		// 연습문제: 1 ~ 45의 랜덤 숫자를 7개 출력
		for(int i=0; i<10;i++) {
//			System.out.println((int)(Math.random() * 45 + 1));
		}
		
		/*
		 * 
		 *  2. Random 클래스
		 *   - 좀 더 편리하게 랜덤 값을 선택할 수 있는 기능들이 모여있는 클래스
		 *   - 생성할 때 무작위 랜덤 시드가 선택된다.
		 *   - 원하는 랜덤 시드를 선택할 수 있다.
		 */
		
		//	# 새로운 랜덤 시드 생성
		Random ran = new Random();
		
		// # Random.nextInt(bound)
		// 
		System.out.println(ran.nextInt(45) +1);  //1 ~ 45
		System.out.println(ran.nextInt(41) +30); //30 ~ 70
//		System.out.println(ran.nextInt());
		
		//boolean 타입도 가능
		System.out.println(ran.nextBoolean() ? "앞" : "뒤");
	}

}
