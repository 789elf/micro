package myobj.item;

public class Inventory {
	
	Item[] inventory;
	int size;
	
	public Inventory(int size) {
		inventory = new Item[size];
	}
	
	// item�� ��ӹ��� �ֵ��� �Ű������� ���� �� �ִ�. ( Candy, Swoard, ��� )
	public boolean put(Item item) {
		for(int i=0; i<inventory.length; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				return true;
			}
		}
		System.out.println("������ �� á���ϴ�.");
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
		
		//* Item�� �־�� �ϴ� �ڸ��� Item�� ��ӹ��� ��� �͵��� �� �� �ִ�.
		inven1.put(new Kart("�̿�",20000));
		inven1.put(new Sword("����", 450));
		inven1.put(new Shoes("�ż��� ��ȭ", 900));
		
		inven1.useAllItems();
	}
}
