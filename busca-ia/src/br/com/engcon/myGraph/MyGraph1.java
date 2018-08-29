package br.com.engcon.myGraph;

public class MyGraph1 {
    private int graph[][];

    public MyGraph1(int edges) {
        this.graph = new int[edges][edges];
    }

    public void addEdge(int n1,int n2,int weight){
        this.graph[n1][n2]=weight;
    }
    public void deleteEdge(int n1,int n2){
        this.graph[n1][n2]=0;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void showGraph(){
        System.out.printf("   ");
        for (int x=0;x<this.graph.length;x++){
            if(x<=9)
            System.out.printf(x + "  ");
            else
                System.out.printf(x + " ");
        }
        System.out.println();
        for(int x=0;x<this.graph.length;x++)
        {
            if(x<=9)
                System.out.printf(x + "  ");
            else
                System.out.printf(x + " ");
            for(int y=0;y<this.graph.length;y++)
            {
                System.out.printf(this.graph[x][y]+"  ");
            }
            System.out.println();
        }
    }


}
