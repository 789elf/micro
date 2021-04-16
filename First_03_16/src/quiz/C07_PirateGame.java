package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C07_PirateGame {

	/*
	 	
	 	1. �÷��̾ ���ư��鼭 ���ϴ� ���� Į�� ���
	 	
	 	2. �߸��� ���� Į�� ������ ���� �������� ���ư��� ���ӿ� �й��Ѵ�. 
	 	
	 	3. �� ���� ����, �� ������ �������.
	   
	 */
	static Random ran = new Random();
	
	
	static int getRandomHoleNum() {
		// (0 ~ 19) + (10 ~ 19) = �� 10 ~ 38 ���� 
		return (ran.nextInt(20)) + (ran.nextInt(10) + 10);
	}
	
	static int getBlankNum() {
		// ���� 1 ~ 3
		return ran.nextInt(3) + 1;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int temp_stab; //����� � ����
		
		int hole_num = getRandomHoleNum();	 //�� ���� ���� (10 ~ 38)
		int blank_num = getBlankNum();		 //�� �� ���� (1 ~ 3)
		
		int[] hole = new int[hole_num];		 
		int[] blank = new int[blank_num];    //�� ��ȣ
		int[] stab = new int[hole_num];		//�񷵴� ��ȣ
		
		
		//hole[]�� ��ȣ �Է�
		for(int i=0; i<hole.length; i++) {
			hole[i] = i+1;
		}
		
		//�ι�ȣ
		int temp[] = new int[blank.length];
		int j=0;
		for(int i=0; i<blank.length; i++) {
			
			temp[i] = hole[ran.nextInt(hole.length)];
			//�� ��ȣ �ߺ� ����
			while(i != 0 && temp[i] == temp[j]) {
				temp[i] = hole[ran.nextInt(hole.length)];
				
			}
			blank[i] = temp[i]; //�� ��ȣ ����
		}
		
		// �� �� �� �� �� �� �� �� �� �� ��
		
		boolean isBlank = true; //���� ( true�� ���� ���, false�� �׸� )
		System.out.println("���� �� �� �� �� ����" );
		System.out.println("��   ��������    ��");
		System.out.println("���� �� �� �� �� ����" );
		
		System.out.println("1.����  2.�׸�");
		int select = sc.nextInt();
		
		int cnt = 0; //���� Ƚ��
		if(select == 1) {
			while(isBlank) {
				System.out.println("����������������������������������");
				System.out.println("������ ���� �� �� ����  ��");
				System.out.println("����������������������������������");

				System.out.println("��������������������������");
				System.out.println("����  ���� �� "+hole_num+" ��");
				System.out.println("��������������������������");				
				
				System.out.println("��� ����");
				System.out.println(Arrays.toString(hole));
				
				System.out.print("� ����\n[");
				for(int i=0; i<stab.length; i++) {
					if(stab[i] != 0) {
						System.out.printf("%d, ",stab[i]);
					}
				}
				System.out.print("]\n");
				
				System.out.println("� ���� > ");
				temp_stab = sc.nextInt();
				
				while(temp_stab > hole.length) {
					System.out.println(hole.length + "���� ���� ���� �Է����ּ��� > ");
					temp_stab = sc.nextInt();
				}
				
				stab[cnt] = temp_stab;
				for(int i=0; i<blank.length; i++) {
					if(temp_stab == blank[i]) {	//����۰� ������ ���ٸ� 
						isBlank = false;	//false (���� �׸�)
						System.out.println("������������������������      ��    ");
						System.out.println("     ��     ��      ��    ");
						System.out.println("       ��          ��    ");
						System.out.println("       ��          ������������");
						System.out.println("������������������������������   �� ");
						System.out.println("         �ߡߡ�");
						System.out.println("       �ߡߡߡߡߡ�");
						System.out.println("      �ߡߡߡߡߡߡߡ�");
						System.out.println("    �ߡߡߡߡߡߡߡߡߡߡߡ�");
						System.out.println("    �ߡߡߡߡߡߡߡߡߡߡ�");
						System.out.println("     �ߡߡߡߡߡߡߡߡ�");
						System.out.println("       �ߡߡߡߡߡߡ�");
						System.out.println("        �ߡߡߡ�");
					}
				}
				hole_num--;

				cnt++;
			}
		}
		if(select == 2) {
			System.exit(0);
		}
	}
}
