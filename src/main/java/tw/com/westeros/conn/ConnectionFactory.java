package tw.com.westeros.conn;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactory {

	public static Connection getConn() {
		Connection conn = null;
		try {
			InitialContext context = new InitialContext();

			DataSource ds = (DataSource) context.lookup("java:comp/env/JDBC/EEIT43DB");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
