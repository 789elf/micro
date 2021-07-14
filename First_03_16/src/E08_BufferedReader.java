import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E08_BufferedReader {

	/*
	 *  1. frankenstein.txt 를 한 글 자씩 모두 읽고 걸린 시간 측정
	 *  
	 *  2. 한 글자씩 읽을때와 배열을 사용해서 읽을때의 성능 비교
	 */
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		File file = new File("./data/text/frankenstein.txt");
		
		try {
			FileReader in = new FileReader(file);
			
			StringBuilder sb = new StringBuilder();
//			int len;
//			while((len = in.read()) != -1) {
//				
//				System.out.println((char)len);
//			}
			
			char[] buff = new char[2048];
            
            
            int len = -1;
            while ((len = in.read(buff)) != -1) {
            	System.out.println(new String(buff, 0 , len));
            	
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
//		System.out.println(end - now + "ms");
		
		try(	
				FileReader fin = new FileReader(file);
				BufferedReader bin = new BufferedReader(new FileReader(file), 2048)
			) {
//			BufferedReader bin = new BufferedReader(new FileReader(file), 2048);
			
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			
			while((line = bin.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter bout = new BufferedWriter(new FileWriter(new File("./data/text/abc.txt")))){
			bout.append("Hello, BufferedWriter");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
