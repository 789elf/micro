package myobj;


public class C08_Coffee {
	

//  �ٵ� main()�ȿ��� ���۷��������� �����Ҷ� Ŀ���̸����� C08_Coffee.AMERICANO�� ����ϴ°� ��������
//  �����ڿ��� ����ص� ������ ���� �ʴµ� �׷��� ����(?) �� �������� CoffeeCode��� Ÿ��(class)�� �����ؼ�
//  C08_Coffee �����ڿ� �Ű������� int coffee�� �ƴ� CoffeeCodeŸ������ ������ ���̻� �������� ���� �� �� ����.
static class CoffeeCode{
	int code;
	String name;
	
	CoffeeCode(){}
	
	private CoffeeCode(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}

static class OriginCode{
	int code;
	String name;
	
	public OriginCode(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}

	// C08_Coffee coffee = new C08_Coffee("�Ƹ޸�ī��", 1500, 10, 0); 
	// �� ���� �� �� ����, ī������ �ٸ� �� ������ �������� Ŀ�� �̸��� ��ΰ� ���� �̸��� ����ϰ� �Ǳ� ������ static���� ����ϴ°��� �޸𸮰� ���� �ȴ�.  
	private static String[] origin_name = {"�ݷҺ��", "�����", "��Ƽ���Ǿ�", "�ɳ�", "�ε�"};
	private static String[] coffee_name = {"�Ƹ޸�ī��", "ī���", "ī���ī", "�ٴҶ��"};
	
	// �迭�� �ε������� �ڵ��ȣ�� �����س��� �� �ִ�. 
	public final static CoffeeCode AMERICANMO = new CoffeeCode(0, "�Ƹ޸�ī��");
	public final static CoffeeCode CAFFEE_LATTE = new CoffeeCode(1, "ī���");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "ī���ī");
	public final static CoffeeCode VANILLA_LATTE = new CoffeeCode(3, "�ٴҶ��");
	
	public final static OriginCode COLOMBIA = new OriginCode(0, "�ݷҺ��");
	public final static OriginCode BRASIL = new OriginCode(1, "�����");
	public final static OriginCode ETHIOPIA = new OriginCode(2, "��Ƽ���Ǿ�");
	public final static OriginCode KENYA = new OriginCode(3, "�ɳ�");
	public final static OriginCode INDIA = new OriginCode(4, "�ε�");
	

	
	CoffeeCode coffee;
	OriginCode origin;
	
	int price;
	int caffeine;
	
	boolean hot;
	
	
	public C08_Coffee(CoffeeCode coffee, int price, int caffeine, OriginCode origin) {

		this.coffee = coffee;
		this.price = price;
		this.caffeine = caffeine;
		this.origin = origin;
		this.hot = true;
	}
	
	public String getCoffeeName() {
		return coffee.name;
	}
	public int getCoffeecode() {
		return coffee.code;
	}
	
	public static void main(String[] args) {

		C08_Coffee coffee = new C08_Coffee(C08_Coffee.AMERICANMO, 1500, 10, C08_Coffee.COLOMBIA);

		System.out.println(coffee.getCoffeeName());
		C08_Coffee coffee2 = new C08_Coffee(C08_Coffee.CAFFEE_LATTE, 1500, 10, C08_Coffee.COLOMBIA);
//		C08_Coffee coffee3 = new C08_Coffee(C08_Coffee.CAFE_MOCHA , 1500, 10, 0);
//		C08_Coffee coffee4 = new C08_Coffee(C08_Coffee.VANILLA_LATTE, 1500, 10, 0);
	}
}
