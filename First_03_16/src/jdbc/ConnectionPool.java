package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	/*
	 *  DB에 DML을 적용할 때 마다 새로운 접속을 생성하는 것은 리소스가 많이 낭비 된다.
	 *  
	 *  연결을 이미 여러개 생성해두고, 사용중이지 않은 커넥션을 꺼내주는 방식을 커넥션 풀이라고 함
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
