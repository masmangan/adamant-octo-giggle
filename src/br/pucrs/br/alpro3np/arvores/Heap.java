package br.pucrs.br.alpro3np.arvores;

public class Heap {

	public static boolean isHeap(int[] v) {
		for (int pai = 0 ; pai < v.length / 2; pai++) {
			int left = 2 * pai + 1;
			int right = left + 1;
			if ( left < v.length && v[pai] < v[left] )
				return false;
			if ( right < v.length && v[pai] < v[right] )
				return false;
		}
		return true;
	}

}
