package quiz;

public class B04_ConditionQuiz {

	public static void main(String[] args) {

		/*
        [ �˸��� �񱳿����� �������� ]
            
        1. int�� ���� a�� 10���� ũ�� 20���� ���� �� true
        2. int�� ���� b�� ¦���� �� true                
        3. int�� ���� c�� 7�� ����� �� true
        4. int�� ���� hour�� 0�̸� 24�̻��� �ƴϰ�, 12�̻��� �� true
        5. int�� ���� d�� e�� ���̰� 30�� �� true                
        6. int�� ���� year�� 400���� ������ �������ų� 
           	�Ǵ� 4�� ������ �������� 100���� ����������� ���� �� true
        7. �μ��� ö������ 2�� ������ true
        8. �μ��� ö������ ������ 3�� ������ true  
         9. boolean�� ���� powerOn�� false�� �� true
        10. ���ڿ� �������� str�� "yes"�� �� true
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
