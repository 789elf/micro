
public class C12_Interface {

	/*
	 *	# �������̽�
	 *
	 *	- abstract class�� ����� ������ ���� �� ���ٴ� ������ ������ ��
	 *	- �������̽� ������ �޼ҵ�� �ڵ����� abstract public�� �ȴ� (������ �޼ҵ带 �����ؾ� �Ѵ�)
	 *  - �������̽� ������ ������ �ڵ����� final static�� �ȴ�
	 *  - �������̽� ������ �޼��带 ������ �� default �� ������ �⺻ ������ ������ �� �ִ�
	 */
	
	public static void main(String[] args) {
		new OrangeTree().click();
	}
}

interface CanClick{
	int a = 10;			 	  // �ڵ����� final static
	default void click() {	      // abstract public�� �ڵ����� �پ��ִ�
		System.out.println("Ŭ�� �������̽��� �޷��ִ� Ŭ������ �⺻ ����. (�������̵� �ؼ� ����ϼ���)");
	}
}
interface CanPunch{
	abstract void punch();
}

class OrangeTree implements CanClick, CanPunch{
	@Override
	public void click() {
	}
	@Override
	public void punch() {
		
	}
}
