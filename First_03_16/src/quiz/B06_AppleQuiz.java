package quiz;

import java.util.Scanner;

public class B06_AppleQuiz {

	public static void main(String[] args) {

		/*
		 * 	사과를 10개씩 담을 수 있는 바구니가 있다.
		 * 	사용자가 구매하고 싶은 사과의 갯수를 입력하면
		 * 	사과를 모두 담기 위해 필요한 바구니의 갯수를 알려주는 프로그램
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int input;
		
		System.out.println("사과의 갯수를 입력하세요. > ");
		input = sc.nextInt();
		
		if(input <= 0) {
			System.out.println("잘못된 값입니다. ");
			
		}else if(input % 10 == 0) {
			System.out.println("총 필요한 바구니의 갯수는 " + (input / 10) + "개 입니다.");
			
		}else if(input % 10 != 0){
			System.out.println("총 필요한 바구니의 갯수는" + ((input / 10) + 1) +"개 입니다." );
		}
	}
}
