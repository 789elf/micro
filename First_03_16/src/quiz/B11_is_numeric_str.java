package quiz;

import java.util.Scanner;

public class B11_is_numeric_str {

	public static void main(String[] args) {

		/*
		 *  입력받은 문자열에 숫자만 포함되어 있으면 result가 1
		 *  다른문자가 포함되어 있다면 result가 0
		 */
		Scanner sc = new Scanner(System.in);
		
		int result;
		String str;
		
		result = 1;
		str = "";
		
		System.out.println("문자열 입력 (숫자가 포함되어있으면 1, 아니면 0 반환)");
		str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				result = 0;
			}
		}
		System.out.println("result : "+ result);
	}

}
