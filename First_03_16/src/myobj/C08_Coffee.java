package myobj;


public class C08_Coffee {
	

//  근데 main()안에서 래퍼런스변수를 생성할때 커피이름에는 C08_Coffee.AMERICANO를 사용하는게 편하지만
//  생성자에서 사용해도 오류는 뜨지 않는데 그러한 가라(?) 를 막으려면 CoffeeCode라는 타입(class)을 생성해서
//  C08_Coffee 생성자에 매개변수에 int coffee가 아닌 CoffeeCode타입으로 받으면 더이상 원산지에 가라를 쓸 수 없다.
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

	// C08_Coffee coffee = new C08_Coffee("아메리카노", 1500, 10, 0); 
	// 로 선언 할 때 가격, 카페인은 다를 수 있지만 원산지와 커피 이름은 모두가 같은 이름을 사용하게 되기 때문에 static으로 사용하는것이 메모리가 절약 된다.  
	private static String[] origin_name = {"콜롬비아", "브라질", "에티오피아", "케냐", "인도"};
	private static String[] coffee_name = {"아메리카노", "카페라떼", "카페모카", "바닐라라떼"};
	
	// 배열의 인덱스값을 코드번호로 저장해놓을 수 있다. 
	public final static CoffeeCode AMERICANMO = new CoffeeCode(0, "아메리카노");
	public final static CoffeeCode CAFFEE_LATTE = new CoffeeCode(1, "카페라떼");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "카페모카");
	public final static CoffeeCode VANILLA_LATTE = new CoffeeCode(3, "바닐라라떼");
	
	public final static OriginCode COLOMBIA = new OriginCode(0, "콜롬비아");
	public final static OriginCode BRASIL = new OriginCode(1, "브라질");
	public final static OriginCode ETHIOPIA = new OriginCode(2, "에티오피아");
	public final static OriginCode KENYA = new OriginCode(3, "케냐");
	public final static OriginCode INDIA = new OriginCode(4, "인도");
	

	
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
