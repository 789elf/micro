package quiz;

import java.util.Arrays;
import java.util.Random;

public class B18_Array2Quiz {

	public static void main(String[] args) {

		/*
		 * 1. numArr의 모든 값을 0 ~ 100 사이의  랜덤 정수로 바꿔 보세요
		 * 2. numArr의 총합과 평균을 구해서 출력
		 * 3. numArr의 각 행의 합을 모두 구해서 출력
		 * 4. nummArr의 각 열의 합을 모두 구해서 출력 
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
				numArr[i][j] = 1;	//값의 확인을 위해 랜덤값 100 대신 1로 임의 지정 했습니다.
				
				total += numArr[i][j]; 					//총합
				row_total[i][0] += numArr[i][j];		//행의 합

				if(col_total[j][0] == 0) {
					col_total[j][0] += numArr[i][j];		//열의 합
				}
				
				total_index++;							//인덱스 갯수
			}
		}
		
		System.out.printf("총합 : %d\n평균 : %.2f\n", total, (float)total / total_index);	
		for(int i=0; i<row_total.length; i++) {
			System.out.printf("%d 번쨰 행의 합 : %d\n", i+1, row_total[i][0]);
		}
		for(int i=0; i<col_total.length; i++) {
			System.out.printf("%d 번째 열의 합: %d\n", i+1, col_total[i][0]);
		}
		//Arrays.toString() : 배열 편하게 출력하기
		System.out.println("행의 합: " + Arrays.toString(row_total[1]));
	}
}
