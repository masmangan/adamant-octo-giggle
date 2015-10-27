package br.pucrs.alpro3np.grafos;

public class GraphApp {
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		System.out.println(g1);
		g1.addEdge(1, 5);
		System.out.println(g1);
	}
}
