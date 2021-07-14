package quiz.E08_CaesarCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class E08_CaesarCipher_ver2 {

	/*
	 * # 암호화
	 * 
	 * - 평문을 알아볼 수 없는 형태(암호문)로 변환하는 것 - 전달 과정에서 내용을 누가 훔쳐가더라도 알아볼 수 없게 하는 것이 목적이다
	 * 
	 * # 복호화
	 * 
	 * - 암호화 된 암호문을 다시 평문으로 되돌리는 것
	 * 
	 * # 키
	 * 
	 * - 암호화 또는 복호화에 사용되는 값
	 * 
	 * 
	 * # 시저 암호
	 * 
	 * "Hello, world!" ---- key:5 ----> "Mjqqt, btwqi!"
	 * 
	 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 * 
	 * 암호화: key만큼 오른쪽으로 문자를 이동 시킴 복호화: key만큼 왼쪽으로 문자를 이동 시킴
	 * 
	 * # "frankenstein.txt"의 전체 내용을 1 ~ 25 사이의 랜덤 키로 암호화한
	 * "frankenstein.encrypted.txt"를 생성해보세요 (단, 알파벳만 암호화 할 것)
	 */
	final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String LOWER = "abcdefghijklmnopqrstuvwxyz";

	public static char encrypt_upper(char ch, int key) {
		return UPPER.charAt((UPPER.indexOf(ch) + key) % UPPER.length());
	}

	public static char encrypt_lower(char ch, int key) {
		return LOWER.charAt((LOWER.indexOf(ch) + key) % LOWER.length());
	}

	public static void main(String[] args) {
		File frankenstein = new File("./data/text/frankenstein.txt");
		File frankenstein_encrypted = new File("./data/text/frakenstein.encrypted.txt");
		int key = new Random().nextInt(25) + 1;

		try (FileReader fin = new FileReader(frankenstein);
				BufferedReader bin = new BufferedReader(fin);
				FileWriter fout = new FileWriter(frankenstein_encrypted);
				BufferedWriter bout = new BufferedWriter(fout);) {
			String line = null;
			while ((line = bin.readLine()) != null) {
				for (int i = 0, len = line.length(); i < len; ++i) {

					char ch = line.charAt(i);

					// System.out.printf("Is '%c' Alphabetic? %b\n", ch,
					// Character.isAlphabetic(ch));

					switch (Character.getType(ch)) {
					case Character.UPPERCASE_LETTER:
						ch = encrypt_upper(ch, key);
						break;
					case Character.LOWERCASE_LETTER:
						ch = encrypt_lower(ch, key);
						break;
					}

					fout.append(ch);
				}
				fout.append('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
