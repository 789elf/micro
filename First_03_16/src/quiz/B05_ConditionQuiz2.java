package quiz;

import java.util.Scanner;

public class B05_ConditionQuiz2 {

	public static void main(String[] args) {
		/*
        [ �˸��� ���ǽ��� �������� ]

        1. char�� ���� a�� 'q'�Ǵ� 'Q'�� �� true
           2. char�� ���� b�� �����̳� ���� �ƴ� �� true
        3. char�� ���� c�� ����('0' ~ '9')�� �� true
        4. char�� ���� d�� ������(�빮�� �Ǵ� �ҹ���)�� �� true
        5. char�� ���� e�� �ѱ��� �� true
        6. char�� ���� f�� �Ϻ����� �� true        
*/        
		Scanner sc = new Scanner(System.in);
		
		char a,b,c,d,e,f;

		a = 'q';
		b = 'a';
		c = '5';
		d = 'e';
		e = '��';
		f = '��';
		String user_Input;
		
		System.out.println("1. : "+ (a == 'q' || a == 'Q'));
		System.out.println("2. : "+ (b != ' ' && b != '\t'));
		System.out.println("3. : "+ (c >= '0' && c <= '9'  ));
		
		System.out.println("4. : "+ ((d >= 'A' && d <= 'Z' ) ||(d >= 'a' && d <= 'z')));
		System.out.println("5. : "+ ((int)e >= 12593 && (int)e <= 55203));
		System.out.println("6. : "+ ((int)f >= 12392 && (int)f <= 12534));
		
		System.out.println("�ܾ� �Է� : ");
		user_Input = sc.next();
		System.out.println(user_Input.equals("exit"));
	}

}
