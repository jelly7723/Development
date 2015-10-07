package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginWel extends HttpServlet {
	public LoginWel() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	        Connection ct=null;
	        PreparedStatement ps=null;
	        //原本上面这个地方写的是Statement st=null;
	        ResultSet rs=null;
	        int dataSum = 0;
	        int pageSum=0;
	        int pageEry=3;
	        int page;
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
        
		try{
	        Class.forName("com.mysql.jdbc.Driver");
	        ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study","root","123");
	        ps=ct.prepareStatement("select count(*) from usertest");
	        rs=ps.executeQuery();
	        
	        String pageFlag=request.getParameter("page");
	        if(pageFlag==null){
	        	page=1;}
	        else{
	        	page=Integer.parseInt(pageFlag);}
	        
	        
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
	        pw.println("<table border=1>");
	        while(rs.next()){
	        	pw.println("<tr>");
	        	pw.println("<td>"+rs.getInt(1)+"</td>");
	        	pw.println("<td>"+rs.getString(2)+"</td>");
	        	pw.println("<td>"+rs.getString(3)+"</td>");
	        	pw.println("<td>"+rs.getInt(4)+"</td>");
	        	pw.println("</tr>");
	        }
	        pw.println("</table>");

	        int pagePre=page-1;
	        int pageNext=page+1;
	        if(pagePre!=0){
	        pw.println("<a href=LoginWel?page="+pagePre+">"+"上页"+"</a>");}
	        for(int i=1;i<pageSum+1;i++){
	        	pw.println("<a href=LoginWel?page="+i+">"+i+"</a>");
	        }
	        if(pageNext<=pageSum){
		        pw.println("<a href=LoginWel?page="+pageNext+">"+"下页"+"</a>");
	        }
	        
		HttpSession hs=request.getSession(true);
		String flag=(String)hs.getAttribute("pass");
		
		if(flag!="ok"){
			response.sendRedirect("LoginBe?info=error");
		}
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>欢迎您，登录成功</h1>");
		
		
		pw.println("</body>");
		pw.println("</html>");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}


	public void init() throws ServletException {
		// Put your code here
	}

}
