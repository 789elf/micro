package algorithm;

import java.util.Arrays;

public class A01_TwoSum {

	/* 
	  	1. 두 매개변수를  받는다.
	  	2. target에는 배열의 합이 들어 있다.
	  	3. nums에는 음수가아닌 정수들이 들어 있다.
	  	4. target의 값을 만드려면 nums의 어떤 인덱스끼리 더해야하는지를 구한 뒤 그 index를 반환한다. 
	
	*/
	public static int[] twoSum(int[] nums, int target) {
		int[] idx = new int[2];
		int k=0;
		for(int i=0; i<nums.length-1; i++) {
			for(int j=1; j<nums.length; j++) {
				if(target - (nums[i] + nums[j] ) == 0 && j != i) {
					idx[0] = i;
					idx[1] = j;
//					return idx;
				}
			}
		}
		return idx;
	}
	public static void main(String[] args) {
		int[] nums = {2,5,5,11};
		System.out.println(Arrays.toString(twoSum(nums, 10)));
	}

}
