package br.com.engcon.myGraph;

public class MyGraph2 extends MyGraph1{
    public MyGraph2(int edges) {
        super(edges);
    }

    @Override
    public void addEdge(int n1, int n2, int weight) {
        super.addEdge(n1, n2, weight);
        super.addEdge(n2,n1,weight);
    }

    @Override
    public int[][] getGraph() {
        return super.getGraph();
    }

    @Override
    public void deleteEdge(int n1, int n2) {
        super.deleteEdge(n1, n2);
    }

    @Override
    public void showGraph() {
        super.showGraph();
    }
}
