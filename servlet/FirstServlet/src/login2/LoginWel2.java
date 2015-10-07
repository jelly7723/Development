package login2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginWel2 extends HttpServlet {
	public LoginWel2() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	        int page;
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
        
		try{

	        
	        String pageFlag=request.getParameter("page");
	        if(pageFlag==null){
	        	page=1;}
	        else{
	        	page=Integer.parseInt(pageFlag);}
	        
	        UserBeanCk ubc=new UserBeanCk();
	        ArrayList all=ubc.pageWay(page);
	        
	        
	        
	        pw.println("<table border=1>");
	        for(int i=0;i<all.size();i++){
	        	UserBean ub=(UserBean)all.get(i);
	        	pw.println("<tr>");
	        	pw.println("<td>"+ub.getUserId()+"</td>");
	        	pw.println("<td>"+ub.getUserName()+"</td>");
	        	pw.println("<td>"+ub.getPassWord()+"</td>");
	        	pw.println("<td>"+ub.getGrade()+"</td>");
	        	pw.println("</tr>");
	        }
	        pw.println("</table>");

	        int pageSum=ubc.getPageSum();
	        int pagePre=page-1;
	        int pageNext=page+1;
	        if(pagePre!=0){
	        pw.println("<a href=LoginWel2?page="+pagePre+">"+"ÉÏÒ³"+"</a>");}
	        for(int i=1;i<pageSum+1;i++){
	        	pw.println("<a href=LoginWel2?page="+i+">"+i+"</a>");
	        }
	        if(pageNext<=pageSum){
		        pw.println("<a href=LoginWel2?page="+pageNext+">"+"ÏÂÒ³"+"</a>");
	        }
	        
		HttpSession hs=request.getSession(true);
		String flag=(String)hs.getAttribute("pass");
		
		if(flag!="ok"){
			response.sendRedirect("LoginBe2?info=error");
		}
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>»¶Ó­Äú£¬µÇÂ¼³É¹¦</h1>");
		
		
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
