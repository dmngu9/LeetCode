package avltree;

public class AVL {

	private class Node {		
		private int val;
		private int balanceFactor;
		private Node left;
		private Node right;
		
		public Node(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
			this.balanceFactor = 0;
		}
	}

	private Node root;
	
	public AVL() {
		this.root = null;
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		root = insert(newNode, root);
	}
		
	public void delete(int data) {
		root = delete(root, data);
	}
	
	private void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.print(root.val);
		System.out.println(" " + root.balanceFactor);
		inOrderTraversal(root.right);
	}
	
	private Node insert(Node newNode, Node root) {
		if(root == null){
			root = newNode;
			root.balanceFactor = 0;
			return root;
		}
		if(newNode.val < root.val) {
			root.left = insert(newNode, root.left);
		} else { 
			root.right = insert(newNode, root.right);
		}		
		
		setBalance(root);
		
		if(root.balanceFactor == -2) {
			if(root.right.balanceFactor == -1) {
				root = singleLeftRotation(root);
			} else {					
				root = doubleRightLeftRotation(root);
			}
		} else if(root.balanceFactor == 2) {
			if(root.left.balanceFactor == 1) {
				root = singleRightRotation(root);
			} else {
				root = doubleLeftRightRotation(root);
			}
		}
		return root;
	}
	
	private Node delete(Node root, int data) {
		if(root == null) {
			return root;
		}
		
		if(root.val > data) {
			root.left = delete(root.left, data);
		} else if (root.val < data) {
			root.right = delete(root.right, data);
		} else {
			if(root.left == null && root.right == null) {
				root = null;
			} else if(root.left == null) {
				root = root.right;
			} else if(root.right == null) {
				root = root.left;
			} else {
				Node temp = findMin(root.right);
				root.val = temp.val;
				root.right = delete(root.right, temp.val);
			}
		}
		
		if(root == null) {
			return root;
		}
		
		setBalance(root);
		
		if(root.balanceFactor == -2) {
			if(root.right.balanceFactor == -1 || root.right.balanceFactor == 0) {
				root = singleLeftRotation(root);
			} else {					
				root = doubleRightLeftRotation(root);
			}
		} else if(root.balanceFactor == 2) {
			if(root.left.balanceFactor == 1 || root.left.balanceFactor == 0) {
				root = singleRightRotation(root);
			} else {
				root = doubleLeftRightRotation(root);
			}
		}
		return root;
	}
	
	private Node singleRightRotation(Node root) {
		Node temp = root.left;
		root.left = temp.right;
		temp.right = root;
		root = temp;
		setBalance(root, root.right);
		return root;
	}
	
	private Node singleLeftRotation(Node root) {
		Node temp = root.right;
		root.right = temp.left;
		temp.left = root;
		root = temp;
		setBalance(root, root.left);
		return root;
	}
	
	private Node doubleLeftRightRotation(Node root) {
		root.left = singleLeftRotation(root.left);
		root = singleRightRotation(root);
		return root;
	}
	
	private Node doubleRightLeftRotation(Node root) {
		root.right = singleRightRotation(root.right);
		root = singleLeftRotation(root);
		return root;
	}
	
	private void setBalance(Node... nodes) {
        for (Node n : nodes)
            n.balanceFactor = height(n.left) - height(n.right);
    }
	
	private Node findMin(Node root) {
		if(root == null || root.left == null) {
			return root;
		}
		return findMin(root.left);
	}
	
	private int height(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) +1;
	}
}
