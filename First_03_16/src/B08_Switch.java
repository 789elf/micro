
public class B08_Switch {

	public static void main(String[] args) {

		/*
		 * 	# switch-case문
		 * 	-()안의 연산 결과에 따라 실행할 코드를 결정한다.
		 * 	-()안에 boolean타입은 들어갈 수 없다.
		 * 	- if문으로 완벽하게 대체 가능하다.
		*/
		
		int a = 11;
		switch (a % 2) {
		case 0:
			System.out.println("a는 짝수입니다.");
			break;
		case 1:
			System.out.println("a는 홀수입니다.");
			break;
		}
		
		char grade = 'A';
		
		switch (grade) {
			case 'E': case 'e':	//case 나열 가능
				System.out.println("전체 관람가 입니다.");
				break;
			case 'K': case 'k':
				System.out.println("12세 이상 관람가 입니다.");
				break;
			case 'Y': case 'y':
				System.out.println("15세 이상 관람가 입니다.");
				break;
			case 'A': case 'a':
				System.out.println("19세 이상 관람가 입니다.");
				break;
			default:	//if문의 else같은 .
				System.out.println("상영제한 등급입니다.");
				break;
			
		}
	}

}
