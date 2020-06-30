package BinarySearchTree;

import java.util.Scanner;
import java.util.Stack;

//Given two Binary Search Trees(without duplicates),
// you need to print the common nodes in them. In other words, find intersection of two BSTs.

public class CommonNodeInBst {

    static class Node{
        int data;
        Node left,right;
        Node (int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n1=sc.nextInt();
            Node root1=null;
            Node root2=null;
            for(int i=0;i<n1;i++){
                int a=sc.nextInt();
                if(root1==null)
                    root1=new Node(a);
                else{
                    insert(root1,a);
                }
            }
            int n2=sc.nextInt();
            for(int i=0;i<n2;i++){
                int a=sc.nextInt();
                if(root2==null)
                    root2=new Node(a);
                else{
                    insert(root2,a);
                }
            }

            printCommon(root1,root2);
            System.out.println();
        }
    }
    public static Node insert(Node root,int a){
        if(root==null)
            return new Node(a);
        if(root.data>a){
            root.left=insert(root.left,a);
        }
        if(root.data<a)
            root.right=insert(root.right,a);
        return root;
    }


    public static void printCommon(Node root1,Node root2){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while(true){

            if(root1 != null){
                s1.push(root1);
                root1= root1.left;
            }else if(root2 != null ){
                s2.push(root2);
                root2 = root2.left;
            }else if(!s1.isEmpty() && !s2.isEmpty()){
                root1 = s1.peek();
                root2 = s2.peek();

                if(root1.data == root2.data){

                    System.out.print(root1.data+" ");
                    s1.pop();
                    s2.pop();

                    root1=root1.right;
                    root2=root2.right;

                }else if(root1.data < root2.data){
                    s1.pop();
                    root1=root1.right;
                    root2=null;
                }else if(root1.data > root2.data){
                    s2.pop();
                    root2=root2.right;
                    root1=null;
                }
            }
            else break;
        }
    }
}


//        Input:
//        2
//        7
//        5 1 10 0 4 7 9
//        5
//        10 7 20 4 9
//        5
//        10 2 11 1 3
//        3
//        2 1 3
//
//        Output:
//        4 7 9 10
//        1 2 3