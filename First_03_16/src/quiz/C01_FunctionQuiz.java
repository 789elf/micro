package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz {

	public static void main(String[] args) {

		/*
		 *  # ������ �Լ��� �����ϰ� �ùٸ��� �����ϴ��� �׽�Ʈ
		 *  
		 *  1. ������ ���ڰ� ���ĺ��̸� true, �ƴϸ� false ��ȯ �ϴ� �Լ�
		 *  2. ������ ���ڰ� 3�� ����̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		 *  3. ���ڸ� �ϳ� �����ϸ� ���ڿ� "¦���Դϴ�" �Ǵ� "Ȧ���Դϴ�"�� ��ȯ�ϴ� �Լ�
		 *  4. ���ڸ� �����ϸ� �ش� ������ ��� ����� �迭 ���·� ��ȯ�ϴ� �Լ�
		 *  5. ������ ������ �Ҽ���� true�� , �ƴϸ� false�� ��ȯ
		 *  6. ���ڸ� �����ϸ� �ش� ������ ���丮�� ����� ��ȯ�ϴ� �Լ�
		 *  	factorial: (n)*(n-1)*(n-2)..3*2*1
		 */
		
		int num = 12;
		char ch = 'a';
		
		System.out.println("1 : "+ alphabet('a'));
		System.out.println("2 : "+ multiple_of_3(num));
		System.out.println("3 : "+ num + "��" + odd_or_even(num));
		System.out.println("4 : "+ num + "�� ��� " + Arrays.toString(factor(num)));
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
			return "¦���Դϴ�";
		else
			return "Ȧ���Դϴ�";
	}
	
	// 4 ���� �ϴ���
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
	
	// 4 ����� ver
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
