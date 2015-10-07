/**
 * @(#)Login.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */

package com.tsinghua;
import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            res.setContentType("text/html;charset=gbk");
            PrintWriter pw=res.getWriter();
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<form method=post action=logincheck>");
            pw.println("”√ªß√˚:<input type=text name=username><br>");
            pw.println("√‹¬Î:<input type=password name=password><br>");
            pw.println("<input value=submit type=submit>");
            pw.println("</form>");
            pw.println("</body>");
            pw.println("</html>");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
}