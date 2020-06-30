package LinkedList;

public class LLtraversal {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public void printList(){
        Node n=head;
        while(n != null){
            System.out.print(n.data+"-->");
            n=n.next;
        }
        System.out.print("Null");
    }

/* Insert new node in front of the list
 */

//    public void push(int new_data) {
//        Node new_node = new Node(new_data);
//        new_node.next = head;
//        head = new_node;
//    }

    /*
   Inserts a new node after the given prev_node.
   */

//    public void insertAfter(Node prev_node, int new_data) {
//        if (prev_node == null){
//            System.out.println("The given previous node cannot be null");
//            return;
//        }
//        Node new_node = new Node(new_data);
//        new_node.next = prev_node.next;
//        prev_node.next = new_node;
//    }

    /*
     Appends a new node at the end.
      */

//    public void append(int new_data){
//        Node new_node = new Node(new_data);
//        if (head == null) {
//            head = new Node(new_data);
//            return;
//        }
//        new_node.next = null;
//        Node last = head;
//        while (last.next != null)
//            last = last.next;
//        last.next = new_node;
//        return;
//    }

    /* Given a key, deletes the first occurrence of key in linked list */

//    void deleteNode(int key) {
//        Node temp = head, prev = null;
//
//        if (temp != null && temp.data == key) {
//            head = temp.next;
//            return;
//        }
//
//        while (temp != null && temp.data != key) {
//            prev = temp;
//            temp = temp.next;
//        }
//        if (temp == null) return;
//        prev.next = temp.next;
//    }

    /* Given a reference (pointer to pointer) to the
   head of a list and a position, deletes the node at
   the given position */

//    void deleteNode(int position) {
//        if (head == null)
//            return;
//        Node temp = head;
//        if (position == 0) {
//            head = temp.next;
//            return;
//        }
//        for (int i=0; temp!=null && i<position-1; i++)
//            temp = temp.next;
//        if (temp == null || temp.next == null)
//            return;
//        Node next = temp.next.next;
//
//        temp.next = next;
//    }

    public static void main(String a[]){
        LLtraversal ll = new LLtraversal();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        ll.head.next=second;
        second.next=third;

        ll.printList();
    }
}
