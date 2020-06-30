package BinarySearchTree;

import java.util.ArrayList;

public class AlternateLeafNodeSum {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int sum;

    static void leafSum(Node root,ArrayList<Integer> al){

//        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            al.add(root.data);

//        sum += root.data;

        leafSum(root.left,al);

        leafSum(root.right,al);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        ArrayList<Integer> al = new ArrayList<>();
        sum = 0;
        leafSum(root,al);


        for (int i=0;i<al.size();i+=2){
            sum += al.get(i);
        }


        System.out.println(sum);
    }

}
