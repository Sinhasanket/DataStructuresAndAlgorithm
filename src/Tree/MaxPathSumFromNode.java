package Tree;

import java.util.Scanner;

//Given a binary tree of N edges, where every node contains distinct data. The task is to find the maximum path sum.
//The path may start and end at any node in the tree.

public class MaxPathSumFromNode {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                            break;
                        case 'R':root.right=new Node(a1);
                            break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            System.out.println(findMaxSum(root));

        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                    break;
                case 'R':root.right=new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }


    static class Res{
        public int value;
    }

    static int findMaxSum(Node node){
        //your code goes here
        Res res = new Res();
        res.value = Integer.MIN_VALUE;
        findmaxUtil(node,res);
        return res.value;
    }

    static int findmaxUtil(Node node, Res res){
        if(node==null)
            return 0;

        int l = findmaxUtil(node.left,res);
        int r = findmaxUtil(node.right,res);

        int max_single = Math.max(Math.max(l,r)+node.data,node.data);

        int max_top = Math.max(max_single, l+r+node.data);

        res.value = Math.max(res.value,max_top);

        return max_single;
    }
}

//        Input:
//        2
//        6
//        10 2 L 2 20 L 2 1 R 10 -25 R -25 3 L -25 4 R
//        3
//        10 2 L 10 5 R 5 -2 R
//
//        Output:
//        32
//        17