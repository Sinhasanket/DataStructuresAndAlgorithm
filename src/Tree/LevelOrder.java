package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static class Node
    {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data){
            this.data = data;
            left = null;
            right =null;
        }
    }

    // Iterative method to do level order traversal line by line
    static int printLevelOrder(Node root,int lvl)
    {
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


    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*               1
                   /     \
                  2       3
                /   \       \
               4     5       6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int level = 2;
        System.out.println(printLevelOrder(root,level));
    }
}

//        2
//        2 1
//        1 2 L 1 3 R
//        4 3
//        10 20 L 10 30 R 20 40 L 20 60 R
//        Output:
//        1
//        2