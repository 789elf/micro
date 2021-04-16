package quiz;

public class A02_Introduce {

	public static void main(String[] args) {
		
		String name,tel;
		int age,weight;
		double height;
		char blood_Type;
		boolean male;
		
		name = "홍길동";
		age = 20;
		tel = "010-1234-1234";
		height = 178.5;
		weight = 75;
		blood_Type = 'O';
		male = true;
		
		System.out.println("==========출력 결과==========\n");
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println("Tel :"+tel);
		System.out.println("키    :"+height);
		System.out.println("몸무게 :"+weight);
		System.out.println("혈액형 :"+blood_Type);
		System.out.println("남성 :"+male);
	}

}
