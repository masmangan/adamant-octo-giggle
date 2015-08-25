package pucrs.alpro3np.ordenacao;

import java.util.Arrays;

public class SortingMethods {

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] tst = { 1, 2, 3, 4, 7, 6, 5 };
		System.out.println(Arrays.toString(tst));
		SortingMethods.bubbleSort(tst);
		System.out.println(Arrays.toString(tst));
	}
}
