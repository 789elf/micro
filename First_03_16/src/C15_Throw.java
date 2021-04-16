import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C15_Throw {

	/*
	 *  # throw
	 *  
	 *  - ���ϴ� ���ܸ� �߻���Ų��
	 *  
	 *  # throws
	 *  
	 *  - �ش� �޼��忡�� �̷��� ���ܵ��� �߻���Ų�ٴ� ���� �˸���
	 *  - �ش� �޼��带 ȣ���ϴ� ���� ��� ���� �� �ִ�.
	 *  
	 *  # Exception Ŭ������ ��ӹ��� ���ܴ� " �ݵ�� ó���ؾ� �ϴ� ���� "
	 *    - Exception�� ����ó���� ���� ������ ������ ������ �߻���Ų��
	 *    
	 *  
	 *  # RuntimeException Ŭ������ ��ӹ��� ���ܴ� "�� ó������ �ʾƵ� �Ǵ� ����" �� �ȴ�.
	 *    (InputMismachException, ArrayIndexOutOfBoundException�� ������ ������ �߻����� �ʴ´�)  
	 */

	
	public static void main(String[] args) {
		C15_Throw instance = new C15_Throw();
	
		try {
			instance.dangerous_method();
			instance.dangerous_method2();
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 ����" + e.getMessage());
		}
		
		try {
			instance.checkEven(20);
			instance.checkOdd(20);
		} catch (NotEvenException e) {
			System.out.println("¦�� �ƴ�");
		} catch(NotOddException e) {
			System.out.println("Ȧ�� �ƴ�");
		}
	}
	
	//�� �޼ҵ忡�� ����ó���� �̷��.
	public void dangerous_method() throws FileNotFoundException {
		// ������ ������ �о���� �غ� ����
		File f = new File("E:\\kg-ac\\temp\\nameless.txt");
		FileReader reader = new FileReader(f);
	}
	
	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("�׳� ����");
	}
	
	public void checkEven(int num) throws NotEvenException{
		if(num % 2 == 0) {
			System.out.println("¦�� �Դϴ�");
		}else {
			throw new NotEvenException();
		}
		System.out.println("checkEven �޼��尡 ���� ����");
	}
	
	public void checkOdd(int num){
		if(num % 2 == 1) {
			System.out.println("Ȧ�� �Դϴ�");
		}else {
			throw new NotOddException();
		}
		System.out.println("checkOdd �޼��尡 ���� ����");
	}
}

// ¦���� �ƴҶ� �߻� ��ų ���� (����ó�� ���� ������ ������ �Ұ�)
class NotEvenException extends Exception{ 
	public NotEvenException() {
		super("¦���� �ƴϾ �߻��ϴ� ����");
	}
}

// Ȧ���� �ƴ� �� �߻���ų ���� ( ����ó�� ���� �ʾƵ� �������� �ȶߴ� ����)
class NotOddException extends RuntimeException{
	public NotOddException() {
		super("Ȧ���� �ƴϾ �߻��ϴ� ����");
	}
}