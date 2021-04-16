package quiz;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_InputRightThing {

	/*
	 *  ����ڷκ��� ���ڸ� ����� �Է¹����� ���� ��� �Է¹޴� ���α׷��� ��������
	 *  (�߸��� ���� �ԷµǾ �������� ���� �ʱ�, �ùٸ� ���� �ԷµǸ�  ��� �� ���α׷� ����)
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = inputInt("���� > ");
		int b = inputInt("����2 > ");
		
		System.out.println("input �Լ��� �Է¹��� �� : " + a);
		System.out.println("a : " + a);
	}
	
	// ��Ȯ�� ���ڸ� �ŷ��ִ� �Լ�
	public static int inputInt(String message) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(true) {
			try {
				System.out.println(message);
				num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				sc.nextLine();
			}
		}
		return num;
	}
}
