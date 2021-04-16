package quiz;

public class B04_ConditionQuiz {

	public static void main(String[] args) {

		/*
        [ 알맞은 비교연산을 만들어보세요 ]
            
        1. int형 변수 a가 10보다 크고 20보다 작을 때 true
        2. int형 변수 b가 짝수일 때 true                
        3. int형 변수 c가 7의 배수일 때 true
        4. int형 변수 hour가 0미만 24이상이 아니고, 12이상일 때 true
        5. int형 변수 d와 e의 차이가 30일 때 true                
        6. int형 변수 year가 400으로 나누어 떨어지거나 
           	또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
        7. 민수가 철수보다 2살 많으면 true
        8. 민수가 철수보다 생일이 3달 빠르면 true  
         9. boolean형 변수 powerOn이 false일 때 true
        10. 문자열 참조변수 str이 "yes"일 때 true
*/        
		
		int a,b,c,hour,d,e,year,minsu_Age,minsu_Month,chulsu_Age,chulsu_Month;
		boolean powerOn;
		String str;
		
		a = 12;
		b = 2;
		c = 49;
		hour = 13;
		e = 31;
		d = 1;
		year = 2000;
		minsu_Age = 12;
		minsu_Month = 2;
		chulsu_Age = 10;
		chulsu_Month = 5;
		
		powerOn = false;
		
		str = "yes";
		
		System.out.println("1. : "+ (a > 10 && a < 20 ));
		System.out.println("2. : "+ (b % 2 == 0));
		System.out.println("3. : "+ (c % 7 == 0));
		System.out.println("4. : "+ (hour > 0 || hour >= 24 && 12 <= hour));
		
		System.out.println(Math.abs(d - e) == 30);
		//System.out.println("5. : "+ (d - e == 30 || e - d == 30));
		
		
		System.out.println("6. : "+ (year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)));
		System.out.println("7. : "+ (minsu_Age - chulsu_Age == 2));
		System.out.println("8. : "+ (chulsu_Month - minsu_Month == 3));
//		System.out.println("9. : "+ (powerOn == false));
		System.out.println("9. : " + !(powerOn));
		System.out.println("10. : "+ (str.equals("yes")));
		
		
	}

}
