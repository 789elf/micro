package quiz.E08_CaesarCipher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/*
 *  # ��ȣȭ
 *   
 *   - ���� �˾ƺ� �� ���� ���·� ��ȯ�ϴ� ��
 *   - ���� �������� ������ ���� ���İ����� �˾ƺ� �� ���� �ϴ� ���� ����
 *   
 *  # ��ȣȭ
 *   
 *   - ��ȣȭ �� ��ȣ���� �ٽ� ������ �ǵ����� ��
 *   
 *  # Ű
 *   
 *   - ��ȣȭ �Ǵ� ��ȣȭ�� ���Ǵ� ��
 *   
 *  # ���� ��ȣ
 *  
 *   "Hello, world!"  --- key:5 ---> "Mjqqt, bqwqu!"
 *   
 *   A - Z
 *   
 *   Quiz
 *   frankenstein.txt �� ��ü ������ 1 ~ 25 ������ ���� Ű�� ��ȣȭ�� 
 *   frankenstein.encrypted.txt"�� �����ϱ�
 */
public class E08_CaesarCipher {

	public static void encryption(File file, StringBuilder str) {
		try (BufferedWriter bout = new BufferedWriter(new FileWriter(file))){
			bout.append(str);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void decryption(File file,int key) {
		StringBuilder sb = new StringBuilder();
		try {
			FileReader in = new FileReader(file);
			char[] buff = new char[2048];
            
            int len = -1;
            while ((len = in.read(buff)) != -1) {
            	sb.append(new String(buff, 0 , len));
            }
		} catch (FileNotFoundException e) {} catch (IOException e) {}

		int len = sb.length();
		char[] chArr = new char[len];
		
		for(int i=0; i<len; i++) {
			if((Character.isLowerCase(sb.charAt(i)) && sb.charAt(i) - key < 'a') || (Character.isUpperCase(sb.charAt(i)) && sb.charAt(i) - key < 'A')) {
				chArr[i] = (char)(sb.charAt(i)-(key-26));
				
			}else if(Pattern.matches("[A-Za-z]",Character.toString(sb.charAt(i)))){
				chArr[i] = (char)(sb.charAt(i)-key);
			}else {
				chArr[i] = (char)sb.charAt(i);
			}
		}
		sb = new StringBuilder();
		for(int i=0; i<len; i++) {
			sb.append(chArr[i]);
		}
		
		System.out.println(sb);
		
	}
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		int key = 8;
//		int key = (int)(Math.random()*25 +1);
		
		File file = new File("./data/text/frankenstein.txt");
		
		try {
			FileReader in = new FileReader(file);
			
			sb = new StringBuilder();
			
			char[] buff = new char[2048];
            
            
            int len = -1;
            while ((len = in.read(buff)) != -1) {
            	sb.append(new String(buff, 0 , len));
            }
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int len = sb.length();
		char[] chArr = new char[len];
		
		for(int i=0; i<len; i++) {
			if(Pattern.matches("[A-Za-z]",Character.toString(sb.charAt(i)))){
				chArr[i] = (char)(sb.charAt(i)+key);
				
				if(!Pattern.matches("[A-Za-z]",Character.toString(chArr[i]))){
					chArr[i] = (char)(chArr[i]-26);
				}
			}else {
				chArr[i] = (char)sb.charAt(i);
			}
		}
		
		sb = new StringBuilder();
		for(int i=0; i<len; i++) {
			sb.append(chArr[i]);
		}
		
		//.
//		encryption(new File("./data/text/frankenstein.encrypted.txt"),sb);
		decryption(new File("./data/text/frankenstein.encrypted.txt"),key);
//		System.out.println(temp);
		
	}
}
