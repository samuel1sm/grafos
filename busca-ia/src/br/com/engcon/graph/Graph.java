package br.com.engcon.graph;

import br.com.engcon.util.Import;
import sun.plugin.javascript.navig.Array;

import java.util.*;

public class Graph {

    protected String dataSetName;

    protected HashMap<String, Node> nodeHash = new HashMap<String, Node>();

    protected List<Edge> edges = new ArrayList<Edge>();

    public Graph(String datasetName) {
        super();
        this.dataSetName = datasetName;
    }

    public Node addNode(String id, Float weight, String label) {

        Node v = nodeHash.get(id);

        if (v == null) {

            v = new Node(id, weight, label);

            this.nodeHash.put(id, v);

        }

        return v;
    }

    public Edge addEdge(Node source, Node target, Float weight) {

        Edge a = new Edge(source, target, weight);

        source.addNeighbor(a);

        target.addNeighbor(a);

        edges.add(a);

        return a;

    }

    public Integer size() {
        return new Integer(getNodeList().size());
    }

    public Node getHub() {
        List<Node> nodes = this.getNodeList();

        Collections.sort(nodes);
        Collections.reverse(nodes);

        return nodes.get(0);
    }

    public String getDatasetName() {
        return dataSetName;
    }

    public void setDatasetName(String datasetName) {
        this.dataSetName = datasetName;
    }

    public List<Node> getNodeList() {
        List<Node> lista = new ArrayList<Node>();

        Set<String> chaves = nodeHash.keySet();

        for (String chave : chaves) {
            Node v = nodeHash.get(chave);

            lista.add(v);
        }

        return lista;
    }

    public Node getNode(String id) {
        return nodeHash.get(id);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public float averageDegree() {
        float average = 0;
        List<Node> nodeList = getNodeList();
        for (Node node : nodeList) {
            average += node.getDegree();
        }
        average = average / nodeList.size();

        return average;
    }

    public ArrayList amountOfCliques(int size, String dataSet) throws Exception {
        ArrayList<NodeAux> nodeListAux = new ArrayList<>();
        int auxSize;
        for(Node node :getNodeList()){
            nodeListAux.add(new NodeAux(node.getId()));
            for(Node nodeN : node.getNeighbors())
                nodeListAux.get(nodeListAux.size()-1).addOnList(nodeN.getId());
        }

            int k = 0;
        while (true){
            k++;
            System.out.println(k);
            auxSize= nodeListAux.size();

            for(int j = nodeListAux.size()-1;j>0;j--){
                if(nodeListAux.get(j).getList().size() < size - 1 ){
                    nodeListAux.remove(j);
                }
            }

            if(auxSize == nodeListAux.size()){
                break;
            }else{
        boolean flag=false ;
                for (int j = nodeListAux.size()-1;j>=0;j--) {
                    NodeAux node = nodeListAux.get(j);
                    for (int i = node.getList().size()-1; i >= 0 ; i--) {
                        flag=false;
                        for(int kk = nodeListAux.size()-1;kk>=0;kk--)
                        {
                            if (node.getList().get(i).equalsIgnoreCase(nodeListAux.get(kk).getId() ))
                            {
                                flag=true;
                            }
                        }
                        if (flag==false)
                        {
                            nodeListAux.get(j).getList().remove(i);
                        }

                    }
                    }

                }
            }


        Collections.sort(nodeListAux, new Comparator<NodeAux>() {
            @Override
            public int compare(NodeAux o1, NodeAux o2) {
                return Integer.valueOf(o2.getList().size()).compareTo(o1.getList().size());
            }
        });

        for (int i = 0; i < nodeListAux.size(); i++) {
            NodeAux node = nodeListAux.get(i);
            for (int j = 0; j < node.getList().size(); j++) {

            }
        }



        return nodeListAux;
    }




    public void graphDistribution() {

        List<Integer> degrees = new ArrayList<>();
        int biggestValue = 0;

        for (Node n : this.getNodeList()) {
            degrees.add(n.getDegree());
            if (n.getDegree() > biggestValue) biggestValue = n.getDegree();
        }

        for (int i = 0; i <= biggestValue; i++) {
            if (Collections.frequency(degrees, i) > 0)
                System.out.print("(" + i + "/" + Collections.frequency(degrees, i) + ")");
        }
        System.out.println();
    }

    public void edgeWeightDistribution() {
        List<Float> weights = new ArrayList<>();
        float biggestValue = 0;

        for (Edge e : this.getEdges()) {
            weights.add(e.getWeight());
            if (e.getWeight() > biggestValue) biggestValue = e.getWeight();
        }

        for (float i = 0; i <= biggestValue; i++) {
            if (Collections.frequency(weights, i) > 0)
                System.out.print("(" + i + "/" + Collections.frequency(weights, i) + ")");
        }
        System.out.println();
    }

}