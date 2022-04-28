package algorithm.problems.Graphs;

import java.io.IOException;
import java.util.Scanner;

import algorithm.problems.Search.RedBlackTree;
import algorithm.tools.inputKit;

/**
 * SymbolGraph
 */
public class SymbolGraph {

    private RedBlackTree<String,Integer> ST;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String filepath,String splitor){
        ST=new RedBlackTree<String,Integer>();

        try{
            String[] lines=inputKit.getLines(filepath);
            for (int i = 0; i < lines.length; i++) {
                String line=lines[i];
                String[] items=line.split(splitor);
                for (int j = 0; j < items.length; j++) {
                    if (!ST.contains(items[j])) {
                        ST.put(items[j], ST.size());
                    }
                }
            }

            keys=new String[ST.size()];
            for(String key:ST.keys()){
                keys[ST.get(key)]=key;
            }

            G=new Graph(ST.size());
            for (int i = 0; i < lines.length; i++) {
                String line=lines[i];
                String[] items=line.split(splitor);
                String key=items[0];
                for (int j = 1; j < items.length; j++) {
                    G.addEdge(ST.get(key), ST.get(items[j]));
                }
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public boolean contains(String key){
        return ST.contains(key);
    }

    public int index(String key){
        return ST.get(key);
    }

    public String name(int index){
        return keys[index];
    }

    public Graph G(){
        return G;
    }

    public static void main(String[] args){
        try{
            String filepath=args[0];
            String splitor=args[1];
            SymbolGraph sg=new SymbolGraph(filepath,splitor);
            Graph G=sg.G();

            Scanner sc=new Scanner(System.in);
            String parameter;
            while (!(parameter=sc.nextLine()).equals("end")) {
                int index=sg.index(parameter);
                System.out.print(parameter+": ");
                for(int w:G.adj(index)){
                    System.out.print(sg.name(w)+" ");
                }
                System.out.println();
            }
        }catch(RuntimeException ex){
            System.out.println("usage: java SymbolGraph filepath splitor");
        }
    }
    
}
