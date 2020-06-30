package LinkedList;

import java.util.Scanner;

class Nodez {
    int data;
    Nodez next;
    Nodez(int d) {data = d; next = null; }
}

class RemoveDupliSorted {
    Node head;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            RemoveDupliSorted llist = new RemoveDupliSorted();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution g = new Solution();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();
        }
    }}

class Solution {
    Node removeDuplicates(Node root) {
        Node curr = root;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                Node temp = curr.next.next;
                curr.next = temp;
            } else{
                curr = curr.next;
            }
        }
        return root;
    }
}