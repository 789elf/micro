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
 * 	 °ÔÀÓÀÌ ½ÃÀÛµÇ¸é ·£´ıÀ¸·Î 4ÀÚ¸®ÀÇ ¼ıÀÚ°¡ ¼±Á¤µÈ´Ù
 * 
 *   1. ÇÃ·¹ÀÌ¾î´Â 8¹øÀÇ ½Ãµµ¸¦ ÇÒ ¼ö ÀÖ´Ù
 *   
 *   2. °¢ ½Ãµµ¸¶´Ù 4ÀÚ¸®ÀÇ ¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¸é ´ÙÀ½°ú °°ÀÌ ¾Ë·ÁÁØ´Ù
 *   
 *   	¼ıÀÚ¿Í À§Ä¡°¡ ´Ù ¸ÂÀ» °æ¿ì - Strike
 *   	¼ıÀÚ¸¸ ¸ÂÀ»°æ¿ì - Ball
 *	
 *	ex: Á¤´äÀÌ 3456ÀÏ¶§
 *		>> 5634   	4 Ball
 *		>> 3789		1 Strike
 *	
 *	 3. ¸ÂÃá ½Ã°£°ú È½¼ö¸¦ ÅëÇØ 1À§ºÎÅÍ 30À§±îÁöÀÇ ·©Å·À» »ı¼ºÇØ ÆÄÀÏ¿¡ ÀúÀå
 *      (È½¼ö°¡ °°´Ù¸é ½Ã°£ÀÌ ´õ Àû°Ô °É¸° »ç¶÷ÀÌ »óÀ§ ·©Å·)
 *   4. »õ·Î¿î °ÔÀÓÀ» ½ÃÀÛÇÒ ¶§ ¸¶´Ù ·©Å·À» Ãâ·ÂÇØÁØ´Ù.
 *
 *
 *   ¸ÂÃß°í ³ª¸é ¸î ¹ø¸¸¿¡ ¸Â­Ÿ´ÂÁö ¾Ë·ÁÁÖ°í ·©Å©¿¡ ¹İ¿µ
 */
public class E_GuessNumber_Ver3 {
	
	static ArrayList<RankVO> rank_list = new ArrayList<RankVO>(); // ±â·Ï list (ÀÌ¸§, È½¼ö, ½Ã°£)
	static File file = new File("./data/guessNumber.txt");	// ÆÄÀÏ À§Ä¡
	static Scanner sc = new Scanner(System.in);
	
	static int clear = 0; 	// 0 ÀÌ¸é ½ÇÆĞ 1ÀÌ¸é ¼º°ø  	
	static int game_cnt = 0; // °ÔÀÓ È½¼ö
	
	static public void inputStream() {
		FileInputStream fin;
//		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fin);
			BufferedReader dis = new BufferedReader(new InputStreamReader(bis));
			
			String text = "";
			
			while(true) {
				text = dis.readLine(); // ÆÄÀÏ ¼ø¼­´ë·Î ÇÑÁÙ¾¿ ÀĞ¾î¿È 
				if(text == null) { // ´õÀÌ»ó ÀĞÀ» ³»¿ë ¾øÀ¸¸é
					break;
				}
				System.out.println(text); 
				
				//name,cnt,secÀ» ±âÁØÀ¸·Î ÀâÀ½
				String name_target = "name"; 
				String cnt_target = "cnt";
				String sec_target = "sec";
				
				// substring ½ÃÀÛÁ¡ index ":" ÀÌÀü±îÁö Àß¶ó³¿ , (nt_num = name_target_num)
				int nt_num = text.indexOf(name_target)+5;
				int ct_num = text.indexOf(cnt_target)+4;
				int st_num = text.indexOf(sec_target)+5;
				
				// ½ÃÀÛÁ¡ index ºÎÅÍ ´ÙÀ½ ´Ü¾î ¸¸³ª±â Àü±îÁöÀÇ °ªÀ» result¿¡ ´ãÀ½
				String name_result; name_result = text.substring(nt_num,(text.substring(nt_num).indexOf("c")+nt_num));
				String cnt_result; cnt_result = text.substring(ct_num,(text.substring(ct_num).indexOf("s")+ct_num));
				String sec_result; sec_result = text.substring(st_num-1,(text.substring(st_num).indexOf(" |")+st_num));

				// list¿¡ add 
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
			
			// list.size() ¸¸Å­ ¹İº¹ÇÏ¸é¼­ ÆÄÀÏ¿¡ ÀúÀå
			for(int j=0; j<rank_list.size(); j++) {
				dos.write("| " + (j+1) + "À§");
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
		
		// °ÔÀÓ ½ÇÇà
		while(game_cnt < 8) {
			
			ball = 0;
			strike = 0;
			
			System.out.println("¼ıÀÚ 4ÀÚ¸® >> ");
			
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
				System.out.println("\n½Ãµµ È½¼ö : " + game_cnt + "¹ø");
				clear = 1;
				break;
			}
		}
		if(clear == 0) {
			System.out.println("½ÇÆĞ");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		
		System.out.println("ÀÌ¸§ > ");
		String name = sc.next();

		// inputStream »ı¼º
		inputStream();
		
		long beforeTime = System.currentTimeMillis(); //ÄÚµå ½ÇÇà Àü¿¡ ½Ã°£ ¹Ş¾Æ¿À±â

		// °ÔÀÓ ½ÇÇà
		gamePlay();
		
		long afterTime = System.currentTimeMillis(); // ÄÚµå ½ÇÇà ÈÄ¿¡ ½Ã°£ ¹Ş¾Æ¿À±â
		long secDiffTime = (afterTime - beforeTime)/1000; //µÎ ½Ã°£¿¡ Â÷ °è»ê
		int intTime = (int)secDiffTime; // long -> int
		String strTime = Integer.toString(intTime); // int -> String
		
		System.out.println("°É¸° ½Ã°£ : " + secDiffTime + "ÃÊ");

		rank_list.add(new RankVO(name, Integer.toString(game_cnt), strTime) );
		
		// ¿À¸§Â÷¼ø Á¤·Ä
		Collections.sort(rank_list, new RankVO_OrderBy());
				
		// 30°³ ³Ñ¾î°¡¸é Á¦ÀÏ µÚ(¼øÀ§ ³·Àº) µ¥ÀÌÅÍ »èÁ¦
		if(rank_list.size() > 30) {
			rank_list.remove(rank_list.size()-1);
		}
		// outputStream»ı¼º
		outputStream();
	}
}
