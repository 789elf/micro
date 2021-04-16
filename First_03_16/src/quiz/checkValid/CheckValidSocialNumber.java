package quiz.checkValid;

import java.util.Scanner;

public class CheckValidSocialNumber {

	/*
	 *  ����ڰ� �ֹι�ȣ�� �Է��ϸ� �� ��ȣ�� ��ȿ���� �˻�
	 *
	 *  �Ǿ� 2�ڸ� ����
	 *  �� �ڸ��� 01 ~ 12 �̳� ����
	 *  �� �ڸ��� 01 ~ 31�̳��� ����
	 *  7��° �ڸ� '-'
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
		
		// ������ �ƴ� ��
		if(!isLeapYear) {
			if(month == 2 && day >= 29) {
				return false;
			}	
		}
		// ���� �� ��
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
	// �ùٸ� �� ���ϱ�
	public boolean checkMonth(int month) {
		if(month >= 1 && month <= 12) {
			return true;
		}
		return false;
	}
	
	// ����
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
//		System.out.println(checkValidSocialNumber.checkValid(social_number) ? "�ùٸ� �ֹι�ȣ " : "�ùٸ��� ���� �ֹι�ȣ" );
		
		System.out.println(checkValidSocialNumber.checkValid("970213-1233456") ? "�ùٸ� �ֹι�ȣ " : "�ùٸ��� ���� �ֹι�ȣ" );
		System.out.println(checkValidSocialNumber.checkValid("970229-1233456") ? "�ùٸ� �ֹι�ȣ " : "�ùٸ��� ���� �ֹι�ȣ" );
		System.out.println(checkValidSocialNumber.checkValid("000229-3233456") ? "�ùٸ� �ֹι�ȣ " : "�ùٸ��� ���� �ֹι�ȣ" );
	}

}
