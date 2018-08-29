package br.com.engcon.graph;

import java.util.ArrayList;

public class NodeAux {
    private String id;
    private ArrayList<String> list;

    public NodeAux(String id) {
        this.id = id;
        this.list = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void addOnList(String nodeId) {
        this.list.add(nodeId);
    }
}
