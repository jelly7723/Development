/**
 * @(#)LoginCheck.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */

package com.tsinghua;
import javax.servlet.http.*;
import java.io.*;

public class LoginCheck extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{

            //接收用户名与密码
            String u=req.getParameter("username");
            String p=req.getParameter("password");

            //检测用户名与密码是否对应给定的值
            if(u.equals("sp")&&p.equals("123")){
            //如果是，即合法，执行什么操作
            res.sendRedirect("loginwelcome");

            }
            else{
            //如果不是，即非法，执行什么操作
            //要填转页面的url
            res.sendRedirect("login");

            }
        }
        catch(Exception ex){   
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
        }
}