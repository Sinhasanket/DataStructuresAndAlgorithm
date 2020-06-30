package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxWidthTree {

    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
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
            int res = getMaxWidth(root);
            System.out.println(res);

            t--;
        }
    }

   static int getMaxWidth(Node root){
       if(root == null ) return 0;
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       int ans=0;
       while(!q.isEmpty()){
           int size = q.size();
           ans = Math.max(ans,size);

           while(size-->0){
               Node curr = q.peek();
               q.remove();

               if(curr.left != null){
                   q.add(curr.left);
               }
               if(curr.right != null){
                   q.add(curr.right);
               }
           }
       }
       return ans;
    }
}
