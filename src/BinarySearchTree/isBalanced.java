package BinarySearchTree;

import java.util.*;
public class isBalanced {

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        isBalanced m = new isBalanced();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.isBalanced());
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public boolean isBalanced() {
            return this.isBalanced(this.root).isBalanced;
        }

        private BalancedPair isBalanced(Node node) {
            // write your code here
            if(node==null){
                BalancedPair bp = new BalancedPair();
                bp.isBalanced = true;
                bp.height = -1;
                return bp;
            }
            BalancedPair left = isBalanced(node.left);
            BalancedPair right = isBalanced(node.right);
            BalancedPair pr = new BalancedPair();
            pr.height = Math.max(left.height,right.height)+1;
            if(Math.abs(left.height - right.height) > 1 || !left.isBalanced && !right.isBalanced){
                pr.isBalanced = false;
            }else{
                pr.isBalanced = true;
            }
            return pr;
        }

        private class BalancedPair {
            int height;
            boolean isBalanced;
        }
    }
}