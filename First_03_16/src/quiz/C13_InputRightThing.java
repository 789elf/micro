package quiz;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_InputRightThing {

	/*
	 *  사용자로부터 숫자를 제대로 입력받을때 까지 계속 입력받는 프로그램을 만들어보세요
	 *  (잘못된 값이 입력되어도 강제종료 되지 않교, 올바른 값이 입력되면  출력 후 프로그램 종료)
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = inputInt("숫자 > ");
		int b = inputInt("숫자2 > ");
		
		System.out.println("input 함수로 입력받은 값 : " + a);
		System.out.println("a : " + a);
	}
	
	// 정확한 숫자를 거러주는 함수
	public static int inputInt(String message) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(true) {
			try {
				System.out.println(message);
				num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				sc.nextLine();
			}
		}
		return num;
	}
}
