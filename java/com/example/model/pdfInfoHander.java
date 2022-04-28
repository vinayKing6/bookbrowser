package com.example.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

import algorithm.problems.Search.ChainingHashST;
import algorithm.tools.inputKit;

/**
 * pdfInfoHander
 */
public class pdfInfoHander {

   public static HashMap<Integer,HashMap<Integer,String>> getComment(String filepath){
       HashMap<Integer,HashMap<Integer,String>> st=new HashMap<Integer,HashMap<Integer,String>>();
       String graph_splitor="---------------";
       String line_splitor="%";
       String sub_splitor=":";
       String link_symbol="_";
       try{
           String[] commentGraph=inputKit.getLines(filepath,graph_splitor);
           for (int i = 0; i < commentGraph.length; i++) {
               String[] commentLines=commentGraph[i].split(line_splitor);
               int id=Integer.parseInt(commentLines[0]);
               st.put(id, new HashMap<Integer,String>());
               HashMap<Integer,String> commentTree=st.get(id);
               for(int j=1;j<commentLines.length;j++){
                   try{
                       String[] line_splits=commentLines[j].split(sub_splitor);
                       commentTree.put(Integer.parseInt(line_splits[0]), line_splits[1]);
                   }catch(Exception ex){
                       break;
                   }
               }
           }
           return st;
       }catch(Exception ex){
           ex.printStackTrace();
           return st;
       }
   } 

   public static synchronized void writeComment(HashMap<Integer,HashMap<Integer,String>> map){
       String graph_splitor="---------------";
       String line_splitor="%";
       String sub_splitor=":";
       String link_symbol="_";
       ChainingHashST<String,String> st=RegisterHandler.readConfig(RegisterHandler.configPath);
       String commentPath=st.get("commentPath");

       try{
           BufferedWriter writer=new BufferedWriter(new FileWriter(commentPath));

           for(int id:map.keySet()){
               writer.write(id+"");
               HashMap<Integer,String> tree=map.get(id);
               for(int i=0;i<tree.size();i++){
                   writer.write(line_splitor);
                   writer.write(i+sub_splitor+tree.get(i));
               }
               writer.write(graph_splitor);
           }
           writer.flush();
           writer.close();
       }catch(IOException ex){
           ex.printStackTrace();
       }
   }

   public static HashMap<Integer,HashMap<String,String>> getId(String filepath){
       HashMap<Integer,HashMap<String,String>> st=new HashMap<Integer,HashMap<String,String>>();
       String line_splitor="%";
       try{
           String[] idLines=inputKit.getLines(filepath);
           for (int i = 0; i < idLines.length; i++) {
               String[] line=idLines[i].split(line_splitor);
               int id=Integer.parseInt(line[0]);
               //System.out.println(line[0]);
               st.put(id, new HashMap<String,String>());
               HashMap<String,String> tree=st.get(id);
               tree.put("bookname", line[1]);
               //System.out.println(line[1]);
               tree.put("arthur", line[2]);
               //System.out.println(line[2]);
               tree.put("classify", line[3]);
               //System.out.println(line[3]);
               tree.put("alias", line[4]);
               //System.out.println(line[4]);
           }
           return st;
       }catch(Exception ex){
           ex.printStackTrace();
           return st;
       }
   }

   public static void main(String[] args){
       getId(RegisterHandler.readConfig(RegisterHandler.configPath).get("idPath"));
   }
}
