package BinarySearchTree;

import java.util.Scanner;
import java.util.Stack;

public class MergeTwoBstAndSort {

    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node fhead = null;
            Node shead = null;
            for(int i = 0; i < x; i++) {
                if(fhead==null)
                    fhead = new Node(sc.nextInt());
                else{
                    insert(fhead,sc.nextInt());
                }
            }
            for(int i = 0; i < y; i++) {
                if(shead==null)
                    shead = new Node(sc.nextInt());
                else{
                    insert(shead,sc.nextInt());
                }
            }
            merge(fhead , shead);
            System.out.println();
        }
    }

    public static Node insert(Node head, int a){
        if(head==null)
            return new Node(a);
        if(head.data>a)
            head.left=insert(head.left,a);
        if(head.data<a)
            head.right=insert(head.right,a);
        return head;
    }


    public static void merge(Node root1 , Node root2){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node c1 = root1;
        Node c2 = root2;

        // base case, when root1 is null
        if (root1 == null) {
            inorder(root2);
            return;
        }

        // base case, when root2 is null
        if (root2 == null) {
            inorder(root1);
            return;
        }

        // Run the loop while there are nodes not yet printed.
        // The nodes may be in stack(explored, but not printed)
        // or may be not yet explored
        while (c1 != null || !s1.empty() || c2 != null || !s2.empty()) {
            // Following steps follow iterative Inorder Traversal
            if (c1 != null || c2 != null) {

                // Reach the leftmost node of both BSTs and push ancestors of
                // leftmost nodes to stack s1 and s2 respectively
                if (c1 != null) {
                    s1.push(c1);
                    c1 = c1.left;
                }

                if (c2 != null) {
                    s2.push(c2);
                    c2 = c2.left;
                }
            } else {

                // If we reach a NULL node and either of the stacks is empty,
                // then one tree is exhausted, ptint the other tree
                if (s1.empty()) {
                    while (!s2.empty()) {
                        c2 = s2.peek();
                        s2.pop();
                        c2.left = null;
                        inorder(c2);
                    }
                    return;
                }

                if (s2.empty()) {
                    while (!s1.empty()) {
                        c1 = s1.peek();
                        s1.pop();
                        c1.left = null;
                        inorder(c1);
                    }
                    return;
                }

                // Pop an element from both stacks and compare the
                // popped elements
                c1 = s1.peek();
                c2 = s2.peek();
                s1.pop();
                s2.pop();

                // If element of first tree is smaller, then print it
                // and push the right subtree. If the element is larger,
                // then we push it back to the corresponding stack.
                if (c1.data < c2.data) {
                    System.out.print(c1.data);
                    System.out.print(" ");
                    c1 = c1.right;
                    s2.push(c2);
                    c2 = null;
                } else {
                    System.out.print(c2.data);
                    System.out.print(" ");
                    c2 = c2.right;
                    s1.push(c1);
                    c1 = null;
                }
            }
        }
    }

    public static void inorder(Node head) {
        if(head==null)
            return;
        inorder(head.left);
        System.out.print(head.data+" ");
        inorder(head.right);
    }
}


//CAN DO LIKE THIS ALSO
//    public static void inorder(ArrayList<Integer> al, Node root){
//        if(root != null){
//            inorder(al,root.left);
//            al.add(root.data);
//            inorder(al,root.right);
//        }
//    }

//    public static void merge(Node root1 , Node root2){
//        ArrayList<Integer> a1 = new ArrayList<>();
//        ArrayList<Integer> a2 = new ArrayList<>();
//
//        inorder(a1,root1);
//        inorder(a2,root2);
//
//        a1.addAll(a2);
//        Collections.sort(a1);
//
//        for(int i=0;i<a1.size();i++){
//            System.out.print(a1.get(i)+" ");
//        }
//    }

//        Input:
//        2
//        3 3
//        1 33 4
//        6 7 1
//        2 2
//        1 6
//        9 2
//
//        Output:
//        1 1 4 6 7 33
//        1 2 6 9