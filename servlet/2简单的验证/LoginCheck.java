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

            //�����û���������
            String u=req.getParameter("username");
            String p=req.getParameter("password");

            //����û����������Ƿ��Ӧ������ֵ
            if(u.equals("sp")&&p.equals("123")){
            //����ǣ����Ϸ���ִ��ʲô����
            res.sendRedirect("loginwelcome");

            }
            else{
            //������ǣ����Ƿ���ִ��ʲô����
            //Ҫ��תҳ���url
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