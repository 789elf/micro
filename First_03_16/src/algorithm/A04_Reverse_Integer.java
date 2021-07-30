package algorithm;

import java.util.Arrays;


// ���ڰ� ������ �Ųٷ� ��ȯ   123 -> 321   -123  -> -321
// int�� ����� ���� ��� 0�� ��ȯ
public class A04_Reverse_Integer {
	public static int reverse(int x) {

		int result = 0;
		try {
			String[] str_arr = String.valueOf(Math.abs(x)).split("");
			StringBuilder temp = new StringBuilder();

			if (x < 0) {
				temp.append("-");
			}
			
			for(int i=str_arr.length -1; i>=0; i--) {
				temp.append(str_arr[i]);
			}
			
			result = Integer.parseInt(temp.toString());

		} catch (NumberFormatException e) {
			System.out.println("��������");
			result = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		reverse((int) 21474836310000L);
//		reverse(213);
	}
}
