package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz {

	public static void main(String[] args) {

		/*
		 *  # 다음의 함수를 정의하고 올바르게 동작하는지 테스트
		 *  
		 *  1. 전달한 문자가 알파벳이면 true, 아니면 false 반환 하는 함수
		 *  2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
		 *  3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
		 *  4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수
		 *  5. 전달한 정수가 소수라면 true를 , 아니면 false를 반환
		 *  6. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
		 *  	factorial: (n)*(n-1)*(n-2)..3*2*1
		 */
		
		int num = 12;
		char ch = 'a';
		
		System.out.println("1 : "+ alphabet('a'));
		System.out.println("2 : "+ multiple_of_3(num));
		System.out.println("3 : "+ num + "은" + odd_or_even(num));
		System.out.println("4 : "+ num + "의 약수 " + Arrays.toString(factor(num)));
		System.out.println("5 : "+ prime(num));
		System.out.println("6 : "+ num + "!" + factorial(num));
	}
	
	// 1
	public static boolean alphabet(char alphabet) {
		if((alphabet >= 'A' && alphabet <= 'Z') || (alphabet >= 'a' && alphabet <= 'z'))
			return true;
		else
			return false;
	}
	
	// 2
	public static boolean multiple_of_3(int num) {
		if(num != 0 &&num % 3 == 0) 
			return true;
		else
			return false;
	}
	
	// 3
	public static String odd_or_even(int num) {
		if(num % 2 == 0)
			return "짝수입니다";
		else
			return "홀수입니다";
	}
	
	// 4 내가 하던거
	public static int[] factor(int num) {
		int index = 0;

		for(int i=1; i<=num; i++) {
			if(num != 0 && num % i == 0) index++;
		}
		
		int[] factor = new int[index];
		int temp = 0;

		for(int i=0; i<num; i++) {

			if(num % (i+1) == 0) {
				factor[temp] = i + 1;
				temp++;
			}
		}
		return factor;
	}
	
	// 4 강사님 ver
	/*
	public static int[] factor(int num) {
		boolean[] divide = new boolean[num];
		
		int count = 0;
		
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				divide[i - 1] = true;
				count++;
			}
		}
		
		int[] result = new int[count];
		int index = 0;
		
		for(int i=0; i<divide.length; i++) {
			if(divide[i]) {
				result[index++] = i + 1;
			}
		}
		return result;
 	}
 	*/
	
	// 5
	public static boolean prime(int num) {

		boolean isPrime = true;
		
		for(int i=2; i<=num; i++) {
			isPrime = true;
			for(int j=2; j<i; j++) {
	        		
	        	if(i % j == 0) 
	        		isPrime = false;
	        }
		}
		return isPrime;
	}
	
	// 6
	public static int factorial(int num) {

		if(num == 1) {
			return num;
		}else if(num > 1) {
			return  factorial(num -1) * num;
		}
		return num;
	}

}
