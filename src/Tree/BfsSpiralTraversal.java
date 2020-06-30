package Tree;

import java.util.HashMap;
import java.util.Scanner;

public class BfsSpiralTraversal {
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

            printSpiral(root);
            System.out.println();
            t--;

        }
    }

   static void printSpiral(Node node) {
        int height =maxDepth(node);
        boolean itr= false;
        for(int i=0;i<=height;i++){
            printGivenLevel(node,i,itr);
            itr = !itr;
        }
    }

   static void printGivenLevel(Node tree,int level, boolean ltr){
        if(tree==null)
            return;

        if(level==1){
            System.out.print(tree.data+" ");
        }else if(level > 1){
            if(ltr!=true){
                printGivenLevel(tree.left, level-1, ltr);
                printGivenLevel(tree.right, level-1, ltr);
            }else{
                printGivenLevel(tree.right, level-1, ltr);
                printGivenLevel(tree.left, level-1, ltr);
            }
        }
    }

    static int maxDepth(Node node){
        if (node==null)
            return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}