package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Dog;

/**
 * DogBreed
 */
public class DogBreed extends HttpServlet{

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException{
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();

        writer.println("test context attributes set by listener<br>");
        writer.println("<br>");

        Dog dog=(Dog)getServletContext().getAttribute("dog");
        writer.println("the breed of dog is "+dog.getBreed());
    }
}
