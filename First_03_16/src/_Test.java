import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 *  �ߺ��� ���ڴ� �ι�°�ź��� ī��Ʈ�ϰ� ���ڴ� ù��°�ź��� �� ī��Ʈ��
 */
public class _Test {
	private static HashSet<Integer> month31;
	private static HashSet<Integer> month30;
	static {
		month31 = new HashSet<>();
		month30 = new HashSet<>();
		
		Collections.addAll(month31, 1, 3, 5, 7, 8, 10, 12);
		Collections.addAll(month30, 4, 6, 9, 11);
	}
	public static void main(String[] args) {
		
		int month = 12; 
		
//		System.out.println(month31.contains(month));
		
	}
}
