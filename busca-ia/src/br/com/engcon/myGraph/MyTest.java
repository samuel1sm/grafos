package br.com.engcon.myGraph;
import br.com.engcon.graph.*;
import br.com.engcon.util.Import;

import java.util.HashMap;

public class MyTest {
    public static void main(String[] args) throws Exception {

       /* String dataset = "caxeiro";
        Graph graph = Import.loadGraph(dataset);
        HashMap<String, Integer> indexMap=new HashMap<>();
        Boolean whileKey=true;

        while (whileKey){

            try {
                indexMap = NodeIndexDao.getMyNodes(dataset);
                whileKey=false;
            } catch (Exception e) {
                NodeIndexDao.createTxt(dataset);
                NodeIndexDao.gravarDados(graph.getNodeList(),dataset);
            }

        }


        MyGraph1 myGraph=new MyGraph1(indexMap.size());
        MyGraph2 myGraph2=new MyGraph2(indexMap.size());
/*
        for(Edge edge : graph.getEdges()){
            myGraph2.addEdge(indexMap.get(edge.getSource().getId()),indexMap.get(edge.getTarget().getId()),edge.getWeight());

        }

        myGraph2.showGraph();*/

    }

}
