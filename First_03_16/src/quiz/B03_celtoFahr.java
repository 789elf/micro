package quiz;

import java.util.Scanner;

public class B03_celtoFahr {

	public static void main(String[] args) {
		
		//����ڷκ��� ���� �µ��� �Է¹�����
		//ȭ�� �µ��� ��ȯ�Ͽ� ������ִ� ���α׷�
		//����� �Ҽ� ù° �ڸ� ����
		
		Scanner sc = new Scanner(System.in);
		
		 
		double cel,fahr;
		
		System.out.println("���� �µ� : ");
		cel = sc.nextDouble();
		fahr = (cel * 1.8) + 32;
		System.out.printf("�Է��� ������ %.1f �̰� ȭ���� %.1f �Դϴ�",cel,fahr);
		
		
		
		
	}
}
