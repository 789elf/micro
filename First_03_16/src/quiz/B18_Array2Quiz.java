package quiz;

import java.util.Arrays;
import java.util.Random;

public class B18_Array2Quiz {

	public static void main(String[] args) {

		/*
		 * 1. numArr�� ��� ���� 0 ~ 100 ������  ���� ������ �ٲ� ������
		 * 2. numArr�� ���հ� ����� ���ؼ� ���
		 * 3. numArr�� �� ���� ���� ��� ���ؼ� ���
		 * 4. nummArr�� �� ���� ���� ��� ���ؼ� ��� 
		 */
		
		int[][] numArr = new int[][] {
			{1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1},
			{1, 1, 1, 1, 1}
		};
		
		Random ran = new Random();

		int total = 0;
		int total_index = 0;
		int[][] row_total = new int[5][1];
		int[][] col_total = new int[7][1];
		
		for(int i=0; i<numArr.length; i++) {
			for(int j=0; j<numArr[i].length; j++) {
				
//				numArr[i][j] = ran.nextInt(100);
				numArr[i][j] = 1;	//���� Ȯ���� ���� ������ 100 ��� 1�� ���� ���� �߽��ϴ�.
				
				total += numArr[i][j]; 					//����
				row_total[i][0] += numArr[i][j];		//���� ��

				if(col_total[j][0] == 0) {
					col_total[j][0] += numArr[i][j];		//���� ��
				}
				
				total_index++;							//�ε��� ����
			}
		}
		
		System.out.printf("���� : %d\n��� : %.2f\n", total, (float)total / total_index);	
		for(int i=0; i<row_total.length; i++) {
			System.out.printf("%d ���� ���� �� : %d\n", i+1, row_total[i][0]);
		}
		for(int i=0; i<col_total.length; i++) {
			System.out.printf("%d ��° ���� ��: %d\n", i+1, col_total[i][0]);
		}
		//Arrays.toString() : �迭 ���ϰ� ����ϱ�
		System.out.println("���� ��: " + Arrays.toString(row_total[1]));
	}
}
