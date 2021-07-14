package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A05_PrepareStatement {

	public static void main(String[] args) {
		// ����ڷκ��� 2���� ���� �Է¹޾� INSERT 
		String fname = "Kiwi";
		String fcolor = "purple";
		
		// ���� ����� (SQL Injection)
		// ������ �̻��� ���� ������ �ְ� ������ �ۼ��ϴ°� ������ ���������� �ʴ�.
		// String sql = "INSERT INTO EMPLOYEES VALUES(fruit_seq.nextval,)"+fname + "," + fcolor + ")";
		
		// �ذ� ���    > pstmt�� �غ��ų �������� ������ �ʿ��ϴٸ� �����ڸ��� ?�� ä���,
		String sql = "INSERT INTO FRUITS VALUES(fruit_seq.nextval,?,?)";
		
		ConnectionPool pool = new ConnectionPool(10);
		
		try(Connection conn = pool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			// pstmt.set() �� �̿��Ͽ� ? �� ä��� �մ�. ���� 1 �� ù��° ����ǥ
			pstmt.setString(1, fname);
			pstmt.setString(2, fcolor);
			
			//����
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
