
public class C10_LocalInnerClass {
	
	/*
	 *  # 지역 내부 클래스
	 *  
	 *   - 메서드 내부에서 선언하여 사용하는 클래스
	 *   - 메서드가 끝나면 해당 클래스도 수명이 다한다
	 */
	
	public static void main(String[] args) {
		class Apple{
			String size;
			String color;
			String insect;
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("고구마 박스").new Apple();

		// 내부 지역 클래스가 업캐스팅 되어있는 상태
		Fruit2 b = getSomething();
		// b라는 인스턴스를 만들었지만 내부 지역 클래스인 Banana의 자원을 사용할 수는 없지만 
		// 상속을 받고 그 부모에 같은 메소드가 있다면 사용이 가능하다. 
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
				System.out.println("열매가 " + fruit + "개");
			}
			void banana만가지고있는기능() {
				System.out.println("엄청난 기능");
			}
		}
		return new Banana(10);
	}
}


abstract class Fruit2{
	abstract void eat();
}