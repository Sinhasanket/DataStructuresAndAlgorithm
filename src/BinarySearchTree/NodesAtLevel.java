package BinarySearchTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodesAtLevel {
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
        while (t-- > 0){
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            int lvl = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr= sc.next().charAt(0);
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')parent.left = child;
                else parent.right = child;
                m.put(n2, child);
                n--;
            }

            System.out.println(Count(root, lvl));
        }
    }

    static int Count(Node root, int lvl) {
        // Code here
        if(root == null)
            return 0;
        Queue<Node> q =new LinkedList<Node>();
        q.add(root);
        int chk=1;
        int c=0;

        while(true){
            int nodeC = q.size();
            if(nodeC == 0)
                break;

            while(nodeC > 0){
                Node node = q.poll();
                if(chk==lvl)
                    c++;

                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeC--;
            }
            chk++;
        }
        return (lvl > chk) ? 0 : c;
    }
}
