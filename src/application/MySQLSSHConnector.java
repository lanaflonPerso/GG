package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class MySQLSSHConnector {

public Connection findUser() throws SQLException {
		
		Connection connection = null;
        Session session= null;
        
		String host = "192.168.0.111";
		String servUser = "g4";
		String servPwd = "1ALJ826HtE";
		int port = 22;
		
		String rhost = "localhost";
		int rport = 3306;
		int lport = 3306;

		String driverName = "com.mysql.cj.jdbc.Driver";
		String db2Url = "jdbc:mysql://localhost:"+lport+"/Hotel?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		String dbUsr = "root";
		String dbPwd = "root";
		
		try {
			JSch jsch = new JSch();
			// Get SSH session
			session = jsch.getSession(servUser, host, port);
			session.setPassword(servPwd);
			java.util.Properties config = new java.util.Properties();
			// Never automatically add new host keys to the host file
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			// Connect to remote server
			session.connect();
			// Apply the port forwarding
			session.setPortForwardingL(lport, rhost, rport);
			// Connect to remote database
			Class.forName(driverName);
			connection = DriverManager.getConnection(db2Url, dbUsr, dbPwd);
			
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}

}