package quiz;

import java.util.Scanner;

public class B14_GCD {

	public static void main(String[] args) {

		/*
		 * 	두 숫자를 입력받고 두 숫자의 최대공약수를 구해 보세요.
		 *  최대공약수 : 두 수의 공약수 중 가장 큰 공약수
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,temp1,result;

		temp1 = 0;
		result = 0;
		
		System.out.println("숫자 1 입력 > ");
		num1 = sc.nextInt();
		
		System.out.println("숫자 2 입력 > ");
		num2 = sc.nextInt();
		

		for(int i = num1; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				result = i;
				break;
			}
		}
		System.out.println("최대공약수 : "+ result);
	}
}
