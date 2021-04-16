package myobj.item;

public class Shoes extends Item{

	int speed;
	
	Shoes(String name, int price) {
		super(name, price);
		speed = 400;
	}
	
	@Override
	public void use() {
		System.out.println("\n ##신발 정보##");
		System.out.println(name + "의 이동 속도는" + speed + "입니다.");
	}
}
