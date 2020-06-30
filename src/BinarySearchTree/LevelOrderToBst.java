package BinarySearchTree;

import java.util.Scanner;

public class LevelOrderToBst {

    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Node tree = constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    static Node constructUtil(Node root,int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(data <= root.data){
            root.left = constructUtil(root.left,data);
        }else{
            root.right = constructUtil(root.right,data);
        }
        return root;
    }


    public static Node constructBST(int[] arr){
        if(arr.length==0){
            return null;
        }

        Node root = null;

        for(int i=0;i<arr.length;i++){
            root = constructUtil(root,arr[i]);
        }
        return root;
    }
}

//        Input:
//        2
//        9
//        7 4 12 3 6 8 1 5 10
//        6
//        1 3 4 6 7 8
//
//        Output:
//        7 4 3 1 6 5 12 8 10
//        1 3 4 6 7 8