package quiz.d05_poker;
/*
 *  포커 구현 버전 2 
 *  getRank를 메소드 별로 구현  
 */
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
public class PokerGame_Ver02 {

	static final int CARD_NUM = 5;
	static String[] card_deck = new String[52];
	static String[] shape = { "♣", "♥", "◆", "♠" };
	static String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	Random ran = new Random();
	
	HashSet<Integer> index_set;
	ArrayList<String> shape_list;   //같은 모양 숫자 인덱스 저장
	ArrayList<String> number_list;
	ArrayList<String> royal_number_list; //로얄 전용
	//중복 숫자, 모양 최대 몇개인지 
	Map<String, Integer> duplicate_num ;  
	Map<String, Integer> duplicate_shape;
	Map<String, Integer> duplicate_royal;

	String[] my_deck;
	String[] my_shape;
	String[] my_number;
	
	PokerGame_Ver02(){
		ran = new Random();
		index_set = new HashSet<>();
		shape_list = new ArrayList<>();   //같은 모양 숫자 인덱스 저장
		number_list = new ArrayList<>();
		royal_number_list = new ArrayList<>();
		
		duplicate_num = new HashMap<String, Integer>();  
		duplicate_shape = new HashMap<String, Integer>();
		duplicate_royal = new HashMap<String, Integer>();
		
		my_deck = new String[CARD_NUM];
		my_shape = new String[CARD_NUM];
		my_number = new String[CARD_NUM];
		
		cardSet();
	}

	// 52개의 카드 덱 생성
	void cardSet() {
		
		int temp = 0;

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
		setMyDeck();
	}
	
	// 내 카드 덱 생성
	void setMyDeck() {
		
		int index = 0;
		// 총 5개의 중복되지 않는 내 카드 생성 
		for(Integer i : index_set) {
			my_deck[index++] = card_deck[i];
		}
		// 내 카드 모양, 숫자 분리
		for(int i=0; i<my_deck.length; i++) {
			my_shape[i] = my_deck[i].substring(0, 1);
			my_number[i] = my_deck[i].substring(1);
//			royal_number_list.add(my_number[i]);
		}
		
		my_shape[0] = "♠";
		my_shape[1] = "♠";
		my_shape[2] = "♠";
		my_shape[3] = "♠";
		my_shape[4] = "♠";
		my_number[0] = "10";
		my_number[1] = "J";
		my_number[2] = "Q";
		my_number[3] = "K";
		my_number[4] = "A";
		royal_number_list.add(my_number[0]);
		royal_number_list.add(my_number[1]);
		royal_number_list.add(my_number[2]);
		royal_number_list.add(my_number[3]);
		royal_number_list.add(my_number[4]);
				
		// 출력
		disp();
	}
	
	void disp() {
		int rank = getRank();
		
		for(int i=0; i<my_deck.length; i++) {
//			System.out.printf(" %s ", my_deck[i]);
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

	// 내 카드덱에 중복된 숫자가 몇개인지 (최대)
	int getNumDuplicate() {
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
			
			return entry.getValue();
		}
		return 0;
	}
	
	// 내 카드덱에 중복된 모양이 몇개인지 (최대)
	int getShapeDuplicate(){
		// 중복그림이 몇개인지
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
	
	// straight 판별 메소드 ( straight_cnt가 5면 스트레이트 )
	int getStraightCount() throws NumberFormatException{
		// 문자열을 Integer로 형변환
		int[] card_num = new int[5];
		for(int i=0; i<5; i++) {
			if(my_number[i].equals("A")) card_num[i] = 1;
			else if(my_number[i].equals("J")) card_num[i] = 11;
			else if(my_number[i].equals("Q")) card_num[i] = 12;
			else if(my_number[i].equals("K")) card_num[i] = 13;
			else card_num[i] = Integer.parseInt(my_number[i]);
		}
		
		// 숫자 정렬  
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
		// 정렬된 숫자의 앞 뒤 차이가 1이면 straight_cnt++
		// 5일경우 스트레이트
		for(int i=4; i>=1; i--) {
			if((card_num[i]) - (card_num[i-1]) == 1) {
				straight_cnt++;
			}
		}
		
		return straight_cnt;
	}
	
	// royal_straight 판별 메소드 (royal이 5면 royal)
	int getRoyal() {
		int royal = 0;	// 5면 royal
		int max = 0;	// royal 조건 카드중 max(중복)가 2 이상일경우 royal X 
		
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
		//royal 중복검사 5개의 카드중 하나씩만 나와야 함
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
			
			System.out.println(max);
			System.out.println(royal_number_list);
			System.out.println(royal);
		}
		if(max > 1) {
			return 0;
		}
		return royal; 
	}

	int getRank() {
		// 같은 모양, 숫자 카운트 (페어, 투페어, 트리플, 풀하우스 구별 할 때)
		int shape_cnt = 1;
		int number_cnt = 1;						// 중복되는 숫자가 총 몇개인지  카운트	  ( 1 1 2 2 2  =>  4 )
 		
		for (int i=0; i<CARD_NUM; i++) {
			for(int j=0; j<i; j++) {
				if(my_shape[i].equals(my_shape[j])) {
					shape_list.add(my_shape[i]);
					shape_cnt++;
//					break;
				}
				if(my_number[i].equals(my_number[j])) {
					number_cnt++;
					number_list.add(my_number[i]);
					break;
				}
			}
		}
		int max_num = getNumDuplicate();	 	// 숫자의 최대 중복갯수가 몇개인지 카운트  (	1 1 2 2 2  =>  3 )
		
		int max_shape = getShapeDuplicate(); 	// 중복 모양 카운트 (flush 구별할 때)
		int straight_cnt = getStraightCount();	// 5면 스트레이트
		int royal = getRoyal();			// 5면 로얄 스트레이트 

		// 중복된 숫자가 2개 이상일 때
		if(number_cnt >= 2) {
			if(number_cnt == 2) return 1; // 중복된 숫자가 한 쌍일때 one pair
			if(max_num == 1 && number_cnt == 3) return 2; 	// 최대 중복 카드가 두개면 two pair 
			if(max_num == 2 && number_cnt == 3) return 3; 	// 최대 중복 카드가 세개면 triple 
			if(max_num == 3) return 4; 						// 최대 중복 카드가 네개면 four of a kind
			if(number_cnt == 4) return 5; // 최대 중복 갯수가3이면 full house ( 1 1 2 2 2 일 경우 number_cnt는 3)
		}

		// 5개가 전부 같은 모양일 때
		if(max_shape == 10) {
			if(royal == 5) return 9; 	// 10,J,Q,K,Q가 전부 포함될 때 royal straight flush
			if(straight_cnt == 5) return 8; // 연속된 숫자 5개의 카드일 때 straight flush
			return 6; 	// flush
		}
		if(straight_cnt == 5) return 7; 	// 연속된 숫자 5개의 카드일 때straight
		
		return 0;
	}
	public static void main(String[] args) {

		PokerGame_Ver02 pg;
		Scanner sc = new Scanner(System.in);
		pg = new PokerGame_Ver02();
		
	}
}
