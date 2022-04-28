package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.RegisterHandler;

import algorithm.problems.Search.RedBlackTree;

/**
 * Login
 */
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("user");
        String pwd=request.getParameter("password");


        RedBlackTree<String,RedBlackTree<String,String>> tree=(RedBlackTree<String,RedBlackTree<String,String>>)getServletContext().getAttribute("tree");

        if (RegisterHandler.check(tree, name, pwd)) {
            Cookie cookie=new Cookie("user",name);
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
            request.setAttribute("name",name);

            RequestDispatcher view=request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }
        else{
            PrintWriter out=response.getWriter();
            out.println("<center><h1>输入帐号有误或密码错误！</h1></center>");
        }


    }
}
