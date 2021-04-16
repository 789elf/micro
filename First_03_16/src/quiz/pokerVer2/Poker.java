package quiz.pokerVer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Poker {

	ArrayList<Player> players;
	
	Deck deck;
	Dealer dealer;
	
	public Poker() {
		players = new ArrayList<>();
		deck = new Deck();
		dealer = new Dealer(deck);
	}
	
	public void addPlayer() {
		players.add(new Player(deck));
	}
	
	public void start() {
		for (Player p : players) {
			p.firstDraw();			
		}
	}
	
	public void next() {
		dealer.next();		
	}
	
	public void peekTable() {
		System.out.println(dealer.table);
	}
	
	public void open() {		
		System.out.println("���̺��� �� ī�� : " + dealer.table);
		for (Player p : players) {
			HashSet<Card> hand = new HashSet<>(dealer.table);			
			
			System.out.println("����ڰ� ����ִ� ī�� :" + p.hand);
			hand.addAll(p.hand);
			
			check(hand);
		}		
	}
	
	private int[] countSuits(HashSet<Card> hand) {
		
		return null;
	}
	
	// 0: not straight
	// 1: straight
	// 2: straight flush
	// 3: royal straight flush
	private int checkStraight(HashSet<Card> hand) {
		
		ArrayList<Card> sorted_hand = new ArrayList<>(hand);
		
		Collections.sort(sorted_hand);
		
		System.out.println("���ĵ� �ڵ� : " + sorted_hand);
		System.out.println("��Ʈ����Ʈ üũ 1 : " + sorted_hand.get(2));
		System.out.println("��Ʈ����Ʈ üũ 1 : " + sorted_hand.get(1));
		System.out.println("��Ʈ����Ʈ üũ 1 : " + sorted_hand.get(0));
		
		for(int i=2; i > -1; i--) {
			Card card0 = sorted_hand.get(i);
			
			System.out.printf("��Ʈ����Ʈ üũ%d : %s\n", 3-i , sorted_hand.get(i));
			
			for(int j=1; j<5; j++) {
//				if(sorted_hand.get(i))	
			}
		}
//		for(Card card : hand) {
//			int value = card.rank.getValue();
//			if(containsRankValue(value + 1)) 
//				
//			}
//		}
//		
		return 0;
	}
	
	private boolean containsRankValue(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean containsRank(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	// �Ѿ�� hand ������ ī�� 7������ � �������� ���߰� ���и� ���� �� �ִ� ������ ����
	private int check(HashSet<Card> hand) {
		HashSet<Rank> ranks = makeRankSet(hand);
		
		int straight = checkStraight(hand);
		return 0;
	}
	
	
	private HashSet<Rank> makeRankSet(HashSet<Card> hand) {
		HashSet<Rank> ranks = new HashSet<>();
		
		for(Card card : hand) {
			ranks.add(card.rank);
		}
		return ranks;
	}

	public static void main(String[] args) {
		Poker game = new Poker();
		
		game.addPlayer();
		game.addPlayer();
		game.addPlayer();
		
		game.start();
		
		// ���� ������ ������ 3�� ����
		game.next();
		game.next();
		game.next();
		
		// ���� ���� ������ ������ 1�� ����
		game.next();
		
		// ���� ���� ������ ������ 1�� ����
		game.next();		
		game.peekTable();
		
		
		// ��� Ȯ�� 
		game.open();
	}
}















