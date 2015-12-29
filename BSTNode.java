public class BSTNode extends Node {

	public BSTNode(char d) {
		super(d);
		left = new BST();
		right = new BST();
	}

}
