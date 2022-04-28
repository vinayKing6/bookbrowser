package com.example.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import algorithm.problems.Search.ChainingHashST;
import algorithm.problems.Search.RedBlackTree;
import algorithm.tools.inputKit;

/**
 * RegisterHandler
 */
public class RegisterHandler {

    public static String configPath="/usr/local/tomcat/webapps/firstWeb/config/config.txt";

    public static ChainingHashST<String,String> readConfig(String configPath){
        ChainingHashST st=new ChainingHashST<String,String>();

        try{
            String[] configLines=inputKit.getLines(configPath);
            for (int i = 0; i < configLines.length; i++) {
                String[] configs=configLines[i].split(" ");
                st.put(configs[0], configs[1]);
            }

            return st;
        }catch(IOException ex){
            ex.printStackTrace();
            return st;
        }
    }

    public static synchronized void dataProcess(RedBlackTree<String,RedBlackTree<String,String>> tree){
        try{
            ChainingHashST<String,String> st=readConfig(configPath);
            String splitor=st.get("splitor");
            BufferedWriter writer=new BufferedWriter(new FileWriter(st.get("pwdPath")));
            for(String name:tree.keys()){
                RedBlackTree<String,String> current=tree.get(name);
                String password=current.get("password");
                String phoneNumber=current.get("phoneNumber");
                writer.write(name+splitor+password+splitor+phoneNumber+"\n");
            }
            writer.flush();
            writer.close();

        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static RedBlackTree<String,RedBlackTree<String,String>> readData(){
        try{
            ChainingHashST<String,String> st=readConfig(configPath);
            String splitor=st.get("splitor");
            RedBlackTree<String,RedBlackTree<String,String>> tree=new RedBlackTree<String,RedBlackTree<String,String>>();
            Scanner sc=new Scanner(new File(st.get("pwdPath")));
            String line;
            while (sc.hasNextLine()) {
                line=sc.nextLine();
                String[] data=line.split(splitor);
                tree.put(data[0],new RedBlackTree<String,String>());
                tree.get(data[0]).put("password",data[1]);
                tree.get(data[0]).put("phoneNumber",data[2]);
            }
            return tree;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String[] dataFormater(RedBlackTree<String,RedBlackTree<String,String>> tree){
        int length=tree.size();
        String[] results=new String[length];

        for (int i=0;i<tree.size();i++) {
            String name=tree.select(i);
            RedBlackTree<String,String> current=tree.get(name);
            String password=current.get("password");
            String phoneNumber=current.get("phoneNumber");

            results[i]=name+" "+password+" "+phoneNumber+" ";
        }

        return results;
    }

    public static boolean check(RedBlackTree<String,RedBlackTree<String,String>> tree,String name,String password){
        RedBlackTree<String,String> current=tree.get(name);

        if (current==null) {
            return false;
        }

        if (current.get("password").equals(password)) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        ChainingHashST st=readConfig(configPath);
        RedBlackTree<String,RedBlackTree<String,String>> data=readData();
        if (data==null) {
            System.out.println("shit");
        }
        System.out.println(data.size());
        for (String name: data.keys()) {
            System.out.println(name);
            for(String d:data.get(name).keys()){
                System.out.println(d);
            }
        }

    }
}
