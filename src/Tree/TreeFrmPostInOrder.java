package Tree;

import java.util.*;
public class TreeFrmPostInOrder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        TreeFrmPostInOrder m = new TreeFrmPostInOrder();
        int[] post = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(post, in);
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

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {

            if (postStart > postEnd || inStart > inEnd)return null;
            Node newNode = new Node();
            newNode.data = post[postEnd];

            if (inStart==inEnd)return newNode;

            int index = 0;
            for (int i=inStart;i<=inEnd;i++){
                if (newNode.data == in[i]){
                    index = i;
                    break;
                }
            }
            newNode.left = construct(post,postStart,postStart+index - (inStart+1) ,in,inStart,index-1);
            newNode.right = construct(post,postStart+index-inStart,postEnd-1,in,index+1,inEnd);


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
