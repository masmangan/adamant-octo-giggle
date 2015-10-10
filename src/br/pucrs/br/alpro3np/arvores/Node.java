package br.pucrs.br.alpro3np.arvores;

// TODO: mover como classe interna da BinarySearchTree
// TODO: colocar visibilidade de pacote nesta classe
public class Node<T> {

	public T key;
	
	public int height;
	
	public Node<T> left; // menores
	public Node<T> right; // maiores

	public Node(T key) {
		this.key = key;
		height = 0;
		left = right = null ;
	}
	
}
