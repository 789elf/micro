package quiz;

import java.util.Scanner;

public class B11_is_contain_aplha {

	public static void main(String[] args) {

		/*
		 *  ����ڰ� �Է��� ���ڿ���
		 *  ���ĺ��� ���ԵǾ� ������ true, ������ false ���  ( 65 ~ 122 ) 91 ~ 96 x 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		boolean bl;
		
		str = "";
		bl = false;
		
		System.out.println("���ڿ� �Է�(���ĺ��� ������ true ������ false ���) >  ");
		str = sc.next();
		
		for(int i=0; i<str.length();i++) {
			if((str.charAt(i) >= 'A'  && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
				bl = true;
			}
		}
		System.out.println(bl);
	}
}
