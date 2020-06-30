package BinarySearchTree;

import java.util.Scanner;

class T {
    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;

      public void insert(int data){
          this.root = insert(this.root,data);
      }

    private static Node insert(Node node,int item){
       if (node==null){
           Node ne = new Node(item);
           return ne;
       }
       if (item <= node.data){
           node.left = insert(node.left,item);
       }else{
           node.right = insert(node.right,item);
       }
       return node;
    }

    public void preOrder(){
        System.out.print("# Preorder : ");
        this.preOrder(this.root);
    }

    private static void preOrder(Node root){
        if (root==null)return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(int l,int r){
        System.out.print("# Nodes within range are : ");
        this.inOrder(this.root,l,r);
    }

    private static void inOrder(Node root,int left,int right){
        if (root==null)return;
        inOrder(root.left,left,right);
        if (root.data >= left && root.data <= right)
                 System.out.print(root.data+" ");
        inOrder(root.right,left,right);
    }
}

public class BstinRange {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while (t-->0){
            T tree = new T();
            int node = sc.nextByte();
            int arr[]=new int[node];
            for(int i=0;i<node;i++){
                arr[i]=sc.nextInt();
                tree.insert(arr[i]);
            }
            int l = sc.nextInt();
            int r = sc.nextInt();
            tree.preOrder();
            System.out.println();
            tree.inOrder(l,r);
            System.out.println();
        }
    }
}

//1
//5
//4 3 2 5 6
//3 5
//# Preorder : 4 3 2 5 6
//# Nodes within range are : 3 4 5

//21 18 2 6 14 24 12 13 3 4