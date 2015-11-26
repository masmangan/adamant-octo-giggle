package br.pucrs.alpro3np.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int m[][];

	public Graph(int nodes) {
		if (nodes <= 0)
			throw new IllegalArgumentException("Invalid nodes value: " + nodes);
		m = new int[nodes + 1][nodes + 1];
	}

	// TODO: ler arquivos do graphviz
	// TODO: ler json, xml
	public Graph(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		String n = br.readLine();
		System.out.println(n);
		int nodes = Integer.parseInt(n);
		m = new int[nodes + 1][nodes + 1];

		String pair;
		while ((pair = br.readLine()) != null) {
			System.out.println(pair);
			String fields[] = pair.split(" ");
			int a = Integer.parseInt(fields[0]);
			int b = Integer.parseInt(fields[1]);
			addEdge(a, b);
		}

		br.close();
		fr.close();
	}

	public void addEdge(int a, int b) {
		addEdge(a, b, 1);
	}

	public void addEdge(int a, int b, int v) {
		checkNode(a);
		checkNode(b);
		m[a][b] = v;
		m[b][a] = v;
	}

	public List<Integer> getAdjacents(int a) {
		checkNode(a);
		List<Integer> adjs = new ArrayList<>();

		for (int i = 1; i < m.length; i++) {
			if (m[a][i] != 0)
				adjs.add(i);
		}

		return adjs;
	}

	private void checkNode(int a) {
		if (a <= 0 || a > m.length)
			throw new IllegalArgumentException("Invalid node: " + a);
	}

	/**
	 * Profundidade
	 * 
	 * @return
	 */

	private boolean marked[];

	public List<Integer> depth(int a) {
		checkNode(a);
		List<Integer> nodes = new ArrayList<>();
		marked = new boolean[m.length];
		depth0(a, nodes);
		return nodes;
	}

	private void depth0(int a, List<Integer> nodes) {
		nodes.add(a);
		marked[a] = true;
		for (Integer adj : getAdjacents(a)) {
			// if (!nodes.contains(adj))
			if (!marked[adj])
				depth0(adj, nodes);
		}
	}

	/**
	 * Largura
	 * 
	 * @return
	 */
	public List<Integer> breadth() {
		List<Integer> nodes = new ArrayList<>();
		// TODO:
		return nodes;
	}

	@Override
	public String toString() {
		return toStringMatriz(m);
	}

	private String toStringMatriz(int mat[][]) {
		String s = "";
		s += "   ";
		for (int i = 1; i < mat.length; i++) {
			s += i + " ";
		}
		s += "\n";

		for (int i = 1; i < mat.length; i++) {
			s += i + "  ";
			for (int j = 1; j < mat.length; j++) {
				s += mat[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

	public int getNodes() {
		return m.length;
	}

	public void dijkstra() {
	}

	public int[][] floydWarshall() {
		final int INFINITO = 2000;

		int d[][] = new int[m.length][m.length];
		int p[][] = new int[m.length][m.length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if ( i != j && m[i][j] == 0)
					d[i][j] = INFINITO;
				else
					d[i][j] = m[i][j];
				
				if ( i != j && m[i][j] != 0)
					p[i][j] = i;
			}
		}
		
		System.out.println(toStringMatriz(d));

		for (int k = 1; k < m.length; k++) {
			for (int i = 1; i < m.length; i++) {
				for (int j = 1; j < m.length; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						p[i][j] = p[k][j];						
//						p[j][i] = k;					//	
						

					}
				}
			}
			System.out.println("K="+k+"\n"+toStringMatriz(d));
			System.out.println("K="+k+"\n"+toStringMatriz(p));
		}
		
		return d;
	}

	public void prim() {
	}

	public void kruskal() {
	}

	public void fordFulkerson() {
	}

	public void topologica() {
	}

	public void ciclos() {
	}

	public void componentes() {
	}

	public void caminho() {
	}

}
