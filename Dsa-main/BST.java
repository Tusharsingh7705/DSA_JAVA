import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    static Scanner sc = new Scanner(System.in);
    Node root;

    Node build() {
        int val = sc.nextInt();

        if (val == -1)
            return null;

        Node root = new Node(val);

        root.left = build();
        root.right = build();

        return root;
    }

    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {

        BST tree = new BST();

        tree.root = tree.build();

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);
    }
}