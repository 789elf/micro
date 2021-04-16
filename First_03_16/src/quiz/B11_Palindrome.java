package quiz;

import java.util.Scanner;

public class B11_Palindrome {

	public static void main(String[] args) {

		/*
		 * 	사용자로부터 단어를 하나 입력받고
		 *  해당 단어가 회문이라면 "PALINDROME" ,
		 *  회문이 아니라면 "NOT PALINDROME" 을 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		String str;
		boolean pal;
		
		pal = true;
		
		System.out.println("단어 입력 : ");
		str = sc.next();
			
			for(int i=0; i < str.length() / 2; i++) {

				if(str.charAt(i) != str.charAt(str.length() -(i+1))) {

					pal = false;
					break;
				}
			}
		System.out.println("PALINDROME : "+pal);
	}

}
