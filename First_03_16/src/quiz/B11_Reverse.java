package quiz;

import java.util.Scanner;

public class B11_Reverse {

	public static void main(String[] args) {

		//����ڰ� ������ �Է��ϸ� �� ������ �Ųٷ� ����غ�����.
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		System.out.println("������ �Է��ϼ���. > ");
		str = sc.next();
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(str.length() - (i+1)));
		}
				
			
	}

}
