package Tree;

import java.util.Stack;

public class zigzagTraversal {
    static class Node{
        int key;
        Node left,right;
        Node(int data){
            this.key = data;
            left=null;
            right=null;
        }
    }

   Node root = null;

//    void insert(int data){
//        insertUtil(root,data);
//    }
//
//    Node insertUtil(Node root,int data){
//        if (root==null){
//            root = new Node(data);
//            return root;
//        }
//
//        if(root.key <= data){
//            root.left = insertUtil(root.left,data);
//        }else if(root.key > data){
//            root.right = insertUtil(root.right,data);
//        }
//        return root;
//    }

    static void travers(Node root){

        if (root==null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);


        while (!st1.isEmpty() || !st2.isEmpty()){

            while (!st1.isEmpty()){
                Node temp = st1.peek();

                if (temp.left != null)
                    st2.push(temp.left);
                if (temp.right != null)
                    st2.push(temp.right);

                System.out.print(temp.key+" ");
                st1.pop();
            }

            while (!st2.isEmpty()){
                Node temp = st2.peek();

                if(temp.right != null)
                    st1.push(temp.right);
                if(temp.left != null)
                    st1.push(temp.left);

                System.out.print(temp.key+" ");
                st2.pop();
            }
        }
    }

    public static void main(String[] args){
        zigzagTraversal tree = new zigzagTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

       travers(tree.root);

    }
}
