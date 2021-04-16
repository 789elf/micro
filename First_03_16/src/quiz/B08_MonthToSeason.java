package quiz;

import java.util.Scanner;

public class B08_MonthToSeason {

	public static void main(String[] args) {

		/*
		 *  사용자로부터 월(月) 을 입력 받으면 해당하는 계절을 출력
		 *  (swtich-case문 이용)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("월(月)을 입력하세요 (숫자만 1 ~ 12 ) > ");
		switch(sc.nextInt()) {
			case 12: case 1: case 2:
				System.out.println("겨울입니다.");
				break;
			case 3: case 4: case 5: 
				System.out.println("봄입니다.");
				break;
			case 6: case 7: case 8: 
				System.out.println("여름입니다.");
				break;
			case 9: case 10: case 11: 
				System.out.println("가을입니다.");
				break;
			default:
				System.out.println("숫자를 입력하세요 ( 1 ~ 12 )");
				break;
		}
	}

}
