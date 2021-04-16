package quiz.fiveDice;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FiveDiceController {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	//�ֻ��� ���� �ϳ��� ArrayList size 1�� ����
	ArrayList<Integer> ones = new ArrayList<Integer>();
	ArrayList<Integer> twos = new ArrayList<Integer>();
	ArrayList<Integer> threes = new ArrayList<Integer>();
	ArrayList<Integer> fours = new ArrayList<Integer>();
	ArrayList<Integer> fives = new ArrayList<Integer>();
	ArrayList<Integer> sixes = new ArrayList<Integer>();
	
	ArrayList<Integer> score = new ArrayList<Integer>();
	
	int[] dices = new int[5]; //�ֻ��� 5��
	
	String select_str;  // �Է¹��� ����
	int select_int;   // �Է¹��� ����
	
	int del, del_cnt;		// �������ֻ���, �������ֻ����� ����
	int next_dice_cnt = 0;      // �������� ���� �ֻ��� �� 
	
	//�ֻ��� 1 ~ 6
	int dice_one;
	int dice_two;
	int dice_three;
	int dice_four;
	int dice_five;
	int dice_six;
	// Ǯ �Ͽ콺
	int full_two;
	int full_three;
	
	public int getTotalScore(){
		
		int total = 0;
		for(int i=0; i<score.size(); i++) {
			total += score.get(i);
		}
		return total;
	}
	
	// �ֻ���  ��¸޼ҵ�
	public void disp(int[] dices) {

		System.out.println("- - - - - - - - - - - - - -");
		System.out.println(result(dices));

		System.out.print("  ������������������������������������������\n  ");
		for(int i=0; i<5; i++) {
			System.out.printf("�� %d ",dices[i]);
		}
		System.out.print("��\n  ������������������������������������������\n");

		System.out.println("- - - -  s c o r e - - - -");
		// ���� ��ȣ
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("��������");
			}
			if(score.size() - i == 1) {
				System.out.print("������������������");
			}
			else System.out.print("������������");
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			System.out.printf("�� %2d  ", i+1);
			if(score.size() - i == 1) {
				System.out.print("��total��");
			}
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("��������");
			}
			if(score.size() - i == 1) {
				System.out.print("������������������");
			}
			else System.out.print("������������");
		}		

		System.out.println();

		// ����
		for(int i=0; i<score.size(); i++) {
			System.out.printf("�� %2d  ", score.get(i));
			if(score.size() - i == 1) {
				System.out.printf("��%3d  ��",getTotalScore());
			}
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("��������");
			}
			if(score.size() - i == 1) {
				System.out.print("������������������");
			}
			else System.out.print("������������");
		}		
		
		System.out.println();
		System.out.println("- - - - - - - - - - - - - -");
		
		System.out.println("\n");
		
	}
	
	
	// �����ϰ� ���� ������ ���� �� ��� �������� �˷��ش�.
	public ArrayList<Integer> getDiceList(int num) {
		if(num == 1) return ones;
		if(num == 2) return twos;
		if(num == 3) return threes;
		if(num == 4) return fours;
		if(num == 5) return fives;
		if(num == 6) return sixes;
		
		return ones;
	}
	
	// ���� �����ϰų� ������ ���� ���� ��� ArrayList ��ü�ε����� �����Ѵ�
	public void listClear() {
		ones.clear(); 
		twos.clear();
		threes.clear();
		fours.clear();
		fives.clear();
		sixes.clear();
	}
	
	// ����Ʈ ���� ( ������ ���� ��ŭ )
	public void listRemove(int dice_no,int cnt) {
		
		System.out.println("dice : " + dice_no + "cnt : " + cnt);
		if(dice_no == 1) {
			for(int i=0; i<cnt; i++) {
				ones.remove(0);
			}
		}
		if(dice_no == 2) {
			for(int i=0; i<cnt; i++) {
				twos.remove(0);
				System.out.println("i : " + i);
			}
		}
		if(dice_no == 3) {
			for(int i=0; i<cnt; i++) {
				threes.remove(0);
			}
		}
		if(dice_no == 4) {
			for(int i=0; i<cnt; i++) {
				fours.remove(0);
			}
		}
		if(dice_no == 5) {
			for(int i=0; i<cnt; i++) {
				fives.remove(0);
			}
		}
		if(dice_no == 6) {
			for(int i=0; i<cnt; i++) {
				sixes.remove(0);
			}
		}
	}
	public void dices(boolean isFirst) {
		if(isFirst) {
			listClear();  // ����Ʈ �ʱ�ȭ
			score.clear(); // ���� �ʱ�ȭ
			
			for(int i=0; i<5; i++) {
				dices[i] = ran.nextInt(6) +1;
				
				if(dices[i] == 1) ones.add(1);
				if(dices[i] == 2) twos.add(1);
				if(dices[i] == 3) threes.add(1);
				if(dices[i] == 4) fours.add(1);
				if(dices[i] == 5) fives.add(1);
				if(dices[i] == 6) sixes.add(1);
			}
			disp(dices);
			
		}else if(!isFirst) {
			next_dice_cnt = 0; //������ ���� �ֻ��� �� �̸� �ʱ�ȭ
			
			System.out.println("Delete ? ( 'y' or 'n' ) ");
			select_str = sc.next();
			if(select_str.equals("Y") || select_str.equals(("y"))){

				int k = 0, keep_num;
				System.out.println("How many numbers? > ");
				keep_num = sc.nextInt();
				
				
				while(k < keep_num) {
					System.out.println("what do you want to delete? > ");
					del = sc.nextInt();
					System.out.println("How many do you want to delete dice " + del + "? > (" + getDiceList(del).size() + " possible)" );
					del_cnt = sc.nextInt();

					int temp_cnt = 1;  // ������ �ֻ��� � ���������� ���� ���� ( break�� �ݺ��� Ż�� )
					
					for(int i=0; i<5; i++) {
						// �ε����� �����ϴ� �ֻ������ݰ�, ������ �ֻ����� �������� ���ٸ�
						// �ش� �ε����� ���� �ٽ� �������� 1 ~ 6�� ���� �ְ� ArrayList�� index�� �߰��Ѵ�.
						if(dices[i] == del) {
							
							dices[i] = ran.nextInt(6) +1;
							
							if(dices[i] == 1) ones.add(1);
							if(dices[i] == 2) twos.add(1);
							if(dices[i] == 3) threes.add(1);
							if(dices[i] == 4) fours.add(1);
							if(dices[i] == 5) fives.add(1);
							if(dices[i] == 6) sixes.add(1);
							
							// �����ϰ� ���� ������ ������ŭ �����ϰ� �ݺ��� Ż�� 
							if(del_cnt == temp_cnt) break;
					
							
							temp_cnt++;
						}
					}
					listRemove(del, del_cnt);
					k++;
				}
				disp(dices);

			}else if (select_str.equals("N") || select_str.equals(("n"))){
				listClear();
				for(int i=0; i<5; i++) {
					dices[i] = ran.nextInt(6) +1;
					
					if(dices[i] == 1) ones.add(1);
					if(dices[i] == 2) twos.add(1);
					if(dices[i] == 3) threes.add(1);
					if(dices[i] == 4) fours.add(1);
					if(dices[i] == 5) fives.add(1);
					if(dices[i] == 6) sixes.add(1);
				}
				disp(dices);
			}else {
				System.out.println("Press Only 'y' or 'n'");
			}
		}
	}
	
	/*
	    # 4 ~ 5 ��Ʈ����Ʈ
	      
	   	�ֻ����� ���� �Ŀ� �ٷ� ���� �ε������� ���̰� 1�̶�� cnt + 1
	   	
	   	cnt ����  4�� �� ��� 4 ��Ʈ����Ʈ , 
	   	  	     5�� �� ��� 5 ��Ʈ����Ʈ
	   	  	     
	 */
	public int straight(int[] dices) {
		int[] temp_dice;
		temp_dice = dices;
		int temp;
		int cnt = 1;
		// �ֻ��������� ������������ �����Ѵ�. ( ������ -> ū�� ) 
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(temp_dice[i] < temp_dice[j]) {
					
					temp = temp_dice[j];
					temp_dice[j] = temp_dice[i];
					temp_dice[i] = temp;
				}
			}
		}
		
		// �ֻ���[i] - �ֻ���[i-1]  = 1 �ϰ�� cnt�� 1 ������Ų��. 
		for(int i=4; i>=1; i--) {
			if((temp_dice[i]) - (temp_dice[i-1]) == 1) {
				cnt++;
			}
		}
		
		System.out.println("cnt : " + cnt);
		//cnt�� 4�� 4��Ʈ����Ʈ
		if(cnt == 4) {
			return 1;
		}
		// 5�� 5��Ʈ����Ʈ
		if(cnt == 5) {
			return 2;
		}
		return 0;
	}
	
	/*
	    # Ǯ�Ͽ콺
	    
	         ���� �ֻ��� ������ ������ 2 Ȥ�� 3�̸� full_two, three �������� �� �ֻ������� ������ �Է�
	      ex : ������ 1 / 1 / 4 / 4 / 4 �� ��� full_two�� 1, full_three�� 3�� �ȴ�.  
	         
	 */
	public boolean fullHouse() {
		
		boolean isFull_house = false;
		
//		int full_two;
//		int full_three;
		
		full_two = 0;
		full_three = 0;
 
		if(ones.size() >= 2) {
			if(ones.size() == 2) full_two = 1;  
			if(ones.size() == 3) full_three = 1;
		}
		if(twos.size() >= 2) {
			if(twos.size() == 2) full_two = 2; 
			if(twos.size() == 3) full_three = 2;
		}
		if(threes.size() >= 2) {
			if(threes.size() == 2) full_two = 3; 
			if(threes.size() == 3) full_three = 3;
		}
		if(fours.size() >= 2) {
			if(fours.size() == 2) full_two = 4; 
			if(fours.size() == 3) full_three = 4;
		}
		if(fives.size() >= 2) {
			if(fives.size() == 2) full_two = 5; 
			if(fives.size() == 3) full_three = 5;
		}
		if(sixes.size() >= 2) {
			if(sixes.size() == 2) full_two = 6; 
			if(sixes.size() == 3) full_three = 6;
		}
		
		//two, three ���� �Ѵ� ä���� �ִٸ� Ǯ �Ͽ콺�̴�.
		if(full_two != 0 && full_three !=0) {
			isFull_house = true;
			score.add(((full_two * 2) + (full_three * 3)));
		}
		
		return isFull_house;
	}
	
	// 4, 5 dice  
	// ���� ������ �ֻ����� 4���� 1�� ���� 5���� 0�� ���� 
	public int fourOrMore() {

		int four_or_more = 0;
		
		if(ones.size() >= 4) {
			if(ones.size() == 4) {
				four_or_more = 1;
				score.add(1 * 4);
			}
			if(ones.size() == 5) {
				four_or_more = 2;
				score.add(1 * 5);
			}
		}
		if(twos.size() >= 4) {
			if(twos.size() == 4) {
				four_or_more = 1;
				score.add(2 * 4);
			}
			if(twos.size() == 5) {
				four_or_more = 2;
				score.add(2 * 5);
			}
		}
		if(threes.size() >= 4) {
			if(threes.size() == 4) {
				four_or_more = 1;
				score.add(3 * 4);
			}
			if(threes.size() == 5) {
				four_or_more = 2;
				score.add(3 * 5);
			}
		}
		if(fours.size() >= 4) {
			if(fours.size() == 4) {
				four_or_more = 1;
				score.add(4 * 4);
			}
			if(fours.size() == 5) {
				four_or_more = 2;
				score.add(4 * 5);
			}
		}
		if(fives.size() >= 4) {
			if(fives.size() == 4) {
				four_or_more = 1;
				score.add(5 * 4);
			}
			if(fives.size() == 5) {
				four_or_more = 2;
				score.add(5 * 5);
			}
		}
		if(sixes.size() >= 4) {
			if(sixes.size() == 4) {
				four_or_more = 1;
				score.add(6 * 4);
			}
			if(sixes.size() == 5) {
				four_or_more = 2;
				score.add(6 * 5);
			}
		}
		
		return four_or_more;
	}
	
	// ������� �������ش�.
	public String result(int[] dices) {
		
		//Ǯ�Ͽ콺
		if(fullHouse()) {
			return 	  "    ����������������������������������\n"
					+ "    ��   Full House  ��\n"
					+ "    ����������������������������������";
		}
		// 4 ~ 5 ���̽�
		if(fourOrMore() == 1) {
			return 	  "    ����������������������������������\n"
					+ "    ��Four of a Kind ��\n"
					+ "    ����������������������������������";
		}
		if(fourOrMore() == 2) {
			return    "    ����������������������������������\n"
					+ "    ��Five of a Kind ��\n"
					+ "    ����������������������������������";
		}
		// 4 ~ 5 ��Ʈ����Ʈ
		if(straight(dices) == 1) {
			score.add(15);
			return    "    ����������������������������������\n"
					+ "    �� Four Straight ��\n"
					+ "    ����������������������������������";
		}

		if(straight(dices) == 2) {
			score.add(30);
			return    "    ����������������������������������\n"
					+ "    �� Five Straight ��\n"
					+ "    ����������������������������������";
		}
		// ����
		score.add(0);
		return 	  "    ����������������������������������\n"
				+ "    ��    No Cards   ��\n" 
				+ "    ����������������������������������";
	}
}
