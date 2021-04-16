package quiz.checkValid;

import java.util.ArrayList;
import java.util.Scanner;

public class D07_CheckValidPhoneNumber {

	/*
	 * 사용자로부터 핸드폰번호를 입력받으면 올바른 전화번호인지 구분하는 프로그램 만들기
	 * 
	 * 앞의 3자리 숫자 두번째 숫자는 3 ~ 4 자리 세번째는 4자리
	 */
	public boolean correctNumber(String number) {
		
		char[] numbers = number.toCharArray();
		int first_number_count = 0; 	// 3일경우 첫번째 자리 올바른 번호	
		int middle_number_count = 0;	// 3~4일 경우 올바른 번호
		int last_number_count = 0;		// 4일경우 올바른 번호
		
		// 전화번호 길이체크 
		if(!(numbers.length >= 12 && numbers.length < 14)) {
			return false;
		}
		
		int hyphen_count = 0;
		int second_hyphen_index = 0;
		
		for(int i=0; i<numbers.length; i++) {
		
			// 번호 한자리마다 숫자나 '-' 인지 확인
			if(((numbers[i] >= '0' && numbers[i] <= '9') || numbers[i] == '-')) {
				// '-' 이 들어가야할 자리
				if(i==3 || (i==7 || i==8)) {
					// 하이픈이 들어갈 자리에 잘 있고 , 2개 이하
					if(numbers[i] == '-' && hyphen_count <= 2) {
						hyphen_count++; // '-' 갯수 +1
						// '-' 가 2개 이상이면 false
						if(hyphen_count > 2) {
							return false;
						}
						// '-'의 두번째 자릿수를 저장해 놓는다
						if(hyphen_count == 2) {
							second_hyphen_index = i;
						}
					}
				}
			}else {
				// 숫자나 '-' 가 아니라면 false
				return false;
			}
		}
		// '-' 을 기준으로 첫번째, 가운데, 마지막의 숫자 갯수를 카운트
		for(int i=0; i<numbers.length; i++) {
			if(i<3 && (numbers[i] >= '0' && numbers[i] <= '9')) {
				first_number_count++;
			}
			if(i>3 && i<second_hyphen_index ) {
				middle_number_count++;
			}
			if(i>second_hyphen_index) {
				last_number_count++;
			}
		}

		// 숫자 갯수 맞는지 확인
		if(!(first_number_count == 3 && (middle_number_count == 3 || middle_number_count == 4) && last_number_count == 4)) {
			return false;
		}
		
		return true;
	}

//	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String number = "010-123-2424";
//		System.out.println("전화번호 >> ");
//		number = sc.next();

		D07_CheckValidPhoneNumber check = new D07_CheckValidPhoneNumber();

		System.out.println(check.correctNumber(number) ? "올바른 번호 " : "올바르지 않은 번호");
	}

}
