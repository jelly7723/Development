/**
 * @(#)HelloGen.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */

package com.tsinghua;
import javax.servlet.GenericServlet;
import javax.servlet.*;
import java.io.*;

public class HelloGen extends GenericServlet{
    public void service(ServletRequest req,ServletResponse res){
        try{
            PrintWriter pw=res.getWriter();
            pw.println("hello,gen");}
        catch(Exception ex){
            ex.printStackTrace();}
    }
}