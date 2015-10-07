package login2;

public class UserBean {
	private int userId;
	private String userName;
	private String passWord;
	private int grade;
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return this.userName;
	}
	
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}
	public String getPassWord(){
		return this.passWord;
	}
	
	public void setGrade(int grade){
		this.grade=grade;
	}
	public int getGrade(){
		return this.grade;
	}
	
}
