package quiz;

import java.util.Scanner;

public class B15_Count369 {

	public static void main(String[] args) {

		/*
		 * ����ڷκ��� ������ �ϳ� �Է¹ް� �ش� ���ڱ��� 369������ ����ȴٸ� �ڼ��� �� ��� ó���ϴ��� �������.
		 */

		Scanner sc = new Scanner(System.in);

		int num;
		int cnt;
		
		num = 333;
		cnt = 0;
		
		for(int i=1; i<=num;i++) {
			
			int testValue = i;
			int digit = 1; // �ڸ���
			
			int n = 1;
			
//			System.out.print(i + ": ");
			while ((n *= 10) <= testValue) {
				System.out.println("testvalue : "+ testValue);
				System.out.println("n : " +  n);
				System.out.println("digit: "+ digit);
				digit++;
			}
			
			for (int j=digit; j>0; j--) {
				//testValue = testValue % 1000 / 100
				//testValue = testValue % 100 / 10
				int value = testValue % (int)Math.pow(10, j) / (int)Math.pow(10, j - 1);
				
				if (value == 3 || value == 6 || value == 9) {
					cnt++;
//					System.out.print("¦");
				}
				
				testValue %= (int)Math.pow(10, j - 1);
			}
//			System.out.println();
			System.out.println("�ڸ���: "+ digit);
		}
		System.out.println("cnt: " + cnt);
	}
}
		
//		System.out.println("���� �Է� > ");
//		num = sc.nextInt();

//		for(int i=0; i<=num; i++) {
//			int a = i % 10;
//			int b = i / 10;
//			if(a == 3 || a == 6 || a == 9 || b == 3 || b == 6 || b == 9) {
//				cnt++;
//				System.out.printf("%2d(%2d) ", i, cnt);
//				if(cnt % 10 == 0) {
//					System.out.println();
//				}
//			}
//		}
//		System.out.println("�� �ڼ� : " + cnt);
