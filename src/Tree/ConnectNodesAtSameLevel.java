package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectNodesAtSameLevel {

    static class Node {
        int data;
        Node left, right, nextRight;
        Node(int item) {
            data = item;
            left = right = nextRight = null;
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

    static void printSpecial(Node root) {
        if(root == null)
            return ;
        Node node = root;
        while(node != null) {
            System.out.print(node.data+" ");
            node = node.nextRight;
        }
        if(root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0) {
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

            connect(root);
            printSpecial(root);
            System.out.println();
            inorder(root);
            System.out.println();
            t--;

        }
    }

   static void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null)
            return;

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;

            while(size-->0){
                Node temp = q.peek();
                q.remove();

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }

                if(prev != null)
                    prev.nextRight=temp;

                prev=temp;
            }
            prev.nextRight=null;
        }
    }
}

//EXAMPLE
//          10                   10 ------> NULL
//         / \                 /    \
//        3   5       =>     3 ------> 5 --------> NULL
//        / \  \               /  \      \
//       4   1   2          4 --> 1 -----> 2 -------> NULL
//
//                  Input:
//                  2
//                  2
//                  3 1 L 3 2 R
//                  4
//                  10 20 L 10 30 R 20 40 L 20 60 R
//
//                  Output:
//                  3 1 2
//                  1 3 2
//                  10 20 30 40 60
//                  40 20 60 10 30