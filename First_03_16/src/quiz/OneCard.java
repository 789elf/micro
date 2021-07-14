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
	String[] shape = { "♣", "♥", "◆", "♠" };
	String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	String top_card_num;
	String top_card_shape;

//	String[] my_deck = new String[CARD_NUM];
//
//	String my_shape[] = new String[CARD_NUM];
//	String my_number[] = new String[CARD_NUM];
	int card_count = 0; // 카드가 뽑힌 횟수

	ArrayList<String> my_deck = new ArrayList<>();
	ArrayList<String> my_shape = new ArrayList<>();
	ArrayList<String> my_number = new ArrayList<>();
	
	ArrayList<String> com_deck = new ArrayList<>();
	ArrayList<String> com_shape = new ArrayList<>();
	ArrayList<String> com_number = new ArrayList<>();
	
	ArrayList<Integer> temp_set_list;
	
	// 맨 처음 카드 받을때마다 1씩 증가
	int order = 1;

	// 게임 처음 시작하는지 체크
	static int first = 0;

	void cardSet() {

		int temp = 0;
		// 52개의 카드 덱 생성
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_deck[temp] = (shape[i] + numbers[j]);
				temp++;
			}
		}

		setRandomIndex(order);
		// 내 카드 덱 생성
		setMyDeck();
		
		//com 카드 덱 생성
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
	// com 덱 set
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
	// com 덱 출력
	void getComDeck() {
		for (int i = 0; i < com_deck.size(); i++) {

			System.out.printf("%d : %s  | ", i + 1, com_deck.get(i));
		}
		System.out.println();
	}
	
	// player 카드 덱 set
	void setMyDeck() {

		int index = 0;
		// 총 7개의 내 카드 생성
		
		for(int i=0; i<CARD_NUM; i++) {
			my_deck.add(card_deck[temp_set_list.get(i)]);
		}
		
		for (int i = 0; i < my_deck.size(); i++) {
			my_shape.add(my_deck.get(i).substring(0, 1));
			my_number.add(my_deck.get(i).substring(1));
		}
	}

	// player 카드 덱 출력
	void getMyDeck() {
		for (int i = 0; i < my_deck.size(); i++) {

			System.out.printf("%d : %s  | ", i + 1, my_deck.get(i));
		}
		System.out.println();
	}

	// 플레이어들에게 보여질 제일 위의 카드
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

	// Com이 카드 내는거
	void play_a_cardOfCom() {
		
		// 컴퓨터가 가진 카드중 모양이나 숫자가 일치하는 카드가 있다면 카드를 낸다.
		for(int i=0; i<com_deck.size(); i++) {
			if(top_card_shape.equals(com_shape.get(i))) {
				System.out.println("Com이 낸 카드  > " + com_deck.get(i));
				removeDeck(i,false);
				return;
			}
			if(top_card_num.equals(com_number.get(i))) {
				System.out.println("Com이 낸 카드  > " + com_deck.get(i));
				removeDeck(i,false);
				return;
			}
		}
		getCard(false);
	}
	
	// 카드 내는거
	void play_a_card(int card_num) {
		//card_num = player가 선택한 카드 인덱스 번호

		try {
			// 만약 플레이어가 낸 카드와 맨위의 카드의 모양이나 숫자가 일치하면 카드를 낸다 
			if (top_card_shape.equals(my_shape.get(card_num))) {
				System.out.println("player가 낸 카드  > " + my_deck.get(card_num));
				removeDeck(card_num,true);
			} else if (top_card_num.equals(my_number.get(card_num))) {
				System.out.println("player가 낸 카드  > " + my_deck.get(card_num));
				removeDeck(card_num,true);
			} else {
				System.out.println("이 카드는 낼 수 없다.");
				getCard(true);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("1 부터 " + my_deck.size() + "까지의 숫자만 입력 가능");
		}
	}

	// 낸 카드 삭제 ( 플레이어, 컴퓨터 같은메소드 사용 )
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
	

	// 카드 먹기
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
		oneCard.cardSet(); // 카드 섞
		oneCard.setTopCard(); // 맨 위 카드

		String select;
		int card_num;

		while (true) {
//			if(first == 0) {
//				oneCard.setTopCard();
//			}
			if (oneCard.my_deck.size() == 0) {
				System.out.println("! 게임 끝 ! ");
				break;
			}
			oneCard.getMyDeck();
			oneCard.getTopCard();
			
			System.out.print("Com Deck : ");
			oneCard.getComDeck();

//			System.out.println("카드를 낸다  y ( y를 제외한 모든 키는 카드를 먹게 된다. )");
//			select = sc.next();
//
//			if (select.equals("y") || select.equals("y")) {
			System.out.printf("무슨 카드 ? (%d 장 남음) > \n", oneCard.my_deck.size());
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
