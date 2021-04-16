package quiz;

import java.util.Random;
import java.util.Scanner;

public class B17_CountRandomFruit {

	public static void main(String[] args) {

		/*
		 *  1. 사용자로부터 배열의 크기를 입력받는다.
		 *  
		 *  2. 해당 크기만큼의 배열에 랜덤 과일 문자열을 저장
		 *   ( 랜덤으로 등장하는 과일 : apple, banana, kiwi, orange, strawberry, pineapple)
		 *   
		 *  3. 각 과일이 몇번 등장했는지 모두 기록하고 출력
		 */
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열 크기 >> ");
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
			System.out.printf("%s = %d 회 \n", all_Fruit[i], cnt[i]);
		}
		
		System.out.println(ran.nextInt(fruit.length));
		System.out.println(fruit[5]);
	}

}
