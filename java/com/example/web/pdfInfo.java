package com.example.web;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.rmi.ServerException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * pdfInfo
 */
public class pdfInfo extends HttpServlet{

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies=request.getCookies();
        String name="";
        String comment;
        int id;

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("user")) {
                name=cookies[i].getValue();
                break;
            }
        }

        id=Integer.parseInt(request.getParameter("id"));

        HashMap<Integer,HashMap<Integer,String>> st=(HashMap<Integer,HashMap<Integer,String>>)getServletContext().getAttribute("comments");
        HashMap<Integer,HashMap<String,String>> idSt=(HashMap<Integer,HashMap<String,String>>)getServletContext().getAttribute("id");

        if (!st.containsKey(id)) {
            st.put(id, new HashMap<Integer,String>());
        }

        request.setAttribute("comments", st.get(id));
        request.setAttribute("idTree", idSt.get(id));
        request.setAttribute("name", name);
        request.setAttribute("id", id);

        RequestDispatcher view=request.getRequestDispatcher("pdfInfo.jsp");
        view.forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        //get pdf information web page
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies=request.getCookies();
        String name="";
        String comment;
        int id;

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("user")) {
                name=cookies[i].getValue();
                break;
            }
        }

        comment=request.getParameter("comment");
        id=Integer.parseInt(request.getParameter("id"));

        if (comment.equals("")) {
            return;
        }

        HashMap<Integer,HashMap<Integer,String>> st=(HashMap<Integer,HashMap<Integer,String>>)getServletContext().getAttribute("comments");
        HashMap<Integer,HashMap<String,String>> idSt=(HashMap<Integer,HashMap<String,String>>)getServletContext().getAttribute("id");

        if (!st.containsKey(id)) {
            st.put(id, new HashMap<Integer,String>());
        }
        HashMap<Integer,String> tree=st.get(id);
        tree.put(tree.size(), name+"_"+comment);

    }
}
