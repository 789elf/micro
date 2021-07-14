package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.ConnectionPool;
import jdbc.DBConnecter;
class UnderLengthException extends Exception{ 
	public UnderLengthException() {
		super("�� ���� �̻� �Է�");
	}
}
public class A05_SearchKeyword {

	/*
	 * first_name�� ����ڰ� �Է��� ���� �� ���ԵǾ� �ִ� ��� ����˻� (��, �˻���� �� ���� �̻��̾�� �ϰ� �� ���� �̻���
	 * �ƴ϶�� ���ܰ� �߻��ؾ� ��)
	 */
	public static void main(String[] args) throws UnderLengthException {
		
		Scanner sc = new Scanner(System.in);
		String sql = "SELECT FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE ?";
		String first_name = "%";
		String temp = "";
		System.out.println("�α��� �̻� �Է� > ");
		temp = sc.next();
		
		if(temp.length() < 2) {
			throw new UnderLengthException();
		}
		first_name += temp + "%";
		
		ConnectionPool pool = new ConnectionPool(5);
		
		try(Connection conn = pool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, first_name);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
