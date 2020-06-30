package Tree;

import java.util.LinkedList;
import java.util.Scanner;

class Bin {
    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    private Node root=null;
    private int size =0;

    Bin(){
        Scanner sc = new Scanner(System.in);
        this.root = takeInput(sc,null,false);
    }

    private Node takeInput(Scanner sc,Node parent,boolean isLeftorRight){
       if (parent==null){
           System.out.println("Enter data for root :");
       }else{
          if (isLeftorRight){
              System.out.println("Enter the data for left child of :"+parent.data);
          }else {
              System.out.println("Enter the data for right child of :"+parent.data);
          }
       }

       int newData = sc.nextInt();
       Node node = new Node(newData,null,null);
       this.size++;

       boolean choice = false;
       System.out.println("Do you have left child of "+node.data);
       choice = sc.nextBoolean();

       if (choice){
            node.left = takeInput(sc,node,true);
       }

        choice = false;
        System.out.println("Do you have right child of "+node.data);
        choice = sc.nextBoolean();

        if (choice){
            node.right = takeInput(sc,node,false);
        }
        return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){
        String str = "";
        if (node.left != null){
            str+= node.left.data+"=>";
        }else{
            str+="END=>";
        }
        str+=node.data;
        if (node.right != null){
            str+= "<="+node.right.data;
        }else{
            str+="<=END";
        }
        System.out.println(str);
        if (node.left != null){
            this.display(node.left);
        }
        if (node.right != null){
            this.display(node.right);
        }
    }

    public int height(){
        return this.height(this.root);
    }

    private int height(Node root){
        if (root==null)return -1;
        int leftHeight =this.height(root.left);
        int rightHeight = this.height(root.right);
        int heigth = Math.max(leftHeight,rightHeight)+1;
        return heigth;
    }

    public void preOrder(){
        this.preOrder(this.root);
    }

    private void preOrder(Node root){
        if (root==null)return;
        System.out.println(root.data+", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(){
        this.inOrder(this.root);
    }

    private void inOrder(Node root){
        if (root==null)return;
        inOrder(root.left);
        System.out.println(root.data+", ");
        inOrder(root.right);
    }


    public void postOrder(){
        this.postOrder(this.root);
    }

    private void postOrder(Node root){
        if (root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+", ");
    }

    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node remove = queue.removeFirst();
            System.out.println(remove.data+", ");
            if (remove.left != null){
                queue.addLast(remove.left);
            }
            if (remove.right != null){
                queue.addLast(remove.right);
            }
        }
    }

    public boolean isBST(){
        return this.isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBST(Node node,int min,int max){
        if (node==null)return true;
        if (node.data < min  || node.data > max){
            return false;
        }else if(!this.isBST(node.left,min,node.data)){
            return false;
        }else if(!this.isBST(node.right,node.data,max)){
            return false;
        }
        return true;
    }

}

public class bintree{
    public static void main(String[] args){
        Bin tree = new Bin();
        tree.display();
        System.out.println("Heigth of tree is :"+tree.height());
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        tree.levelOrder();
        System.out.println(tree.isBST());
    }
}