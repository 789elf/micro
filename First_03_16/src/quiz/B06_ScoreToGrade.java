package quiz;

import java.util.Scanner;

public class B06_ScoreToGrade {

	public static void main(String[] args) {
		
		/*
		 * 	������ �Է¹����� ������ �ش��ϴ� ����� ������ִ� ���α׷��� �ۼ��غ�����.
		 * 
		 * 		90�� �̻� : A
		 * 		80�� �̻� : B
		 * 		70�� �̻� : C
		 * 		60�� �̻� : D
		 * 		�� �� : F ���
		 *  	
		 *  	��ȿ ���� : 0 ~ 100 �� 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		
		System.out.println("������ �Է��ϼ��� (0 ~ 100)");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			
			System.out.println(" �߸��� �����Դϴ�. 0 ���� 100������ �Է��ϼ���.");
			
		}else if (score >= 90) {
			System.out.println("A ���");
		}else if (score >= 80 && score <= 89) {
			System.out.println("B ���");
		}else if (score >= 70 && score <= 79) {
			System.out.println("C ���");
		}else if (score >= 60 && score <= 69) {
			System.out.println("D ���");
		}else {
			System.out.println("F ���");
		}
	}
}
