
public class A04_VarNaming {
	
	public static void main(String[] args) {
		
		/*
		 *  # �츮�� ������ ����ؾ� �ϴ� ����
		 *  
		 *  1. ���� �ѹ��� ������ �� �ִ�.
		 *  	- ���� ������ ã�ƴٴϸ鼭 ������ �ʿ䰡 ��������.
		 *  
		 *  2. ���� �ǹ̸� �ο��� �� �ִ�.
		 *  	- ������ �̸��� ���� �ش� ���� �뵵�� ���� ������ �ľ��� �� �ִ�.
		 *  	- ������ �̸��� �� ���°��� �ſ� �߿��ϴ�.
		 *  
		 *  # ���� �۸� ��Ģ ( ���� ���� )
		 *  
		 *  (1) �� �ܾ� �̻��� �̾���� �������� ����� �� _ �� ����Ѵ�. (snake_case)
		 *  	ex: apple_count,minsu_age,sujin_grade
		 *  
		 *  (2) �� �ܾ� �̻��� �̾� ���� �������� ����� �� �빮�ڸ� Ȱ���Ѵ�. (camelCase)
		 *  	ex: appleCount,minsuAge,sujinGrade
		 *  
		 *  (3) ������ ù ���ڴ� �ҹ��ڸ� ����Ѵ�.
		 *  
		 *  (4) Ŭ������ ù ���ڴ� �빮�ڸ� ����Ѵ�.
		 *  
		 *  (5) ���α׷� ������ ���� ������ ���� ����(���)�� ��� �빮�ڸ� ����Ѵ�.
		 *  	ex: APPLE_PRICE, APPLE_GRAM
		 *  
		 *  # ���� �۸� ��Ģ  ( �ʼ� ���� )
		 *  
		 *  (1) ������ ù ��° ���ڴ� ���ڰ� �� �� ����.
		 *  	EX: 1st,2nd,4pple
		 *  
		 *  (2) ������ ���̿��� ������ ����� �� ����.
		 *  
		 *  (3) Ư�����ڴ� _��  $�� ����� �� �ִ�.
		 *  
		 *  (4) ������ ����� �� ����.
		 *  	ex: byte, float, double, int ...
		 */
		int apple_Count = 15;
		int apple_Price = 493;
		int apple_Calorie = 110;
		int apple_Gram = 50;
		
		System.out.println("����� ���� : "+apple_Count);
		System.out.println("����� �� ���� : "+apple_Count * apple_Price+ "��");
		System.out.println("����� ���� Į�θ� : "+apple_Calorie+ "Kcal");
		System.out.println("����� �� Į�θ� : "+apple_Count * apple_Calorie+"Kcal");
		System.out.println("����� ���� ���� : "+ apple_Gram + "g");
		System.out.println("����� �� ���� : "+ apple_Count + apple_Gram + "g");
	}

}
