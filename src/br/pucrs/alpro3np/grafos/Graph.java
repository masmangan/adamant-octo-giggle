package br.pucrs.alpro3np.grafos;

public class Graph {

	private int m[][];

	public Graph(int nodes) {
		if (nodes <= 0)
			throw new IllegalArgumentException("Invalid nodes value: " + nodes);
		m = new int[nodes + 1][nodes + 1];
	}

	public void addEdge(int a, int b) {
		addEdge(a, b, 1);
	}

	public void addEdge(int a, int b, int v) {
		checkNode(a);
		checkNode(b);
		m[a][b] = v;
	}
	
	
	private void checkNode(int a) {
		if (a <= 0 || a > m.length)
			throw new IllegalArgumentException("Invalid node: " + a);

	}

	@Override
	public String toString() {
		String s = "";
		s += "    ";
		for (int i = 1; i < m.length; i++) {
			s += i + " ";
		}
		s += "\n";

		for (int i = 1; i < m.length; i++) {
			s += i + "  ";
			for (int j = 1; j < m.length; j++) {
				s += m[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

}
