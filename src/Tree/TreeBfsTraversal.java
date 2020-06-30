package Tree;

import java.util.LinkedList;
import java.util.Queue;

class Nodeji {
    int data;
    Nodeji left, right;

    public Nodeji(int item) {
        data = item;
        left = null;
        right = null;
    }
}

public class TreeBfsTraversal {
    Nodeji root;

    void printLevelOrder() {
        Queue<Nodeji> queue = new LinkedList<Nodeji>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Nodeji tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String args[]) {
        TreeBfsTraversal tree_level = new TreeBfsTraversal();
        tree_level.root = new Nodeji(1);
        tree_level.root.left = new Nodeji(2);
        tree_level.root.right = new Nodeji(3);
        tree_level.root.left.left = new Nodeji(4);
        tree_level.root.left.right = new Nodeji(5);

        System.out.println("Level order traversal " +
                "of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

