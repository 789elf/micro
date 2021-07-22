import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import jdbc.DBConnecter;

public class _Test {
	/*
	 * JDBC���� SELECT�� ResultSet�� ��ȯ �� ���� DML�� ����� ���� ������ ��ȯ.
	 * 
	 * SELECT�� PreparedStatement�� executeQuery() �޼��带 ����ϰ� �������� executeUpdate()�� ���.
	 */

	public static void main(String[] args) {
		int min_sal = 9000;
		try{
			Connection conn = DBConnecter.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE SALARY > ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, min_sal);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				System.out.printf("%d\t%10s\t%10s\t%s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("salary"));
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args) {
//		// static ���(jdbcĿ�ؼ�)�� �ҷ����� ���ؼ� ���
////	      try {
////	         Class.forName("jdbc.quiz.A01_ConnectionPratice");
////	      } catch (ClassNotFoundException e) {
////	         e.printStackTrace();
////	      }
//		
//		String sql = "INSERT INTO FRUITS VALUES(fruits_fid_seq.nextval,'Orange','ORANGE')";
//		// INSERT INTO FRUITS VALUES ((SELECT MAX(FID) FROM
//		// FRUITS)+1,'Orange','ORANGE');
//		String sql2 = "SELECT * FROM employees";
//		try (Connection conn = DBConnecter.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//
//		) {
//			// INSERT, UPDATE, DELETE�� �Ʒ� �޼ҵ� ��� ��ɾ� ����� ���ÿ� ��ȭ�� ���� ������ �����Ѵ�.
//
//			for (int i = 0; i < 10; i++) {
////	            int rows = pstmt.executeUpdate();
////	            System.out.println(rows);   
//			}
//			// SELECT
//			ResultSet rs = pstmt2.executeQuery();
//			while (rs.next()) {
//				System.out.printf("%d\t%s\t%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}