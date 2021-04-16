package quiz;

import java.util.Scanner;

public class B03_celtoFahr {

	public static void main(String[] args) {
		
		//사용자로부터 섭씨 온도를 입력받으면
		//화씨 온도로 변환하여 출력해주는 프로그램
		//출력은 소수 첫째 자리 까지
		
		Scanner sc = new Scanner(System.in);
		
		 
		double cel,fahr;
		
		System.out.println("섭씨 온도 : ");
		cel = sc.nextDouble();
		fahr = (cel * 1.8) + 32;
		System.out.printf("입력한 섭씨는 %.1f 이고 화씨는 %.1f 입니다",cel,fahr);
		
		
		
		
	}
}
