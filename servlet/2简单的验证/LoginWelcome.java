/**
 * @(#)LoginWelcome.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */

package com.tsinghua;
import javax.servlet.http.*;
import java.io.*;

public class LoginWelcome extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw=res.getWriter();
            pw.println("wel,hello");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
}