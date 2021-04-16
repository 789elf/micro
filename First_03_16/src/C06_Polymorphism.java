import java.util.Scanner;

public class C06_Polymorphism {

/*
 * 	# ��ü�� ������
 * 	  
 *    - ��ü�� �پ��� ���¸� ���� �� �ִ�
 *    - ����� ����̱⵵ �ϰ� �����̱⵵ �ϴ�
 *    - ������ ���������� ����� �ƴϴ�.
 *    
 *  # �ڽ� Ŭ������ �θ� Ŭ������ �� �� �ִ�. (��ĳ����)(�θ��� ���� ��밡��)
 *   - �ڽ� Ŭ���� Ÿ���� �θ� Ŭ���� Ÿ���� �Ǵ� ���� ��ĳ�����̶�� �Ѵ�.
 *   - ��ĳ���õ� ��ü�� �ڽ� Ŭ�������� �����ϴ� �͵��� ��� �ؾ������.
 *   - �������̵�� �״�� �����ȴ�.
 *   
 *  # �θ� Ŭ������ �ڽ� Ŭ������ �� �� ����. (�ٿ�ĳ����)(�θ�� �ڽ��� ���� ��� �Ұ�) 
 *    
 *    - ������ ���������� ��ĳ���� �Ǿ��� �ν��Ͻ��� �ٽ� ���� Ÿ������ �ٿ�ĳ������ ���� 
 *      ex) Police -> Person -> Police
 */
}

/*  ��� ��� ex)
 *  Car�� TireVer1�� ����ϴٰ� TireVer2�� ���� ���ﶧ ���������� ����
 *  new Car(new Tire());
 *  new Car(new TireVer1());   -- > new Car(new TireVer2());
 */
class Car{
	Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
}

class Tire{}
class Tire2{}

class TireVer1 extends Tire{}
class TireVer2 extends Tire{}

class Food{
	MainMaterial mainMat;
	SubMaterial subMat;
	Sauce sauce;
	
	public Food(MainMaterial mainMat, SubMaterial subMat, Sauce sauce) {
		this.mainMat = mainMat;
		this.subMat = subMat;
		this.sauce = sauce;
	}
}

class PorkCutlet{
	public PorkCutlet(PigMeat pig, SubMaterial subMat, Sauce sauce) {
		new Food(new PigMeat(), new Vege(), new Balsamic());
		
		
		//������ �ν��Ͻ� ���� ���� ��� (�������ε�)
		Scanner sc = new Scanner(System.in);
		String str = new String();
		MainMaterial main_mat = new MainMaterial();   //�������ε��� ���
		
		//����� ����ϸ� ������ ���� ���(�������ε�)
		MainMaterial main_mat2 = new Meat();   // �� ��Ḧ ��� ���� ��� ��ü�� ���� ������ ����
		MainMaterial main_mat3 = new Fish();   // �� ��Ḧ ��� ���� ��� ��ü�� ���� ������ ����
	
		Police police = new Police();
		police.sayHi();
		police.arrest("�谭��");
		
		// Person���� ��ĳ���õ� police�� ü���� �� �� ����.
		Person person = police; //��ĳ����
		Person person2 = new Person("����ġ", 20, 30);
		person.sayHi();
		
		//�ٿ� ĳ������ Ȱ���� ���� ��� �ٽ� ����ϱ�
		//���� �����̾��� �ν��Ͻ��� �ٿ�ĳ������ ���� 
		((Police)person).arrest("��Ҹ�"); //�ٿ�ĳ����
		
		//������ �ƴϾ��� �ν��Ͻ��� �ٿ�ĳ���� �Ұ���
//		((Police)person2).arrest("�赵��");
	}
	public static void doSomethingWithmainMaterial(MainMaterial mat) {
			
	}
}

//���� ���� �θ� Ŭ���� (�����, �����, �ҽ�)
class MainMaterial{}
class SubMaterial{}
class Sauce{}

// ����Ḧ ��ӹ��� Ŭ������
class Fish extends MainMaterial{}
class Meat extends MainMaterial{}

// ����Ḧ ��ӹ��� Ŭ������ ��ӹ��� Ŭ����
class PigMeat extends Meat{}

// ����Ḧ ��ӹ��� Ŭ������
class Vege extends SubMaterial{}
class Fruit extends SubMaterial{}

// �ҽ��� ��ӹ��� 
class Salsa extends Sauce{}
class Balsamic extends Sauce{}