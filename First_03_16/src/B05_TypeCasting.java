
public class B05_TypeCasting {

	public static void main(String[] args) {

		/*
		 * 	# Ÿ�� ĳ����
		 * 	- Ÿ���� �ڿ������� ���ϴ� ��� (Ÿ���� ���ϴ��� ������ ���� ��)
		 * 	- Ÿ���� ������ ��ȯ��Ű�� ��� (Ÿ���� ���ϸ� ������ ��)
		 * 
		 * 	# Ÿ���� ũ��
		 * 	- ���� Ÿ��: byte(1) < char,short(2) < int(4) < long(8)
		 * 	- �Ǽ� Ÿ��: float(4) < double(8)
		 * 
		 * 	# ���� Ÿ���� ������ �Ǽ� Ÿ�Ժ��� ǥ�� ������ �۴�.
		 */
		
		// 1. �ڿ������� Ÿ�� ĳ����
		byte _byte = 127;
		int _int;
		long _long;
		float _float;
		short _short;
		_int = _byte;
		_int = 2100000000;
		_long = _int;
		_float = _long;
	
		// 2. ���� �ջ�� ������ �ִ� Ÿ�� ĳ����
		_int = 1000;
		_short = (short)_int;	// ���� �ջ�� �� ������ ��� ���ְ� ���� ĳ������ �ؾ��Ѵ�.
		
		// 3. ���� ���̴��� �ٸ��� �ؼ��� �� �ִ� Ÿ���� ��� Ÿ�� ĳ������ �ʿ��ϴ�.
		int a = 80;
		char ch = 'z';
		
		System.out.println((char) a);
		System.out.println(a);
		
		System.out.println((int) ch);
		System.out.println(ch);
		
		
		
		
	}

}
