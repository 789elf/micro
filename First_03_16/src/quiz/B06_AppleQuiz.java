package quiz;

import java.util.Scanner;

public class B06_AppleQuiz {

	public static void main(String[] args) {

		/*
		 * 	����� 10���� ���� �� �ִ� �ٱ��ϰ� �ִ�.
		 * 	����ڰ� �����ϰ� ���� ����� ������ �Է��ϸ�
		 * 	����� ��� ��� ���� �ʿ��� �ٱ����� ������ �˷��ִ� ���α׷�
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int input;
		
		System.out.println("����� ������ �Է��ϼ���. > ");
		input = sc.nextInt();
		
		if(input <= 0) {
			System.out.println("�߸��� ���Դϴ�. ");
			
		}else if(input % 10 == 0) {
			System.out.println("�� �ʿ��� �ٱ����� ������ " + (input / 10) + "�� �Դϴ�.");
			
		}else if(input % 10 != 0){
			System.out.println("�� �ʿ��� �ٱ����� ������" + ((input / 10) + 1) +"�� �Դϴ�." );
		}
	}
}
