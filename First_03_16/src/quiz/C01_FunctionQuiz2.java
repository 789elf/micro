package quiz;

import java.lang.reflect.Array;
import java.util.Arrays;

public class C01_FunctionQuiz2 {

	public static void main(String[] args) {

		/*
		 *  # ������ �Լ��� �����ϰ� �ùٸ��� �����ϴ��� �׽�Ʈ
		 *  
		 *  1. �ּҰ��� �ִ밪�� �Ű������� ������, �� ���̿� �����ϴ�
		 *     ��� ���� �����ϴ� int �迭�� �����Ͽ� ��ȯ�ϴ� 
		 *     range �Լ� ����� (�ּҰ� �̻�, �ִ밪 �̸� )
		 *     
		 *  2. �ִ밪�� �Ű������� ���� ������ 0���� �ִ밪 �̸��� ��� ���� �����ϴ�
		 *     int �迭�� �����Ͽ� ��ȯ�ϴ� range �Լ� ����� (�ִ밪 �̸�)
		 *     
		 *  3. �ּҰ��� �ִ밪�� �������� �Ű������� ������ �ּҰ����� �����Ͽ� 
		 *     �ִ밪���� ��������ŭ �����ϴ� int �迭�� �����Ͽ� ��ȯ�ϴ� range�Լ� ����� (�ּҰ� �̻�, �ִ밪 �̸� )
		 *  
		 *  	ex: range (50, 56, 5) �� ��� -> [50, 55]
		 *  	ex: range (50, 55, 5) �� ��� -> [50]
		 */
		
		
		int min,max,increase;
		
		min = 50;
		max = 56;
		increase = 5;
		
		System.out.println("1: "+ Arrays.toString(range(max)));
		System.out.println("2: "+ Arrays.toString(range(min, max)));
		System.out.println("3: "+ Arrays.toString(range(min, max, increase)));
	}

	/*
	 *  ������ range�̸��� �Լ� �ϳ��� ����� ���̾��� . 
	 */

	// 1
	public static int[] range(int min, int max) {
		
		int index = max - min;
		
		int[] range = new int[index];
		
		for(int i=min; i<max; i++) {
			range[i - min] = i;
		}
		return range;
	}
	
	// 2
	public static int[] range(int max) {
		
		int[] range = new int[max];
		
		for(int i=0; i<max; i++) {
			range[i] = i;
		}
		return range;
	}

	// 3
	public static int[] range(int min,int max,int increase) {
		
		int count = (int)Math.ceil((max - min) / (double)increase);
		int index = 0;
		
//		for(int i=min; i<max; i+=increase) {
//			count++;
//		}
		
		int[] range = new int[count];
		
		for(int i=min; i<max; i+=increase) {
			range[index++] = i;
		}
		return range;
	}
}
