public class Tester1
{
	public static void main(String args[])
	{
		BinaryTree btree = new BinaryTree(new Node('A'));
		System.out.println("Inserting test data into Btree");
		btree.insertNode('B', 0);
		btree.insertNode('B', 1);
		btree.getLeft().insertNode('B', 0);
		btree.getLeft().insertNode('B', 1);
		btree.getRight().insertNode('A', 0);
		btree.getRight().insertNode('B', 1);
		btree.getLeft().getLeft().insertNode('A', 0); //added
		btree.getLeft().getLeft().insertNode('A', 1); //added
		btree.getLeft().getRight().insertNode('A', 0); 
		btree.getLeft().getRight().insertNode('A', 1); 
		btree.getRight().getRight().insertNode('A', 0);
		btree.getRight().getRight().insertNode('A', 1); //added
		System.out.println("Tree data:\n"+inOrder(btree));
		System.out.println("count A: " + countA(btree));
		System.out.println("Inserting new data into Btree");
		btree = new BinaryTree(new Node('+'));
		btree.insertNode('/', 0);
		btree.insertNode('*', 1);
		btree.getLeft().insertNode('*', 0);
		btree.getLeft().insertNode('-', 1);
        	btree.getRight().insertNode('5', 0);
        	btree.getRight().insertNode('-', 1); //added
		btree.getLeft().getLeft().insertNode('2', 0); //added
		btree.getLeft().getLeft().insertNode('3', 1); //added
		btree.getLeft().getRight().insertNode('2', 0); 
		btree.getLeft().getRight().insertNode('1', 1); 
		btree.getRight().getRight().insertNode('4', 0);
		btree.getRight().getRight().insertNode('1', 1); //added
		System.out.println("Tree data:\n"+inOrder(btree));
/*******************************************************************************************
        ____________________a b c d e f g h TREE______________________
		BinaryTree btree = new BinaryTree(new Node('f'));
		btree.insertNode('b', 0);
		btree.insertNode('g', 1);
		btree.getLeft().insertNode('d', 1);
                btree.getRight().insertNode('i', 1);
		btree.getLeft().insertNode('a', 0);
		btree.getLeft().getRight().insertNode('c', 0); 
		btree.getLeft().getRight().insertNode('e', 1); 
		btree.getRight().getRight().insertNode('h', 0);

********************************************************************************************/
		System.out.println("Leaves: " + countLeaves(btree));
		System.out.println("Post Order representation: " + postOrder(btree));
		System.out.println("In Order representation: " + inOrder(btree));
              
	}
	public static int countA(BinaryTree tree)
	{
		if (tree.emptyTree())
		{
			return 0;
		}
		else if(tree.getRoot() == 'A')
			return 1+countA(tree.getLeft())+countA(tree.getRight());
		else
			return countA(tree.getLeft())+countA(tree.getRight());
	}
	public static int countLeaves(BinaryTree tree)
	{
		if (tree.emptyTree())
		{
			return 0;
		}
		else if (tree.getLeft().emptyTree() && tree.getRight().emptyTree())
		{
			return 1;
		}
		else
			return countLeaves(tree.getLeft()) + countLeaves(tree.getRight());
	}
	public static String postOrder(BinaryTree tree)
	{
		if (tree.emptyTree())
		{
			return "";
		}
		else
			return postOrder(tree.getLeft()) + postOrder(tree.getRight()) + tree.getRoot() + " ";
	}
	public static String inOrder(BinaryTree tree)
	{
		if (tree.emptyTree())
		{
			return "";
		}
		else
			return inOrder(tree.getLeft()) + tree.getRoot() + " " + inOrder(tree.getRight());
	}
}
