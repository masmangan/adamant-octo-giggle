package br.pucrs.br.alpro3np.arvores;

// TODO: mover como classe interna da BinarySearchTree
// TODO: colocar visibilidade de pacote nesta classe
public class Node {

	public int key;
	
	public int height;
	
	public Node left; // menores
	public Node right; // maiores

	public Node(int key) {
		this.key = key;
		height = 0;
		left = right = null ;
	}
	
}
