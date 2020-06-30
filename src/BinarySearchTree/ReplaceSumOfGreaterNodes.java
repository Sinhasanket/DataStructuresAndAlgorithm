package BinarySearchTree;

import java.util.Scanner;

public class ReplaceSumOfGreaterNodes {
    //preprocess the data before building the nodes of tree
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l  =sc.nextInt();
        int arr[]=new int[l];
        int total = 0;
        for (int i=0;i<l;i++){
            arr[i]=sc.nextInt();
            total+=arr[i];
        }
        int temp[]=new int[l];
        for (int i=0;i<l-1;i++){
            temp[i] = total;
            total-=arr[i];
        }
        temp[l-1] = arr[l-1];
        Trees tree = new Trees(temp);
        tree.preOrder();
    }
}

class Trees{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    private Node root = null;

    Trees(int arr[]){
       this.root = add(arr,0,arr.length-1);
    }

    private static Node add(int[] arr,int left,int right){
        if (left > right)return null;
        int mid = (left+right)/2;
        Node nn = new Node(arr[mid]);
        nn.left = add(arr,left,mid-1);
        nn.right = add(arr,mid+1,right);
        return nn;
    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(Node node){
        if (node==null)return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
