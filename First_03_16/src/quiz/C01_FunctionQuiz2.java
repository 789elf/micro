package quiz;

import java.lang.reflect.Array;
import java.util.Arrays;

public class C01_FunctionQuiz2 {

	public static void main(String[] args) {

		/*
		 *  # 다음의 함수를 정의하고 올바르게 동작하는지 테스트
		 *  
		 *  1. 최소값과 최대값을 매개변수로 받으면, 그 사이에 존재하는
		 *     모든 값을 포함하는 int 배열을 생성하여 반환하는 
		 *     range 함수 만들기 (최소값 이상, 최대값 미만 )
		 *     
		 *  2. 최대값을 매개변수로 전달 받으면 0부터 최대값 미만의 모든 값을 포함하는
		 *     int 배열을 생성하여 반환하는 range 함수 만들기 (최대값 미만)
		 *     
		 *  3. 최소값과 최대값과 증가값을 매개변수로 받으면 최소값에서 시작하여 
		 *     최대값까지 증가값만큼 증가하는 int 배열을 생성하여 반환하는 range함수 만들기 (최소값 이상, 최대값 미만 )
		 *  
		 *  	ex: range (50, 56, 5) 의 결과 -> [50, 55]
		 *  	ex: range (50, 55, 5) 의 결과 -> [50]
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
	 *  문제가 range이름의 함수 하나만 만드는 것이었음 . 
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
