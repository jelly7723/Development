/**
 * @(#)HelloHttp.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */

package com.tsinghua;
import javax.servlet.http.*;
import java.io.*;

public class HelloHttp extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw=res.getWriter();
            pw.println("hello,http");
           }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
}