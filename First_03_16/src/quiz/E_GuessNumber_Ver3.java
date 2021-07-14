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
 * 	 ������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�
 * 
 *   1. �÷��̾�� 8���� �õ��� �� �� �ִ�
 *   
 *   2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�
 *   
 *   	���ڿ� ��ġ�� �� ���� ��� - Strike
 *   	���ڸ� ������� - Ball
 *	
 *	ex: ������ 3456�϶�
 *		>> 5634   	4 Ball
 *		>> 3789		1 Strike
 *	
 *	 3. ���� �ð��� Ƚ���� ���� 1������ 30�������� ��ŷ�� ������ ���Ͽ� ����
 *      (Ƚ���� ���ٸ� �ð��� �� ���� �ɸ� ����� ���� ��ŷ)
 *   4. ���ο� ������ ������ �� ���� ��ŷ�� ������ش�.
 *
 *
 *   ���߰� ���� �� ������ �­����� �˷��ְ� ��ũ�� �ݿ�
 */
public class E_GuessNumber_Ver3 {
	
	static ArrayList<RankVO> rank_list = new ArrayList<RankVO>(); // ��� list (�̸�, Ƚ��, �ð�)
	static File file = new File("./data/guessNumber.txt");	// ���� ��ġ
	static Scanner sc = new Scanner(System.in);
	
	static int clear = 0; 	// 0 �̸� ���� 1�̸� ����  	
	static int game_cnt = 0; // ���� Ƚ��
	
	static public void inputStream() {
		FileInputStream fin;
//		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fin);
			BufferedReader dis = new BufferedReader(new InputStreamReader(bis));
			
			String text = "";
			
			while(true) {
				text = dis.readLine(); // ���� ������� ���پ� �о�� 
				if(text == null) { // ���̻� ���� ���� ������
					break;
				}
				System.out.println(text); 
				
				//name,cnt,sec�� �������� ����
				String name_target = "name"; 
				String cnt_target = "cnt";
				String sec_target = "sec";
				
				// substring ������ index ":" �������� �߶� , (nt_num = name_target_num)
				int nt_num = text.indexOf(name_target)+5;
				int ct_num = text.indexOf(cnt_target)+4;
				int st_num = text.indexOf(sec_target)+5;
				
				// ������ index ���� ���� �ܾ� ������ �������� ���� result�� ����
				String name_result; name_result = text.substring(nt_num,(text.substring(nt_num).indexOf("c")+nt_num));
				String cnt_result; cnt_result = text.substring(ct_num,(text.substring(ct_num).indexOf("s")+ct_num));
				String sec_result; sec_result = text.substring(st_num-1,(text.substring(st_num).indexOf(" |")+st_num));

				// list�� add 
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
			
			// list.size() ��ŭ �ݺ��ϸ鼭 ���Ͽ� ����
			for(int j=0; j<rank_list.size(); j++) {
				dos.write("| " + (j+1) + "��");
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
		
		// ���� ����
		while(game_cnt < 8) {
			
			ball = 0;
			strike = 0;
			
			System.out.println("���� 4�ڸ� >> ");
			
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
				System.out.println("\n�õ� Ƚ�� : " + game_cnt + "��");
				clear = 1;
				break;
			}
		}
		if(clear == 0) {
			System.out.println("����");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		
		System.out.println("�̸� > ");
		String name = sc.next();

		// inputStream ����
		inputStream();
		
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���

		// ���� ����
		gamePlay();
		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime)/1000; //�� �ð��� �� ���
		int intTime = (int)secDiffTime; // long -> int
		String strTime = Integer.toString(intTime); // int -> String
		
		System.out.println("�ɸ� �ð� : " + secDiffTime + "��");

		rank_list.add(new RankVO(name, Integer.toString(game_cnt), strTime) );
		
		// �������� ����
		Collections.sort(rank_list, new RankVO_OrderBy());
				
		// 30�� �Ѿ�� ���� ��(���� ����) ������ ����
		if(rank_list.size() > 30) {
			rank_list.remove(rank_list.size()-1);
		}
		// outputStream����
		outputStream();
	}
}
