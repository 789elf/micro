package myobj.item;

public class Candy extends Item{
	
	int healthy;
	
	
	public Candy(String name, int price) {
		super(name, price);
		healthy = 10;
	}
	
	public void use() {
		System.out.println(name + "사탕을 먹어서 " + healthy + "만큼 목 건강이 좋아졌습니다.");
	}
	
	public static void main(String[] args) {
		new Item("목캔디", 1500).info();
	}
}
