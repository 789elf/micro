package quiz.checkValid;

import java.util.Scanner;

public class CheckValidSocialNumber {

	/*
	 *  사용자가 주민번호를 입력하면 그 번호가 유효한지 검사
	 *
	 *  맨앞 2자리 숫자
	 *  월 자리에 01 ~ 12 이내 숫자
	 *  일 자리에 01 ~ 31이내의 숫자
	 *  7번째 자리 '-'
	 *  
	 *  
	 */
	
	public boolean checkDay(int day,int month, boolean isLeapYear) {

		if(day > 31 || day < 1) {
			return false;
		}
		
		int last_day = 0;
		if((month < 8 && month % 2 != 0) ||(month >= 8 && month % 2 == 0)) {
			last_day = 31;
		}else if((month < 8 && month % 2 == 0) || (month >= 8 && month % 2 != 0)){
			last_day = 30;
		}
		
		// 윤년이 아닐 때
		if(!isLeapYear) {
			if(month == 2 && day >= 29) {
				return false;
			}	
		}
		// 윤년 일 때
		if(isLeapYear) {
			if(month == 2 && day >= 30) {
				return false;
			}	
		}

		if(day <= last_day){
			
			return true;
		}
		return false;
		
	}
	// 올바른 달 구하기
	public boolean checkMonth(int month) {
		if(month >= 1 && month <= 12) {
			return true;
		}
		return false;
	}
	
	// 윤년
	public boolean checkLeapYear(int last_social_number, String year, int month, int day) {
		
		String str_year;
		
		if(!(last_social_number >= 1 && last_social_number <= 4)) {
			return false;
		}
		
		if(last_social_number == 1 || last_social_number == 2) {
			str_year = "19" + year;
		}else {
			str_year = "20" + year;
		}
		
		int int_year = Integer.parseInt(str_year);
		
		if((int_year % 4 == 0 && int_year % 100 !=0) || int_year % 400 == 0) {
			return true;
		}
		
		return false;
	}

	public  boolean checkValid(String social_number) {
		
		String year = social_number.substring(0,2);
		int month = Integer.parseInt(social_number.substring(2,4));
		int day = Integer.parseInt(social_number.substring(4,6));
		int last_social_number = Integer.parseInt(social_number.substring(7, 8));
		
		if(social_number.length() != 14) {
			return false;
		}
		if(social_number.charAt(6) != '-') {
			return false;
		}
		
		for(int i=0; i<social_number.length(); i++) {
			if(!((social_number.charAt(i) >= '0' || social_number.charAt(i) <= '9') || social_number.charAt(i) == '-')) {
				return false;
			}
			if(social_number.charAt(i) == '-') {
				if(i != 6) {
					return false;
				}
			}
		}
		boolean isLeapYear = checkLeapYear(last_social_number,year,month,day);
		
		System.out.println(isLeapYear);
		if(checkDay(day,month, isLeapYear) && checkMonth(month)) {
			
			return true;
		}
		
		
		return false;
	}
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		CheckValidSocialNumber checkValidSocialNumber = new CheckValidSocialNumber();
//		String social_number = "970228-1234567";
//		System.out.println(checkValidSocialNumber.checkValid(social_number) ? "올바른 주민번호 " : "올바르지 않은 주민번호" );
		
		System.out.println(checkValidSocialNumber.checkValid("970213-1233456") ? "올바른 주민번호 " : "올바르지 않은 주민번호" );
		System.out.println(checkValidSocialNumber.checkValid("970229-1233456") ? "올바른 주민번호 " : "올바르지 않은 주민번호" );
		System.out.println(checkValidSocialNumber.checkValid("000229-3233456") ? "올바른 주민번호 " : "올바르지 않은 주민번호" );
	}

}
