package jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jdbc.model.Employee;

public class A04_DESC {

	
	public static void main(String[] args) {
		String sql = "SELECT * FROM EMPLOYEES";
		try(Connection conn = DBConnecter.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.getResultSet();
		){
			// 가져온 데이터의 메타데이터들을 보고 싶을 때 
			ResultSetMetaData rsmd = rs.getMetaData();
		
			int col_cnt = rsmd.getColumnCount();
			System.out.println("컬럼 갯수 : " + col_cnt);
			for(int i=1; i<=col_cnt; i++) {
				System.out.println("-----------------------------------");
				System.out.println(i + "번째 컬럼 이름 : " + rsmd.getColumnLabel(i));
				System.out.println(i + "번째 컬럼 타입 : " + rsmd.getColumnTypeName(i));
				System.out.println(i + "번째 컬럼 크기 : " + rsmd.getPrecision(i));
			}
			
			Class<?> employee = Class.forName("jdbc.model.Employee");

			for(Method method : employee.getMethods()) {
				System.out.print(method.getReturnType()  + " ");
				System.out.println(method.getName());
			}
			while(rs.next()) {
				Employee e = new Employee(rs);
				
				System.out.print(e.getFirst_name());
				System.out.println(" " + e.getLast_name());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
