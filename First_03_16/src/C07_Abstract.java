
public class C07_Abstract {

	/*
	 *  # �߻� Ŭ����
	 *  
	 *    - �ϼ��� �ڽ� Ŭ�������� �̷�� Ŭ����
	 *    - �߻�޼ҵ带 �ϳ��� ���� �ִٸ� �߻� Ŭ����
	 *    
	 *  # �߻� �޼ҵ�
	 *    - �Լ��� ����(���� Ÿ��, ���� ������, �Ű�����)�� ���س��� �ڼ��� ������
	 *      �ڽ� Ŭ�������� �������̵带 ���� �����ϴ� �޼ҵ�
	 *      
	 *    - �ڽ� Ŭ�������� �������̵� ���� ������ ������ ������ �߻��Ѵ� (�ʼ�)
	 */
	public static void main(String[] args) {
		Vehicle v1 = new Bus();
		
		//�͸� Ŭ����
		Vehicle v2 = new Vehicle() {
			
			@Override
			void ride() {
				System.out.println("�Ｎ���� ������ Ż ��");
			}
		};
		
		v1.ride();
		v2.ride();
	}
}

abstract class Vehicle{
	
	abstract void ride();
}

class Bus extends Vehicle{
	
	@Override
	void ride() {
		System.out.println("����� ���� Ÿ����");
	}
}
class Bike extends Vehicle{

	// �������̵� ���� (���� �Լ���, ���� ���� Ÿ��, ���� �Ű� ����)
	@Override 
	void ride() {
		
	}
}