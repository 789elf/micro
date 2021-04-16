package quiz;

public class B16_RandomPass {

	public static void main(String[] args) {

		/*
		 * 4자리의 랜덤 임시비밀번호를 생성하는 프로그램을 만들어보세요.

			(비밀번호를 구성하는 문자는 영어 대문자와 숫자입니다) 65 ~ 90   58 ~ 64
		 */
		//(Math.random() * 45 + 1) == 45)
		
		//문자열 + 하기에 효율 좋은 StringBuilder
		StringBuilder pw = new StringBuilder();
		
		//초기화
		pw.append("");
		
		
		for(int i=pw.length(); i<4; i++) {
			//'0'(48) ~ 'Z'(90)
			pw.append((char)((int)(Math.random()*42)+48));
			
			System.out.println(pw.charAt(i));
			
			//숫자와 알파벳 중간 특수문자
			if(pw.charAt(i) >= 58 && pw.charAt(i) <= 64){
				
				//특수문자가 섞인 경우 StringBuilder 메소드를 이용해 인덱스 제거
				 pw.deleteCharAt(i);
				 
				 //글자 제거된 만큼 i값도 -1 (반복문 한번 더해야함)
				 i--;
			}
		}
		
		System.out.println(pw);
	}
}
