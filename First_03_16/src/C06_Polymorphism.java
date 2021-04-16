import java.util.Scanner;

public class C06_Polymorphism {

/*
 * 	# 객체의 다형성
 * 	  
 *    - 객체는 다양한 형태를 지닐 수 있다
 *    - 사과는 사과이기도 하고 과일이기도 하다
 *    - 과일은 과일이지만 사과는 아니다.
 *    
 *  # 자식 클래스는 부모 클래스가 될 수 있다. (업캐스팅)(부모의 모든것 사용가능)
 *   - 자식 클래스 타입이 부모 클래스 타입이 되는 것을 업캐스팅이라고 한다.
 *   - 업캐스팅된 객체는 자식 클래스에만 존재하던 것들을 모두 잊어버린다.
 *   - 오버라이드는 그대로 유지된다.
 *   
 *  # 부모 클래스는 자식 클래스가 될 수 없다. (다운캐스팅)(부모는 자식의 모든것 사용 불가) 
 *    
 *    - 하지만 예외적으로 업캐스팅 되었던 인스턴스는 다시 원래 타입으로 다운캐스팅이 가능 
 *      ex) Police -> Person -> Police
 */
}

/*  상속 사용 ex)
 *  Car가 TireVer1을 사용하다가 TireVer2로 갈아 끼울때 유지보수의 편리함
 *  new Car(new Tire());
 *  new Car(new TireVer1());   -- > new Car(new TireVer2());
 */
class Car{
	Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
}

class Tire{}
class Tire2{}

class TireVer1 extends Tire{}
class TireVer2 extends Tire{}

class Food{
	MainMaterial mainMat;
	SubMaterial subMat;
	Sauce sauce;
	
	public Food(MainMaterial mainMat, SubMaterial subMat, Sauce sauce) {
		this.mainMat = mainMat;
		this.subMat = subMat;
		this.sauce = sauce;
	}
}

class PorkCutlet{
	public PorkCutlet(PigMeat pig, SubMaterial subMat, Sauce sauce) {
		new Food(new PigMeat(), new Vege(), new Balsamic());
		
		
		//기존의 인스턴스 변수 선언 방식 (정적바인딩)
		Scanner sc = new Scanner(System.in);
		String str = new String();
		MainMaterial main_mat = new MainMaterial();   //정적바인딩의 모습
		
		//상속을 사용하면 가능한 선언 방식(동적바인딩)
		MainMaterial main_mat2 = new Meat();   // 주 재료를 상속 받은 모든 객체로 변수 선언이 가능
		MainMaterial main_mat3 = new Fish();   // 주 재료를 상속 받은 모든 객체로 변수 선언이 가능
	
		Police police = new Police();
		police.sayHi();
		police.arrest("김강도");
		
		// Person으로 업캐스팅된 police는 체포를 할 수 없다.
		Person person = police; //업캐스팅
		Person person2 = new Person("전우치", 20, 30);
		person.sayHi();
		
		//다운 캐스팅을 활용해 원래 기능 다시 사용하기
		//원래 경찰이었던 인스턴스는 다운캐스팅이 가능 
		((Police)person).arrest("김소매"); //다운캐스팅
		
		//경찰이 아니었떤 인스턴스는 다운캐스팅 불가능
//		((Police)person2).arrest("김도적");
	}
	public static void doSomethingWithmainMaterial(MainMaterial mat) {
			
	}
}

//제일 높은 부모 클래스 (주재료, 부재료, 소스)
class MainMaterial{}
class SubMaterial{}
class Sauce{}

// 주재료를 상속받은 클래스들
class Fish extends MainMaterial{}
class Meat extends MainMaterial{}

// 주재료를 상속받은 클래스를 상속받은 클래스
class PigMeat extends Meat{}

// 부재료를 상속받은 클래스들
class Vege extends SubMaterial{}
class Fruit extends SubMaterial{}

// 소스를 상속받은 
class Salsa extends Sauce{}
class Balsamic extends Sauce{}