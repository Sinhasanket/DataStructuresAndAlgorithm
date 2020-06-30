package LinkedList;

import java.io.*;

class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}

public class ReverseLL{
    Node head;
    Node lastNode;
    static PrintWriter out;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    void printList() {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data+" ");
            temp = temp.next;
        }
        out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t= Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            ReverseLL llist = new ReverseLL();
            String nums[] = br.readLine().split(" ");
            if (n > 0) {
                int a1= Integer.parseInt(nums[0]);
                Node head= new Node(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(nums[i]);
                llist.addToTheLast(new Node(a));
            }
            llist.head = new ReverseL().reverseList(llist.head);

            llist.printList();

            t--;
        }
        out.close();
    }
}

class ReverseL {
    Node reverseList(Node head) {
        //put head of ll in curr variable of node type
        Node curr=head;
        //previous and next is null right now
        Node prev=null,next=null;
        //run a loop untill curr is not null
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
}