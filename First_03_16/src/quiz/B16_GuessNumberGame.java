package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_GuessNumberGame {

	public static void main(String[] args) {

		/*
		 * 	 ������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�
		 * 
		 *   1. �÷��̾�� 8���� �õ��� �� �� �ִ�
		 *   
		 *   2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�
		 *   
		 *   	���ڿ� ��ġ�� �� ���� ��� - Strike
		 *   	���ڸ� ������� - Ball
		 *	
		 *	ex: ������ 3456�϶�
		 *		>> 5634   	4 Ball
		 *		>> 3789		1 Strike
		 *
		 *   ���߰� ���� �� ������ �­����� �˷��ֱ� 
		 */
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		
		int ball;
		int strike;
		
		int num = 0, num1, num2, num3, num4;
		int user_Num = 0, user_Num1, user_Num2, user_Num3, user_Num4 ;
		
		
		num = ran.nextInt(9000) +1000;
		
		num1 = num % 10;
		num2 = num / 10 % 10;
		num3 = num / 10 / 10 % 10;
		num4 = num / 10 / 10/ 10 % 10;
		
		System.out.println(num);
		while(i < 8) {
			
			ball = 0;
			strike = 0;
			
			System.out.println("���� 4�ڸ� >> ");
			
			user_Num = sc.nextInt();
			
			user_Num1 = user_Num % 10;
			user_Num2 = user_Num / 10 % 10;
			user_Num3 = user_Num / 10 / 10 % 10;
			user_Num4 = user_Num / 10 / 10 / 10 % 10;

			//1
			if(num1 == user_Num1) strike++;
			if(num1 != user_Num1) {
				if(num1 == user_Num2) ball++;
				if(num1 == user_Num3) ball++;
				if(num1 == user_Num4) ball++;
			}
			
			//2
			if(num2 == user_Num2) strike++;
			if(num2 != user_Num2) {
				if(num2 == user_Num1) ball++;
				if(num2 == user_Num3) ball++;
				if(num2 == user_Num4) ball++;
			}

			//3
			if(num3 == user_Num3) strike++;
			if(num3 != user_Num3) {
				if(num3 == user_Num1) ball++;
				if(num3 == user_Num2) ball++;
				if(num3 == user_Num4) ball++;
			}
			
			//4
			if(num4 == user_Num4) strike++;
			if(num4 != user_Num4) {
				if(num4 == user_Num1) ball++;
				if(num4 == user_Num2) ball++;
				if(num4 == user_Num3) ball++;
			}
			System.out.println("Ball : " + ball + "\tStrike : " + strike);
			
			i++;
			
			if(strike == 4) {
				System.out.println(i +"�� ���� �¸�!\n");
				break;
			}
			System.out.println("�õ��� Ƚ�� : "+( i )+ "��");
		}
	}
}
