package login2;
import java.sql.*;

public class ConnDB {
	private Connection ct=null;
	
	public Connection getConn(){
		try{
			//��������
	        Class.forName("com.mysql.jdbc.Driver");
	        //�õ�����
	        ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study","root","123");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ct;
	}
}
