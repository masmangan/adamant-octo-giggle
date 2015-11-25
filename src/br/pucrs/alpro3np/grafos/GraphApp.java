package br.pucrs.alpro3np.grafos;

import java.io.IOException;

public class GraphApp {
	public static void main(String[] args) throws IOException {
		Graph g1 = new Graph("g1.txt");
		// System.out.println(g1);
		// g1.addEdge(1, 4);
		// g1.addEdge(1, 5);
		System.out.println(g1);
		for (int i = 1; i < g1.getNodes(); i++)
			System.out.println(i + " : " + g1.getAdjacents(i));
		
		System.out.println(g1.depth(2));
	}
}
