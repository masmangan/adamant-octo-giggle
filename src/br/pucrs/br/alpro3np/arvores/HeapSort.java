package br.pucrs.br.alpro3np.arvores;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int v[] = {15, 60, 72, 70, 56, 32, 62, 92, 45, 30, 65};
		System.out.println(Arrays.toString(v));
		heapsort(v);
		System.out.println(Arrays.toString(v));
	}
	
	public static void heapsort(int v[]) {
		buildMaxHeap(v);
		System.out.printf("heap=%s\n", Arrays.toString(v));

		int size = v.length;
		for (int i = v.length - 1 ; i > 0 ; i--) {
			swap(v, 0, i);
			maxHeapify(v, 0, --size);
		}
	}

	private static void maxHeapify(int[] v, int i, int size) {
		int largest;
		int l = 2 * i + 1;
		int r = l + 1;
		System.out.println(Arrays.toString(v));
		
		if (l < size && v[l] > v[i])
			largest = l;
		else
			largest = i;
		
		if (r < size && v[r] > v[largest])
			largest = r;
		
		if (largest != i) {
			swap(v, i, largest);
			maxHeapify(v, largest, size);
		}
		
	}

	private static void swap(int[] v, int i, int j) {
		int tmp = v[i];
		v[i] = v[j];
		v[j] = tmp;
	}

	private static void buildMaxHeap(int[] v) {
		for (int i = v.length / 2 - 1 ; i >= 0 ; i--)
			maxHeapify(v, i, v.length);
	}
}
