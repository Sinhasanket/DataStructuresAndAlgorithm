package Tree;

import java.util.Scanner;

public class MaxDiffNodeAndAcentor {

   static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                            break;
                        case 'R':root.right=new Node(a1);
                            break;
                    }
                } else{
                    insert(root,a,a1,lr);
                }
            }
            System.out.println(maxDiff(root));

        }
    }
    public static void insert(Node root,int a,int a1,char lr){
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


    static class Res {
        int r = Integer.MIN_VALUE;
    }

    static int maxDiffUtil(Node t,Res res) {
        if (t == null)
            return Integer.MAX_VALUE;

        if (t.left == null && t.right == null)
            return t.data;

        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));
        res.r = Math.max(res.r, t.data - val);

        return Math.min(val, t.data);
    }

    static int maxDiff(Node root) {
        Res res = new Res();
        maxDiffUtil(root, res);
        return res.r;
    }
}

//        Input:
//        1
//        2
//        5 2 L 5 1 R
//
//        Output:
//        4

//      Testcase:
//
//               5
//             /    \
//            2      1