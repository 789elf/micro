package quiz.fiveDice;

import java.util.Random;
import java.util.Scanner;

public class FiveDiceMainRun {

	/*
	 *  랜덤으로 5개의 주사위를 굴린 다음에 결과를 통해 다음을 구분하는 클래스를 만들어 보기
	 *  
	 *  1. 풀하우스 (같은 눈이 2개 + 3개) (주사위 눈이 점수)
	 *  2. 스몰 스트레이트 (1234/2345/3456) (15점)
	 *  3. 라지 스트레이트 (12345/45623) (30점)
	 *  4. 4 다이스 (같은 숫자 4개) (주사위 눈이 점수)
	 *  5. 5 다이스 (같은 숫자 5개) (50점)
	 *  
	 *   * 게임까지 구현하려면 Yacht을 검색해보라
	 *   
	 *   # 메서드
	 *   	(1) 모든 주사위를 던지는 메서드
	 *   	
	 *   	(2) 원하는 주사위를 제외하고 나머지를 던지는 메서드 (결과중에 원하는 주사위는 킵 해둘 수있다 원하는 수 만큼)
	 *  
	 *  	(3) 주사위를 새로 던질때 마다 위의 1,2,3,4,5 중 해당하는 것이 있는지 체크
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FiveDiceController cont = new FiveDiceController();
		
		int select = -1;
		boolean isFirst = true;
		
		while(true) {
			
			System.out.println("┌─────── five dices ───────┐");
			System.out.println("│ 1.New | 2.Next | 0.Exit  │");
			System.out.println("└──────────────────────────┘");
			select = sc.nextInt();
			
			if(select == 1) {
				isFirst = true;
				cont.dices(isFirst);
			}
			
			if(select == 2) {
				isFirst = false;
				cont.dices(isFirst);
			}
			
			if(select == 0) {
				System.exit(0);
			}
		}
		
	}
}
