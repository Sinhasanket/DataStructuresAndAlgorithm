package Tree;

import java.util.Scanner;

public class FoldableBT {

   static class Node {
        int data;
        Node left, right;
        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void insert(Node root,int a,int a1,char lr) {
        if(root==null) {
            return;
        }
        if(root.data==a) {
            switch(lr) {
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

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            if(n==0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++) {
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0) {
                    root=new Node(a);
                    switch(lr) {
                        case 'L':root.left=new Node(a1);
                            break;
                        case 'R':root.right=new Node(a1);
                            break;
                    }
                }
                else {
                    insert(root,a,a1,lr);
                }
            }

            boolean val = isFoldable(root);
            if(val == true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public static boolean fold(Node rootLeft,Node rootRight){
        if(rootLeft==null&&rootRight==null)
            return true;

        if((rootLeft==null && rootRight!=null)||(rootLeft!=null && rootRight==null))
            return false;

        else return true&&fold(rootLeft.left,rootRight.right)&&fold(rootRight.right,rootLeft.left);
    }

    public static boolean isFoldable(Node root) {
        return fold(root,root);
    }
}
//
//      Consider the below trees:
//        (a) and (b) can be folded.
//        (c) and (d) cannot be folded.
//         (a)
//          10
//        /    \
//        7      15
//        \    /
//        9  11
//
//        (b)
//        10
//        /  \
//        7    15
//        /      \
//        9       11
//
//        (c)
//        10
//        /  \
//        7   15
//        /    /
//        5   11
//
//        (d)
//         10
//        /   \
//        7     15
//        / \    /
//        9  10  12


//        Input:
//        2
//        4
//        10 7 L 7 9 R 10 15 R 15 11 L
//        4
//        10 7 L 7 5 L 10 15 R 15 11 L
//
//        Output:
//        Yes
//        No