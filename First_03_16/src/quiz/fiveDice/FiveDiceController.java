package quiz.fiveDice;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FiveDiceController {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	//주사위 눈금 하나당 ArrayList size 1씩 증가
	ArrayList<Integer> ones = new ArrayList<Integer>();
	ArrayList<Integer> twos = new ArrayList<Integer>();
	ArrayList<Integer> threes = new ArrayList<Integer>();
	ArrayList<Integer> fours = new ArrayList<Integer>();
	ArrayList<Integer> fives = new ArrayList<Integer>();
	ArrayList<Integer> sixes = new ArrayList<Integer>();
	
	ArrayList<Integer> score = new ArrayList<Integer>();
	
	int[] dices = new int[5]; //주사위 5개
	
	String select_str;  // 입력받을 문자
	int select_int;   // 입력받을 숫자
	
	int del, del_cnt;		// 삭제할주사위, 삭제할주사위의 갯수
	int next_dice_cnt = 0;      // 다음번에 돌릴 주사위 수 
	
	//주사위 1 ~ 6
	int dice_one;
	int dice_two;
	int dice_three;
	int dice_four;
	int dice_five;
	int dice_six;
	// 풀 하우스
	int full_two;
	int full_three;
	
	public int getTotalScore(){
		
		int total = 0;
		for(int i=0; i<score.size(); i++) {
			total += score.get(i);
		}
		return total;
	}
	
	// 주사위  출력메소드
	public void disp(int[] dices) {

		System.out.println("- - - - - - - - - - - - - -");
		System.out.println(result(dices));

		System.out.print("  ┌───┬───┬───┬───┬───┐\n  ");
		for(int i=0; i<5; i++) {
			System.out.printf("│ %d ",dices[i]);
		}
		System.out.print("│\n  └───┴───┴───┴───┴───┘\n");

		System.out.println("- - - -  s c o r e - - - -");
		// 게임 번호
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("┌───");
			}
			if(score.size() - i == 1) {
				System.out.print("──┬─────┐");
			}
			else System.out.print("──┬───");
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			System.out.printf("│ %2d  ", i+1);
			if(score.size() - i == 1) {
				System.out.print("│total│");
			}
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("├───");
			}
			if(score.size() - i == 1) {
				System.out.print("──┼─────┤");
			}
			else System.out.print("──┼───");
		}		

		System.out.println();

		// 점수
		for(int i=0; i<score.size(); i++) {
			System.out.printf("│ %2d  ", score.get(i));
			if(score.size() - i == 1) {
				System.out.printf("│%3d  │",getTotalScore());
			}
		}
		System.out.println();
		for(int i=0; i<score.size(); i++) {
			if(i == 0) {
				System.out.print("└───");
			}
			if(score.size() - i == 1) {
				System.out.print("──┴─────┘");
			}
			else System.out.print("──┴───");
		}		
		
		System.out.println();
		System.out.println("- - - - - - - - - - - - - -");
		
		System.out.println("\n");
		
	}
	
	
	// 삭제하고 싶은 눈금이 있을 때 몇개가 가능한지 알려준다.
	public ArrayList<Integer> getDiceList(int num) {
		if(num == 1) return ones;
		if(num == 2) return twos;
		if(num == 3) return threes;
		if(num == 4) return fours;
		if(num == 5) return fives;
		if(num == 6) return sixes;
		
		return ones;
	}
	
	// 새로 시작하거나 삭제할 값이 없는 경우 ArrayList 전체인덱스를 삭제한다
	public void listClear() {
		ones.clear(); 
		twos.clear();
		threes.clear();
		fours.clear();
		fives.clear();
		sixes.clear();
	}
	
	// 리스트 제거 ( 제거할 갯수 만큼 )
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
			listClear();  // 리스트 초기화
			score.clear(); // 점수 초기화
			
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
			next_dice_cnt = 0; //다음에 돌릴 주사위 수 미리 초기화
			
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

					int temp_cnt = 1;  // 삭제할 주사위 몇개 제거할지에 대한 변수 ( break로 반복문 탈출 )
					
					for(int i=0; i<5; i++) {
						// 인덱스에 존재하는 주사위눈금과, 삭제할 주사위의 변수값이 같다면
						// 해당 인덱스의 값을 다시 랜덤으로 1 ~ 6의 값을 넣고 ArrayList의 index를 추가한다.
						if(dices[i] == del) {
							
							dices[i] = ran.nextInt(6) +1;
							
							if(dices[i] == 1) ones.add(1);
							if(dices[i] == 2) twos.add(1);
							if(dices[i] == 3) threes.add(1);
							if(dices[i] == 4) fours.add(1);
							if(dices[i] == 5) fives.add(1);
							if(dices[i] == 6) sixes.add(1);
							
							// 제거하고 싶은 눈금의 갯수만큼 삭제하고 반복문 탈출 
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
	    # 4 ~ 5 스트레이트
	      
	   	주사위를 정렬 후에 바로 다음 인덱스와의 차이가 1이라면 cnt + 1
	   	
	   	cnt 값이  4가 될 경우 4 스트레이트 , 
	   	  	     5가 될 경우 5 스트레이트
	   	  	     
	 */
	public int straight(int[] dices) {
		int[] temp_dice;
		temp_dice = dices;
		int temp;
		int cnt = 1;
		// 주사위눈금을 오름차순으로 정렬한다. ( 작은수 -> 큰수 ) 
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(temp_dice[i] < temp_dice[j]) {
					
					temp = temp_dice[j];
					temp_dice[j] = temp_dice[i];
					temp_dice[i] = temp;
				}
			}
		}
		
		// 주사위[i] - 주사위[i-1]  = 1 일경우 cnt를 1 증가시킨다. 
		for(int i=4; i>=1; i--) {
			if((temp_dice[i]) - (temp_dice[i-1]) == 1) {
				cnt++;
			}
		}
		
		System.out.println("cnt : " + cnt);
		//cnt가 4면 4스트레이트
		if(cnt == 4) {
			return 1;
		}
		// 5면 5스트레이트
		if(cnt == 5) {
			return 2;
		}
		return 0;
	}
	
	/*
	    # 풀하우스
	    
	         같은 주사위 눈금의 갯수가 2 혹은 3이면 full_two, three 변수값을 그 주사위눈금 값으로 입력
	      ex : 눈금이 1 / 1 / 4 / 4 / 4 일 경우 full_two는 1, full_three는 3이 된다.  
	         
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
		
		//two, three 값이 둘다 채워져 있다면 풀 하우스이다.
		if(full_two != 0 && full_three !=0) {
			isFull_house = true;
			score.add(((full_two * 2) + (full_three * 3)));
		}
		
		return isFull_house;
	}
	
	// 4, 5 dice  
	// 같은 눈금의 주사위가 4개면 1을 리턴 5개면 0을 리턴 
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
	
	// 결과값을 리턴해준다.
	public String result(int[] dices) {
		
		//풀하우스
		if(fullHouse()) {
			return 	  "    ┌───────────────┐\n"
					+ "    │   Full House  │\n"
					+ "    └───────────────┘";
		}
		// 4 ~ 5 다이스
		if(fourOrMore() == 1) {
			return 	  "    ┌───────────────┐\n"
					+ "    │Four of a Kind │\n"
					+ "    └───────────────┘";
		}
		if(fourOrMore() == 2) {
			return    "    ┌───────────────┐\n"
					+ "    │Five of a Kind │\n"
					+ "    └───────────────┘";
		}
		// 4 ~ 5 스트레이트
		if(straight(dices) == 1) {
			score.add(15);
			return    "    ┌───────────────┐\n"
					+ "    │ Four Straight │\n"
					+ "    └───────────────┘";
		}

		if(straight(dices) == 2) {
			score.add(30);
			return    "    ┌───────────────┐\n"
					+ "    │ Five Straight │\n"
					+ "    └───────────────┘";
		}
		// 잡패
		score.add(0);
		return 	  "    ┌───────────────┐\n"
				+ "    │    No Cards   │\n" 
				+ "    └───────────────┘";
	}
}
