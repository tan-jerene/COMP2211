public class BST extends BinaryTree {

	public BST(char c) {
		this.root = new BSTNode(c);
	}

	public BST() {
	}

	public char largestKey() {
		if (this.getRight().emptyTree())
			return this.getRoot();
		else
			return ((BST) this.getRight()).largestKey();
	}

	public char smallestKey() {
		if (this.getLeft().emptyTree())
			return this.getRoot();
		else
			return ((BST) this.getLeft()).smallestKey();
	}

	public BST search(Character val) {
		if (this.emptyTree())
			return null;
		else if (this.getRoot() == val)
			return this;
		else if (this.getRoot() < val)
			return ((BST) this.getRight()).search(val);
		else
			return ((BST) this.getLeft()).search(val);
	}

	public void insertNode(char val) {
		BSTNode n;

		n = new BSTNode(val);

		if (this.emptyTree())
			root = n;

		else if (val > this.getRoot()) {
			if (this.getRight().emptyTree())
				this.getRight().root = n;
			else
				((BST) this.getRight()).insertNode(val);
		} else {
			if (this.getLeft().emptyTree())
				this.getLeft().root = n;
			else
				((BST) this.getLeft()).insertNode(val);
		}
	}

	@Override
	public String toString() {
		if (root == null)
			return " ";
		else
			return " ( " + getLeft().toString() + " ) " + root.getData()
					+ " ( " + getRight().toString() + " ) ";
	}

	public boolean delete(char val) {
		BST t = search(val);
		if (t == null) {
			return false;
		}
		if (t.emptyTree()) {
			return false;
		} else if (t.getRight().emptyTree() && t.getLeft().emptyTree()) {
			t.root = null;
			return true;
		} else if (t.getRight().emptyTree()) {
			t.root = t.getLeft().root;
			return true;
		} else if (t.getLeft().emptyTree()) {
			t.root = t.getRight().root;
			return true;
		} else {
			char pred = getPred((BST) t.getLeft());
			t.root.setData(pred);
			((BST) t.getLeft()).delete(pred);
			return true;
		}

	}

	private char getPred(BST tree) {
		if (tree.getRight().emptyTree())
			return tree.getRoot();
		else {
			return getPred((BST) tree.getRight());
		}
	}
}
