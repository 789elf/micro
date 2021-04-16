package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_GuessNumberGame {

	public static void main(String[] args) {

		/*
		 * 	 °ÔÀÓÀÌ ½ÃÀÛµÇ¸é ·£´ıÀ¸·Î 4ÀÚ¸®ÀÇ ¼ıÀÚ°¡ ¼±Á¤µÈ´Ù
		 * 
		 *   1. ÇÃ·¹ÀÌ¾î´Â 8¹øÀÇ ½Ãµµ¸¦ ÇÒ ¼ö ÀÖ´Ù
		 *   
		 *   2. °¢ ½Ãµµ¸¶´Ù 4ÀÚ¸®ÀÇ ¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¸é ´ÙÀ½°ú °°ÀÌ ¾Ë·ÁÁØ´Ù
		 *   
		 *   	¼ıÀÚ¿Í À§Ä¡°¡ ´Ù ¸ÂÀ» °æ¿ì - Strike
		 *   	¼ıÀÚ¸¸ ¸ÂÀ»°æ¿ì - Ball
		 *	
		 *	ex: Á¤´äÀÌ 3456ÀÏ¶§
		 *		>> 5634   	4 Ball
		 *		>> 3789		1 Strike
		 *
		 *   ¸ÂÃß°í ³ª¸é ¸î ¹ø¸¸¿¡ ¸Â­Ÿ´ÂÁö ¾Ë·ÁÁÖ±â 
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
			
			System.out.println("¼ıÀÚ 4ÀÚ¸® >> ");
			
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
				System.out.println(i +"¹ø ¸¸¿¡ ½Â¸®!\n");
				break;
			}
			System.out.println("½ÃµµÇÑ È½¼ö : "+( i )+ "¹ø");
		}
	}
}
