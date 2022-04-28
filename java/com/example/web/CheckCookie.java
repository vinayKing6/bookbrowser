package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CheckCookie
 */
public class CheckCookie extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        Cookie[] cookies=request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("user")) {
                String name=cookies[i].getValue();
                out.println("hello! "+name+"<br>");
                break;
            }
        }

    }
}
