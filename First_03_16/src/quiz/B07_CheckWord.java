package quiz;

import java.util.Scanner;

public class B07_CheckWord {

	public static void main(String[] args) {

		/*
		 *  사용자로부터 단어를 하나 입력받고
		 *  첫 번째 글자와 마지막 번째 글자가 일치하면 "OK" 출럭
		 *  
		 *  아니라면 "NOT OK"를 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String word;
		char first_Char,last_Char;
		
		System.out.println("단어를 입력하세요. ");
		word = sc.next();
		
		first_Char = word.charAt(0);
		last_Char = word.charAt(word.length() - 1); 
		
		if(first_Char == last_Char) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
		
		
	}

}
