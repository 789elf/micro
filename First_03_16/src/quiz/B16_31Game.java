package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_31Game {

	public static void main(String[] args) {

		/*
		 * 31����
		 * 
		 * 1. ��ǻ�Ϳ� ����� �����ư��鼭 ���ڸ� ���� 2. ��ǻ�ʹ� �������� ���ڸ� ���� 3. ������ �������� �����Ѵ�. 4. �������� 31
		 * �̻��� ���ڸ� ���� �÷��̾ �й�
		 */

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		int user_Num = 0;
		int cnt = 0;
		
		int i = 1;
		while(i <= 31) {

			System.out.println("My turn > ");
			user_Num = sc.nextInt();
			
			if(!(user_Num >= 1 && user_Num <=3)) {
				System.out.println("1 ~ 3���� �Է�");
				continue;
			}

			cnt = i;
			
			for(int j=1; j<=user_Num;j++) {
				System.out.println("User > " + i);
				i++;
			}
			
			int turn;
			
			turn = ran.nextInt(3) + 1;

			if(i == 31) {
				break;
			}

			if(31 - i <= 3 ) {
				turn = 31 - (i);
			}
			
			for (int j = 1; j <= turn; j++) {
				System.out.println("AI > "+ i++);
			}
		}
		System.out.printf("'[%s] �� �¸�", cnt == 31 ? "��ǻ��" : "����");
	}
}