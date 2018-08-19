package br.com.engcon.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.engcon.graph.Graph;
import br.com.engcon.graph.Node;
import br.com.engcon.util.Import;

public class TestLoad {
	
	public static void main(String[] args) throws Exception {

		//"bus-network" ou "caxeiro"
		Graph graph = Import.loadGraph("bus-network");
		
		List<Node> nodes = graph.getNodeList();

		//Q1-Q4
        System.out.println("1. A quantidade de nós (ordem) é " + graph.size());
		System.out.println("2. A quantidade de arestas (tamanho) é " + (float)graph.getEdges().size());
        System.out.println("3. A densidade é "+ ((float)graph.getEdges().size())/graph.size());
		System.out.println("4. O grau médio é "+ graph.averageDegree());

		//Q6
		List<Integer> degrees = new ArrayList<>();
		int biggestValue = 0;

		for (Node n : graph.getNodeList()){
			degrees.add(n.getDegree());
			if (n.getDegree() > biggestValue) biggestValue = n.getDegree();
		}

		System.out.print("6. Distribuição de graus (grau/quantidade): ");
		for (int i = 0; i <= biggestValue; i++){
			if (Collections.frequency(degrees, i) > 0) System.out.print("(" + i + "/" + Collections.frequency(degrees, i) + ")");
		}
		System.out.println();


		//5. Quantidade de cliques >= 4 vértices
		//7. Distribuição dos pesos nas arestas
	}

}
