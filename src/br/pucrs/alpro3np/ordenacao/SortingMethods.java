package br.pucrs.alpro3np.ordenacao;

import java.util.Arrays;

public class SortingMethods {

	private static int z;

	public static void bubbleSort(int[] a) {
		z += 3;
		for (int i = 0; i < a.length; i++) {
			z += 8;
			for (int j = 0; j < a.length - 1; j++) {
				z += 11;
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	public static void insertionSort(int[] a) {
		z += 3;
		for (int j = 1; j < a.length; j++) {
			z += 15; 
			int i = j - 1;
			int key = a[j];
			while ((i >= 0) && (a[i] > key)) {
				z += 10;
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		//int[] tst = { 1, 2, 3, 4, 7, 6, 5 };
		int[] tst = { 1,2,3,4,5 };
		System.out.println(Arrays.toString(tst));
		SortingMethods.insertionSort(tst);
		System.out.println(Arrays.toString(tst));
		System.out.printf("Contagem de operações: %d\n", z);
	}
}
