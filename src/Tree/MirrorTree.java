package Tree;

import java.util.HashMap;
import java.util.Scanner;

public class MirrorTree {

   static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            mirror(root);
            inOrder(root);
            System.out.println();
            t--;
        }
    }

    static void mirror(Node node) {
        if(node==null){
            return;
        }else{
            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}

//
//        Input:
//        2
//        2
//        1 2 R 1 3 L
//        4
//        10 20 L 10 30 R 20 40 L 20 60 R
//
//        Output:
//        2 1 3
//        30 10 60 20 40
