package quiz;

import java.util.Scanner;

public class B11_ForBasicQuiz {

	public static void main(String[] args) {

		/*
		 *  사용자가 숫자를 입력했을 때
		 *  1. 10부터 입력한 숫자까지의 총 합을 구해보시오
		 *  2. 1부터 입력한 숫자 사이의 5의 배수만 모두 출력해보세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num,sum;
		sum = 0;
		
		System.out.println("숫자 입력: ");
		num = sc.nextInt();
		
		// 1
		if(num<10) {
			for(int i=10; i>=num; i--) {
				sum += i; 
			}
		}else if(num>=10) {
			for(int i=10; i<=num; i++) {
				sum += i; 
			}
		}
		
		// 2
		for(int i=1; i <= num; i++) {
			if(i % 5 == 0) {
				System.out.printf("%2d",i);
				if(i % 30 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println("총 합"+sum);
	}

}
