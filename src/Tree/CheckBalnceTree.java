package Tree;

import java.util.HashMap;
import java.util.Scanner;

public class CheckBalnceTree {
   static class Node {
        int data;
        Node left,right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr= sc.next().charAt(0);

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

            if(isBalanced(root) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }

   static boolean isBalanced(Node root) {
        int heig = height(root);
        if(heig==100)
            return false;
        else
            return true;
    }

    static int height(Node root){
        if(root==null)
            return 0;
        else{
            int ldepth = height(root.left);
            int rdepth = height(root.right);

            return ( rdepth==100 || Math.abs(ldepth-rdepth)>1)? 100 : (Math.max(ldepth,rdepth)+1);
        }
    }
}
