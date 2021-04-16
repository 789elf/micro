package quiz.checkValid;

import java.util.ArrayList;
import java.util.Scanner;

public class D07_CheckValidPhoneNumber {

	/*
	 * ����ڷκ��� �ڵ�����ȣ�� �Է¹����� �ùٸ� ��ȭ��ȣ���� �����ϴ� ���α׷� �����
	 * 
	 * ���� 3�ڸ� ���� �ι�° ���ڴ� 3 ~ 4 �ڸ� ����°�� 4�ڸ�
	 */
	public boolean correctNumber(String number) {
		
		char[] numbers = number.toCharArray();
		int first_number_count = 0; 	// 3�ϰ�� ù��° �ڸ� �ùٸ� ��ȣ	
		int middle_number_count = 0;	// 3~4�� ��� �ùٸ� ��ȣ
		int last_number_count = 0;		// 4�ϰ�� �ùٸ� ��ȣ
		
		// ��ȭ��ȣ ����üũ 
		if(!(numbers.length >= 12 && numbers.length < 14)) {
			return false;
		}
		
		int hyphen_count = 0;
		int second_hyphen_index = 0;
		
		for(int i=0; i<numbers.length; i++) {
		
			// ��ȣ ���ڸ����� ���ڳ� '-' ���� Ȯ��
			if(((numbers[i] >= '0' && numbers[i] <= '9') || numbers[i] == '-')) {
				// '-' �� ������ �ڸ�
				if(i==3 || (i==7 || i==8)) {
					// �������� �� �ڸ��� �� �ְ� , 2�� ����
					if(numbers[i] == '-' && hyphen_count <= 2) {
						hyphen_count++; // '-' ���� +1
						// '-' �� 2�� �̻��̸� false
						if(hyphen_count > 2) {
							return false;
						}
						// '-'�� �ι�° �ڸ����� ������ ���´�
						if(hyphen_count == 2) {
							second_hyphen_index = i;
						}
					}
				}
			}else {
				// ���ڳ� '-' �� �ƴ϶�� false
				return false;
			}
		}
		// '-' �� �������� ù��°, ���, �������� ���� ������ ī��Ʈ
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

		// ���� ���� �´��� Ȯ��
		if(!(first_number_count == 3 && (middle_number_count == 3 || middle_number_count == 4) && last_number_count == 4)) {
			return false;
		}
		
		return true;
	}

//	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String number = "010-123-2424";
//		System.out.println("��ȭ��ȣ >> ");
//		number = sc.next();

		D07_CheckValidPhoneNumber check = new D07_CheckValidPhoneNumber();

		System.out.println(check.correctNumber(number) ? "�ùٸ� ��ȣ " : "�ùٸ��� ���� ��ȣ");
	}

}
