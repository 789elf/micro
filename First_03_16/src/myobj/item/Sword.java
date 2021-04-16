package myobj.item;

public class Sword extends Item{

	int damage;
	
	public Sword(String name, int price) {
		super(name, price);
		damage = 400;
	}
	
	@Override
	public void use() {
		System.out.println(" ##검 정보##");
		System.out.println(name + "의 공격력은" + damage + "입니다");
		
	}
	
}
