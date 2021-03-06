package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class RankVO_OrderBy implements Comparator<RankVO>{
	@Override
	public int compare(RankVO o1, RankVO o2) {
		if(o1.cnt < o2.cnt) {
			return -1;
		}else if(o1.cnt == o2.cnt) {
			if(o1.sec < o2.sec) {
				return -1;
			} else if(o1.sec == o2.sec) {
				return 0;
			}else {
				return 0;
			}
		}else {
			return 1;
		}
	}
}

class RankVO{
	String name;
	int cnt;
	long sec;
	
	public RankVO(String name, String cnt, String sec) {
		this.name = name;
		this.cnt = Integer.parseInt(cnt.trim());
		this.sec = Integer.parseInt(sec);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public long getSec() {
		return sec;
	}
	public void setSec(long sec) {
		this.sec = sec;
	}
	@Override
	public String toString() {
		return "RankVO [name=" + name + ", cnt=" + cnt + ", sec=" + sec + "]";
	}
}
/*
 * 	 게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다
 * 
 *   1. 플레이어는 8번의 시도를 할 수 있다
 *   
 *   2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다
 *   
 *   	숫자와 위치가 다 맞을 경우 - Strike
 *   	숫자만 맞을경우 - Ball
 *	
 *	ex: 정답이 3456일때
 *		>> 5634   	4 Ball
 *		>> 3789		1 Strike
 *	
 *	 3. 맞춘 시간과 횟수를 통해 1위부터 30위까지의 랭킹을 생성해 파일에 저장
 *      (횟수가 같다면 시간이 더 적게 걸린 사람이 상위 랭킹)
 *   4. 새로운 게임을 시작할 때 마다 랭킹을 출력해준다.
 *
 *
 *   맞추고 나면 몇 번만에 맞췃는지 알려주고 랭크에 반영
 */
public class E_GuessNumber_Ver3 {
	
	static ArrayList<RankVO> rank_list = new ArrayList<RankVO>(); // 기록 list (이름, 횟수, 시간)
	static File file = new File("./data/guessNumber.txt");	// 파일 위치
	static Scanner sc = new Scanner(System.in);
	
	static int clear = 0; 	// 0 이면 실패 1이면 성공  	
	static int game_cnt = 0; // 게임 횟수
	
	static public void inputStream() {
		FileInputStream fin;
//		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fin);
			BufferedReader dis = new BufferedReader(new InputStreamReader(bis));
			
			String text = "";
			
			while(true) {
				text = dis.readLine(); // 파일 순서대로 한줄씩 읽어옴 
				if(text == null) { // 더이상 읽을 내용 없으면
					break;
				}
				System.out.println(text); 
				
				//name,cnt,sec을 기준으로 잡음
				String name_target = "name"; 
				String cnt_target = "cnt";
				String sec_target = "sec";
				
				// substring 시작점 index ":" 이전까지 잘라냄 , (nt_num = name_target_num)
				int nt_num = text.indexOf(name_target)+5;
				int ct_num = text.indexOf(cnt_target)+4;
				int st_num = text.indexOf(sec_target)+5;
				
				// 시작점 index 부터 다음 단어 만나기 전까지의 값을 result에 담음
				String name_result; name_result = text.substring(nt_num,(text.substring(nt_num).indexOf("c")+nt_num));
				String cnt_result; cnt_result = text.substring(ct_num,(text.substring(ct_num).indexOf("s")+ct_num));
				String sec_result; sec_result = text.substring(st_num-1,(text.substring(st_num).indexOf(" |")+st_num));

				// list에 add 
				rank_list.add(new RankVO(name_result.trim(), cnt_result.trim(), sec_result.trim()));

			}
			bis.close();
			dis.close();
		} catch (FileNotFoundException e) {} catch (IOException e) {}
	}
	static public void outputStream() {
		String a;
		try {
			FileOutputStream fout = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(bos));
			
			// list.size() 만큼 반복하면서 파일에 저장
			for(int j=0; j<rank_list.size(); j++) {
				dos.write("| " + (j+1) + "위");
//				dos.write("\tname:" + rank_list.get(j).getName().trim());
//				dos.write("\tcnt:" + rank_list.get(j).getCnt());
//				dos.write("\tsec:" + rank_list.get(j).getSec() + " |");
				a = String.format("\t%-110s\t%6s\t%s", 
						"name:" + rank_list.get(j).getName(),
						"cnt:" + rank_list.get(j).getCnt(),
						"sec:" + rank_list.get(j).getSec() + " |" );
				dos.write(a);
				dos.write("\n");
			}
			dos.close();
			bos.close();
			fout.close();
		} catch (FileNotFoundException e) {} catch (IOException e) {}
	}
	public static void gamePlay() {
		Random ran = new Random();
		
		int ball;
		int strike;
		
		int num = 0, num1, num2, num3, num4;
		int user_Num = 0, user_Num1, user_Num2, user_Num3, user_Num4;
		
		num = ran.nextInt(9000) +1000;
		
		num1 = num % 10;
		num2 = num / 10 % 10;
		num3 = num / 10 / 10 % 10;
		num4 = num / 10 / 10/ 10 % 10;
		
		System.out.println(num);
		
		// 게임 실행
		while(game_cnt < 8) {
			
			ball = 0;
			strike = 0;
			
			System.out.println("숫자 4자리 >> ");
			
			user_Num = sc.nextInt();
			
			user_Num1 = user_Num % 10;
			user_Num2 = user_Num / 10 % 10;
			user_Num3 = user_Num / 10 / 10 % 10;
			user_Num4 = user_Num / 10 / 10 / 10 % 10;

			//1
			if(num1 == user_Num1) strike++;
			if(num1 != user_Num1) {
				if(num1 == user_Num2) ball++;
				if(num1 == user_Num3) ball++;
				if(num1 == user_Num4) ball++;
			}
			
			//2
			if(num2 == user_Num2) strike++;
			if(num2 != user_Num2) {
				if(num2 == user_Num1) ball++;
				if(num2 == user_Num3) ball++;
				if(num2 == user_Num4) ball++;
			}

			//3
			if(num3 == user_Num3) strike++;
			if(num3 != user_Num3) {
				if(num3 == user_Num1) ball++;
				if(num3 == user_Num2) ball++;
				if(num3 == user_Num4) ball++;
			}
			
			//4
			if(num4 == user_Num4) strike++;
			if(num4 != user_Num4) {
				if(num4 == user_Num1) ball++;
				if(num4 == user_Num2) ball++;
				if(num4 == user_Num3) ball++;
			}
			System.out.println("Ball : " + ball + "\tStrike : " + strike);
			
			game_cnt++;
			
			if(strike == 4) {
				System.out.println("\n시도 횟수 : " + game_cnt + "번");
				clear = 1;
				break;
			}
		}
		if(clear == 0) {
			System.out.println("실패");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		
		System.out.println("이름 > ");
		String name = sc.next();

		// inputStream 생성
		inputStream();
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

		// 게임 실행
		gamePlay();
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		int intTime = (int)secDiffTime; // long -> int
		String strTime = Integer.toString(intTime); // int -> String
		
		System.out.println("걸린 시간 : " + secDiffTime + "초");

		rank_list.add(new RankVO(name, Integer.toString(game_cnt), strTime) );
		
		// 오름차순 정렬
		Collections.sort(rank_list, new RankVO_OrderBy());
				
		// 30개 넘어가면 제일 뒤(순위 낮은) 데이터 삭제
		if(rank_list.size() > 30) {
			rank_list.remove(rank_list.size()-1);
		}
		// outputStream생성
		outputStream();
	}
}
