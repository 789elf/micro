package quiz.d05_poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 *  중복시 숫자는 두번째거부터 카운트하고 문자는 첫번째거부터 잘 카운트함
 */
public class PokerGame_Ver01 {

//	static final int KIND_MAX = 4;
//	static final int NUM_MAX = 13;
	static final int CARD_NUM = 5;

	Random ran = new Random();
	HashSet<Integer> index_set = new HashSet();
	ArrayList<String> shape_list = new ArrayList<>();   //같은 모양 숫자 인덱스 저장
	ArrayList<String> number_list = new ArrayList<>();
	
	String[] card_deck = new String[52];
	String[] shape = { "♣", "♥", "◆", "♠" };
	String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	String[] my_deck = new String[CARD_NUM];

	String my_shape[] = new String[CARD_NUM];
	String my_number[] = new String[CARD_NUM];
	
	void clear() {
		shape_list.clear();
		number_list.clear();
		index_set.clear();
		
	}
	void cardSet() {
		
		int temp = 0;
		// 52개의 카드 덱 생성
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_deck[temp] = (shape[i] + numbers[j]);
				temp++;
			}
		}
		// 52개중 중복되지 않는 랜덤 인덱스 생성.
		while(index_set.size() < CARD_NUM) {
			index_set.add(ran.nextInt(52));
		}
		// 내 카드 덱 생성
		getMyDeck();
		
	}
	
	void getMyDeck() {
		
		int index = 0;
		// 총 7개의 내 카드 생성 
		for(Integer i : index_set) {
			my_deck[index++] = card_deck[i];
		}
		
		for(int i=0; i<my_deck.length; i++) {
			my_shape[i] = my_deck[i].substring(0, 1);
			my_number[i] = my_deck[i].substring(1);
		}
//		my_shape[0] = "♠";
//		my_shape[1] = "♠";
//		my_shape[2] = "♠";
//		my_shape[3] = "♠";
//		my_shape[4] = "♠";
//		my_number[0] = "10";
//		my_number[1] = "J";
//		my_number[2] = "Q";
//		my_number[3] = "K";
//		my_number[4] = "A";
//		my_number[0] = "1";
//		my_number[1] = "1";
//		my_number[2] = "1";
//		my_number[3] = "2";
//		my_number[4] = "3";
		for(int i=0; i<my_deck.length; i++) {
			System.out.printf(" %s ", my_deck[i]);
		}
		System.out.println();
		getRank();
	}
	
	void getRank() {
		int rank = setRank();
		if(rank != 0) {
			if(rank == 1) System.out.println("One Pair");
			if(rank == 2) System.out.println("Two pair");  // two
			if(rank == 3) System.out.println("Triple");    //triple
			if(rank == 4) System.out.println("Four of a Kind");
			if(rank == 5) System.out.println("Full House"); 
			if(rank == 6) System.out.println("Flush"); 
			if(rank == 7) System.out.println("Straight");
			if(rank == 8) System.out.println("Straight Flush"); 
			if(rank == 9) System.out.println("Royal Straight Flush");
			
		}
	}
	int setRank() {
		int shape_cnt = 0, number_cnt = 0; //같은 모양, 숫자 몇갠지
		Map<String, Integer> duplicate_num = new HashMap<String, Integer>();
		Map<String, Integer> duplicate_shape = new HashMap<String, Integer>();
		int max = 0, max_shape = 0;

		for (int i=0; i<CARD_NUM; i++) {
			for(int j=0; j<CARD_NUM; j++) {
				if(my_shape[i].equals(my_shape[j])) {
					shape_cnt++;
					shape_list.add(my_shape[i]);
					break;
				}
				if(my_number[i].equals(my_number[j])) {
					number_cnt++;
					number_list.add(my_number[i]);
					break;
				}
			}
		}
		
		// 중복숫자가 몇개인지
		for(int i = 0 ; i < number_list.size() ; i++){ // ArrayList 만큼 반복
		    if (duplicate_num.containsKey(number_list.get(i))) { // HashMap 내부에 이미 key 값이 존재하는지 확인
		    	duplicate_num.put(number_list.get(i), duplicate_num.get(number_list.get(i))  + 1);  // key가 이미 있다면 value에 +1
		    } else { // key값이 존재하지 않으면
		    	duplicate_num.put(number_list.get(i) , 1); // key 값을 생성후 value를 1로 초기화
		    }
		}
		if(number_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_num.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			max = entry.getValue();
		}
		// 중복그림이 몇개인지
		for(int i = 0 ; i < shape_list.size() ; i++){ // ArrayList 만큼 반복
		    if (duplicate_shape.containsKey(shape_list.get(i))) { // HashMap 내부에 이미 key 값이 존재하는지 확인
		    	duplicate_shape.put(shape_list.get(i), duplicate_shape.get(shape_list.get(i))  + 1);  // key가 이미 있다면 value에 +1
		    } else { // key값이 존재하지 않으면
		    	duplicate_shape.put(shape_list.get(i) , 1); // key 값을 생성후 value를 1로 초기화
		    }
		}
		if(shape_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_shape.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			max_shape = entry.getValue();
		}

		int[] card_num = new int[5];
		for(int i=0; i<5; i++) {
			if(my_number[i] == "A") card_num[i] = 1;
			else if(my_number[i] == "J") card_num[i] = 11;
			else if(my_number[i] == "Q") card_num[i] = 12;
			else if(my_number[i] == "K") card_num[i] = 13;
			else {
				try {
				card_num[i] = Integer.parseInt(my_number[i]);
				}catch (Exception e) {
					
				}
			}
		}
		// 스트레이트
		int[] card_temp;
		int temp;
		card_temp = card_num;
		int straight_cnt = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(card_temp[i] < card_temp[j]) {
					temp = card_temp[j];
					card_temp[j] = card_temp[i];
					card_temp[i] = temp;
				}
			}
		}
		
		for(int i=4; i>=1; i--) {
			if((card_temp[i]) - (card_temp[i-1]) == 1) {
				straight_cnt++;
			}
		}
		
		// 로열 스트레이트
		int royal = 0;
		for(int i=0; i<5; i++) {
			if(my_number[i].equals("A")) {
				royal++;
			}
			if(my_number[i].equals("10")) {
				royal++;
			}
			if(my_number[i].equals("J")) {
				royal++;
			}
			if(my_number[i].equals("Q")) {
				royal++;
			}
			if(my_number[i].equals("K")) {
				royal++;
			}
		}

		if(number_cnt >= 1) {
			if(number_cnt == 1) return 1; //one
			if(max == 1 && number_cnt == 2) return 2; //twopair
			if(max == 2 && number_cnt == 2) return 3; //triple
			if(max == 3) return 4; //four of a kind
			if(number_cnt == 3) return 5; //full house
		}

		if(max_shape == 5) {
			if(royal == 5 && max_shape == 5 ) return 9; //royal straight flush
			if(straight_cnt == 5 && max_shape == 5) return 8; //straight flush
			if(max_shape == 5) return 6; // flush
		}
		if(straight_cnt == 5) return 7; //straight
		
		
		return 0;
	}
	public static void main(String[] args) {

		PokerGame_Ver01 pg = new PokerGame_Ver01();
		Scanner sc = new Scanner(System.in);
		while(true) {
//		int loop = sc.nextInt();
//		for(int i=0; i<loop; i++) {
			pg.clear();
			pg.cardSet();
		}
//		}
		
	}
}
