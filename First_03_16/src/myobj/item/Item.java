package myobj.item;

/*
 *  �� Ŭ������ ��ӹ޾� �������� 3�� ����� ������
 *  
 *  * Item Ŭ������ �������� �� ��
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
	
	// final�� ���� �޼���� �ڽ� Ŭ�������� �������̵带 ������Ų��. 
	final public void info() {
		System.out.println("�̸� : " + name );
		System.out.println("���� : " + price + "��");
	}
	public void use() {
		System.out.println("���� ������ �ڽ�Ŭ�������� �������̵�� ����"); //������ ��������� � ȿ���� �Ͼ���� ��
	}
}

