package quiz;

import java.util.Random;
import java.util.Scanner;

public class B17_CountRandomFruit {

	public static void main(String[] args) {

		/*
		 *  1. ����ڷκ��� �迭�� ũ�⸦ �Է¹޴´�.
		 *  
		 *  2. �ش� ũ�⸸ŭ�� �迭�� ���� ���� ���ڿ��� ����
		 *   ( �������� �����ϴ� ���� : apple, banana, kiwi, orange, strawberry, pineapple)
		 *   
		 *  3. �� ������ ��� �����ߴ��� ��� ����ϰ� ���
		 */
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�迭 ũ�� >> ");
		int num = sc.nextInt();
		String[] all_Fruit = new String[num];
		
		String[] fruit = new String[]{"apple", "banana", "kiwi", "orange", "strawberry", "pineapple"};
		
		int[] cnt = new int[num];
		
		for(int i=0; i<all_Fruit.length; i++) {
			
			all_Fruit[i] = fruit[ran.nextInt(fruit.length)];
			
			cnt[i]++;
			
			for(int j=0; j<i; j++) {
				if(all_Fruit[i] == all_Fruit[j]) {
					
					cnt[i]++;
				}
			}
		}
		for(int i=0; i<all_Fruit.length; i++) {
			System.out.printf("%s = %d ȸ \n", all_Fruit[i], cnt[i]);
		}
		
		System.out.println(ran.nextInt(fruit.length));
		System.out.println(fruit[5]);
	}

}
