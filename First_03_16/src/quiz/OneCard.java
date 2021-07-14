package quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class OneCard {
	static final int CARD_NUM = 7;

	Random ran = new Random();
	HashSet<Integer> index_set = new HashSet<>();
	ArrayList<Integer> index_list = new ArrayList<>();

	String[] card_deck = new String[52];
	String[] shape = { "��", "��", "��", "��" };
	String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	String top_card_num;
	String top_card_shape;

//	String[] my_deck = new String[CARD_NUM];
//
//	String my_shape[] = new String[CARD_NUM];
//	String my_number[] = new String[CARD_NUM];
	int card_count = 0; // ī�尡 ���� Ƚ��

	ArrayList<String> my_deck = new ArrayList<>();
	ArrayList<String> my_shape = new ArrayList<>();
	ArrayList<String> my_number = new ArrayList<>();
	
	ArrayList<String> com_deck = new ArrayList<>();
	ArrayList<String> com_shape = new ArrayList<>();
	ArrayList<String> com_number = new ArrayList<>();
	
	ArrayList<Integer> temp_set_list;
	
	// �� ó�� ī�� ���������� 1�� ����
	int order = 1;

	// ���� ó�� �����ϴ��� üũ
	static int first = 0;

	void cardSet() {

		int temp = 0;
		// 52���� ī�� �� ����
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_deck[temp] = (shape[i] + numbers[j]);
				temp++;
			}
		}

		setRandomIndex(order);
		// �� ī�� �� ����
		setMyDeck();
		
		//com ī�� �� ����
		setRandomIndex(++order);
		setComDeck();

	}
	void setRandomIndex(int order) {
		temp_set_list = new ArrayList<>();
		int temp;
		
		while (index_set.size() < order * CARD_NUM) {
			temp = ran.nextInt(52);
			if (index_set.add(temp)) {
				temp_set_list.add(temp);
				card_count++;
			}
		}
	}
	// com �� set
	void setComDeck() {
		
		int index = 0;
		
		for(int i=0; i<CARD_NUM; i++) {
			com_deck.add(card_deck[temp_set_list.get(i)]);
		}

		for (int i = 0; i < com_deck.size(); i++) {
			com_shape.add(com_deck.get(i).substring(0, 1));
			com_number.add(com_deck.get(i).substring(1));
		}
		
	}
	// com �� ���
	void getComDeck() {
		for (int i = 0; i < com_deck.size(); i++) {

			System.out.printf("%d : %s  | ", i + 1, com_deck.get(i));
		}
		System.out.println();
	}
	
	// player ī�� �� set
	void setMyDeck() {

		int index = 0;
		// �� 7���� �� ī�� ����
		
		for(int i=0; i<CARD_NUM; i++) {
			my_deck.add(card_deck[temp_set_list.get(i)]);
		}
		
		for (int i = 0; i < my_deck.size(); i++) {
			my_shape.add(my_deck.get(i).substring(0, 1));
			my_number.add(my_deck.get(i).substring(1));
		}
	}

	// player ī�� �� ���
	void getMyDeck() {
		for (int i = 0; i < my_deck.size(); i++) {

			System.out.printf("%d : %s  | ", i + 1, my_deck.get(i));
		}
		System.out.println();
	}

	// �÷��̾�鿡�� ������ ���� ���� ī��
	void setTopCard() {
		int top_card_index = 0;

		while (index_set.size() < card_count + 1) {
			top_card_index = ran.nextInt(52);
			if (index_set.add(top_card_index))
				break;
		}

		top_card_shape = card_deck[top_card_index].substring(0, 1);
		top_card_num = card_deck[top_card_index].substring(1);
	}

	void getTopCard() {

		System.out.println("### " + top_card_shape + top_card_num + " ###");
	}

	// Com�� ī�� ���°�
	void play_a_cardOfCom() {
		
		// ��ǻ�Ͱ� ���� ī���� ����̳� ���ڰ� ��ġ�ϴ� ī�尡 �ִٸ� ī�带 ����.
		for(int i=0; i<com_deck.size(); i++) {
			if(top_card_shape.equals(com_shape.get(i))) {
				System.out.println("Com�� �� ī��  > " + com_deck.get(i));
				removeDeck(i,false);
				return;
			}
			if(top_card_num.equals(com_number.get(i))) {
				System.out.println("Com�� �� ī��  > " + com_deck.get(i));
				removeDeck(i,false);
				return;
			}
		}
		getCard(false);
	}
	
	// ī�� ���°�
	void play_a_card(int card_num) {
		//card_num = player�� ������ ī�� �ε��� ��ȣ

		try {
			// ���� �÷��̾ �� ī��� ������ ī���� ����̳� ���ڰ� ��ġ�ϸ� ī�带 ���� 
			if (top_card_shape.equals(my_shape.get(card_num))) {
				System.out.println("player�� �� ī��  > " + my_deck.get(card_num));
				removeDeck(card_num,true);
			} else if (top_card_num.equals(my_number.get(card_num))) {
				System.out.println("player�� �� ī��  > " + my_deck.get(card_num));
				removeDeck(card_num,true);
			} else {
				System.out.println("�� ī��� �� �� ����.");
				getCard(true);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("1 ���� " + my_deck.size() + "������ ���ڸ� �Է� ����");
		}
	}

	// �� ī�� ���� ( �÷��̾�, ��ǻ�� �����޼ҵ� ��� )
	void removeDeck(int card_num, boolean isPlayer) {
		if(isPlayer == true) {
			top_card_shape = my_shape.remove(card_num);
			top_card_num = my_number.remove(card_num);
			my_deck.remove(card_num);
		}else {
			top_card_shape = com_shape.remove(card_num);
			top_card_num = com_number.remove(card_num);
			com_deck.remove(card_num);
		}
		
	}
	

	// ī�� �Ա�
	void getCard(boolean isPlayer) {
		int temp = index_set.size() + 1;
		int card_num = 0;

		while (true) {
			card_num = ran.nextInt(52);
			if (index_set.add(card_num)) {
				break;
			}
		}
		if(isPlayer) {
			my_deck.add(card_deck[card_num]);
			my_shape.add(card_deck[card_num].substring(0, 1));
			my_number.add(card_deck[card_num].substring(1));
		}else {
			com_deck.add(card_deck[card_num]);
			com_shape.add(card_deck[card_num].substring(0, 1));
			com_number.add(card_deck[card_num].substring(1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OneCard oneCard = new OneCard();
		oneCard.cardSet(); // ī�� ��
		oneCard.setTopCard(); // �� �� ī��

		String select;
		int card_num;

		while (true) {
//			if(first == 0) {
//				oneCard.setTopCard();
//			}
			if (oneCard.my_deck.size() == 0) {
				System.out.println("! ���� �� ! ");
				break;
			}
			oneCard.getMyDeck();
			oneCard.getTopCard();
			
			System.out.print("Com Deck : ");
			oneCard.getComDeck();

//			System.out.println("ī�带 ����  y ( y�� ������ ��� Ű�� ī�带 �԰� �ȴ�. )");
//			select = sc.next();
//
//			if (select.equals("y") || select.equals("y")) {
			System.out.printf("���� ī�� ? (%d �� ����) > \n", oneCard.my_deck.size());
			card_num = sc.nextInt();
			
			oneCard.play_a_card(card_num - 1);
			oneCard.getTopCard();
			oneCard.play_a_cardOfCom();
//			}else {

//				oneCard.getCard(true);
//			}
//			first++;
		}

	}

}
