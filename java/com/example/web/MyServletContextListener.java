package com.example.web;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.model.RegisterHandler;
import com.example.model.pdfInfoHander;

import algorithm.problems.Search.ChainingHashST;
import algorithm.problems.Search.RedBlackTree;

/**
 * MyServletContextListener
 */
public class MyServletContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent event){
        ServletContext sc=event.getServletContext();
        RedBlackTree<String,RedBlackTree<String,String>> tree=RegisterHandler.readData();
        ChainingHashST<String,String> configTree=RegisterHandler.readConfig(RegisterHandler.configPath);
        HashMap<Integer,HashMap<Integer,String>> commentsSt=pdfInfoHander.getComment(configTree.get("commentPath"));
        HashMap<Integer,HashMap<String,String>> idSt=pdfInfoHander.getId(configTree.get("idPath"));
        sc.setAttribute("tree", tree);
        sc.setAttribute("comments", commentsSt);
        sc.setAttribute("id", idSt);
    }

    public void contextDestroyed(ServletContextEvent event){
        ServletContext sc=event.getServletContext();
        RedBlackTree<String,RedBlackTree<String,String>> tree=(RedBlackTree<String,RedBlackTree<String,String>>)sc.getAttribute("tree");
        RegisterHandler.dataProcess(tree);
        HashMap<Integer,HashMap<Integer,String>> commentsSt=(HashMap<Integer,HashMap<Integer,String>>)sc.getAttribute("comments");
        pdfInfoHander.writeComment(commentsSt);
    }
    
}
