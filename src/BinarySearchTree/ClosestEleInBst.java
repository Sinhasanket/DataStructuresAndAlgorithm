package BinarySearchTree;

import java.util.Scanner;

//Given a BST with N nodes and a target node K. The task is to find an integer
//having minimum absolute difference with given target value K and return this difference.

public class ClosestEleInBst {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Node root = new Node(sc.nextInt());
            for(int i=0;i<n-1;i++)
                insert(root,sc.nextInt());
            int k=sc.nextInt();
            System.out.println(maxDiff(root,k));
        }
    }

    public static Node insert(Node root,int n){
        if(root==null)
            return new Node(n);
        if(n<root.data)
            root.left=insert(root.left,n);
        if(n>root.data)
            root.right=insert(root.right,n);
        return root;
    }

    static int min_diff, min_diff_key;
    static void maxDiffUtil(Node  ptr, int k) {
        if (ptr == null)
            return ;

        if (ptr.data == k) {
            min_diff_key = k;
            return;
        }

        if (min_diff > Math.abs(ptr.data - k)) {
            min_diff = Math.abs(ptr.data - k);
            min_diff_key = ptr.data;
        }
        if (k < ptr.data)
            maxDiffUtil(ptr.left, k);
        else
            maxDiffUtil(ptr.right, k);
    }

    static int maxDiff(Node  root, int k) {
        min_diff = Integer.MAX_VALUE; min_diff_key = -1;

        maxDiffUtil(root, k);

        return Math.abs(min_diff_key-k);
    }
}

//        Input:
//        2
//        9
//        9 4 3 6 5 7 17 22 20
//        18
//        9
//        9 4 3 6 5 7 17 22 20
//        4
//
//        Output:
//        1
//        0

//SHORT
//    public static int maxDiff(Node root, int k){
//        if(root==null){
//            return 200;
//        }
//        return Math.min(Math.min(Math.abs(root.data-k),maxDiff(root.left,k)),maxDiff(root.right,k));
//
//    }