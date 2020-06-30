package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

class Bt{
    private static class Node{
        int data;
        Node left;
        Node right;
        int hd;
        Node(int data) {
            this.data = data;
            this.left=this.right=null;
            this.hd = Integer.MAX_VALUE;
        }
    }

    Node root = null;

    Bt(int arr[]){

    }

    public void insert(int data){
      // this.root = this.insert(this.root,data);
    }

//    private Node insert(Node node,int item){
//
//    }

    public void bottom(){
        bottom(this.root);
    }

    private void bottom(Node root){
        if (root==null)return;
        LinkedList<Node> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(root);
         int hd = 0;
        root.hd = hd;
        while (!q.isEmpty()){
            Node temp = q.remove();
            hd = root.hd;
            map.put(hd,temp.data);
            if (temp.left != null){
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if (temp.right != null){
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }

        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        for(int keys : key ) {
            System.out.print(map.get(keys)+" ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Bt tree = new Bt(arr);
        tree.bottom();
    }
}



//public class BottomView {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        Bt tree = new Bt();
//        int n = sc.nextInt();
//        for (int i=0;i<n;i++){
//            tree.insert(sc.nextInt());
//        }
//        tree.bottom();
//    }
//}