package quiz;

public class B16_RandomPass {

	public static void main(String[] args) {

		/*
		 * 4�ڸ��� ���� �ӽú�й�ȣ�� �����ϴ� ���α׷��� ��������.

			(��й�ȣ�� �����ϴ� ���ڴ� ���� �빮�ڿ� �����Դϴ�) 65 ~ 90   58 ~ 64
		 */
		//(Math.random() * 45 + 1) == 45)
		
		//���ڿ� + �ϱ⿡ ȿ�� ���� StringBuilder
		StringBuilder pw = new StringBuilder();
		
		//�ʱ�ȭ
		pw.append("");
		
		
		for(int i=pw.length(); i<4; i++) {
			//'0'(48) ~ 'Z'(90)
			pw.append((char)((int)(Math.random()*42)+48));
			
			System.out.println(pw.charAt(i));
			
			//���ڿ� ���ĺ� �߰� Ư������
			if(pw.charAt(i) >= 58 && pw.charAt(i) <= 64){
				
				//Ư�����ڰ� ���� ��� StringBuilder �޼ҵ带 �̿��� �ε��� ����
				 pw.deleteCharAt(i);
				 
				 //���� ���ŵ� ��ŭ i���� -1 (�ݺ��� �ѹ� ���ؾ���)
				 i--;
			}
		}
		
		System.out.println(pw);
	}
}
