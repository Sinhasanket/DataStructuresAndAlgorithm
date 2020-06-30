package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewBinTree {
  static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
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
            leftView(root);
            System.out.println();
            t--;
        }
    }

   static void leftView(Node root) {
        Queue<Node> q = new LinkedList<>();

        if(root==null)
            return;

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = ((LinkedList<Node>) q).peekFirst();
            if(temp != null){
                System.out.print(temp.data+" ");

                while(((LinkedList<Node>) q).peekFirst() != null){
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                    q.remove();
                    temp=q.peek();
                }
                q.add(null);
            }
            q.remove();
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
//        1 3
//        10 20 40