package login2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBe2 extends HttpServlet {

	public LoginBe2() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		response.setContentType("text/html;charset=gbk");
		PrintWriter pw=response.getWriter();
		String info=request.getParameter("info");
		
		
		pw.println("<html>");
		pw.println("<body>");
		if(info!=null){
			pw.println("<h1>��ĵ�½��Ϣ���������µ�½��</h1>");
		}
		pw.println("<h1>�û���¼</h1>");
		pw.println("<form action=LoginCk2 method=post>");
		pw.println("�û���:<input type=text name=username>");
		pw.println("���룺<input type=text name=password>");
		pw.println("<input type=submit value=loding>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		this.doGet(request,response);

	}


	public void init() throws ServletException {
		// Put your code here
	}

}

