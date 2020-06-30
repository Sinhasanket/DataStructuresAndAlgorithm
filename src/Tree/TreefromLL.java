package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreefromLL {

    static class Tree {
        int data;
        Tree left;
        Tree right;
        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                int a1 = sc.nextInt();
                head = new Node(a1);
                addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    addToTheLast(new Node(a));
                }
            }

            Tree root = convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }
    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }
    public static void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null) temp = temp.next;
            temp.next = head;
        }
    }

    public static Tree convert(Node head, Tree node) {

        Queue<Tree> q=new LinkedList<>();

        node=new Tree(head.data);

        q.add(node);
        head=head.next;
        while(head!=null){

            Tree temp=q.poll();

            if(temp.left==null){
                temp.left=new Tree(head.data);
                q.add(temp.left);
                head=head.next;
            }

            if(temp.right==null && head!=null){
                temp.right=new Tree(head.data);
                q.add(temp.right);
                head=head.next;
            }
        }
        return node;
    }
}