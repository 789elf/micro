
public class B04_String {

	public static void main(String[] args) {
	/*
	 *  # 	���ڿ� (������ Ÿ��)�� ==���� ���ϸ� �ȵȴ�.
	 *  	������ Ÿ���� ���� ���� ����  �ش� Ŭ������ ���ǵǾ� �ִ� equals()���
	 *  	�޼��带 �̿��ؾ� �Ѵ�. 
	 *  	ex: System.out.println(str.equals("yes"));
	 *  	
	 *  	���ڿ����� ���� �� == �� ����ϸ� ���񱳰� �ƴ� �ּҰ� �񱳸� �Ѵ�.
	 *  
	 *  #	�⺻�� Ÿ�԰� ������ Ÿ���� ����
	 *  	- �⺻�� Ÿ���� ���� �������� ũ�⸦ �����ϱ� ����.
	 *  	  (�������� ���̴� �޸� ��� , Stack)
	 *  	- ������ Ÿ���� ���� �������� ũ�⸦ �����ϱ� ��ƴ�.
	 *  	  (�������� �� ���̴� �޸� ���, Heap)
	 */
		
		String str1 = "yes";
		String str2 = new String("yes");
		String str3 = "yes";
				
		
		
	}
	
	/*
	 *  format = ���ڿ��� ���鶧 ������ ���صΰ� ������ �� ���ִ�
	 */
	public String getTranscript(String name, int kor, int eng, int mat, int total, float avg) {
		return String.format("%s  %d  %d  %d %d  %.2f", name, kor, eng, mat, total, avg);
	}
	
	
	
	
}
