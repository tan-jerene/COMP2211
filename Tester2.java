import java.io.IOException;
import java.util.Scanner;

public class Tester2 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		while (true) {
			System.out.println("1: Insert node");
			System.out.println("2: Search for a node");
			System.out.println("3: Get Maximum");
			System.out.println("4: Get Minimum");
			System.out.println("5: Delete");
			System.out.println("6: Display Tree");

			String choice = sc.next();
			switch (choice.charAt(0)) {
			case '1':
				System.out.println("Enter value to enter: ");
				try {
					char c = (char) System.in.read();
					bst.insertNode(c);
					System.out.println("Node Inserted!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case '2':
				System.out.println("Enter search char: ");
				try {
					char c = (char) System.in.read();
					BST result = bst.search(c);
					if (result == null) {
						System.out.println("Not Found");
					} else
						System.out.println("Found: \n" + result.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case '3':
				System.out.println("Maximum: " + bst.largestKey());
				break;
			case '4':
				System.out.println("Minimum: " + bst.smallestKey());
				break;
			case '5':
				try {
					System.out.print("Which key should be deleted? => ");
					char c = (char) System.in.read();
					if (bst.delete(c))
						System.out.println("Key " + c + " deleted!");
					else
						System.out.println("Failed to delete key");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case '6':
				System.out.println(bst);
				break;
			default:
				System.out.println(choice.charAt(0) + " is not a valid option");
				break;

			}
		}
	}
}
