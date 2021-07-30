package algorithm;

import java.util.regex.Pattern;

// 문자열에 괄호 짝이 맞으면 true, 아니면 false를 반환
/* 
  
  	String s = "()"  true
  	{[()]} true
  	{] false
  	{()] false
   
 */

public class A06_ValidParentheses {

	public static char check(char ch) {
		switch (ch) {
		case '(': {
			return ')';
		}
		case '{': {
			return '}';
		}
		case '[': {
			return ']';
		}

		default:
			return ' ';
		}
	}

	public static boolean isValid(String s) {

		boolean flag = false;
		boolean flag2 = false;
		if (s.length() % 2 != 0) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				return false;
			}
		}

		int j = s.length() - 1;
		boolean lastCheck = true;
		
		for (int i = 0; i < s.length(); i++) {
			flag = false;
			flag2 = false;
			System.out.print("\n" + s.charAt(i));
			System.out.println(s.charAt(j));
			
			if (i != s.length() - 1 && check(s.charAt(i)) == s.charAt(i + 1)) {  // 앞, 바로뒤 체크
				System.out.println("if 1");
				System.out.print(s.charAt(i));
				System.out.println(s.charAt(i+1));

				i++;
				flag = true;
			}
			
			if(check(s.charAt(i)) == s.charAt(j)) {  // 앞, 뒤 체크
				System.out.println("if 2");
				System.out.print(s.charAt(i));
				System.out.println(s.charAt(j));
				if(i==0) {
					lastCheck = false;
				}
				flag2 = true;
			}
			
			if(!flag && !flag2) {
				System.out.println("if 3");
				System.out.print(flag);
				System.out.println(flag2);
				return false;
			}
			
			if(i == s.length()-2 && !lastCheck) {
				return true;
			}
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("(([]){})"));

	}
}
