
public class B17_Array {

	public static void main(String[] args) {

		/*
			 # 배열 ( Array )
			 
			  - 같은 타입 변수를 한번에 여러개 선언하는 방법
			  - 같은 이름으로 변수를 여러개 선언한 뒤 인덱스를 활용해 구분한다
			  - 배열은 한번 크기가 정해지면 크기를 변경할 수 없다.
			  - 배열은 생성과 동시에 초기화가 되어있다.
			   (정수: 0, 실수: 0.0, boolean: false, 참조형: null)
		 
		 	 # 배열을 선언하는 방법
		 	 
		 	  1. 타입[] 배열이름 = new 타입[배열 크기];
		 	  2. 타입[] 배열이름 = { 값1, 값2, 값3, ...};\
		 	  3. 타입[] 배열이름 = new 타입[] {값1, 값2, 값3, ...};
		 	  
		 	 # String은 char형 배열로 변환할 수 있다.
 		 */
		
		int[] score = new int[133];

		for(int index=0; index < score.length; index++) {
			score[index] = (int)(Math.random() * 101);
		}
		
//		System.out.println("10번째 학생의 점수: "+ score[9]);
		
		// 연습문제 1 : score의 총합과 평균(소수 둘째자리) 출력
		
		int total=0;
		float avg;
		
		for(int i=0; i<score.length; i++) {
			total += score[i];
		}
		
		avg = total / (float)score.length;
		System.out.printf("총점 : %d\n평균 : %.2f",total, avg);
		
		
		
		//배열을 선언하는 방법
		char[] grade = new char[5];
		int[] age = {10, 15, 20, 18, 31, 80, 75};
		boolean[] passExam = {true, false, true, true, false};
		String[] animals = new String[] {"lion", "tiger", "penguin", "monkey"};

		System.out.println(animals[0]);
		System.out.println(animals[3]);

		if(passExam[3]) {
			System.out.println("4번째 사람은 시험을 통과했습니다.");
		}
		
		//초기화를 알아서 해준다
		for(int i=0; i<grade.length;i++) {
			System.out.println((int)grade[i]);  // char 기본 초기화 0 = null이라서 int로 형변환을 하고 확인해야 나온다. 
		}
		
		int[] arr = new int[3];
		int a, b, c;
		System.out.println("arr[0]: "+ arr[0]);
		
		// String -> char형 배열로 전환
		char[] msg1 = new char[] { 'h', 'e', 'l', 'l', 'o'};
		String msg2 = "hello";
		char[] msg3 = msg2.toCharArray(); // String "hello" 를 하나씩 char형태로 저장
		
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
