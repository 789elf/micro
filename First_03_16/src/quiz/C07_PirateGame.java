package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C07_PirateGame {

	/*
	 	
	 	1. ÇÃ·¹ÀÌ¾î°¡ µ¹¾Æ°¡¸é¼­ ¿øÇÏ´Â °÷¿¡ Ä®À» Âî¸¥´Ù
	 	
	 	2. Àß¸øµÈ °÷¿¡ Ä®À» ³ÖÀ¸¸é ÇØÀû ¾ÆÀú¾¾°¡ ³¯¾Æ°¡¸ç °ÔÀÓ¿¡ ÆÐ¹èÇÑ´Ù. 
	 	
	 	3. ÃÑ ±¸¸Û °¹¼ö, ²Î °¹¼ö´Â ¸¶À½´ë·Î.
	   
	 */
	static Random ran = new Random();
	
	
	static int getRandomHoleNum() {
		// (0 ~ 19) + (10 ~ 19) = ÃÑ 10 ~ 38 ±îÁö 
		return (ran.nextInt(20)) + (ran.nextInt(10) + 10);
	}
	
	static int getBlankNum() {
		// ²ÎÀº 1 ~ 3
		return ran.nextInt(3) + 1;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int temp_stab; //»ç¶÷ÀÌ Âî¸¦ ±¸¸Û
		
		int hole_num = getRandomHoleNum();	 //ÃÑ ±¸¸Û °¹¼ö (10 ~ 38)
		int blank_num = getBlankNum();		 //ÃÑ ²Î °¹¼ö (1 ~ 3)
		
		int[] hole = new int[hole_num];		 
		int[] blank = new int[blank_num];    //²Î ¹øÈ£
		int[] stab = new int[hole_num];		//Âñ·µ´ø ¹øÈ£
		
		
		//hole[]¿¡ ¹øÈ£ ÀÔ·Â
		for(int i=0; i<hole.length; i++) {
			hole[i] = i+1;
		}
		
		//²Î¹øÈ£
		int temp[] = new int[blank.length];
		int j=0;
		for(int i=0; i<blank.length; i++) {
			
			temp[i] = hole[ran.nextInt(hole.length)];
			//²Î ¹øÈ£ Áßº¹ Á¦°Å
			while(i != 0 && temp[i] == temp[j]) {
				temp[i] = hole[ran.nextInt(hole.length)];
				
			}
			blank[i] = temp[i]; //²Î ¹øÈ£ »ðÀÔ
		}
		
		// ¦¡ ¦¢ ¦£ ¦¤ ¦¥ ¦¦ ¦§ ¦¨ ¦© ¦ª ¦«
		
		boolean isBlank = true; //ÇÔÁ¤ ( true¸é °ÔÀÓ °è¼Ó, false¸é ±×¸¸ )
		System.out.println("¦£¦¡ ¦¡ ¦¡ ¦¡ ¦¡ ¦¡¦¤" );
		System.out.println("¦¢   ÇØÀû°ÔÀÓ    ¦¢");
		System.out.println("¦¦¦¡ ¦¡ ¦¡ ¦¡ ¦¡ ¦¡¦¥" );
		
		System.out.println("1.½ÃÀÛ  2.±×¸¸");
		int select = sc.nextInt();
		
		int cnt = 0; //°ÔÀÓ È½¼ö
		if(select == 1) {
			while(isBlank) {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢±¸¸Û °¹¼ö ¦¢ ²Î °¹¼ö  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
				System.out.println("¦¢²Î  °¹¼ö ¦¢ "+hole_num+" ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");				
				
				System.out.println("¸ðµç ±¸¸Û");
				System.out.println(Arrays.toString(hole));
				
				System.out.print("Âî¸¥ ±¸¸Û\n[");
				for(int i=0; i<stab.length; i++) {
					if(stab[i] != 0) {
						System.out.printf("%d, ",stab[i]);
					}
				}
				System.out.print("]\n");
				
				System.out.println("Âî¸¦ ±¸¸Û > ");
				temp_stab = sc.nextInt();
				
				while(temp_stab > hole.length) {
					System.out.println(hole.length + "º¸´Ù ÀÛÀº ¼ö¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					temp_stab = sc.nextInt();
				}
				
				stab[cnt] = temp_stab;
				for(int i=0; i<blank.length; i++) {
					if(temp_stab == blank[i]) {	//Âî¸¥±¸¸Û°ú ÇÔÁ¤ÀÌ °°´Ù¸é 
						isBlank = false;	//false (°ÔÀÓ ±×¸¸)
						System.out.println("¦¡¦¡¦¡¦¡¦¡¦¤¦¡¦¡¦¡¦¡¦¡¦¤      ¦¢    ");
						System.out.println("     ¦¢     ¦¢      ¦¢    ");
						System.out.println("       ¦¢          ¦¢    ");
						System.out.println("       ¦¢          ¦§¦¡¦¡¦¡¦¡¦¡");
						System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡   ¦¢ ");
						System.out.println("         ¡ß¡ß¡ß");
						System.out.println("       ¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("      ¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("    ¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("    ¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("     ¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("       ¡ß¡ß¡ß¡ß¡ß¡ß¡ß");
						System.out.println("        ¡ß¡ß¡ß¡ß");
					}
				}
				hole_num--;

				cnt++;
			}
		}
		if(select == 2) {
			System.exit(0);
		}
	}
}
