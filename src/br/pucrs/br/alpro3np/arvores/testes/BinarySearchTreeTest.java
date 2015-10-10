package br.pucrs.br.alpro3np.arvores.testes;

import br.pucrs.br.alpro3np.arvores.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("Teste");
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		int ns[] = {50, 17, 76, 9, 23, 54, 14, 19, 72, 12, 67};
		for (int i : ns) {
			tree.addObject(i);
		}
		
		tree.preorder();
		tree.central();
		tree.postOrder();
		
		//System.out.println(tree);		
		//System.out.println(tree.isBalanced());
		//System.out.println(tree.getMax());
		//System.out.println(tree.getPath(30));
		
	}
}
