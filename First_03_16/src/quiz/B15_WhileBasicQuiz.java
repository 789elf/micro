package quiz;

public class B15_WhileBasicQuiz {

	public static void main(String[] args) {

		/*
		 * 	while문을 이용하여
		 *  
		 *  1. 1부터 100까지의 3의 배수의 총합
		 *  
		 *  2. 200부터 1까지 출력
		 *  
		 *  3. continue를 이용하여 300 ~ 500사이의 7의 배수만 출력
		 *  
		 *  4. 1부터 200까지의 숫자 중 2, 3의 배수가 아닌 숫자들의 총합
		 *  
		 *  을 구하시오.
		 */
		
		int i;
		int sum;
		
		i = 3;
		sum = 0;
		System.out.println(" d ");

		// # 1
		while(i <= 100) {
			if(i % 3 == 0) {
				sum += i;
			}
			i++;
		}
		
		System.out.println("1번 : "+ sum);
		
		// # 2
		i = 200;
		while(i >= 1) {
//			System.out.println(i);    지저분해서 주석 했습니다.
			i--;
		}
		
		// # 3
		i = 299;
		System.out.print("3번 :");
		while(i++ < 500) {
			if(i % 7 != 0) {
				continue; 
			}
			System.out.print(" "+ i);
			i++;
		}
		
		// # 4  1부터 200까지의 숫자 중 2, 3의 배수가 아닌 숫자들의 총합
		i = 1;
		sum = 0;
		while(i <= 200) {
			if(i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("\n4번 : "+sum);
		
	}

}
