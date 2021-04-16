package quiz;

import java.util.Scanner;

public class B17_CountAlphabet {

	public static void main(String[] args) {

		/*
			사용자로부터 문장을 하나 입력받고
			해당 문자에 어떤 알파벳이 몇번 등장했는지 세어서 모두 출력해보기
			 (대소문자 구별 X) 
		 */
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("문장 입력 : > ");
//		String str = sc.next();
		
		String text = "Hello";
		text = text.toUpperCase();
		
		int[] count = new int[26];
		
		for(int i=0; i<text.length();i++) {
			
			char ch = text.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				count[ch - 'A']++;
			}
		}
		
		for(int i=1; i<26; i++) {
			if(count[i] !=0) {
				System.out.println((char)(i + 'A')+ ":" + count[i]);
			}
		}
	}
}
