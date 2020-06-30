package BinarySearchTree;

import java.util.Scanner;

public class FixingTwoNodesBst {

     class Node {
        int data;
        Node left, right;
        Node(int key) {
            data = key;
            left = right = null;
        }
    }
         int flag = 1;
         int c = 0;
        public void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-- > 0) {
                int n = sc.nextInt();
                int m = n;
                if(n == 0) {
                    System.out.println(0);
                    continue;
                }
                Node root = null;
                Node temp = null;
                for(int i=0;i<n;i++){
                    int a=sc.nextInt();
                    int a1=sc.nextInt();
                    char lr=sc.next().charAt(0);
                    if(i==0){
                        root=new Node(a);
                        temp = new Node(a);
                        switch(lr){
                            case 'L':root.left=new Node(a1);
                                temp.left = new Node(a1);
                                break;
                            case 'R':root.right=new Node(a1);
                                temp.right=new Node(a1);
                                break;
                        }
                    }
                    else{
                        insert(root,a,a1,lr);
                        insert(temp, a, a1, lr);
                    }
                }
                flag = 1;
                c = 0;
                root = correctBST(root);

                inorder(temp, root);
                if(c+1 == m)
                    System.out.println(flag);
                else
                    System.out.println("0");

            }
        }

        public  void insert(Node root, int a, int a1, char lr) {
            if(root==null){
                return;
            }
            if(root.data==a){
                switch(lr){
                    case 'L':root.left=new Node(a1);
                        break;
                    case 'R':root.right=new Node(a1);
                        break;
                }
                return;
            }
            insert(root.left,a,a1,lr);
            insert(root.right,a,a1,lr);
        }

        public void inorder(Node temp, Node root) {
            if(flag==0){
                return;
            }
            if(temp==null && root== null)
                return;
            if(root==null){
                flag=0;
                return;
            }
            if(temp==null){
                flag=0;
                return;
            }
            if(temp.data==root.data){
                c++;
            }
            inorder(temp.left,root.left);
            inorder(temp.right,root.right);
        }

    Node first,mid,last,prev;

    public void bstUtil(Node root){

        if(root != null){
            bstUtil(root.left);

            if(prev != null && root.data < prev.data){
                if(first==null){
                    first=prev;
                    prev=root;
                }else
                    last=root;
            }
            prev=root;

            bstUtil(root.right);
        }
    }

    public Node correctBST(Node root){

        first=null;mid=null;last=null;prev=null;

        bstUtil(root);

        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }else if(first != null && mid != null){
            int temp = first.data;
            first.data = mid.data;
            mid.data = temp;
        }
        return root;
    }
}

//EXAMPLE
//           10
//         /    \
//        5      8
//      /   \    ^
//     /     \   |
//    2      20 <- Node to fix

//        Input:
//        2
//        4
//        10 5 L 10 8 R  5 2 L 5 20 R
//        5
//        8 3 L 8 10 R 3 1 L 3 6 R 6 7 R
//
//        Output:
//        1
//        0