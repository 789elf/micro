import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIO {

	/*
	 *  # Java I/O (Input/Output)
	 *   
	 *   - 자바는 스트림이라는 개념을 이용해 입출력을 다룬다.
	 *   - 프로그램으로 들어오는 모든 데이터들을 입력이라고 부른다 (Input)
	 *   - 프로그램이 연산해서 내보내는 모든 데이터들을 출력이라고 부른다 (Output)
	 *   
	 *  # Stream
	 *  
	 *   - 데이터들이 오고 가능 통로
	 *   - 입력 받을 때 데이터들이 프로그램으로 들어오는 통로르 InputStream이라고 한다.
	 *   - 출력 할 때 데이터들이 나가는 통로를 OutputStream이라고 한다.
	 *   - 데이터가 Stream으로 이동하기 위해서는 해당 데이터를 byte 타입으로 변환해야 한다.
	 *   
	 *   write()를 사용하여 파일에 입력일할때는 기본적으로 파일을 다시 덮어쓰게 된다.
	 *   FileOutputStream()생성자를 통해 파일의 위치와 boolean타입 true 값을 같이 넣어주게 되면 덮어쓰지 않고 내용이 추가가 된다. 
	 *   
	 *            ※ 소스의 경로의 현재 위치는 프로젝트의 root이다 ./a.txt = 프로젝트 기준 바로 하위 폴더의 a.txt
	 */
	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			// 기본 덮어쓰는 방식
			// fout = new FileOutputStream("E:\\kg-ac\\잡\\a.txt");
			
			// true를 매개변수로 주면 내용이 추가가 된다.
//			fout = new FileOutputStream("E:\\kg-ac\\잡\\a.txt", true);
			
//			File b = new File("b.txt");
			fout = new FileOutputStream("./a.txt");
			
			File a = new File("./a.txt");			
			
			// 절대 경로 알아오기
			for(int i=0; i<5; i++) {
				// fout.write("오늘의 날씨 ".getBytes());
				fout.write(String.format("오늘의 날씨 %d \n", i).getBytes());
			}
			
			// ※ I/O Stream 수동으로 close()를 호출해줘야 한다(메모리 회수)
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch (IOException e) {
			System.out.println("데이터를 쓰다가 문제가 생김");
		} finally {
			
				try {
					if(fout != null) fout.close();
				} catch (IOException e) {}
		}
	}
}
