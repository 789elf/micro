package myobj.item;
import myobj.item.*;

public class Kart extends Item{


	static String name = "�̿�";
	int speed = 1000;
	char grade = 'S';
	
	Kart(String name, int price){
		super(name, price);
	}
	
	@Override
	public void use() {
		System.out.println("\n ##īƮ ����##");
		System.out.println("�̸� : " + name);
		System.out.println("��� : " + grade);
		System.out.println("�ӵ� : " + speed);
		System.out.println("���� : " + super.price);
	}
	
	public static void main(String[] args) {
		new Sword("���", 50000).use();
		new Shoes("�ż��� ��ȭ", 900).use();
		new Kart(name, 20000).use();
	}

}
