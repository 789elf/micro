package quiz.d05_poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 *  �ߺ��� ���ڴ� �ι�°�ź��� ī��Ʈ�ϰ� ���ڴ� ù��°�ź��� �� ī��Ʈ��
 */
public class PokerGame_Ver01 {

//	static final int KIND_MAX = 4;
//	static final int NUM_MAX = 13;
	static final int CARD_NUM = 5;

	Random ran = new Random();
	HashSet<Integer> index_set = new HashSet();
	ArrayList<String> shape_list = new ArrayList<>();   //���� ��� ���� �ε��� ����
	ArrayList<String> number_list = new ArrayList<>();
	
	String[] card_deck = new String[52];
	String[] shape = { "��", "��", "��", "��" };
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
		// 52���� ī�� �� ����
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_deck[temp] = (shape[i] + numbers[j]);
				temp++;
			}
		}
		// 52���� �ߺ����� �ʴ� ���� �ε��� ����.
		while(index_set.size() < CARD_NUM) {
			index_set.add(ran.nextInt(52));
		}
		// �� ī�� �� ����
		getMyDeck();
		
	}
	
	void getMyDeck() {
		
		int index = 0;
		// �� 7���� �� ī�� ���� 
		for(Integer i : index_set) {
			my_deck[index++] = card_deck[i];
		}
		
		for(int i=0; i<my_deck.length; i++) {
			my_shape[i] = my_deck[i].substring(0, 1);
			my_number[i] = my_deck[i].substring(1);
		}
//		my_shape[0] = "��";
//		my_shape[1] = "��";
//		my_shape[2] = "��";
//		my_shape[3] = "��";
//		my_shape[4] = "��";
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
		int shape_cnt = 0, number_cnt = 0; //���� ���, ���� ���
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
		
		// �ߺ����ڰ� �����
		for(int i = 0 ; i < number_list.size() ; i++){ // ArrayList ��ŭ �ݺ�
		    if (duplicate_num.containsKey(number_list.get(i))) { // HashMap ���ο� �̹� key ���� �����ϴ��� Ȯ��
		    	duplicate_num.put(number_list.get(i), duplicate_num.get(number_list.get(i))  + 1);  // key�� �̹� �ִٸ� value�� +1
		    } else { // key���� �������� ������
		    	duplicate_num.put(number_list.get(i) , 1); // key ���� ������ value�� 1�� �ʱ�ȭ
		    }
		}
		if(number_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_num.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			max = entry.getValue();
		}
		// �ߺ��׸��� �����
		for(int i = 0 ; i < shape_list.size() ; i++){ // ArrayList ��ŭ �ݺ�
		    if (duplicate_shape.containsKey(shape_list.get(i))) { // HashMap ���ο� �̹� key ���� �����ϴ��� Ȯ��
		    	duplicate_shape.put(shape_list.get(i), duplicate_shape.get(shape_list.get(i))  + 1);  // key�� �̹� �ִٸ� value�� +1
		    } else { // key���� �������� ������
		    	duplicate_shape.put(shape_list.get(i) , 1); // key ���� ������ value�� 1�� �ʱ�ȭ
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
		// ��Ʈ����Ʈ
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
		
		// �ο� ��Ʈ����Ʈ
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
