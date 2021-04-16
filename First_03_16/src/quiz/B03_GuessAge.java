package quiz;

import java.util.Scanner;
public class B03_GuessAge {

	public static void main(String[] args) {

		// 사용자로부터 태어난해와 올해의 년도를 입력받으면
		// 그 사람의 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을  만들어보세요.
		Scanner sc = new Scanner(System.in);
		int year, birth, age;
		
		System.out.println("올해년도는 ?");
		year = sc.nextInt();
		
		System.out.println("출생년도는 ? ");
		birth = sc.nextInt();
		
		age = year - birth + 1;
		
		System.out.println("한국 나이는 " + age +"살 입니다.");
	}

}
