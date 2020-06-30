package LinkedList;

import java.util.Scanner;

class Nodee {
    int data;
    Node next;
    Nodee(int d) {
        data = d;
        next = null;
    }
}

class DetectLoop {
    Node head;
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String args[]) {
        int t, d, n, i, x, c;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (d = 0; d < t; d++) {
            n = sc.nextInt();
            DetectLoop llist = new DetectLoop();
            Node q;
            for (i = 0; i < n; i++) {
                x = sc.nextInt();
                llist.push(x);
            }
            Node p;
            p = llist.head;
            q = llist.head;
            while (q.next != null) q = q.next;
            c = sc.nextInt();
            if (c > 0) {
                c = c - 1;
                for (i = 0; i < c; i++) {
                    p = p.next;
                }
                q.next = p;
            }
            if (new Loop().detectLoop(llist.head) == 1)
                System.out.print("True ");
            else
                System.out.print("False ");
        }
    }
}

class Loop{
    int detectLoop(Node head) {
        Node slow=head,fast=head;
        if(head==null){
            return 0;
        }
        while(fast !=null && fast.next != null && slow != null){
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
            if(slow==fast){
                return 1;
            }
        }
        return 0;
    }
}
