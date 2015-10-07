package login2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCk2 extends HttpServlet {


	public LoginCk2() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		
        
        try{
		String user=request.getParameter("username");
		String pass=request.getParameter("password");

        /*Class.forName("com.mysql.jdbc.Driver");

        ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study","root","123");

        sm=ct.createStatement();
        
        rs=sm.executeQuery("select * from usertest where userName='"+user
        +"' and passWord='"+pass+"'");*/
		
		UserBeanCk ck=new UserBeanCk();
		
        if(ck.cheakUser(user, pass)){
		
		HttpSession hs=request.getSession(true);
		hs.setAttribute("pass","ok");
		
		PrintWriter pw = response.getWriter();
		response.sendRedirect("LoginWel2");
		
        }
        else{
        	response.sendRedirect("LoginBe2?info=error");
        }
		

		/*
		if(user.equals("sp")&&pass.equals("123"))
		{
			response.sendRedirect("LoginWel");
		}
		else{
			response.sendRedirect("LoginBe?info=error");
		}*/

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
