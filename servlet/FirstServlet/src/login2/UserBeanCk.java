package login2;
import java.sql.*;
import java.util.ArrayList;


public class UserBeanCk {
		
		private Connection ct=null;
		private PreparedStatement ps=null;
        private ResultSet rs=null;
        private int pageSum=0;
	
    //验证用户的业务逻辑
	public boolean cheakUser(String u,String p){

		try{
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			ps=ct.prepareStatement("select * from usertest where userName='"+u
			        +"' and passWord='"+p+"'");
			rs=ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	//分页的业务逻辑
	public ArrayList pageWay(int page){
		int dataSum=0;
		int pageEry=3;
		ArrayList all=new ArrayList();
		
		try{
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
	        ps=ct.prepareStatement("select count(*) from usertest");
	        rs=ps.executeQuery();

	        if(rs.next()){
	        	dataSum=rs.getInt(1);
	        }
	        if(dataSum%pageEry==0){
	        	pageSum=dataSum/pageEry;
	        }
	        else{
	        	pageSum=dataSum/pageEry+1;
	        }
	        
	        //
	        ps=ct.prepareStatement("select * from usertest limit ?,?");
	        ps.setInt(1,pageEry*(page-1));
	        ps.setInt(2, pageEry);
	        
	        rs=ps.executeQuery();
	        while(rs.next()){
	        	UserBean ub=new UserBean();
	        	ub.setUserId(rs.getInt(1));
	        	ub.setUserName(rs.getString(2));
	        	ub.setPassWord(rs.getString(3));
	        	ub.setGrade(rs.getInt(4));
	        	all.add(ub);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return all;
	}
	
	public int getPageSum(){
		return this.pageSum;
	}
}
