package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LefTopBotViewBinTree {
    static class Node {
        int data;
        DiamofBinTree.Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    void leftViewUtil(Node root) {

        Queue<Node> q=new LinkedList<Node>();

        if (root == null)
            return;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = ((LinkedList<Node>) q).peekFirst();

            if (temp != null) {

                System.out.println(temp.data);

                while (((LinkedList<Node>) q).peekFirst() != null) {

                    // If left child is present
                    // push into queue
                    if (temp.left !=null)
//              error1       //   q.add(temp.left);

                    // If right child is present
                    // push into queue
                    if (temp.right !=null)
//             error2         //  q.add(temp.right);

                    // Pop the current node
                    q.remove();

                    temp = ((LinkedList<Node>) q).peekFirst();
                }

                // Push delimiter
                // for the next level
                q.add(null);
            }

            // Pop the delimiter of
            // the previous level
            q.remove();
        }
    }

}
