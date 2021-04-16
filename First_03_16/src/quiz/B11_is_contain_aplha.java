package quiz;

import java.util.Scanner;

public class B11_is_contain_aplha {

	public static void main(String[] args) {

		/*
		 *  사용자가 입력한 문자열에
		 *  알파벳이 포함되어 있으면 true, 없으면 false 출력  ( 65 ~ 122 ) 91 ~ 96 x 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		boolean bl;
		
		str = "";
		bl = false;
		
		System.out.println("문자열 입력(알파벳이 있으면 true 없으면 false 출력) >  ");
		str = sc.next();
		
		for(int i=0; i<str.length();i++) {
			if((str.charAt(i) >= 'A'  && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
				bl = true;
			}
		}
		System.out.println(bl);
	}
}
