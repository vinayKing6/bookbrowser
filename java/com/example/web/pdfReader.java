package com.example.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * pdfReader
 */
public class pdfReader extends HttpServlet{

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/pdf");

         int id=Integer.parseInt(request.getParameter("id"));
        HashMap<Integer,HashMap<String,String>> idSt=(HashMap<Integer,HashMap<String,String>>)getServletContext().getAttribute("id");
        String filename=idSt.get(id).get("bookname");
        ServletContext context=getServletContext();
        InputStream in=context.getResourceAsStream("/source/books/"+filename);

        int read=0;
        byte[] bytes=new byte[1024];

        OutputStream out=response.getOutputStream();
        while ((read=in.read(bytes))!=-1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }
}
