package login2;
import java.sql.*;

public class ConnDB {
	private Connection ct=null;
	
	public Connection getConn(){
		try{
			//加载驱动
	        Class.forName("com.mysql.jdbc.Driver");
	        //得到连接
	        ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study","root","123");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ct;
	}
}
