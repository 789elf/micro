package quiz;

import java.util.Scanner;
public class B03_GuessAge {

	public static void main(String[] args) {

		// ����ڷκ��� �¾�ؿ� ������ �⵵�� �Է¹�����
		// �� ����� �ѱ� ���̸� ����Ͽ� �� ������ �˷��ִ� ���α׷���  ��������.
		Scanner sc = new Scanner(System.in);
		int year, birth, age;
		
		System.out.println("���س⵵�� ?");
		year = sc.nextInt();
		
		System.out.println("����⵵�� ? ");
		birth = sc.nextInt();
		
		age = year - birth + 1;
		
		System.out.println("�ѱ� ���̴� " + age +"�� �Դϴ�.");
	}

}
