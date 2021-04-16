import myobj.DiffPackage;

public class C08_AccessModifier {

	/*
	 * C08_SamePackage , myobj.DiffPackage
	 * 
	 *  # ���� ������ ( Access Modifier)
	 *  
	 *    - �ٸ� Ŭ������ �ش� Ŭ������ �ڿ��� ����Ϸ��� �� ��
	 *      ������ ��������� �����Ѵ�
	 *      
	 *  # ���� �����ڸ� ���� ������ �� �ִ� �Ÿ��� ����
	 *    
	 *    - ���� Ŭ���������� �ٸ� �ڿ�  ( ���� ����� )
	 *    - ���� ��Ű�� ������ �ٸ� �ڿ�
	 *    - �ٸ� ��Ű���� ������ ��ӹ��� �ڿ�
	 *    - �ٸ� ��Ű���� �ڿ� ( ���� �� )
	 *    
	 *  # ���� �������� ����
	 *  
	 *	  - private 
	 *			 �տ� private�� ���� �ڿ��� ���� Ŭ���� ���ο����� ������ �� �ְ� �ȴ�.  
	 *  
	 *    - default ( �ƹ��͵� �� �� ) 
	 *    		 ���� ��Ű�����ο����� �����Ӱ� ������ �� �ְ� �ȴ�
	 *    		 �ٸ� ��Ű�������� ������ �� ����.
	 *    
	 *    - protected
	 *    		���� ��Ű�� ���ο����� �����Ӱ� ������ �� �ִ�.
	 *			�ٸ� ��Ű�������� ��ӹ��� Ŭ������ ������ �� �ִ� �ڿ��� �ȴ�.
	 *    
	 *    - public
	 *    		�ٸ� ��Ű�������� �����Ӱ� ������ �� �ִ� �ڿ��� �ȴ�.
 	 *	    
 	 *    * �׷� ���������ڸ� �� ���� ��ó�� public �޼ҵ忡 private�� ������ ���� ����� �� �ִµ� ? 
 	 *        : Ŭ���� �������� �ǵ��� ���� �� �� �ֱ� ������. ����Ѵ� (�޴����� ����)
	 */
	public static void main(String[] args) {
		C08_SamePackage instance = new C08_SamePackage();
		
		// SamePackage�� private ���� �� ��� �����ϴ�. ( ���� ��Ű�� ���� �����ϱ� )
		instance.protected_method();
		instance.default_method();
		instance.public_method();
		
		// DiffPackage�� public�� ����� �����ϴ� ( �٤Ӹ���Ű�� )
		DiffPackage instance2 = new DiffPackage(); 
		
		//public�� �ƴϾ public�� �޼ҵ�� �� �� �ֱ⶧���� private,protect,default�� ���������� Ȯ���� �����ϴ�.
		instance2.public_method();
	}
}


class Snack{
	int size = 10;
	
	private void eat() {
		System.out.println(size - 1);
	}
}

class HoneyButterChip extends Snack{
	
	private void abc() {
		System.out.println(size);
	}
}

class Choco extends DiffPackage{
	
	public Choco() {
		this.protected_var = 1; // ����� ������ protected�� �ٸ� ��Ű������ ��� ����
	}
	
	void abc() {
		Snack s = new Snack();
		int size = s.size;
	}
}