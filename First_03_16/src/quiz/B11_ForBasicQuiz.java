package quiz;

import java.util.Scanner;

public class B11_ForBasicQuiz {

	public static void main(String[] args) {

		/*
		 *  ����ڰ� ���ڸ� �Է����� ��
		 *  1. 10���� �Է��� ���ڱ����� �� ���� ���غ��ÿ�
		 *  2. 1���� �Է��� ���� ������ 5�� ����� ��� ����غ�����.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num,sum;
		sum = 0;
		
		System.out.println("���� �Է�: ");
		num = sc.nextInt();
		
		// 1
		if(num<10) {
			for(int i=10; i>=num; i--) {
				sum += i; 
			}
		}else if(num>=10) {
			for(int i=10; i<=num; i++) {
				sum += i; 
			}
		}
		
		// 2
		for(int i=1; i <= num; i++) {
			if(i % 5 == 0) {
				System.out.printf("%2d",i);
				if(i % 30 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println("�� ��"+sum);
	}

}
