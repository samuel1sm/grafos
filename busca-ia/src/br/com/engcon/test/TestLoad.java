package br.com.engcon.test;

import java.util.List;

import br.com.engcon.graph.Graph;
import br.com.engcon.graph.Node;
import br.com.engcon.util.Import;

public class TestLoad {
	
	public static void main(String[] args) throws Exception {
		
		Graph graph = Import.loadGraph("bus-network");
		
		List<Node> nodes = graph.getNodeList();

        System.out.println("Quntidade de nós é " + graph.size());
        System.out.println("A decidade é "+ ((float)graph.getEdges().size())/graph.size());
		System.out.println("O grau médio é "+ graph.averageDegree());
		
	}

}
