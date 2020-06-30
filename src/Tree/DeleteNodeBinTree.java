package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeBinTree {
    static class Node {
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    static Node root;
    static Node temp = root;
    static void inorder(Node temp) {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }

    static void deleteDeepest(Node root, Node d_node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp;
        while(!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.right!=null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    d_node = null;
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left!=null) {
                if (temp.left == d_node) {
                    temp.left=null;
                    d_node = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }

    static void deletion(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;
        Node key_node = null;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key)
                key_node = temp;

            if (temp.left!=null)
                q.add(temp.left);

            if (temp.right!=null)
                q.add(temp.right);
        }

        int x = temp.key;
        deleteDeepest(root, temp);
        key_node.key = x;
    }

    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before Deletion:");
        inorder(root);

        int key = 11;
        deletion(root, key);

        System.out.print("\nInorder traversal after Deletion:");
        inorder(root);
    }
}