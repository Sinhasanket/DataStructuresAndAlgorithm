package Tree;

import java.util.*;
public class TreeusingPreInOrder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        TreeusingPreInOrder m = new TreeusingPreInOrder();
        int[] pre = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(pre, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        int idx = 0;
        private Node construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

            // write your code here

            if(inStart > inEnd){
                return null;
            }

            Node newNode = new Node();
            newNode.data = pre[idx++];

            int search = 0;
            for(int i=inStart;i<=inEnd;i++){
                if(in[i] == newNode.data){
                    search = i;
                    break;
                }
            }

            newNode.left =  construct(pre,preStart,preEnd,in,inStart,search-1);
            newNode.right =  construct(pre,preStart,preEnd,in,search+1,inEnd);

            return newNode;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }
    }
}
