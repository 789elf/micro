package myobj.item;

/*
 *  이 클래스를 상속받아 아이템을 3개 만들어 보세요
 *  
 *  * Item 클래스는 수정하지 말 것
 *  
 */
public class Item {

	String name;
	int price;
	int qty;
	
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// final을 붙힌 메서드는 자식 클래스에서 오버라이드를 금지시킨다. 
	final public void info() {
		System.out.println("이름 : " + name );
		System.out.println("가격 : " + price + "원");
	}
	public void use() {
		System.out.println("세부 사항은 자식클래스에서 오버라이드로 구현"); //사탕을 사용햇을때 어떤 효과가 일어나는지 등
	}
}

