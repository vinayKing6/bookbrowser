package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.RegisterHandler;

import algorithm.problems.Search.RedBlackTree;

/**
 * Register
 */
public class Register extends HttpServlet{

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");
        String pwd=request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");

        RedBlackTree<String,RedBlackTree<String,String>> tree=(RedBlackTree<String,RedBlackTree<String,String>>)getServletContext().getAttribute("tree");
        tree.put(name, new RedBlackTree<String,String>());
        RedBlackTree<String,String> current=tree.get(name);
        current.put("password", pwd);
        current.put("phoneNumber", phoneNumber);
        RegisterHandler.dataProcess(tree);

        request.setAttribute("call", name);
        String[] data=RegisterHandler.dataFormater(tree);
        request.setAttribute("data", data);
        RequestDispatcher view=request.getRequestDispatcher("registerCall.jsp");
        view.forward(request, response);
    }
}
