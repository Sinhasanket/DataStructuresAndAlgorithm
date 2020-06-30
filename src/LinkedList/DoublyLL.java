package LinkedList;

public class DoublyLL {
    Node head;
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) { data = d; }
    }

    // Add a node at the end of the list
    void append(int new_data) {
        Node new_node = new Node(new_data);
        Node last = head;
        new_node.next = null;
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        new_node.prev = last;
    }

    public void printlist(Node node) {
        Node last = null;

        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        DoublyLL dll = new DoublyLL();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7. So linked list becomes 6->7->NULL
        dll.append(7);

        // Insert 1. So linked list becomes 6->7->1->NULL
        dll.append(1);

        // Insert 4. So linked list becomes 6->7->1->4->NULL
        dll.append(4);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
    }
}
