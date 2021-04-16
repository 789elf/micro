package quiz.d05_poker;
/*
 *  포커 구현 버전 3
 *  버전2 에서 주석 제거  
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class PokerGame_Ver03 {

	static final int CARD_NUM = 5;
	static String[] card_deck = new String[52];
	static String[] shape = { "♣", "♥", "◆", "♠" };
	static String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	Random ran = new Random();
	
	HashSet<Integer> index_set;
	ArrayList<String> shape_list;  
	ArrayList<String> number_list;
	ArrayList<String> royal_number_list; 
	Map<String, Integer> duplicate_num ;  
	Map<String, Integer> duplicate_shape;
	Map<String, Integer> duplicate_royal;

	String[] my_deck;
	String[] my_shape;
	String[] my_number;
	
	PokerGame_Ver03(){
		ran = new Random();
		index_set = new HashSet<>();
		shape_list = new ArrayList<>();   
		number_list = new ArrayList<>();
		royal_number_list = new ArrayList<>();
		
		duplicate_num = new HashMap<String, Integer>();  
		duplicate_shape = new HashMap<String, Integer>();
		duplicate_royal = new HashMap<String, Integer>();
		
		my_deck = new String[CARD_NUM];
		my_shape = new String[CARD_NUM];
		my_number = new String[CARD_NUM];
	}

	void cardSet() {
		
		int temp = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_deck[temp] = (shape[i] + numbers[j]);
				temp++;
			}
		}
		
		while(index_set.size() < CARD_NUM) {
			index_set.add(ran.nextInt(52));
		}
		
		setMyDeck();
	}
	
	void setMyDeck() {
		
		int index = 0;
		
		for(Integer i : index_set) {
			my_deck[index++] = card_deck[i];
		}
		
		for(int i=0; i<my_deck.length; i++) {
			
			my_shape[i] = my_deck[i].substring(0, 1);
			my_number[i] = my_deck[i].substring(1);
			royal_number_list.add(my_number[i]);
		}
		disp();
	}
	
	void disp() {
		int rank = getRank();
		
		for(int i=0; i<my_deck.length; i++) {
			
			System.out.printf(my_shape[i] + my_number[i] + " ");
		}
		System.out.println();
		
		if(rank != 0) {
			if(rank == 1) System.out.println("One Pair");
			if(rank == 2) System.out.println("Two pair!");
			if(rank == 3) System.out.println("Triple!!");
			if(rank == 4) System.out.println("Four of a Kind!!!");
			if(rank == 5) System.out.println("Full House!!!!");
			if(rank == 6) System.out.println("Flush!!!!!");
			if(rank == 7) System.out.println("Straight!!!!!!");
			if(rank == 8) System.out.println("Straight Flush!!!!!!!");
			if(rank == 9) System.out.println("!!!!!!!!!Royal Straight Flush!!!!!!!!!");
		}
		
		else System.out.println("No Cards");
	}
	
	int getNumDuplicate() {
		
		for(int i = 0 ; i < number_list.size() ; i++){ 
		    if (duplicate_num.containsKey(number_list.get(i))) { 
		    	
		    	duplicate_num.put(number_list.get(i), duplicate_num.get(number_list.get(i))  + 1);  
		    	
		    } else { 
		    	
		    	duplicate_num.put(number_list.get(i) , 1);
		    }
		}
		if(number_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_num.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			return entry.getValue();
		}
		return 0;
	}
	
	
	int getShapeDuplicate(){
	
		for(int i = 0 ; i < shape_list.size() ; i++){ 
			
		    if (duplicate_shape.containsKey(shape_list.get(i))) { 
		    	
		    	duplicate_shape.put(shape_list.get(i), duplicate_shape.get(shape_list.get(i))  + 1);  
		    	
		    } else { 
		    	
		    	duplicate_shape.put(shape_list.get(i) , 1); 
		    	
		    }
		}
		if(shape_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_shape.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			return entry.getValue();
		}
		return 0;
	}
	
	int getStraightCount() throws NumberFormatException{

		int[] card_num = new int[5];
		
		for(int i=0; i<5; i++) {
			
			if(my_number[i].equals("A")) card_num[i] = 1;
			else if(my_number[i].equals("J")) card_num[i] = 11;
			else if(my_number[i].equals("Q")) card_num[i] = 12;
			else if(my_number[i].equals("K")) card_num[i] = 13;
			else card_num[i] = Integer.parseInt(my_number[i]);
		}
		
		int temp;
		int straight_cnt = 1;
		
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<5; j++) {
				
				if(card_num[i] < card_num[j]) {
					
					temp = card_num[j];
					card_num[j] = card_num[i];
					card_num[i] = temp;
				}
			}
		}
		
		for(int i=4; i>=1; i--) {
			
			if((card_num[i]) - (card_num[i-1]) == 1) {
				straight_cnt++;
			}
		}
		
		return straight_cnt;
	}
	
	int getRoyal() {
		
		int royal = 0;
		int max = 0;	
		
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
		
		for(int i = 0 ; i < royal_number_list.size(); i++){ 
			
		    if (duplicate_royal.containsKey(royal_number_list.get(i))) { 
		    	
		    	duplicate_royal.put(royal_number_list.get(i), duplicate_royal.get(royal_number_list.get(i))  + 1);  
		    } else { 
		    	
		    	duplicate_royal.put(royal_number_list.get(i) , 1); 
		    }
		}
		if(royal_number_list.size() != 0) {
			Entry<String, Integer> entry = duplicate_royal.entrySet().stream()									  	   
					  .max(Map.Entry.comparingByValue(Integer::compareTo)).get();
			
			max = entry.getValue();
			
		}
		if(max > 1) {
			return 0;
		}
		return royal; 
	}

	int getRank() {
		
		int shape_cnt = 1;
		int number_cnt = 1;					
 		
		for (int i=0; i<CARD_NUM; i++) {
			for(int j=0; j<i; j++) {
				if(my_shape[i].equals(my_shape[j])) {
					shape_list.add(my_shape[i]);
					shape_cnt++;
					break;
				}
				if(my_number[i].equals(my_number[j])) {
					number_cnt++;
					number_list.add(my_number[i]);
					break;
				}
			}
		}
		int max_num = getNumDuplicate();	 
		
		int max_shape = getShapeDuplicate(); 	
		int straight_cnt = getStraightCount();	
		int royal = getRoyal();			

		if(number_cnt >= 2) {
			if(number_cnt == 2) return 1; 
			if(max_num == 1 && number_cnt == 3) return 2; 	
			if(max_num == 2 && number_cnt == 3) return 3; 	
			if(max_num == 3) return 4; 						
			if(number_cnt == 4) return 5;
		}

		if(max_shape == 4) {
			if(royal == 5) return 9; 	
			if(straight_cnt == 5) return 8; 
			return 6; 	
		}
		if(straight_cnt == 5) return 7; 	
		
		return 0;
	}
	public static void main(String[] args) {

		PokerGame_Ver03 pg;
		
		pg = new PokerGame_Ver03();
		pg.cardSet();
		
	}
}
