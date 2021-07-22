package algorithm;

import java.util.Arrays;

public class A01_TwoSum {

	/* 
	  	1. �� �Ű�������  �޴´�.
	  	2. target���� �迭�� ���� ��� �ִ�.
	  	3. nums���� �������ƴ� �������� ��� �ִ�.
	  	4. target�� ���� ������� nums�� � �ε������� ���ؾ��ϴ����� ���� �� �� index�� ��ȯ�Ѵ�. 
	
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
