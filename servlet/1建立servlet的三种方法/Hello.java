/**
 * @(#)Hello.java
 *
 *
 * @author 
 * @version 1.00 2015/7/27
 */

package com.tsinghua;

import javax.servlet.*;
import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Hello implements Servlet{
    /**
     * Method init
     *
     *
     * @param parm1
     *
     @throws ServletException
     *
     */
    public void init(ServletConfig parm1) throws ServletException {
        System.out.println("init it");
        // TODO: Add your code here
    }

    /**
     * Method getServletConfig
     *
     *
     * @return
     *
     */
    public ServletConfig getServletConfig() {
        return null;
        // TODO: Add your code here
    }

    /**
     * Method service
     *
     *
     * @param parm1
     * @param parm2
     *
     @throws ServletException
     @throws IOException
     *
     */
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service it");
        PrintWriter pw=res.getWriter();
        pw.println("hello,world");
        // TODO: Add your code here
    }

    /**
     * Method getServletInfo
     *
     *
     * @return
     *
     */
    public String getServletInfo() {
        return "";
        // TODO: Add your code here
    }

    /**
     * Method destroy
     *
     *
     */
    public void destroy() {
        System.out.println("destroy");
        // TODO: Add your code here
    }

}