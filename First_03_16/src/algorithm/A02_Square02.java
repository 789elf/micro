package algorithm;

public class A02_Square02 {

	public static void main(String[] args) {

		/*
		 * 기존의 네모가 아닌 ㄹ 자 형태로 출력
		 */
		
		int num = 5;		// 사각형 크기
		int reverse = 0;	// 반대로 출력될 때 사용될 변수
		
		int square;			// 반대로 출력될 때 사용될 변수 2
		int cnt = 1;		// 숫자 출력될 때 사용될 변수

		// num 크기 만큼 반복 ( 2중 for문 총 num * num 만큼 반복 )
		for (int i = 0; i < num; i++) {
			
			//square num 값으로 초기화
			square = num;	
			
			for (int j = 0; j < num; j++) {
				
				// reverse가 짝수라면 정상적으로 출력 
				if (reverse % 2 == 0) {		

					System.out.printf("%3d ", cnt);  
					
				// reverse가 홀수라면 역순으로 출력
				} else if (reverse % 2 != 0) {
					
					// 아래 식 대로 출력후 square -2 씩 해주면 정상적으로 역순으로 출력
					// cnt는 1씩 증가 , 출력되어야할 수는 1씩 감소 총 2씩 마이너스를 해주고,  
					// 현재 수(cnt)에서 (square -1)값을 출력해주면 정상적으로 역순으로 출력된다.
					
					System.out.printf("%3d ", cnt + (square - 1));
					square = square - 2;
					
				}
				//반복문 한번 끝날때마다 값 + 1
				cnt++;
			}
			//2번째 for문 나갈때마다 역순 출력 변수 값 + 1 (짝,홀수 번갈아가며 조건 변경), 줄 바꿈
			reverse++;
			System.out.println("\n");
		}
	}
}
