package quiz;

import java.util.Scanner;

public class B11_Palindrome {

	public static void main(String[] args) {

		/*
		 * 	����ڷκ��� �ܾ �ϳ� �Է¹ް�
		 *  �ش� �ܾ ȸ���̶�� "PALINDROME" ,
		 *  ȸ���� �ƴ϶�� "NOT PALINDROME" �� ���
		 */
		
		Scanner sc = new Scanner(System.in);
		String str;
		boolean pal;
		
		pal = true;
		
		System.out.println("�ܾ� �Է� : ");
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
