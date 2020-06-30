package Tree;

import java.util.Scanner;

public class CheckSubtree {

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node proot = null;
            if (n == 1) {
                proot = new Node(sc.nextInt());
                n--;
            }
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (proot == null) {
                    proot = new Node(a);
                    switch (lr) {
                        case 'L':
                            proot.left = new Node(b);
                            break;
                        case 'R':
                            proot.right = new Node(b);
                            break;
                    }
                } else {
                    insert(a, b, lr, proot);
                }
            }
            int m = sc.nextInt();
            Node rroot = null;
            if (m == 1) {
                rroot = new Node(sc.nextInt());
                m--;
            }
            while (m-- > 0) {
                int z = sc.nextInt();
                int y = sc.nextInt();
                char ch = sc.next().charAt(0);
                if (rroot == null) {
                    rroot = new Node(z);
                    switch (ch) {
                        case 'L':
                            rroot.left = new Node(y);
                            break;
                        case 'R':
                            rroot.right = new Node(y);
                            break;
                    }
                } else {
                    insert(z, y, ch, rroot);
                }
            }

            boolean q = isSubtree(rroot, proot);
            if (q == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    public static void insert(int a, int b, char lr, Node root) {
        if (root == null) return;
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(b);
                    break;
                case 'R':
                    root.right = new Node(b);
                    break;
            }
        }
        insert(a, b, lr, root.left);
        insert(a, b, lr, root.right);
    }

    public static boolean isSubtree(Node T, Node S) {
        if(T==null && S == null)
            return true;

        if(T==null || S == null)
            return false;

        if(T.data ==S.data){
            boolean left = isSubtree(T.left,S.left);
            boolean right = isSubtree(T.right,S.right);
            return left&&right;
        }else{
            return (isSubtree(T.left,S) || isSubtree(T.right,S));
        }
    }
}



//       Input:
//        3
//        1
//        3 4 L
//        3
//        1 2 L 1 3 R 3 4 L
//        5
//        26 10 L 10 20 L 10 30 R 20 40 L 20 60 R
//        5
//        26 10 L 10 20 L 10 30 R 20 40 L 20 60 R
//        3
//        10 4 L 10 6 R 4 30 R
//        6
//        26 10 L 26 3 R 10 4 L 10 6 R 6 25 R 3 3 R
//
//        Output:
//        1
//        1
//        0