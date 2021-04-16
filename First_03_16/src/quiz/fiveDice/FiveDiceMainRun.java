package quiz.fiveDice;

import java.util.Random;
import java.util.Scanner;

public class FiveDiceMainRun {

	/*
	 *  �������� 5���� �ֻ����� ���� ������ ����� ���� ������ �����ϴ� Ŭ������ ����� ����
	 *  
	 *  1. Ǯ�Ͽ콺 (���� ���� 2�� + 3��) (�ֻ��� ���� ����)
	 *  2. ���� ��Ʈ����Ʈ (1234/2345/3456) (15��)
	 *  3. ���� ��Ʈ����Ʈ (12345/45623) (30��)
	 *  4. 4 ���̽� (���� ���� 4��) (�ֻ��� ���� ����)
	 *  5. 5 ���̽� (���� ���� 5��) (50��)
	 *  
	 *   * ���ӱ��� �����Ϸ��� Yacht�� �˻��غ���
	 *   
	 *   # �޼���
	 *   	(1) ��� �ֻ����� ������ �޼���
	 *   	
	 *   	(2) ���ϴ� �ֻ����� �����ϰ� �������� ������ �޼��� (����߿� ���ϴ� �ֻ����� ŵ �ص� ���ִ� ���ϴ� �� ��ŭ)
	 *  
	 *  	(3) �ֻ����� ���� ������ ���� ���� 1,2,3,4,5 �� �ش��ϴ� ���� �ִ��� üũ
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FiveDiceController cont = new FiveDiceController();
		
		int select = -1;
		boolean isFirst = true;
		
		while(true) {
			
			System.out.println("���������������� five dices ����������������");
			System.out.println("�� 1.New | 2.Next | 0.Exit  ��");
			System.out.println("��������������������������������������������������������");
			select = sc.nextInt();
			
			if(select == 1) {
				isFirst = true;
				cont.dices(isFirst);
			}
			
			if(select == 2) {
				isFirst = false;
				cont.dices(isFirst);
			}
			
			if(select == 0) {
				System.exit(0);
			}
		}
		
	}
}
