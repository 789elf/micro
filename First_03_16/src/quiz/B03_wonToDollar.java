package quiz;

import java.util.Scanner;
public class B03_wonToDollar {
	//�ѱ� ���� �Է��ϸ� �̱� �޷��� ȯ�����ִ� ���α׷�
	//���� ȯ��  : 1$ = 1,122.80��
	//������ : 1.75%
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final double WON_TO_DOLLAR = 0.00089;
		
		System.out.println("�ѱ��� => �޷� (������ 1.75%) : ");
		int korMoney = sc.nextInt();
		
		double usd = korMoney * WON_TO_DOLLAR;
		System.out.printf("%d���� %.2fUSD�Դϴ�. \n", korMoney,(usd * 0.9825));
		
		
//		int won;
//		float commission;
//		float exchange;
//		
//		System.out.println("���� �Է� : ");
//		won = sc.nextInt();
//		
//		exchange = (won / 1122.80F);
//		commission = exchange * 0.0175F;
//		
//		System.out.printf("������� %.2f �Դϴ�.",commission);
//		System.out.printf("ȯ���ݾ��� %.2f$ �Դϴ�.", exchange - commission);
	}
	
	
	
	
}
