package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_31Game {

	public static void main(String[] args) {

		/*
		 * 31게임
		 * 
		 * 1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택 2. 컴퓨터는 랜덤으로 숫자를 선택 3. 선공은 랜덤으로 결정한다. 4. 마지막에 31
		 * 이상의 숫자를 만든 플레이어가 패배
		 */

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		int user_Num = 0;
		int cnt = 0;
		
		int i = 1;
		while(i <= 31) {

			System.out.println("My turn > ");
			user_Num = sc.nextInt();
			
			if(!(user_Num >= 1 && user_Num <=3)) {
				System.out.println("1 ~ 3까지 입력");
				continue;
			}

			cnt = i;
			
			for(int j=1; j<=user_Num;j++) {
				System.out.println("User > " + i);
				i++;
			}
			
			int turn;
			
			turn = ran.nextInt(3) + 1;

			if(i == 31) {
				break;
			}

			if(31 - i <= 3 ) {
				turn = 31 - (i);
			}
			
			for (int j = 1; j <= turn; j++) {
				System.out.println("AI > "+ i++);
			}
		}
		System.out.printf("'[%s] 의 승리", cnt == 31 ? "컴퓨터" : "유저");
	}
}