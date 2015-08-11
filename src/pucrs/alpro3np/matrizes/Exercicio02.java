package pucrs.alpro3np.matrizes;

public class Exercicio02 {

	public static void main(String[] args) {
		int[][] a = { { 1, 0 }, { 0, 2 } };
		int[][] b = { { 0, 1 }, { 1, 0 } };
		int[][] c = { { 0, 1 }, { 2, 0 } };
		int[][] r;
		
		r = multiplicar(a, b);
		
		// TODO: conferir se r e c tem o mesmo conteudo 
		}

	private static int[][] multiplicar(int[][] a, int[][] b) {
		
		if (a[0].length != b.length)
			throw new RuntimeException("O numero de colunas de a deve coincidir com o numero de linhas de b.");
		
		int[][] r = new int[a.length][b[0].length];
		// TODO: calcular r
		return r;
	}

}
