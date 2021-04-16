package myobj.item;

public class Inventory {
	
	Item[] inventory;
	int size;
	
	public Inventory(int size) {
		inventory = new Item[size];
	}
	
	// item을 상속받은 애들을 매개변수로 넣을 수 있다. ( Candy, Swoard, 등등 )
	public boolean put(Item item) {
		for(int i=0; i<inventory.length; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				return true;
			}
		}
		System.out.println("가방이 꽉 찼습니다.");
		return false;
	}
	
	public void useAllItems() {
		for(Item item : inventory) {
			if(item!=null) {
				item.use();
			}
		}
	}
	public static void main(String[] args) {
		Inventory inven1 = new Inventory(3);
		
		//* Item을 넣어야 하는 자리에 Item을 상속받은 모든 것들이 들어갈 수 있다.
		inven1.put(new Kart("이온",20000));
		inven1.put(new Sword("도란", 450));
		inven1.put(new Shoes("신속의 장화", 900));
		
		inven1.useAllItems();
	}
}
