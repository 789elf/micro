package quiz;

import java.util.Scanner;

public class B11_is_numeric_str {

	public static void main(String[] args) {

		/*
		 *  �Է¹��� ���ڿ��� ���ڸ� ���ԵǾ� ������ result�� 1
		 *  �ٸ����ڰ� ���ԵǾ� �ִٸ� result�� 0
		 */
		Scanner sc = new Scanner(System.in);
		
		int result;
		String str;
		
		result = 1;
		str = "";
		
		System.out.println("���ڿ� �Է� (���ڰ� ���ԵǾ������� 1, �ƴϸ� 0 ��ȯ)");
		str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				result = 0;
			}
		}
		System.out.println("result : "+ result);
	}

}
