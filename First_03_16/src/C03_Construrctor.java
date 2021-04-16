import java.util.Scanner;

import myobj.Peach;
import myobj.PublicTransport;

public class C03_Construrctor {

	/*
	 * # Ŭ������ ������ (Constructor)
	 * 
	 * - Ŭ������ �̸��� �Ȱ��� �̸��� �޼ҵ� - �޼ҵ����� ���� Ÿ���� ���� �����ʴ´� - �ν��Ͻ��� �����ϱ� ���ؼ��� new�� ���� �����ڸ�
	 * ȣ���ؾ� �Ѵ�. - �����ڸ� �ϳ��� �������� ���� Ŭ�������� �⺻ �����ڰ� �ڵ����� �����ȴ�. - �����ڰ� ��� ����� �Ŀ��� ������
	 * �ν��Ͻ��� �ּҰ� ��ȯ�ȴ�.
	 */
	public static void main(String[] args) {

		// Ŭ���� �̸��� �Ȱ��� �̸��� �޼��带 ȣ���� �ν��Ͻ��� ������ �� �ִ�.

		// * �����ڸ� ȣ���ϴ� ������
		String s1 = new String();
		Peach p1 = new Peach(); // �̰� ��� �����ڸ� ȣ���� �ſ���.
		Scanner sc = new Scanner(System.in); // Scanner�� ������ ���� ������

		new Orange(); // �⺻ ������ ȣ��
		new Orange(8); // �����ε��� �ٸ� ������ (�絵)
		new Orange(9, 10, new int[] { 235, 165, 0 }); // �����ε��� �ٸ� ������ 2
		
		

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
		
		String area = "��⵵";
		
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

	// ������ - �� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� ȣ��Ǵ� �޼ҵ� ( ex: Orange orange = new Orange(); ��
	// �ϴ� ���� ȣ���� ���� ���� )
	// �����ڴ� ���� ���� ȣ��Ǳ� ������ �ַ� �ʱ�ȭ �뵵�� ���
	Orange() {
		System.out.println("�������� �ʱ�ȭ �Ǿ����ϴ�.");
		sweet = 5;
		size = (int) (Math.random() * 3 + 7);
		color = new int[] { 255, 165, 0 };
	}

	// �����ڵ� �޼����̱� ������ �����ε� �� �� �ִ�
	Orange(int sweet) {
		// ���� �̷��� ����Ѵ�. �Ű����� sweet�� �������� sweet�� �ִ´�.
		this.sweet = sweet; // * this : �� �ν��Ͻ����� �ڱ� �ڽ��� ����Ų�� (��������) , �⺻������ �Ű������� �켱

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
	
	//�ٸ� �����ε� Ÿ���� �����ڰ� �����Ҷ��� �⺻�����ڸ� ����� �� ����.
	public Strawberry(int seed) {
		this.seed = seed;
	}
}


// �Ʊ� myobj�� ������� Ŭ������ �˸��� �����ڸ� 2�� �̻� �߰��غ���
