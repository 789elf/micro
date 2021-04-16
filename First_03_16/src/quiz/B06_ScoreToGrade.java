package quiz;

import java.util.Scanner;

public class B06_ScoreToGrade {

	public static void main(String[] args) {
		
		/*
		 * 	점수를 입력받으면 점수에 해당하는 등급을 출력해주는 프로그램을 작성해보세요.
		 * 
		 * 		90점 이상 : A
		 * 		80점 이상 : B
		 * 		70점 이상 : C
		 * 		60점 이상 : D
		 * 		그 외 : F 등급
		 *  	
		 *  	유효 점수 : 0 ~ 100 점 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		
		System.out.println("점수를 입력하세요 (0 ~ 100)");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			
			System.out.println(" 잘못된 점수입니다. 0 부터 100점까지 입력하세요.");
			
		}else if (score >= 90) {
			System.out.println("A 등급");
		}else if (score >= 80 && score <= 89) {
			System.out.println("B 등급");
		}else if (score >= 70 && score <= 79) {
			System.out.println("C 등급");
		}else if (score >= 60 && score <= 69) {
			System.out.println("D 등급");
		}else {
			System.out.println("F 등급");
		}
	}
}
