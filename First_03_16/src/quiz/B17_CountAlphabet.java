package quiz;

import java.util.Scanner;

public class B17_CountAlphabet {

	public static void main(String[] args) {

		/*
			����ڷκ��� ������ �ϳ� �Է¹ް�
			�ش� ���ڿ� � ���ĺ��� ��� �����ߴ��� ��� ��� ����غ���
			 (��ҹ��� ���� X) 
		 */
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("���� �Է� : > ");
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
