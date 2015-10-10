package br.pucrs.br.alpro3np.arvores;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	/**
	 * 
	 * @param key
	 */
	public void addObject(T key) {
		root = addObject0(root, key);
	}

	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node<T> addObject0(Node<T> node, T key) {
		if (node == null)
			return new Node<>(key);

		if (key.compareTo(node.key) < 0) {
			node.left = addObject0(node.left, key);

			if (h(node.left) - h(node.right) == 2) {
				if (key.compareTo(node.left.key) < 0) {
					node = rotateWithLeftChild(node);
				} else {
					node = doubleWithLeftChild(node);
				}
			}
		} else if (key.compareTo(node.key) > 0) {
			node.right = addObject0(node.right, key);
			if (h(node.left) - h(node.right) == -2) {
				if (key.compareTo(node.right.key) > 0) {
					node = rotateWithRightChild(node);
				} else {
					node = doubleWithRightChild(node);
				}
			}

		} else
			throw new IllegalArgumentException("Duplicate Key!"); //$NON-NLS-1$

		node.height = 1 + Math.max(h(node.left), h(node.right));

		return node;
	}

	private Node<T> doubleWithRightChild(Node<T> k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	private Node<T> doubleWithLeftChild(Node<T> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private Node<T> rotateWithLeftChild(Node<T> k2) {
		Node<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;

		k2.height = 1 + Math.max(h(k2.left), h(k2.right));
		k1.height = 1 + Math.max(h(k1.left), k2.height);
		return k1;
	}

	private Node<T> rotateWithRightChild(Node<T> k1) {
		Node<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;

		k1.height = 1 + Math.max(h(k1.left), h(k1.right));
		k2.height = 1 + Math.max(k1.height, h(k2.right));

		return k2;
	}

	private int h(Node<T> node) {
		return node == null ? -1 : node.height;
	}

	public void preorder() {
		System.out.println("Pre-order/Pre-ordem/Prefixado");
		preOrder0(root);
		System.out.println();
	}

	private void preOrder0(Node<T> node) {
		if (node != null) {
			System.out.print(" " + node.key);
			preOrder0(node.left);
			preOrder0(node.right);
		}
	}

	public void postOrder() {
		System.out.println("Post-order/Pós-ordem/Pósfixado");
		postOrder0(root);
		System.out.println();
	}

	private void postOrder0(Node<T> node) {
		if (node != null) {
			postOrder0(node.left);
			postOrder0(node.right);
			System.out.print(" " + node.key);
		}
	}

	public void central() {
		System.out.println("Central/Infixado");
		central0(root);
		System.out.println();
	}

	private void central0(Node<T> node) {
		if (node != null) {
			central0(node.left);
			System.out.print(" " + node.key);
			central0(node.right);
		}
	}

	@Override
	public String toString() {
		return String.format("BinarySearchTree [root=%s]", //$NON-NLS-1$
				toString0(root));
	}

	/**
	 * Pre-order
	 * 
	 * @param node
	 * @return
	 */
	private String toString0(Node<T> node) {
		if (node == null)
			return " # "; //$NON-NLS-1$
		int delta = getHeight0(node.left) - getHeight0(node.right);

		String msg = String
				.format(" %s degree = %d level = %d height = %d delta = %d father = ? uncle = ? %n[%s] %n[%s]",
						node.key, degree(node), level(node), h(node), delta,
						toString0(node.left), toString0(node.right));

		return msg;
	}

	private int level(Node<T> node) {
		return level0(root, node, 0);
	}

	/**
	 * 
	 * @param node
	 * @param target
	 * @param level
	 * @return
	 */
	private int level0(Node<T> node, Node<T> target, int level) {
		// if (target.key < node.key)
		if (target.key.compareTo(node.key) < 0)
			return level0(node.left, target, level + 1);
		// else if (target.key > node.key)
		else if (target.key.compareTo(node.key) > 0)
			return level0(node.right, target, level + 1);
		else
			return level;
	}

	private int degree(Node<T> node) {
		if (node == null)
			return -1;

		int d = 0;

		if (node.left != null)
			d++;

		if (node.right != null)
			d++;

		return d;
	}

	public boolean containsObject(T key) {
		return containsObject0(root, key);
	}

	private boolean containsObject0(Node<T> node, T key) {
		if (node == null)
			return false;

		// if (key < node.key)
		if (key.compareTo(node.key) < 0)
			return containsObject0(node.left, key);
		// else if (key > node.key)
		else if (key.compareTo(node.key) > 0)
			return containsObject0(node.right, key);

		return true;
	}

	public int getHeight() {
		return getHeight0(root);
	}

	/**
	 * Post-order
	 * 
	 * @param node
	 * @return
	 */
	private int getHeight0(Node<T> node) {
		if (node == null)
			return -1;
		int hl = getHeight0(node.left);
		int hr = getHeight0(node.right);

		return 1 + Math.max(hl, hr);
	}

	public boolean isBalanced() {
		return isBalanced0(root);
	}

	/**
	 * Pre-order
	 * 
	 * @param node
	 * @return
	 */
	private boolean isBalanced0(Node<T> node) {
		if (node == null)
			return true;

		int delta = getHeight0(node.left) - getHeight0(node.right);

		if (delta == 2 || delta == -2)
			return false;

		return isBalanced0(node.left) && isBalanced0(node.right);

	}

	public T getMax() {
		return getMax0(root);
	}

	private T getMax0(Node<T> node) {
		if (node == null)
			throw new IllegalArgumentException("Root is null!");
		if (node.right == null)
			return node.key;
		return getMax0(node.right);
	}

	public T getMin() {
		if (root == null)
			throw new IllegalArgumentException("Root is null!");

		Node<T> n = root;
		while (n.left != null) {
			n = n.left;
		}
		return n.key;

	}

	public List<T> getPath(T key) {
		return getPath0(root, key, new ArrayList<>());
	}

	private List<T> getPath0(Node<T> node, T key, ArrayList<T> path) {
		if (node == null)
			throw new IllegalArgumentException("Key not found!");
		path.add(node.key);
		// if (key < node.key)
		if (key.compareTo(node.key) < 0)
			return getPath0(node.left, key, path);
		// if (key > node.key)
		if (key.compareTo(node.key) > 0)
			return getPath0(node.right, key, path);
		return path;
	}

	// TODO: getParent()
	// TODO: getUncle()

}
