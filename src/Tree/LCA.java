package Tree;

//The LCA or Lowest Common Ancestor of any two nodes N1 and N2 is defined as the common ancestor of both the nodes
//which is closest to them. That is the distance of the common ancestor from the nodes N1 and N2 should be least possible.

//The idea is to traverse the tree starting from the root node. If any of the given keys (n1 and n2) matches with root,
//then root is LCA (assuming that both keys are present). If root doesn't match with any of the keys, we recur for left
//and right subtrees. The node which has one key present in its left subtree and the other key present in the right subtree
//is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise, LCA lies in the right subtree.

public class LCA {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;
    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    Node findLCA(Node node, int n1, int n2) {

        if (node == null)
            return null;

        if (node.data == n1 || node.data == n2)
            return node;

        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        if (left_lca != null && right_lca != null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String args[]) {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
    }
}