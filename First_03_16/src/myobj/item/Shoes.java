package myobj.item;

public class Shoes extends Item{

	int speed;
	
	Shoes(String name, int price) {
		super(name, price);
		speed = 400;
	}
	
	@Override
	public void use() {
		System.out.println("\n ##�Ź� ����##");
		System.out.println(name + "�� �̵� �ӵ���" + speed + "�Դϴ�.");
	}
}
