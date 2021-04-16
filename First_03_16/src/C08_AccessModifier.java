import myobj.DiffPackage;

public class C08_AccessModifier {

	/*
	 * C08_SamePackage , myobj.DiffPackage
	 * 
	 *  # 접근 제어자 ( Access Modifier)
	 *  
	 *    - 다른 클래스가 해당 클래스의 자원을 사용하려고 할 때
	 *      어디까지 허용할지를 설정한다
	 *      
	 *  # 접근 제어자를 통해 구분할 수 있는 거리의 종류
	 *    
	 *    - 같은 클래스내부의 다른 자원  ( 가장 가까운 )
	 *    - 같은 패키지 내부의 다른 자원
	 *    - 다른 패키지에 있지만 상속받은 자원
	 *    - 다른 패키지의 자원 ( 가장 먼 )
	 *    
	 *  # 접근 제어자의 종류
	 *  
	 *	  - private 
	 *			 앞에 private가 붙은 자원은 같은 클래스 내부에서만 접근할 수 있게 된다.  
	 *  
	 *    - default ( 아무것도 안 씀 ) 
	 *    		 같은 패키지내부에서는 자유롭게 접근할 수 있게 된다
	 *    		 다른 패키지에서는 접근할 수 없다.
	 *    
	 *    - protected
	 *    		같은 패키지 내부에서는 자유롭게 접근할 수 있다.
	 *			다른 패키지에서는 상속받은 클래스만 접근할 수 있는 자원이 된다.
	 *    
	 *    - public
	 *    		다른 패키지에서도 자유롭게 접근할 수 있는 자원이 된다.
 	 *	    
 	 *    * 그럼 접근제어자를 왜 쓸까 어처피 public 메소드에 private를 담으면 값을 사용할 수 있는데 ? 
 	 *        : 클래스 제작자의 의도를 전달 할 수 있기 때문에. 사용한다 (메뉴얼의 역할)
	 */
	public static void main(String[] args) {
		C08_SamePackage instance = new C08_SamePackage();
		
		// SamePackage는 private 빼고 다 사용 가능하다. ( 같은 패키지 내에 있으니까 )
		instance.protected_method();
		instance.default_method();
		instance.public_method();
		
		// DiffPackage는 public만 사용이 가능하다 ( 다ㅣ른패키지 )
		DiffPackage instance2 = new DiffPackage(); 
		
		//public이 아니어도 public의 메소드는 볼 수 있기때문에 private,protect,default의 변수내용이 확인은 가능하다.
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
		this.protected_var = 1; // 상속을 받으면 protected도 다른 패키지에서 사용 가능
	}
	
	void abc() {
		Snack s = new Snack();
		int size = s.size;
	}
}