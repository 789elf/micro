
public class B17_Array {

	public static void main(String[] args) {

		/*
			 # �迭 ( Array )
			 
			  - ���� Ÿ�� ������ �ѹ��� ������ �����ϴ� ���
			  - ���� �̸����� ������ ������ ������ �� �ε����� Ȱ���� �����Ѵ�
			  - �迭�� �ѹ� ũ�Ⱑ �������� ũ�⸦ ������ �� ����.
			  - �迭�� ������ ���ÿ� �ʱ�ȭ�� �Ǿ��ִ�.
			   (����: 0, �Ǽ�: 0.0, boolean: false, ������: null)
		 
		 	 # �迭�� �����ϴ� ���
		 	 
		 	  1. Ÿ��[] �迭�̸� = new Ÿ��[�迭 ũ��];
		 	  2. Ÿ��[] �迭�̸� = { ��1, ��2, ��3, ...};\
		 	  3. Ÿ��[] �迭�̸� = new Ÿ��[] {��1, ��2, ��3, ...};
		 	  
		 	 # String�� char�� �迭�� ��ȯ�� �� �ִ�.
 		 */
		
		int[] score = new int[133];

		for(int index=0; index < score.length; index++) {
			score[index] = (int)(Math.random() * 101);
		}
		
//		System.out.println("10��° �л��� ����: "+ score[9]);
		
		// �������� 1 : score�� ���հ� ���(�Ҽ� ��°�ڸ�) ���
		
		int total=0;
		float avg;
		
		for(int i=0; i<score.length; i++) {
			total += score[i];
		}
		
		avg = total / (float)score.length;
		System.out.printf("���� : %d\n��� : %.2f",total, avg);
		
		
		
		//�迭�� �����ϴ� ���
		char[] grade = new char[5];
		int[] age = {10, 15, 20, 18, 31, 80, 75};
		boolean[] passExam = {true, false, true, true, false};
		String[] animals = new String[] {"lion", "tiger", "penguin", "monkey"};

		System.out.println(animals[0]);
		System.out.println(animals[3]);

		if(passExam[3]) {
			System.out.println("4��° ����� ������ ����߽��ϴ�.");
		}
		
		//�ʱ�ȭ�� �˾Ƽ� ���ش�
		for(int i=0; i<grade.length;i++) {
			System.out.println((int)grade[i]);  // char �⺻ �ʱ�ȭ 0 = null�̶� int�� ����ȯ�� �ϰ� Ȯ���ؾ� ���´�. 
		}
		
		int[] arr = new int[3];
		int a, b, c;
		System.out.println("arr[0]: "+ arr[0]);
		
		// String -> char�� �迭�� ��ȯ
		char[] msg1 = new char[] { 'h', 'e', 'l', 'l', 'o'};
		String msg2 = "hello";
		char[] msg3 = msg2.toCharArray(); // String "hello" �� �ϳ��� char���·� ����
		
		System.out.println(msg1[0]);
		System.out.println(msg1[1]);
		System.out.println(msg1[2]);
		
		System.out.println(msg2.charAt(0));
		System.out.println(msg2.charAt(1));
		System.out.println(msg2.charAt(2));
		
		System.out.println(msg3[0]);
		System.out.println(msg3[1]);
	}

}
