package quiz;

import java.util.Scanner;

public class B14_GCD {

	public static void main(String[] args) {

		/*
		 * 	�� ���ڸ� �Է¹ް� �� ������ �ִ������� ���� ������.
		 *  �ִ����� : �� ���� ����� �� ���� ū �����
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,temp1,result;

		temp1 = 0;
		result = 0;
		
		System.out.println("���� 1 �Է� > ");
		num1 = sc.nextInt();
		
		System.out.println("���� 2 �Է� > ");
		num2 = sc.nextInt();
		

		for(int i = num1; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				result = i;
				break;
			}
		}
		System.out.println("�ִ����� : "+ result);
	}
}
