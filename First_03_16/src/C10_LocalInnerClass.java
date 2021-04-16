
public class C10_LocalInnerClass {
	
	/*
	 *  # ���� ���� Ŭ����
	 *  
	 *   - �޼��� ���ο��� �����Ͽ� ����ϴ� Ŭ����
	 *   - �޼��尡 ������ �ش� Ŭ������ ������ ���Ѵ�
	 */
	
	public static void main(String[] args) {
		class Apple{
			String size;
			String color;
			String insect;
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("���� �ڽ�").new Apple();

		// ���� ���� Ŭ������ ��ĳ���� �Ǿ��ִ� ����
		Fruit2 b = getSomething();
		// b��� �ν��Ͻ��� ��������� ���� ���� Ŭ������ Banana�� �ڿ��� ����� ���� ������ 
		// ����� �ް� �� �θ� ���� �޼ҵ尡 �ִٸ� ����� �����ϴ�. 
		b.eat();
		
	}

	public static Fruit2 getSomething() {
		
		class Banana extends Fruit2{
			int fruit;
			int[] color;
			
			public Banana(int fruit) {
				this.fruit = fruit;
			}
			void eat() {
				System.out.println("���Ű� " + fruit + "��");
			}
			void banana���������ִ±��() {
				System.out.println("��û�� ���");
			}
		}
		return new Banana(10);
	}
}


abstract class Fruit2{
	abstract void eat();
}