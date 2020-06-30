package BinarySearchTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PairSumBst {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (node.data > data)
            node.left = insert(node.left, data);
        if (node.data < data)
            node.right = insert(node.right, data);
        return node;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int temp = 0;
            Node root = null;
            for (int i = 0; i < n; i++) {
                temp = sc.nextInt();
                root = insert(root, temp);
            }
            temp = sc.nextInt();
            if (findPair(root, temp) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean findPair(Node root, int sum) {
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();

        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.peek();
            int ans = sum-temp.data;
            q.remove();
            if(hs.contains(ans)){
                return true;
            }else{
                hs.add(temp.data);
            }
            if(temp.right != null)
                q.add(temp.right);

            if(temp.left != null)
                q.add(temp.left);
        }
        return false;
    }
}

//        Input:
//        2
//        5
//        8 5 1 3 9
//        4
//        6
//        0 1 2 7 8 3
//        6
//
//        Output:
//        1
//        0
