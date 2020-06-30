package Tree;

//Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively.
//The task is to construct the binary tree from these traversals.

import java.util.*;
public class TreeFrmPosandIn {
          static  class Node {
            int data;
            Node left;
            Node right;

            Node(int value) {
                data = value;
                left = null;
                right = null;
            }
        }

        static class InorderPostorderToTree {

            public void preOrder(Node root) {
                if (root == null)
                    return;

                System.out.print(root.data + " ");
                preOrder(root.left);

                preOrder(root.right);
            }
        }

            public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                InorderPostorderToTree ip = new InorderPostorderToTree();
                int T = sc.nextInt();
                while(T>0) {
                    int n = sc.nextInt();
                    int inorder[] = new int[n];
                    int postorder[] = new int[n];
                    for(int i=0; i<n; i++)
                        inorder[i] = sc.nextInt();
                    for(int i=0; i<n; i++)
                        postorder[i] = sc.nextInt();
                    Node root = buildTree(inorder,postorder,n);
                    ip.preOrder(root);
                    System.out.println();

                    T--;

                }
            }


        static int pIndex = 0;

    /* Recursive function to construct binary of size n
    from  Inorder traversal in[] and Postorder traversal
    post[].  Initial values of inStrt and inEnd should
    be 0 and n -1.  The function doesn't do any error
    checking for cases where inorder and postorder
    do not form a tree */
   static Node buildTreeUtil(int[] inOrder, int[] postOrder, int iStart, int iEnd,int postStart, int postEnd) {
        if (iStart > iEnd || postEnd > postEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using postIndex
        and increment postIndex */
        int rootValue = postOrder[postEnd];
        Node root = new Node(rootValue);
        pIndex++;

        /* If this node has no children then return */
        if (iStart == iEnd) {
            return root;
        }

        /* Else find the index of this node in Inorder traversal */
        int index = getInorderIndex(inOrder, iStart, iEnd, root.data);

		/* Using index in Inorder traversal, construct left and
            right subtress */
        root.left = buildTreeUtil(inOrder, postOrder, iStart, index - 1, postStart, postStart + index - (iStart + 1));
        root.right = buildTreeUtil(inOrder, postOrder, index + 1, iEnd, postStart + index - iStart, postEnd - 1);

        return root;
    }

    // function to get inorder array
    static public int getInorderIndex(int[] inOrder, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }

   static Node buildTree(int in[], int post[], int n) {
        return buildTreeUtil(in, post, 0, n-1,0,n-1);
    }

}

//       Input:
//        2
//        8
//        4 8 2 5 1 6 3 7
//        8 4 5 2 6 7 3 1
//        5
//        9 3 2 5 4
//        5 9 3 4 2
//
//        Output:
//        1 2 4 8 5 3 6 7
//        2 9 5 4 3
//
//        Explanation:
//        Testcase 1:
//           1
//         /    \
//        2       3
//      /   \    /   \
//     4     5  6     7
//      \
//       8