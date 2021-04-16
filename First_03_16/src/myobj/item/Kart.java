package myobj.item;
import myobj.item.*;

public class Kart extends Item{


	static String name = "이온";
	int speed = 1000;
	char grade = 'S';
	
	Kart(String name, int price){
		super(name, price);
	}
	
	@Override
	public void use() {
		System.out.println("\n ##카트 정보##");
		System.out.println("이름 : " + name);
		System.out.println("등급 : " + grade);
		System.out.println("속도 : " + speed);
		System.out.println("가격 : " + super.price);
	}
	
	public static void main(String[] args) {
		new Sword("목검", 50000).use();
		new Shoes("신속의 장화", 900).use();
		new Kart(name, 20000).use();
	}

}
