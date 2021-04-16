
public class C11_AnonymousInnerClass {

	/*
	 *  # �͸� ���� Ŭ����
	 *  
	 *  - Ŭ������ �̸��� ���� �ʰ� ������ ���� �ٷ� ����ϴ� ���
	 *  - ��ȸ��
	 */
	
	
	public static void kick(Kickable something) {
		something.kick();
	}
	
	public static void punch(Punchable something) {
		something.punch();
	}
	
	public static void main(String[] args) {
		kick(new Human());
		kick(new VendingMachine());
		kick(new Ball("�޽�"));
		kick(new Ball("�⼺��"));
		
		class Door extends Kickable{
			boolean open;

			@Override
			void kick() {
				if(open) {
					System.out.println("��¦�� �߷� ���� �ݾҽ��ϴ�.");
					open = false;
				}else {
					System.out.println("��¦�� �߷� �Ⱦ����� �������ϴ�.");
					open = true;
				}
			}
		}
	
		
		Door door1 = new Door(), door2 = new Door(), door3 = new Door();
		
		kick(door1);
		kick(door2);
		kick(door3);
		
		// # �͸� Ŭ���� ("�Ｎ"���� Door�� ����� �ν��Ͻ��� ����
		// - ����� ���� �������� �ʱ� ������ �ٽ� ����� �� ����.
		kick(new Door() {
			@Override
			void kick() {
				System.out.println("ưư�� �ݰ� ���� ���ſ��� ��½�� ���� �ʾҽ��ϴ�.");
			}
		});
		kick(new Ball() {
			@Override
			void kick() {
				System.out.println("�󱸰��� �߷� á���� �ָ� �������� �ʰ� ������.");
			}
		});
		
		// punch �޼����� ���ڰ����� ������ �� �ִ� 
		// �͸�Ŭ������ 2���� ���� ���� Ŭ���� 2���� ���� ������ ������
		class Glass extends Punchable{
			@Override
			void punch() {
				System.out.println("������ �ָ����� �ƴ��� ���� ���ƽ��ϴ�.");
			}
		}
		
		punch(new Boxing());
		punch(new PunchMachine());
		punch(new Glass() {
			@Override
			void punch() {
				System.out.println("�ָ����� ������ �ν����ϴ�.");
			}
		});
		punch(new Boxing() {
			@Override
			void punch() {
				System.out.println("������ �Ϲ������� �¾ҽ��ϴ�.");
			}
		});
	}

}
abstract class Kickable{
	abstract void kick();
}

abstract class Punchable{
	abstract void punch();
}

class Boxing extends Punchable{
	@Override
	void punch() {
		System.out.println("������ ����� ���Ƚ��ϴ�.");
	}
}
class PunchMachine extends Punchable{
	@Override
	void punch() {
		System.out.println("��ġ��踦 ���ȴ��� ������ �����ϴ�.");
	}
	
}
class Ball extends Kickable{
	String kicker;
	
	public Ball() {}
	public Ball(String kicker) {
		this.kicker = kicker;
	}
	
	@Override
	void kick() {
		if(kicker.equals("�޽�")) {
			System.out.println("���� ���հ� á���ϴ�.");
		}else if(kicker.equals("�⼺��")) {
			System.out.println("�н��� ��Ȯ�ϰ� á���ϴ�.");
		}
	}
}

class Human extends Kickable{

	@Override
	void kick() {
		System.out.println("����� �߷� �Ⱦ�á���ϴ�.");
	}
}
class VendingMachine extends Kickable{

	@Override
	void kick() {
		System.out.println("���Ǳ⸦ �Ⱦ�á���� ������� �ϳ� ���Խ��ϴ�.");
	}
}
