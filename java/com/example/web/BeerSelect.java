package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

/**
 * BeerSelect
 */
public class BeerSelect extends HttpServlet{


    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        BeerExpert be=new BeerExpert();
        String color=request.getParameter("color");
        List<String> list=be.getBrands(color);
        response.setContentType("text/html");
        /* PrintWriter writer=response.getWriter(); */
        /* writer.println("Beer Selection Advice<br>"); */
        /* for(String brand:list){ */
        /*     writer.print("<br>try: "+brand); */
        /* } */
        request.setAttribute("styles", list);
        RequestDispatcher view=request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}
