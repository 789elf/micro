package myobj.item;

public class Sword extends Item{

	int damage;
	
	public Sword(String name, int price) {
		super(name, price);
		damage = 400;
	}
	
	@Override
	public void use() {
		System.out.println(" ##�� ����##");
		System.out.println(name + "�� ���ݷ���" + damage + "�Դϴ�");
		
	}
	
}
