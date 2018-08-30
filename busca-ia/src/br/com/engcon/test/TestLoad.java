package br.com.engcon.test;

import java.lang.reflect.Array;
import java.util.*;

import br.com.engcon.graph.Graph;
import br.com.engcon.graph.Node;
import br.com.engcon.graph.NodeAux;
import br.com.engcon.myGraph.MyGraph2;
import br.com.engcon.myGraph.NodeIndexDao;
import br.com.engcon.util.Import;

public class TestLoad {
	
	public static void main(String[] args) throws Exception {

		String dataSet = "bus-network";
		Graph graph = Import.loadGraph(dataSet);
		
		List<Node> nodes = graph.getNodeList();


//        System.out.println("1. A quantidade de nós (ordem) é " + graph.size());
//		System.out.println("2. A quantidade de arestas (tamanho) é " + graph.getEdges().size());
//        System.out.println("3. A densidade é "+ ((float)graph.getEdges().size())/graph.size());
//		System.out.println("4. O grau médio é "+ graph.averageDegree());
//
//		System.out.print("6. Distribuição de graus (grau/quantidade): ");
//		graph.graphDistribution();
//
//		System.out.print("7. Distribuição dos pesos das aretas (peso/quantidade): ");
//		graph.edgeWeightDistribution();

		ArrayList<NodeAux> list = graph.amountOfCliques(3,dataSet);


		HashMap<String, Integer> indexMap=new HashMap<>();

		MyGraph2 graphAux = new MyGraph2(list.size());

		for (int i = 0; i < list.size(); i++) {
			indexMap.put(list.get(i).getId(),i);
		}

		for (int i = 0; i < list.size(); i++) {
					graphAux.addEdge(i,i,1);
			}


			for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getList().size(); j++) {

				graphAux.addEdge(indexMap.get(list.get(i).getId()),indexMap.get(list.get(i).getList().get(j)),1);
			}
		}
		//graphAux.showGraph();

//		int graph2[][] = graphAux.getGraph();
//
//		ArrayList<ArrayList<Integer>> cliqueList = new ArrayList<>();
//
//		for (int i = 0; i < list.size(); i++) {
//			ArrayList<Integer> array = new ArrayList<>();
//			array.add(i);
//			for (int j = 0; j < list.size(); j++) {
//				if(graph2[i][j]!=0){
//					array.add(j);
//				}
//			}
//			cliqueList.add(array);
//		}


		List<ArrayList<Integer>> cliques = new ArrayList<>();
		ArrayList<Integer> indices = new ArrayList<>();
		ArrayList<Integer> indicesCliques = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (graphAux.getGraph()[i][j] == 1){
					indices.add(j);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				boolean validacao = true;
				for (int k = 0; k < indices.size(); k++) {
					if (graphAux.getGraph()[indices.get(k)][j] != 1){
						validacao = false;
					}
				}
				if (validacao){
					indicesCliques.add(j);
				}

			}
			cliques.add(indicesCliques);
			indicesCliques.clear();
			System.out.println(cliques.size());
			//cliques.add(indices);
			indices.clear();
		}

		for (int i = 0; i < cliques.size(); i++) {

			for (int b = 0; b < cliques.get(i).size(); b++) {
				System.out.printf( b + " : ");
			}
			System.out.println();
		}




//		String dataset = "nossoBusao";
// 		NodeIndexDao.createTxt(dataset);
//		ArrayList<String> ids = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			ids.add(list.get(i).getId());
//
//		}
//		NodeIndexDao.gravarDados2(ids,dataset);

		//5. Quantidade de cliques >= 4 vértices

	}

}
