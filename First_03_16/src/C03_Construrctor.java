import java.util.Scanner;

import myobj.Peach;
import myobj.PublicTransport;

public class C03_Construrctor {

	/*
	 * # 클래스의 생성자 (Constructor)
	 * 
	 * - 클래스의 이름과 똑같은 이름의 메소드 - 메소드지만 리턴 타입을 정의 하지않는다 - 인스턴스를 생성하기 위해서는 new를 통해 생성자를
	 * 호출해야 한다. - 생성자를 하나도 정의하지 않은 클래스에는 기본 생성자가 자동으로 생성된다. - 생성자가 모두 실행된 후에는 생성된
	 * 인스턴스의 주소가 반환된다.
	 */
	public static void main(String[] args) {

		// 클래스 이름과 똑같은 이름의 메서드를 호출해 인스턴스를 생성할 수 있다.

		// * 생성자를 호출하는 행위들
		String s1 = new String();
		Peach p1 = new Peach(); // 이건 사실 생성자를 호출한 거엿음.
		Scanner sc = new Scanner(System.in); // Scanner는 굉장히 많은 생성자

		new Orange(); // 기본 생성자 호출
		new Orange(8); // 오버로딩한 다른 생성자 (당도)
		new Orange(9, 10, new int[] { 235, 165, 0 }); // 오버로딩한 다른 생성자 2
		
		

		Orange[] orange_box = new Orange[7];

		for (int i = 0; i < 5; i++) {
			orange_box[i] = new Orange();
		}

		System.out.println(orange_box[0].sweet);
		System.out.println(orange_box[1].size);
		System.out.println(orange_box[2].color[0]);
		System.out.println(orange_box[3].color[1]);
		System.out.println(orange_box[4].color[2]);

		
		Strawberry berry01 = new Strawberry(150);
		System.out.println(berry01.color);
		System.out.println(berry01.seed);
		
		String area = "경기도";
		
		PublicTransport bus = new PublicTransport(4444, 57, 2500, area);
		PublicTransport sub = new PublicTransport(1, 98);
		
		bus.bus_info();
		sub.sub_info();
		
		
	}
}

class Orange {
	int sweet;
	int size;
	int[] color;

	// 생성자 - 이 클래스의 인스턴스를 생성할 때 가장 먼저 호출되는 메소드 ( ex: Orange orange = new Orange(); 를
	// 하는 순간 호출이 제일 먼저 )
	// 생성자는 가장 먼저 호출되기 때문에 주로 초기화 용도로 사용
	Orange() {
		System.out.println("오렌지가 초기화 되었습니다.");
		sweet = 5;
		size = (int) (Math.random() * 3 + 7);
		color = new int[] { 255, 165, 0 };
	}

	// 생성자도 메서드이기 때문에 오버로딩 할 수 있다
	Orange(int sweet) {
		// 보통 이렇게 사용한다. 매개변수 sweet를 전역변수 sweet에 넣는다.
		this.sweet = sweet; // * this : 각 인스턴스에서 자기 자신을 가리킨다 (전역변수) , 기본적으료 매개변수가 우선

	}

	Orange(int sweet, int size, int[] color) {
		this.sweet = sweet;
		this.size = size;
		this.color = color;
		System.out.println(this.color);
		System.out.println(color);
	}
}


class Strawberry{
	
	int seed;
	String color;
	
	//다른 오버로딩 타입의 생성자가 존재할때는 기본생성자를 사용할 수 없다.
	public Strawberry(int seed) {
		this.seed = seed;
	}
}


// 아까 myobj에 만들었던 클래스에 알맞은 생성자를 2개 이상 추가해보기
