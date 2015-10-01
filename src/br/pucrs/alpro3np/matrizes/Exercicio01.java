package br.pucrs.alpro3np.matrizes;

public class Exercicio01 {
	//
	// Implemente um método ou “main�? que:
	// ◦ Crie uma matriz 5X6 (5 "linhas" e 6 "colunas")
	// ◦ Inicialize cada posição com o valor da soma da
	// coordenada de sua linha com a coordenada de sua
	// coluna;
	// ◦ Exiba todos os elementos, linha após linha;
	// ◦ Exiba todos os elementos, coluna após coluna;

	public static void main(String[] args) {
		int[][] m = new int[5][6];

		inicializa(m);

		printLinha(m);
		System.out.println();
		printColuna(m);

	}

	private static void inicializa(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = i + j;
			}
		}
	}

	private static void printLinha(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%3d ", m[i][j]);
			}
			System.out.println();
		}
	}

	private static void printColuna(int[][] m) {
		for (int j = 0; j < m[0].length; j++) {
			for (int i = 0; i < m.length; i++) {
				System.out.printf("%3d ", m[i][j]);
			}
			System.out.println();
		}
	}

}
