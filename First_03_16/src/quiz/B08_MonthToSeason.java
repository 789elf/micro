package quiz;

import java.util.Scanner;

public class B08_MonthToSeason {

	public static void main(String[] args) {

		/*
		 *  ����ڷκ��� ��(��) �� �Է� ������ �ش��ϴ� ������ ���
		 *  (swtich-case�� �̿�)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("��(��)�� �Է��ϼ��� (���ڸ� 1 ~ 12 ) > ");
		switch(sc.nextInt()) {
			case 12: case 1: case 2:
				System.out.println("�ܿ��Դϴ�.");
				break;
			case 3: case 4: case 5: 
				System.out.println("���Դϴ�.");
				break;
			case 6: case 7: case 8: 
				System.out.println("�����Դϴ�.");
				break;
			case 9: case 10: case 11: 
				System.out.println("�����Դϴ�.");
				break;
			default:
				System.out.println("���ڸ� �Է��ϼ��� ( 1 ~ 12 )");
				break;
		}
	}

}
