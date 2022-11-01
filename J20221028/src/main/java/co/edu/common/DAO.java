package co.edu.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	// Connection ��ȯ getConnect
	public Connection getConnect() {
		try {
			
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Temp/database.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pass = prop.getProperty("passwd");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass); // url/ 계정/ pw
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.2:1521:xe", "kch", "kch"); // url/ 계정/ pw
//			System.out.println("���Ἲ��");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������");
		}
		return conn;
	}

	// Resource �����ϴ� disconnect
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(stmt!= null) stmt.close();
			if(conn != null) conn.close();
			if(psmt != null) psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
