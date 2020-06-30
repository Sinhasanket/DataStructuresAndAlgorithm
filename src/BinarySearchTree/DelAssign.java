package BinarySearchTree;

import java.util.*;

public class DelAssign {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int d = sc.nextInt();
            int[] del = new int[d];
            for (int i = 0; i < d; i++) {
                del[i] = sc.nextInt();
            }

            Tree bst = new Tree(arr);

            for (int i = 0; i < d; i++)
                bst.remove(del[i]);

            bst.preOrder();
        }

    }
}

class Tree {

    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root = null;

    Tree(int[] arr) {
        Node nn = new Node(arr[0]);
        this.root = nn;
        for (int i = 1; i < arr.length; i++) {
            add(this.root, null, arr[i], false);
        }
    }

    void add(Node root, Node parent, int data, boolean isLeft) {
        if (root == null) {
            if (isLeft == true)
                parent.left = new Node(data);
            else
                parent.right = new Node(data);
            return;
        }

        if (data < root.data) {
            add(root.left, root, data, true);
        } else if (data > root.data) {
            add(root.right, root, data, false);
        }
    }

    public void preOrder() {
        displaypreorder(this.root);
    }

    private void displaypreorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        displaypreorder(root.left);
        displaypreorder(root.right);
    }

    public void remove(int data) {
        this.root = remove_from_bst(this.root, data);
    }

    private Node remove_from_bst(Node root,  int data) {

        if(root == null){
            return root;
        }

        if(root.data < data){
            root.right = remove_from_bst(root.right, data);
        }else if(root.data > data){
            root.left = remove_from_bst(root.left, data);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.data = find_min(root.right);
            root.right = remove_from_bst(root.right, root.data);
        }
        return root;
    }

    int find_min(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}
