package quiz;

import java.util.Scanner;
public class B03_wonToDollar {
	//한국 돈을 입력하면 미국 달러로 환전해주는 프로그램
	//현재 환율  : 1$ = 1,122.80￦
	//수수료 : 1.75%
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final double WON_TO_DOLLAR = 0.00089;
		
		System.out.println("한국돈 => 달러 (수수료 1.75%) : ");
		int korMoney = sc.nextInt();
		
		double usd = korMoney * WON_TO_DOLLAR;
		System.out.printf("%d원은 %.2fUSD입니다. \n", korMoney,(usd * 0.9825));
		
		
//		int won;
//		float commission;
//		float exchange;
//		
//		System.out.println("원을 입력 : ");
//		won = sc.nextInt();
//		
//		exchange = (won / 1122.80F);
//		commission = exchange * 0.0175F;
//		
//		System.out.printf("수수료는 %.2f 입니다.",commission);
//		System.out.printf("환전금액은 %.2f$ 입니다.", exchange - commission);
	}
	
	
	
	
}
