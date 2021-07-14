import java.util.Random;

public class _Test{
	public static void main(String[] args) {
		
		Random ran = new Random();
		for(int i=0; i< 100; i++) {
			System.out.println(ran.nextInt(45) +1);  //1 ~ 45);
		}
		
		
	}
}