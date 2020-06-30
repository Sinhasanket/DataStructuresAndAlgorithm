package LinkedList;


class Nodei {
    int data;
    Nodei next;
    Nodei(int key)
    {
        data = key;
        next = null;
    }
}

public class Ksum {
    static Nodei head;
    public static Nodei insertNode(Nodei head, int key) {
        if (head == null)
            head = new Nodei(key);
        else
            head.next = insertNode(head.next, key);

        return head;
    }

    public static void print(Nodei head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void KSum(Nodei head, int k) {
        Nodei temp = head;
        while (temp != null) {
            int count = k;
            int sum = 0;
            Nodei curr = temp;
            while (count > 0 && curr != null) {
                sum = sum + curr.data;
                curr = curr.next;
                count--;
            }
            temp.data = sum;
            temp.next = curr;
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 6);

        int k = 2;
        KSum(head, k);
        print(head);
    }
}
