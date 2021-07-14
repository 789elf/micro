import java.io.File;

public class E02_File {

	/*
	 *	 # java.util.file
	 *	
	 *	  - 파일 시스템의 파일 정보를 담을 수 있는 클래스
	 *	  - 인스턴스에 담겨있는 정보를 바탕으로 새로운 파일이나 디렉토리를 생성할 수 있다
	 *	  - 이미 존재하는 파일 또는 디렉토리의 정보를 불러오기도 한다
	 */
	public static void main(String[] args) {

		// 생성자로 경로 전달
		File a = new File("E:\\kg-ac\\잡\\a.txt");
//		File b = new File("b.txt");
		
		File dir = new File("E:/kg-ac/잡");
		File dir2 = new File("E:/kg-ac/잡/test_dir");
		
		// File의 여러가지 메소드
		System.out.println("읽기 권한이 있는 파일인가요 ? " + a.canRead());
		System.out.println("실행 권한이 있는 파일인가요 ? " + a.canExecute());
		System.out.println("쓰기 권한이 있는 파일인가요 ? " + a.canWrite());
		
		// 절대 경로 알아오기
		System.out.println(a.getAbsolutePath());
		
		// a에 담긴 경로가 절대 경로인가?
		System.out.println(a.isAbsolute());
		
		// a에 담긴 파일 인스턴스는 디렉토리인가?
		System.out.println("Is a a directory ?" + a.isDirectory());
		
		System.out.println("a가 현재 존재하는가 ? " + a.exists());
		System.out.println("dir이 현재 존재하는가 ? " + dir.exists());
		System.out.println("dir2가 현재 존재하는가 ? " + dir2.exists());
		
		//존재하지 않으면 디렉토리 생성하기 mkdir() : 디렉토리 생성 메소드 
		if(!dir2.exists()) {
			dir2.mkdir();
		}else {
			System.out.println("이미 존재");
		}
		
	}

}
