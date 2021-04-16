
public class A04_VarNaming {
	
	public static void main(String[] args) {
		
		/*
		 *  # 우리가 변수를 사용해야 하는 이유
		 *  
		 *  1. 값을 한번에 변경할 수 있다.
		 *  	- 값을 일일히 찾아다니면서 변경할 필요가 없어진다.
		 *  
		 *  2. 값에 의미를 부여할 수 있다.
		 *  	- 변수의 이름을 통해 해당 값의 용도를 쉽고 빠르게 파악할 수 있다.
		 *  	- 변수의 이름을 잘 짓는것이 매우 중요하다.
		 *  
		 *  # 변수 작명 규칙 ( 권장 사항 )
		 *  
		 *  (1) 두 단어 이상을 이어붙힌 변수명을 사용할 때 _ 를 사용한다. (snake_case)
		 *  	ex: apple_count,minsu_age,sujin_grade
		 *  
		 *  (2) 두 단어 이상을 이어 붙힌 변수명을 사용할 때 대문자를 활용한다. (camelCase)
		 *  	ex: appleCount,minsuAge,sujinGrade
		 *  
		 *  (3) 변수명 첫 글자는 소문자를 사용한다.
		 *  
		 *  (4) 클래스명 첫 글자는 대문자를 사용한다.
		 *  
		 *  (5) 프로그램 내에서 값이 변하지 않을 변수(상수)는 모두 대문자를 사용한다.
		 *  	ex: APPLE_PRICE, APPLE_GRAM
		 *  
		 *  # 변수 작명 규칙  ( 필수 사항 )
		 *  
		 *  (1) 변수의 첫 번째 글자는 숫자가 될 수 없다.
		 *  	EX: 1st,2nd,4pple
		 *  
		 *  (2) 변수명 사이에는 공백을 사용할 수 없다.
		 *  
		 *  (3) 특수문자는 _와  $만 사용할 수 있다.
		 *  
		 *  (4) 예약어는 사용할 수 없다.
		 *  	ex: byte, float, double, int ...
		 */
		int apple_Count = 15;
		int apple_Price = 493;
		int apple_Calorie = 110;
		int apple_Gram = 50;
		
		System.out.println("사과의 갯수 : "+apple_Count);
		System.out.println("사과의 총 가격 : "+apple_Count * apple_Price+ "원");
		System.out.println("사과의 개당 칼로리 : "+apple_Calorie+ "Kcal");
		System.out.println("사과의 총 칼로리 : "+apple_Count * apple_Calorie+"Kcal");
		System.out.println("사과의 개당 무게 : "+ apple_Gram + "g");
		System.out.println("사과의 총 무게 : "+ apple_Count + apple_Gram + "g");
	}

}
