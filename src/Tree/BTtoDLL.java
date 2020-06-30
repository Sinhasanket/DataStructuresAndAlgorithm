package Tree;

import java.util.HashMap;
import java.util.Scanner;

//    The idea is to do inorder traversal of the binary tree. While doing inorder traversal,
//        keep track of the previously visited node in a variable say prev. For every visited node,
//        make it next of prev and previous of this node as prev.

public class BTtoDLL {

    static class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void inorder(Node node) {
        if(node==null)
            return ;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while(prev != null) {
            System.out.print(prev.data+" ");
            prev = prev.left;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
            int n = sc.nextInt();

            Node root = null;

            while(n>0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                Node parent = hm.get(n1);
                if(parent == null) {
                    parent = new Node(n1);
                    hm.put(n1, parent);
                    if(root == null) {
                        root = parent;
                    }
                }

                Node child = new Node(n2);
                if(lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;

                hm.put(n2,child);
                n--;
            }

            Node node = bToDLL(root);
            printList(node);
            t--;
            System.out.println();
        }
    }

   static Node head=null;
   static Node bToDLL(Node root) {
      BTtoDublyLL(root);
      return head;

      /*
      for Binary tree to circular LL
      if (root == null) {
            return head;
        }
        BTtoDublyLL(root);
        head.left = prev;
        prev.right = head;
        return head;
       */
    }

    private static Node prev=null;

    static private void BTtoDublyLL(Node root){
        if(root != null){
            BTtoDublyLL(root.left);
            if(head==null){
                head=root;
            }else{
                root.left=prev;
                root.right=root;
            }
            prev=root;
            BTtoDublyLL(root.right);
        }
    }
}

//        Input:
//        2
//        2
//        1 2 R 1 3 L
//        4
//        10 20 L 10 30 R 20 40 L 20 60 R
//
//        Output:
//        3 1 2
//        2 1 3
//        40 20 60 10 30
//        30 10 60 20 40
//
//        Explanation:
//        Testcase1: The tree is
//            1
//          /   \
//        3       2
//        So, DLL would be 3<=>1<=>2
//        Testcase2: The tree is
//            10
//          /      \
//        20         30
//        /           \
//      40             60
//        So, DLL would be 40<=>20<=>60<=>10<=>30.