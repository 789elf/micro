package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	/*
	 *  DB�� DML�� ������ �� ���� ���ο� ������ �����ϴ� ���� ���ҽ��� ���� ���� �ȴ�.
	 *  
	 *  ������ �̹� ������ �����صΰ�, ��������� ���� Ŀ�ؼ��� �����ִ� ����� Ŀ�ؼ� Ǯ�̶�� ��
	 */
	
	List<JdbcConnection> pool;
	
	public ConnectionPool(int size) {
		pool = new ArrayList<>(size);
		
		for(int i=0; i<size; i++) {
			pool.add(new JdbcConnection());
		}
	}
	
	public Connection getConnection() {
		for(JdbcConnection jconn : pool) {
			if(!jconn.using()) {
				return jconn.use();
			}
		}
		return null;
	}
	
	class JdbcConnection implements AutoCloseable {
		private Connection conn;
		private boolean using;
		
		public JdbcConnection() {
			conn = DBConnecter.getConnection();
		}
		public boolean using() {
			return using;
		}
		public Connection use() {
			using = true;
			return conn;
		}
		public void close() {
			using = false;
		}
	}
}