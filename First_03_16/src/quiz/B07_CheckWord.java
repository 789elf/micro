package quiz;

import java.util.Scanner;

public class B07_CheckWord {

	public static void main(String[] args) {

		/*
		 *  ����ڷκ��� �ܾ �ϳ� �Է¹ް�
		 *  ù ��° ���ڿ� ������ ��° ���ڰ� ��ġ�ϸ� "OK" �ⷰ
		 *  
		 *  �ƴ϶�� "NOT OK"�� ���
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String word;
		char first_Char,last_Char;
		
		System.out.println("�ܾ �Է��ϼ���. ");
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
